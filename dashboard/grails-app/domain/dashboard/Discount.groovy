package dashboard

class Discount {
	Client client
	Item item
	BigDecimal amount = 0
	Boolean percentage = false
	Date effectiveDate = new Date() - 30
	Date endDate = effectiveDate + 15
	Long tenantId = 1
	
	static belongsTo = [Client, Item]
	
    static constraints = {
		client()
		item()
		amount blank:false, min:0.0, max:100.0
		effectiveDate blank:false
		endDate editable:false
		tenantId(display:false)
    }

	String toString() {
		return item.toString() + ' - ' + amount.toString()
	}
}
