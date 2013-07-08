package dashboard
import java.net.URL
import net.Rounding
import groovy.sql.Sql
import groovyx.net.http.*
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.ContentType
import groovyx.net.http.Method
import groovyx.net.http.RESTClient
import java.net.proxy.*
import grails.converters.JSON
import groovyx.net.http.*
import groovy.json.JsonSlurper
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsHttpSession
import java.net.InetAddress
import groovyx.net.http.HttpResponseDecorator
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.Cookie
import org.codehaus.groovy.grails.web.util.WebUtils
import org.springframework.web.context.request.RequestContextHolder
import org.apache.http.impl.cookie.BasicClientCookie
import javax.servlet.ServletRequestListener
import java.util.Map
import org.springframework.web.multipart.MultipartHttpServletRequest
import org.springframework.web.multipart.commons.CommonsMultipartFile
import javax.servlet.http.HttpServletResponse
import static groovyx.net.http.Method.POST
import groovyx.net.http.Method
import groovyx.net.http.HTTPBuilder
import javax.servlet.http.HttpServletResponse
import org.apache.commons.httpclient.*
import org.apache.http.entity.mime.content.FileBody
import org.apache.http.entity.mime.MultipartEntity
import org.apache.http.message.BasicHeader
import java.io.FileReader

class UsersRTController {
	def scaffold = true

	

	def save = {

		flash.message = "Please take a note for the user id, so you could use to update users."
		def user = new UsersRT(params)
		
		def userId = params.userId
		def name = params.name

		def password = params.password

		def email = params.email
	
		def realName = params.realName
	
		def gecos = params.organization
		
		def comments = params.comments
		
		def privileged = params.privileged
		

		def http = new HTTPBuilder("http://10.20.41.111/REST/1.0")
        	http.request(Method.POST, ContentType.ANY){
        	uri.path="http://10.20.41.111/REST/1.0/user/new/"
        	uri.query = [user:'root', pass:'password', content:"Name: ${name}\nPassword: ${password}\nEmailAddress: ${email}\nRealName: ${realName}\nGecos: ${gecos}\nComments: ${comments}\nPrivileged: ${privileged}\nDisabled: 0"]
        	 
        	response.success = {resp, text->  

        	def ret = text.getText() 


      	
       if(!user.hasErrors() && user.save()){
        	flash.message = "${ret}"
        	def list =[]
        	list.add(ret)
        	list.each{
        		def op = it.split('#')
        		def cutuser = op[1]
        		def rtuser = cutuser.minus("created.")
        		def repl = rtuser.minus("User")
        		
        	if(params.name == name){
        		flasg.message="username in use"
        	}
			
        	user.userId = repl
        	user.save()
        	redirect (action:'list')
        

        }	
        }
        else
        {
        	render(view:'create', model:[user:user])
        }

}
 }       
	}

	def update = {
		def user = UsersRT.get(params.id)
		
			if (user) {


		def userId = params.userId //example:ticket/38
		def name = params.name
	
		def password = params.password
	
		def email = params.email
	
		def realName = params.realName
		
		def gecos = params.organization
		
		def comments = params.comments
		
		def privileged = params.privileged
		//def disabled = params.disabled

		def http = new HTTPBuilder("http://10.20.41.111/REST/1.0")
        	http.request(Method.POST, ContentType.ANY){
        	uri.path="http://10.20.41.111/REST/1.0/user/edit/"
        	uri.query = [user:'root', pass:'password', content:"id: ${userId}\nName: ${name}\nPassword: ${password}\nEmailAddress: ${email}\nRealName: ${realName}\nGecos: ${gecos}\nComments: ${comments}\nPrivileged: ${privileged}"]
        	 
        	response.success = {resp, text->  

        	def ret = text.getText() 


      	
       if(!user.hasErrors() && user.save()){
        	flash.message = "${ret}"

        	user.save()
        	redirect (action:'list')
        }
        else
        {
        	render(view:'edit', model:[user:user])
        }
}
 }       
			
                          
                
            
}
	}

	def list = {
		
			
					params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [usersRTInstanceList: UsersRT.list(params), usersRTInstanceTotal: UsersRT.count()]

			

		

	}






	
	
	
	
}
