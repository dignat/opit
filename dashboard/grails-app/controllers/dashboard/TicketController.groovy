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
 





class TicketController {
	def scaffold = true
def ticket = new Ticket()

	def create = {
		def ticket = new Ticket(params)

		def ticketId = Ticket.listOrderById(max:1, order:"desc")

		flash.message = ticketId.tid + "This is the last created ticket, please make sure you insert the next value "

	}

	def save = {

		def ticketId = Ticket.listOrderById(max:1, order:"desc")
		def ticket = new Ticket(params)
		def tid = params.tid
		def tlast = params.tlastUpdated
		def token = params.id + params.tsubject
		def tqueue = params.tqueue
		def tresolved = params.tresolved
		def tstatus = params.tstatus
		def tsubject = params.tsubject
		def towner = params.towner
		def tcreator = params.tcreator
		def tpriority = params.tpriority
		def tinitialPriority = params.tinitialPriority
		def tfinalPriority = params.tfinalPriority
		def trequestors = params.trequestors
		def tcc = params.tcc
		def tadminCc = params.tadminCc
		def tcreated = params.tcreated
		def tstarts = params.tstarts
		def tstarted = params.tstarted
		def tdue = params.tdue
		def ttold = params.ttold
		def ttimeEstimated = params.ttimeEstimated
		def ttimeWorked = params.ttimeWorked
		def ttimeLeft = params.ttimeLeft
		def http = new HTTPBuilder("http://10.20.41.111/REST/1.0")
        	http.request(Method.POST, ContentType.ANY){
        	uri.path="http://10.20.41.111/REST/1.0/ticket/new/"
        	uri.query = [user:'root', pass:'password', content:"id: ${tid}\nLast Updated: ${tlast}\nQueue: ${tqueue}\nResolved: ${tresolved}\nStatus: ${tstatus}\nSubject: ${tsubject}\nOwner: ${towner}\nPriority: ${tpriority}\nInitialPriority: ${tinitialPriority}\nFinalPriority: ${tfinalPriority}\nRequestors: ${trequestors}\nCc: ${tcc}\nAdminCc: ${tadminCc}\nStarts: ${tstarts}\nStarted: ${tstarted}\nDue: ${tdue}\nTimeEstimated: ${ttimeEstimated}\nTimeWorked: ${ttimeWorked}\nTimeLeft: ${ttimeLeft}"]
        	 
        	response.success = {resp, text->  

        	def ret = text.getText() 


      	
       if(!ticket.hasErrors() && ticket.save()){
        	flash.message = "${ret}"
        	ticket.delete()
        	redirect (action:'list')
        }
        else
        {
        	render(view:'create', model:[ticket:ticket])
        }
}
 }       
 

	}

	def show = {
		def ticketInstance = Ticket.get(params.id)
		if(!ticketInstance){

			flash.message = "${ticket.id}.not.found"
			return

		}

		render (view:'show', model:[ticketInstance:ticketInstance])


		


	}

	def list = {
		
			
					params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [ticketInstanceList: Ticket.list(params), ticketInstanceTotal: Ticket.count()]

			

		

	}


