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
import groovy.json.JsonBuilder

  





class RTJob {

  RestConnectorService restConnector
 
  HttpServletRequest httpServletRequest
    
  static triggers = {
    simple repeatInterval: 6000l // execute job once in 5 seconds
  }

  def execute() {
        // execute job        
  
                    
//println connect.getRef()
//def req = request.url
  def pass = "password"
    pass = URLEncoder.encode(pass,"UTF-8")

  def http = new HTTPBuilder("http://10.20.41.111/REST/1.0")

    http.request(Method.POST, ContentType.ANY){ 
  //headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
  //headers.'Referer' = 'http://10.20.41.111/REST/1.0/?user=root&pass=Mn4%C2%A3dss2Z'
  //println request.getRequestLine()
    request.setHeader('Referer', 'http://212.46.157.236:80')
  //println request.getHeaders('Referer')
  def q = "status='new'"
    q = URLEncoder.encode(q, "UTF-8")

    uri.path = "http://10.20.41.111/REST/1.0/search/ticket"
    uri.query = [query:"Queue='General'", user:'root', pass:'password', format:'l']
   
  //println uri
    response.success = {resp, text->
      resp.headers.each{h->
  //println "${h.name}:${h.value}"
    }

   resp.getHeaders('Set-Cookie').each{ 

    def name = it.name
    def str = 'RT_SID_example.com.80='
    def s= it.value.split(';')[0]
    def baseDomain =  s.split('=').first()

   //cookies.add(session)
  

   //def c = cookies.join()


}


//println resp.headers
  
//println 'Response data:-----------------------'

//println 'Headers-------------------------'


//println text.text


  // println resp.status

//println resp.contentType

  def ret = text.getText()



 



  def list = []
   list.add(ret)
  def json = (list as JSON).toString()

  def jsonObject = new JsonSlurper().parseText(json)
  def map=[:]
 
//println jsonObject



//println json

//println jsonObject.getClass().name

 /* def pattern = ~/(Subject):.+/
  def pattern1 = ~/(id):.+/
  def pattern2 = ~/(Status):.+/
  def pattern3 = ~/(Resolved):.+/
  def pattern4 = ~/(LastUpdated):.+/
  def pattern5 = ~/(Queue):.+/
  def pattern6 = ~/([^\n:]+):([^\n]+)/
def pr = []
  def proba = [:]
  ret.findAll(/([^\n:]+):([:[^\n]]+)/){full->
   // proba[name] =value
   //println full
  }


  def list_json =[]
  def list_subject =[]
  def list_status = []
  def list_resolved = []
  def list_lastupdated = []
  def list_queue = []
  def list_ticket = [:]
  def ticketid = (ret =~ pattern1)
    ticketid.each{
    list_json.add(it[0])
    
}

  def subject = (ret=~pattern)
    subject.each{
      list_subject.add(it[0])
      
      //  
    }
  def status = (ret=~pattern2)
    status.each{
      list_status.add(it[0])
      
      }
         
  def resolved = (ret=~pattern3)
    resolved.each{
      list_resolved.add(it[0])
      
      }
  
  def lastupdated = (ret=~pattern4)
    lastupdated.each{
      list_lastupdated.add(it[0])
      
      }
    
      def queue = (ret=~pattern5)
      queue.each{
      list_queue.add(it[0])
      
}
    list_json.each{i->
      list_subject.each{su->
      list_status.each{st->
        list_resolved.each{res->
          list_lastupdated.each{l->
            list_queue.each{qu->


              def tid = i
              def tsubject = su
              def tstatus = st
              def tresolved = res
              def tlast = l
              def tqueue = qu
              def token = tid+tsubject+tlast
              def tsize = Ticket.findAllByToken(token)

if(!tsize){
 // def tickets = new Ticket(tid:tid, tlast:tlast,tsubject:tsubject,tstatus:tstatus,tresolved:tresolved, tqueue:tqueue, token:token).save(failOnError:true)

  }else{
  
  

  
def sql = Sql.newInstance("jdbc:mysql://localhost/calligo",
        "root",
        "Pa55word",
        "com.mysql.jdbc.Driver")
    sql.executeUpdate("update ticket set token = $token where tid = $tid")
 

//result.each{
  //if (it == token)

  //tickets.save()
//}
}

            }
          }
          }

        }
      }
    }
  
 


*/
 





//println tlast
  
 
  

  
  
   
   

def ticket1 = []
    def lines = ret.split('\n')
   def ticket = [:]
  lines.each{
  def li =  it.split('--')
  
  li.each{line->
   
      def nvp = line.replaceAll(',',':')

    def trick =  nvp.split(':') 
     
//println trick

     trick.each{
    //ticket1.add(it)


    
     }
    

    
}


}

list.each{
def op = it.split('--')
op.each{
  def p = it.split(':')
p.eachWithIndex{k, value->


}


 // println  p[1]
 // println p[2]
//println p[5]
 // println p[6]
  //println p[12]
 // println p[19]
 // println p[21]
  //println p[22]
  //println p[23]
  


def ti = p[1]
def tid = ti.minus("Queue")

//def tid = ti.substring(0, ti.length()-5)

def s = p[6]
def tstatus = s.minus("Priority")
//def tstatus = s.substring(0,s.length()-8)


def a = p[5]
def tsubject = a.minus("Status")
//def tsubject = a.substring(0, a.length()-6)

def w = p[19]

def tresolved = w.minus("Told")
//def tresolved = w.substring(0,w.length()-4)

def r = p[2]
def tqueue = r.minus("Owner")
//def tqueue =r.substring(0, r.length()-5)
def y = p[21]+":"+p[22]+":"+p[23]
def tlast = y.minus("TimeEstimated")
//def tlast = y.substring(0,y.length()-13)
def token = tid+a

//def towner = p[3].substring(0, p[3].length()-7)
def towner = p[3].minus("Creator")
//def tcreator = p[4].substring(0, p[4].length()-7)
def tcreator = p[4].minus("Subject")
//def tpriority = p[7].substring(0, p[7].length()-15)
def tpriority = p[7].minus("InitialPriority")
//def tinitialPriority = p[8].substring(0, p[8].length()-13)
def tinitialPriority = p[8].minus("FinalPriority")
//def tfinalPriority = p[9].substring(0, p[9].length()-10)
def tfinalPriority = p[9].minus("Requestors")
//def trequestors = p[10].substring(0, p[10].length()-2)
def trequestors = p[10].minus("Cc")
//def tcc = p[11].substring(0, p[11].length()-7)
def tcc = p[11].minus("AdminCc")
//def tadminCc = p[12].substring(0, p[12].length()-7)
def tadminCc = p[12].minus("Created")
def tc = p[13]+":"+p[14]+":"+p[15]
//def tcreated = tc.substring(0, tc.length()-6)
def tcreated = tc.minus("Starts")


//def tstarts = p[16].substring(0, p[16].length()-7)
def tstarts = p[16].minus("Started")
if(tstatus.size() == 5){

//def tstarted = p[17].substring(0, p[17].length()-3)
def tstarted = p[17].minus("Due")
//def tdue = p[18].substring(0, p[18].length()-8)
def tdue = p[18].minus("Resolved")
//def ttold = p[20].substring(0, p[20].length()-11)
def ttold = p[20].minus("LastUpdated")
//def ttimeEstimated = p[24].substring(0, p[24].length()-10)
def ttimeEstimated = p[24].minus("TimeWorked")
//def ttimeWorked = p[25].substring(0, p[25].length()-8)
def ttimeWorked = p[25].minus("TimeLeft")
def ttimeLeft = p[26]

def tsize = Ticket.findAllByTid(tid)
def tisize1 = Ticket.listOrderById(max:1, order:"desc")

//println tisize1.tid
if(tsize.size() == 0){
def tickets = new Ticket(tid:tid, tlastUpdated:tlast,tsubject:tsubject,tstatus:tstatus,tresolved:tresolved, tqueue:tqueue, token:token, towner:towner, tcreator:tcreator, tpriority:tpriority,tinitialPriority:tinitialPriority,tfinalPriority:tfinalPriority,trequestors:trequestors,tcc:tcc,tadminCc:tadminCc,tcreated:tcreated,tstarts:tstarts,tstarted:tstarted,tdue:tdue,ttold:ttold,ttimeEstimated:ttimeEstimated,ttimeWorked:ttimeWorked,ttimeLeft:ttimeLeft).save(failOnError:true)
}
}else{
   tresolved = p[21]+":"+p[22]+":"+p[23].minus("Told")

  
  def cuted = p[17]+":"+p[18]+":"+p[19]

  //def tstarted = cuted.substring(0, cuted.length()-3)
def tstarted = cuted.minus("Due")
 
  def tdue = p[20].substring(0,p[20].length()-8)

  def cuted_told = p[20]+p[21]
 
  def ttold =  p[24].minus("LastUpdated")
 // def ttold = cuted_told.substring(0, cuted_told.length()-11)
  def cuted_last = p[25]+":"+p[26]+":"+p[27]
 
   //tlast = cuted_last.substring(0, cuted_last.length()-13)
tlast = cuted_last.minus("TimeEstimated")
//def ttimeEstimated = p[26].substring(0, p[26].length()-2)
def ttimeEstimated = p[28].minus("TimeWorked")

//def ttimeWorked = p[27].substring(0, p[27].length()-6)
def ttimeWorked = p[29].minus("TimeLeft")
def ttimeLeft = p[30]
def tsize = Ticket.findAllByTid(tid)
def tisize1 = Ticket.listOrderById(max:1, order:"desc")

//println tisize1.tid
if(tsize.size() == 0){
def tickets = new Ticket(tid:tid, tlastUpdated:tlast,tsubject:tsubject,tstatus:tstatus,tresolved:tresolved, tqueue:tqueue, token:token, towner:towner, tcreator:tcreator, tpriority:tpriority,tinitialPriority:tinitialPriority,tfinalPriority:tfinalPriority,trequestors:trequestors,tcc:tcc,tadminCc:tadminCc,tcreated:tcreated,tstarts:tstarts,tstarted:tstarted,tdue:tdue,ttold:ttold,ttimeEstimated:ttimeEstimated,ttimeWorked:ttimeWorked,ttimeLeft:ttimeLeft).save(failOnError:true)
}

 /*def sql = Sql.newInstance("jdbc:mysql://localhost/calligo",
        "root",
        "Pa55word",
        "com.mysql.jdbc.Driver")
    sql.executeUpdate("update ticket set token = $token where tid = $tid")*/


}

}


}








//


/*ret.eachMatch(pattern){

  list_json.add(it[0].split(':')[1])
 
  println list_json[0]
  def id = list_json[0]

def ticket = new Ticket(id:id,)

}*/


//println jsonObject



//def js = json[22..33]
//println json[36..49]
//println json[52..64]
//println js
  
//println json.get("id")
//println list
//println json
  
}

}




            }
}
