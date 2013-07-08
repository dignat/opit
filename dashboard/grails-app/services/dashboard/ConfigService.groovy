package dashboard

import org.springframework.security.core.context.SecurityContextHolder    
     
class ConfigService {    
     
    def getSessionTimeoutMinutes() {    
     
        String username = session.SecurityContextHolder?.authentication?.principal?.getAuthorities()   
           
     
        if(username.equals("ROLE_USER")) {
        	setMaxInactiveInterval(10)
        }
    }    
}
