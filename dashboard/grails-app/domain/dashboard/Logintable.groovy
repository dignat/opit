package dashboard
import java.net.URL


class Logintable {
	User login
	String ipaddress 
	Date logedin
	Date logout
	String session
	Long tenantId = 1


	static mapping = {
		 
		 cache:true
	}
	
	static belongsTo = User
    static constraints = {
		login()
		ipaddress()
		logedin()
		logout(nullable:true)
		session()
		tenantId(display:false)
    }

  
    

	String toString() {
		return ipaddress
	}
}
