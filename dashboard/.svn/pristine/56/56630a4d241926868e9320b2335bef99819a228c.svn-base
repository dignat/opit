package dashboard

class Invoice {
	Client client
	String invoice_No = 'INV'+'-'+0+ new Date()[12]+new Date()[13]+new Date()[11]+new Date()[5]+new Date()[1]
	Date createDate = new Date()
	Date billingDate = new Date()+30
	BigDecimal total = 0
	Rate rate
	List item = new ArrayList()
	Long tenantId = 1
	static mapping = {
		version false
	}
	
    static constraints = {
		client(blank:false)
		invoice_No(editable: false)
		createDate(editable: false)
		billingDate()
		total(editable: false)
		rate(editable:false)
		tenantId(display:false)
		
    }
	
	
    static hasMany = [items:Item, billings:Billing]
        def invoiceService


	def beforeInsert(){
		invoiceService.generateInvoice(this)
	}
	
	
	String toString() {
		return client.toString() + invoice_No
	}
}