	def update = {

		def ticket = Ticket.get(params.id)
		ticket.properties = params
			if (ticket) {
			if (params.token) { 
                          
                if (ticket.token != params.token) {
                    
                   ticket.delete()
                }
            }
}

      	
      	def tid = params.tid
		def tlast = params.tlastUpdated
		def token = params.id + params.tsubject
		def tqueue = params.tqueue
		def tresolved = params.tresolved
		def tstatus = params.tstatus
		def tsubject = params.tsubject
		def towner = params.towner
		def tcreator = params.tcreator
		def tpriority = params.tpriority
		def tinitialPriority = params.tinitialPriority
		def tfinalPriority = params.tfinalPriority
		def trequestors = params.trequestors
		def tcc = params.tcc
		def tadminCc = params.tadminCc
		def tcreated = params.tcreated
		def tstarts = params.tstarts
		def tstarted = params.tstarted
		def tdue = params.tdue
		def ttold = params.ttold
		def ttimeEstimated = params.ttimeEstimated
		def ttimeWorked = params.ttimeWorked
		def ttimeLeft = params.ttimeLeft
		def http = new HTTPBuilder("http://10.20.41.111/REST/1.0")
        	http.request(Method.POST, ContentType.ANY){
        	uri.path="http://10.20.41.111/REST/1.0/ticket/edit"
        	        	uri.query = [user:'root', pass:'password', content:"id: ${tid}\nLast Updated: ${tlast}\nQueue: ${tqueue}\nResolved: ${tresolved}\nStatus: ${tstatus}\nSubject: ${tsubject}\nOwner: ${towner}\nPriority: ${tpriority}\nInitialPriority: ${tinitialPriority}\nFinalPriority: ${tfinalPriority}\nRequestors: ${trequestors}\nCc: ${tcc}\nAdminCc: ${tadminCc}\nStarts: ${tstarts}\nStarted: ${tstarted}\nDue: ${tdue}\nTimeEstimated: ${ttimeEstimated}\nTimeWorked: ${ttimeWorked}\nTimeLeft: ${ttimeLeft}"]

        	 
        	response.success = {resp, text->  

        	def ret = text.getText() 
       if(!ticket.hasErrors()){

        	flash.message = "${ret}"
        	ticket.delete()
        	
        	redirect (action:'list')
        }
        else
        {
        	redirect(action:'edit', model:[ticket:ticket])
        }

       
}
 }       

	}
	def history (Long id){
		def ticket = Ticket.get(id)
		
		def tid = ticket.tid
		
		def cut = tid.minus("ticket/").toInteger()
		def http = new HTTPBuilder("http://10.20.41.111/REST/1.0")
		http.request(Method.POST, ContentType.ANY){
        	uri.path="http://10.20.41.111/REST/1.0/ticket/${cut}/history"
        	uri.query = [query:"hisotry", user:'root', pass:'password', format:'l']        	 
        		response.success = {resp, text->  

        			def history = text.getText() 
      	     		def list = []
      	     		def map = [:]
      	     		list.add(history)
      	     		list.each{
					def op = it.split('--')
					//println  "${op[-1]}"
					def size = op.size()
def array = op[-1]

						//op.each{

  					//def p = it.split(':')
  					
def proba = array.split(':')
println proba.size()
//println p.size()
if(proba.size() <= 17){
def historyId=proba[1]//history id minus ("Ticket")
 proba[2]//ticket id minus("TimeTaken")
 proba[3]//time taken minus("Type")
 proba[4]//type minus("Field")
 proba[5] //field minus("OldValue")
 proba[6] //old value minus("NewValue")
 proba[7]//new value minus("Data")
 proba[8]//data minus ("Description")
 proba[9]//description minus ("Content")//depends on the size of the all array bigger than 17
 proba[11]//creator minus ("Created")
 def created = proba[12]+':'+proba[13]+':'+proba[14]//created minus("Attachments")
 //than 
 def totalHistory = "History id" + historyId + proba[2] + proba[3] +proba[4]+proba[5]+proba[6]+proba[7]+proba[8]+proba[9]+proba[11]+created
render(view:'history', model:[ticket:ticket, totalHistory:totalHistory])

 } else if(proba.size() > 17){
 	def historyId=proba[1]//history id minus ("Ticket")
 proba[2]//ticket id minus("TimeTaken")
 proba[3]//time taken minus("Type")
 proba[4]//type minus("Field")
 proba[5] //field minus("OldValue")
 proba[6] //old value minus("NewValue")
 proba[7]//new value minus("Data")
 proba[8]//data minus ("Description")
 proba[9]//description minus ("Content")//depends on the size of the all array bigger than 17
 proba[11]//creator minus ("Created")
 created = proba[12]+':'+proba[13]+':'+proba[14]//created minus("Attachments")

 def content = proba[10]+proba[11]+proba[12]//description minus ("Content")
 proba[14]//creator minus ("Created")
 proba[15]//created minus ("Attachments")
 
 totalHistory = "History id" + historyId + proba[2] + proba[3] +proba[4]+proba[5]+proba[6]+proba[7]+proba[8]+proba[9]+proba[11]+created +content
+proba[14]+proba[15]
        	render(view:'history', model:[ticket:ticket, totalHistory:totalHistory])
        
  //}    

 } 


}
 } 
 }      



	}
	def comment (Long id){

		//def ticket = new Ticket(params)
		//ticket.properties = params
		//ticket = Ticket.get(params.id)
		def ticket = Ticket.get(id)
		def tid = ticket.tid
		def comment = params.comment
		def path = params.attachment_1
		//def attachment_file ="upload/${path}"
		def type = 'text/plain'
		//def webRootDir = servletContext.getRealPath("/")
		//def file = new File(webRootDir,"/upload/${path}")
		//def encoded = file.bytes.encodeBase64().toString()
      //  def cbFile = new FileBody(file, type)
        def cut = tid.minus("ticket/").toInteger()
		//def contents = new File(webRootDir, "/upload/${path}").getText('UTF-8')
		
		def http = new HTTPBuilder("http://10.20.41.111/REST/1.0")
		
				http.request(Method.POST){ req->
        		uri.path="http://10.20.41.111/REST/1.0/ticket/${cut}/comment"
        		
        		//def mp = new MultipartEntity()
        	//	mp.addPart("file", cbFile)
               
        	    		
      						
        	    //req.setHeader('Accept', "text/plain")
        	  //  req.setHeader('Content-Disposition', "attachment; filename=${path}")
        	    //req.setHeader('Content-Type', "text/plain")
        	    
        	    //req.setHeader('Content-Transfer-Encoding-Encoding',"Binary")
        	    //req.setHeader('Accept-Content-Length', "${file.length()}")
        	   	//req.setHeader('Accept',  "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
        	    
      	
//headers.Accept = "Content-Disposition: inline; filename=${path};\nContent-Length: ${file.length()}\nContent-Transfer-Encoding: binary\nContent-Type: text/plain; name=${path}; charset=utf-8"
        		uri.query = [user:'root', pass:'password', content:"id: ${tid}\nAction: comment\nText: ${comment}\nAttach: ${path}", attachement_1: ""]
        		


	 				//req.entity = mp
				       
				       
				       	response.success = {resp, text-> 
				       		 

 
   def resEntity = resp.getEntity()

        					
        					def reply =text.getText()
     

        						flash.message="${reply}"
        	
        	
        							render(view:'comment', model:[ticket:ticket])
        
       

       

}
 }       



	}
	
def comment_view = {
		def ticket = new Ticket(params)
			ticket.properties = params
			ticket = Ticket.get(params.id)
		def tid = params.tid
		def id= params.id
				
      render(view:'comment_view')
	}


