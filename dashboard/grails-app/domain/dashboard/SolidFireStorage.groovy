package dashboard

class SolidFireStorage {
	String description
	String host
	String username = 'administrator'
	String password
	
    static constraints = {
		description blank:false
		host blank:false
		username blank:false
		password password:true
    }

	String toString() {
		return description
	}
}
