package dashboard

class User {

	transient springSecurityService

	String username
	String password
	String email
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	Client client
	Long tenantId = 1

	static constraints = {
		username blank: false, unique: true
		password blank: false
		email email: true
		tenantId(display:false)
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	//defaults new user with role user
	def afterInsert () {
		def user = this
		def roleUser = Role.findByAuthority('ROLE_USER')
		UserRole.create user, roleUser, false
	}


	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
