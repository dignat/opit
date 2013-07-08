package dashboard

class VirtualDataCenter {
	String description = "vCenter"
	String host
	String username = 'administrator'
	String password
	Long tenantId = 1
	
    static constraints = {
		description blank:false
		host blank:false
		username blank:false
		password password:true
		tenantId(display:false)
    }

	String toString() {
		return description
	}
}
