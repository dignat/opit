package dashboard

class Product {
	String description
	Territory territory
	String frequency
	String glCode
	Integer importid

	static hasMany = [productprices:ProductPrices]
	static belongsTo = [Territory]

    static constraints = {
		description(blank:false)
		territory(nullable:true)
		importid(nullable:true, blank:true, display:false)
		frequency(inList: ["Monthly","Annual","Daily","Hourly"],blank:false)
		glCode(nullable:true,blank:true)
    }


	String toString() {
		return description.toString() 
		
		
		
	}
}
