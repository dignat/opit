package dashboard

class ProductPrices {
	Product product
	BigDecimal unitPrice  = 0
	BigDecimal setupPrice = 0
	Date effectiveDate = new Date() //effective date from ui

	static belongsTo = [Product]

    static constraints = {
		unitPrice(blank:false)
		setupPrice(nullable:true, blank:true)
    }

	String toString() {
		return unitPrice
	}
}
