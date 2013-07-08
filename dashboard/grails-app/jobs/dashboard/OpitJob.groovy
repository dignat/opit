package dashboard
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.security.core.context.SecurityContextHolder 
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
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.HEAD
 
import java.security.KeyStore
import org.apache.http.conn.scheme.Scheme
import org.apache.http.conn.ssl.SSLSocketFactory


class OpitJob {
def springSecurityService
def configService
def authenticateService

    static triggers = {
      simple repeatInterval: 5000l // execute job once in 5 seconds
    }

    def execute() {
        // execute job
        
       

       



    }
}
