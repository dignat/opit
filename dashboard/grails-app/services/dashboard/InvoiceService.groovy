package dashboard

import static java.util.Calendar.*

class InvoiceService {
static transactional = false
    def generateInvoice(invoiceInstance) {
        //product find all by effective date use that price

    	def invoiceRate = invoiceInstance.rate.rate
    	def total = 0
    	def setupPriceTotal = 0
		def itemTotal 
        def billDate = invoiceInstance.billingDate
        def today = new Date() -5
         def prorate
        //pro rate
        Date calendar = new Date()
        def date = calendar.toCalendar()
        def lastDayOfMonth = date.getActualMaximum(GregorianCalendar.DAY_OF_MONTH)
        def billCalendar = billDate.toCalendar()
        def mydate = new Date()
        def noOfDays = lastDayOfMonth + 1 - mydate[DATE]

        if(noOfDays !=lastDayOfMonth){

           prorate = true
        }


        def calligo = Client.findByCompany("Calligo") //TODO Session variable
// find all purchased products for company in sessions
        def allPurchasedProducts = calligo.products
        allPurchasedProducts.each {

            def liveproduct = it.product
            def livequantity = it.units
            
            def liveprice = ProductPrices.findByProductAndEffectiveDateGreaterThanEquals(liveproduct,today)
            def setup = liveprice.setupPrice 
            def price  = liveprice.unitPrice
            if(!setup){
                setup = 0
            }
        // pro rate if it meets the conditions todo so
            if (prorate == true){
               price = (liveprice.unitPrice / lastDayOfMonth) * noOfDays
                   if(setup !=0){
                      setup = (setup / lastDayOfMonth) * noOfDays
                   }
            }

        def monthly = liveprice.unitPrice * livequantity
        //create line item for invoice
        def lineitem = new Item(product:liveproduct, units:livequantity,setupPriceTotal:setup,itemTotal:monthly,setupUnitPrice:setup,itemUnitPrice:price)
        invoiceInstance.addToItems(lineitem)
    }


        def invoiceItems = invoiceInstance.items.asList()
		//loop through each item
    	invoiceItems.each{    	
    		//total monthly items	
    		//if it is initial billing period apply one off setup fee.
    		if(it.firstBilling==true && it.setupPriceTotal>0){

    			it.firstBilling = false
    			setupPriceTotal = it.setupPriceTotal * it.units
    			it.setupPriceTotal = setupPriceTotal

    		}
    			it.save(failOnError:true)
    		//apply any discounts relevant to this client and item	
		def client = invoiceInstance.client
		def discount = Discount.findByClientAndItem(client,it)
		def amount
        def itemdiscount

			if(!discount){
				amount = 0
                itemdiscount = 0
			}

			if(discount && discount.percentage==true) {
				amount = discount.amount/100
                itemdiscount = amount*itemTotal
			}

            if(discount && discount.percentage==false) {
                amount = discount.amount
                itemdiscount = amount
            }



			//currently deals with monthly discounts not discounts applied on one off fees
		def itemtotalwithdiscount = it.itemTotal - itemdiscount

		//after looping through each invoice item add it to the total for the invoice
		total += (itemtotalwithdiscount*invoiceRate) + (setupPriceTotal*invoiceRate)
		setupPriceTotal = 0
		itemTotal = 0
    	} 

    	invoiceInstance.total = total
    	invoiceInstance.save(failOnError:true)

    }
}