	def reply_view = {
		def ticket = new Ticket(params)
			ticket.properties = params
			ticket = Ticket.get(params.id)
		def tid = params.tid
		def id= params.id
				
      render(view:'reply_view')


	}

	def reply (Long id){
		//def ticket = new Ticket(params)
		//ticket.properties = params
		//ticket = Ticket.get(params.id)
		def ticket = Ticket.get(id)
		def tid = ticket.tid
		def comment = params.comment
		
		def cut = tid.minus("ticket/").toInteger()
	
		def http = new HTTPBuilder("http://10.20.41.111/REST/1.0")
				http.request(Method.POST){ req->
        		uri.path="http://10.20.41.111/REST/1.0/ticket/${cut}/comment"
        		
        	

      				uri.query = [user:'root', pass:'password', content:"id: ${tid}\nAction: correspond\nText: ${comment}"]  
	
				       	response.success = {resp, text->  
				       		
  

        					def history = text.getText() 
      

        						flash.message = "${history}"
        	
        	
        							render(view:'reply', model:[ticket:ticket])
        
       

       

}
 }       


	}

	def edit_links = {
		def ticket = new Ticket(params)
			ticket.properties = params
			ticket = Ticket.get(params.id)
		def tid = params.tid
		def id= params.id
				
      render(view:'links_edit')


	}

	def links (Long id) {

		def ticket = Ticket.get(id)
		def tid = params.id
		def dependOn = params.dependOn
		def refersTo = params.refersTo
		def cut = tid.minus("ticket/").toInteger()

		def http = new HTTPBuilder("http://10.20.41.111/REST/1.0")
				http.request(Method.POST){ req->
        		uri.path="http://10.20.41.111/REST/1.0/ticket/${cut}/links"
        		
        	

      				uri.query = [user:'root', pass:'password', content: "DependsOn: ${dependOn}\nRefersTo: ${refersTo}"]  
	
				       	response.success = {resp, text->  
				       		
  

        					def history = text.getText() 
      

        						flash.message = "${history}"
        	
        	
        							render(view:'links', model:[ticket:ticket])
        
       

       

}
 }       


	}

	def logout = {
		def http = new HTTPBuilder("http://10.20.41.111/REST/1.0")
				http.request(Method.POST){ req->
        		uri.path="http://10.20.41.111/REST/1.0/logout"
        		
        	

      				uri.query = [user:'root', pass:'password']  
	
				       	response.success = {resp, text->  
				       		
  

        					def history = text.getText() 
      

        						flash.message = "${history}"
        	
        	
        							render(view:'logout')
        
       

       

}
 }       


	}

	



}
