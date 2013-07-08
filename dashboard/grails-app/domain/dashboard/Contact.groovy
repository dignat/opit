package dashboard

class Contact {
	Client client
	String title = ''	
	String firstName = ''
	String lastName = ''
	String jobTitle = ''
	ContactType contactType
	String email = ''
	String telephone = ''
	String fax = ''
	String notes = ''
	Long tenantId = 1
	
	static belongsTo = [Client]
	
    static constraints = {
		client(blank:false)
		title(blank:false)
		firstName(blank:false)
		contactType(nullable:true)
		lastName(blank:false)
		jobTitle()
		email(blank:false)
		telephone()
		fax()
		notes(widget:'textarea')
		tenantId(display:false)
    }

	String toString() {
		return lastName + ', ' + firstName
	}
}
