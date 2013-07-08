import grails.converters.JSON
import dashboard.User
import dashboard.Logintable
import java.net.InetAddress
import javax.servlet.http.HttpServletResponse

import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

import org.springframework.security.authentication.AccountExpiredException
import org.springframework.security.authentication.CredentialsExpiredException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.LockedException
import org.springframework.security.core.context.SecurityContextHolder as SCH
import org.springframework.security.web.WebAttributes
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class LoginController {

	def mailService
	def userinstance = new User()
	/**
	 * Dependency injection for the authenticationTrustResolver.
	 */
	def authenticationTrustResolver

	/**
	 * Dependency injection for the springSecurityService.
	 */
	def springSecurityService

	/**
	 * Default action; redirects to 'defaultTargetUrl' if logged in, /login/auth otherwise.
	 */
	def index = {
		if (springSecurityService.isLoggedIn()) {
			redirect uri: SpringSecurityUtils.securityConfig.successHandler.defaultTargetUrl
		}
		else {
			redirect action: 'auth', params: params
		}
	}

	/**
	 * Show the login page.
	 */
	def auth = {

		def config = SpringSecurityUtils.securityConfig

		if (springSecurityService.isLoggedIn()) {
			redirect uri: config.successHandler.defaultTargetUrl
			return
		}

		String view = 'auth'
		String postUrl = "${request.contextPath}${config.apf.filterProcessesUrl}"
		render view: view, model: [postUrl: postUrl,
		                           rememberMeParameter: config.rememberMe.parameter]
	}

	/**
	 * The redirect action for Ajax requests.
	 */
	def authAjax = {
		response.setHeader 'Location', SpringSecurityUtils.securityConfig.auth.ajaxLoginFormUrl
		response.sendError HttpServletResponse.SC_UNAUTHORIZED
	}

	/**
	 * Show denied page.
	 */
	def denied = {
		if (springSecurityService.isLoggedIn() &&
				authenticationTrustResolver.isRememberMe(SCH.context?.authentication)) {
			// have cookie but the page is guarded with IS_AUTHENTICATED_FULLY
			redirect action: 'full', params: params
		}
	}

	/**
	 * Login page for users with a remember-me cookie but accessing a IS_AUTHENTICATED_FULLY page.
	 */
	def full = {
		def config = SpringSecurityUtils.securityConfig
		render view: 'auth', params: params,
			model: [hasCookie: authenticationTrustResolver.isRememberMe(SCH.context?.authentication),
			        postUrl: "${request.contextPath}${config.apf.filterProcessesUrl}"]
	}

	/**
	 * Callback after a failed login. Redirects to the auth page with a warning message.
	 */
	def authfail = {

		def username = session[UsernamePasswordAuthenticationFilter.SPRING_SECURITY_LAST_USERNAME_KEY]
		String msg = ''
		def exception = session[WebAttributes.AUTHENTICATION_EXCEPTION]
		if (exception) {
			if (exception instanceof AccountExpiredException) {
				msg = g.message(code: "springSecurity.errors.login.expired")
			}
			else if (exception instanceof CredentialsExpiredException) {
				msg = g.message(code: "springSecurity.errors.login.passwordExpired")
			}
			else if (exception instanceof DisabledException) {
				msg = g.message(code: "springSecurity.errors.login.disabled")
			}
			else if (exception instanceof LockedException) {
				msg = g.message(code: "springSecurity.errors.login.locked")
			}
			else {
				msg = g.message(code: "springSecurity.errors.login.fail")
			}
		}

		if (springSecurityService.isAjax(request)) {
			render([error: msg] as JSON)
		}
		else {
			flash.message = msg
			redirect action: 'auth', params: params
		}
	}

	/**
	 * The Ajax success redirect url.
	 */
	def ajaxSuccess = {
		render([success: true, username: springSecurityService.authentication.name] as JSON)
	}

	/**
	 * The Ajax denied redirect url.
	 */
	def ajaxDenied = {
		render([error: 'access denied'] as JSON)
	}

	def recover = {

		render (view:'/user/recover')
	}


	def recovery ={

		if(request.method =='POST'){
			def date = new Date()

			def userinstance = new User(params)
			def username = userinstance.username
			def email = userinstance.email
			def user = User.findByUsername(username)
			if(user){
    		    def ipAddres =java.net.InetAddress.getLocalHost().getHostAddress()
				def key = username +email+ ipAddres


				mailService.sendMail{
				to "ryan.jeffs@calligo.net"
				from "denise.ignatova@calligo.net"
				subject "New Account"
			html  '<a href ="http://localhost:8080/dashboard/login/validation/" >Click here to recover a password</a>'
		}
			flash.message ="Your request for password recovery has been sent to ${email}"


			}
			else{
				redirect(controller:'login', action:'auth')
			}


		}
	}



		def validation = {
 def linkip =java.net.InetAddress.getLocalHost().getHostAddress()

 def logtable = new Logintable(params)
 def ipaddress = logtable.ipaddress
// def logip = Logintable.findByIpaddress(logtable.ipaddress)
 def ip = Logintable.createCriteria()
 def result = ip.list(){
 	like("ipaddress", "$linkip")
 	cache true
 	maxResults 1
 	
 }
 def link = []
 link.add(linkip)


 if(!result != link){
 	flash.message = "${link}"

 	redirect action:'forgotPassword'
 }

 else{
 	redirect(controller:'login', action:'auth')
 }






	}



	def forgotPassword = {

if(request.method == 'POST'){
		def userinstance = new User(params)
		def username = userinstance.username
		def email = userinstance.email
		
		userinstance.password = springSecurityService.encodePassword(params.password, userinstance.username)
		def user = User.findByUsername(username)

if(!user){

	redirect action:'recover'
}
				def newPassword = params.password_new
				def newPassword2 = params.password_new_2

				if(!newPassword == newPassword2){	
				flash.message = 'Please retype password again'
				return

				} 

				else if(user){

			    user.password =newPassword
			    user.save()
				//userinstance.passwordExpired = false
				//userinstance.save()
				flash.message = "${user.password}"
				redirect (controller:'login', action:'auth')

			}
		
	}	
	
}







}
