// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = true
grails.mime.types = [
    all:           '*/*',
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false
grails {
   mail {
     host = "mail2.calligocloud.je"
     port = 25
     username = "denise.ignatova@calligo.net"
     password = "Welcome123!"
     }
   }


environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
    def catalinaBase = System.properties.getProperty('catalina.base')
    if (!catalinaBase) catalinaBase = '.'   // just in case
    def logDirectory = "${catalinaBase}/logs"
    def appName = Metadata.current.'app.name'  // JH fix for not finding appName
    }
}

// log4j configuration
    log4j = {
      appenders {
        // set up a log file in the standard tomcat area; be sure to use .toString() with ${}
        rollingFile name:'tomcatLog', file:"${logDirectory}/${appName}.log".toString(), maxFileSize:'100KB'
        'null' name:'stacktrace'
        rollingFile name:'userActionFile', file: "${logDirectory}/userActions.log".toString(),
        threshold: org.apache.log4j.Level.INFO,
        maxFileSize:"1MB", maxBackupIndex: 10, 'append':true,
        layout:pattern(conversionPattern: "%d{dd MMM yyyy HH:mm:ss} %m%n")
      }

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
           'org.codehaus.groovy.grails.web.pages',          // GSP
           'org.codehaus.groovy.grails.web.sitemesh',       // layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping',        // URL mapping
           'org.codehaus.groovy.grails.commons',            // core / classloading
           'org.codehaus.groovy.grails.plugins',            // plugins
           'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
}

// Quartz2 configuration
grails.plugin.quartz2.autoStartup = true 
org { 
	quartz{ 
		//anything here will get merged into the quartz.properties so you don't need another file 
		scheduler.instanceName = 'MyAppScheduler' 
		threadPool.class = 'org.quartz.simpl.SimpleThreadPool' 
		threadPool.threadCount = 20 
		threadPool.threadsInheritContextClassLoaderOfInitializingThread = true 
		jobStore.class = 'org.quartz.simpl.RAMJobStore' 
	} 
} 
grails.events.session.listener = {
  'configService'
}

// Added by the Spring Security Core plugin:
grails.plugins.springsecurity.requestMap.className = 'dashboard.Requestmap'
grails.plugins.springsecurity.securityConfigType = "Requestmap"
grails.plugins.springsecurity.userLookup.userDomainClassName = 'dashboard.User'
grails.plugins.springsecurity.userLookup.authorityJoinClassName = 'dashboard.UserRole'
grails.plugins.springsecurity.authority.className = 'dashboard.Role'
grails.plugins.springsecurity.successHandler.defaultTargetUrl = '/virtualMachine/updateDials'
grails.plugins.springsecurity.successHandler.alwaysUseDefault = true
grails.plugins.springsecurity.successHandler.alwaysUseDefaultTargetUrl = true
grails.plugins.springsecurity.useSessionFixationPrevention = true
//grails.plugins.springsecurity.rejectIfNoRule = true
