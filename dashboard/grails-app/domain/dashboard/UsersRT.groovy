package dashboard

class UsersRT {
	String userId
	String name
	String email
	String password
	String realName
	String organization
	String comments
	Integer privileged
	
	Long tenantId = 1
	
    static constraints = {
    	tenantId(display:false)
    	password blank: false, nullable: false,unique: true, size: 5..10
    	name blank:false, unique:true
		
    }
   

	String toString() {
		return userId
	}
}
