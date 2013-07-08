package dashboard

class Client {
	String company
	String clientID
	String address1 = ''
	String address2 = ''
	String city = ''
	String county = ''
	String country = ''
	String postcode = ''
	String telephone = ''
	String fax = ''
	Integer sessionTimeout = 10
	Long tenantId = 1
	byte[] logo
	//Rate rate

 	static hasMany = [users:User, contacts:Contact, virtualDataCenters:VirtualDataCenter, products:PurchasedProducts, discounts:Discount,rates:Rate, virtualmachines: VirtualMachine]
	

    static constraints = {
		company(blank:false)
		clientID()
		address1()
		address2()
		city()
		county()
		country()
		postcode()
		telephone()
		fax()
		tenantId(display:false)
		logo(nullable:true,maxSize: 50000000)
    }

	String toString() {
		return company
	}
}
