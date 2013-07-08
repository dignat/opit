import dashboard.*
import groovy.sql.Sql
import javax.servlet.http.HttpSessionEvent    
import javax.servlet.http.HttpSessionListener  
import org.springframework.security.core.context.SecurityContextHolder 
class SecurityFilters implements Serializable{  
    def springSecurityService
    def dataSource
    def firstlogin = true
    def logaction = true
    def filters = {  

            basicAuth(controller:'*', action:'*') {  
              before = {  

                    // Exempt login controller from filter
                if (controllerName.equals('login') ) {
                    return true
                }

                boolean loggedin = springSecurityService.isLoggedIn()
                if (!loggedin){                 
                    redirect (controller: 'login', action: 'index' )
                                        
                }

                if (loggedin && firstlogin==true){
                    def userDetails = springSecurityService.principal?.getUsername()
                    def userObject = null
                    userObject = User.get(springSecurityService.principal?.id)
                    session.tenantId = userObject.client.id
                    firstlogin = true
                    logaction = false
                    if(session.tenantId){
                     def loginexists = Logintable.findBySession(session.id)
                       if(!loginexists){
                        def ipAddres =java.net.InetAddress.getLocalHost().getHostAddress()
                        def session = session.id                   
                        def logedin = new Date()
                        def logout = new Date()
                        def login = new Logintable(login:userObject, ipaddress:ipAddres, logedin:logedin, session:session, logout:logout).save(failOnError:true)
                       }
                    }                   
                }

                if (controllerName.equals('logout') && actionName.equals('index') ) {
                    firstlogin = true
                    def logout = new Date()
                    def sql = new Sql(dataSource)
                    def session = session.id
                    sql.executeUpdate("update logintable set logout = $logout where session = $session")
                    return true
                }
    
               /* def authentication = session.SPRING_SECURITY_CONTEXT?.authentication?.principal?.getAuthorities()
                //Object principal = authentication.getPrincipal()  
                if(authentication.equals("ROLE_USER"))
                  session.setMaxInactiveInterval(10*60)
                   println ("session created")*/

               def now = System.currentTimeMillis()
               def last = new Date().getTime()
               if(!last) last = now
               def idle = last -now 
               def timeout = 1800
               def autority =session.SPRING_SECURITY_CONTEXT?.authentication?.principal?.getUsername()
               if(autority != 'Calligo'){
                session.setMaxInactiveInterval(10*60)
               } else {
                 session.tenantId = 1
                 session.vdcid = 1          
                 }
            }  
          }  
    }  
}