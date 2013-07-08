package dashboard
import dashboard.Invoice

class Billing {

	Client client

	String status 

	
static belongsTo = Invoice
static hasMany = [invoices:Invoice]
	
    static constraints = {
		status(blank:false)
    }



    def beforeInsert(){

/*
    	def statusInstance = this
        def invoicestatus = statusInstance.invoices.asList()
        invoicestatus.each{
            def createdate = Invoice.findByCreateDate()
        def date = new Date()
            
             if(createdate == date)
            status = 'Generated'
       }
    	*/
    	   	

    }

    def beforeUpdate(){
    	
    /*def statusInstance = this
        def invoicestatus = statusInstance.invoices.asList()
        invoicestatus.each{
            def createdate = Invoice.findByCreateDate()
        def date = new Date()
            
             if(createdate ==date)
            status = 'Generated'
       }*/
       

    }

	String toString() {
		return status.toString()
	}
}
