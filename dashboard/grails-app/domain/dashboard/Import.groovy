package dashboard

import java.util.Random;
import org.codehaus.groovy.grails.commons.ApplicationHolder as AH
import org.springframework.web.context.request.RequestContextHolder

class Import {
	String description
	byte[] file
	def importerService
	def failure
	Integer importid = 0
	Long tenantId = 1
	static transients = ['importerService','failure']


	
    static constraints = {
		description(blank:false)
		file (maxSize:100000000)
		importid(display:false)
		tenantId(display:false)
    }

	String toString() {
		return description
	}



	def beforeInsert = {
		Random random = new Random()
		importid = random.nextInt(10000000)
	   def unique = false
		   while(unique==false){
		   def idExists = Product.findByImportid(importid)
		   if(idExists){
			   unique = false
			   importid = random.nextInt(10000000)
		   }
		   else{
			   unique = true
		   }
	   }
		 failure=importerService.masterImport(this)
		 if (failure==null){
			 failure ="no errors found"
		 }
		
		 def session = RequestContextHolder.currentRequestAttributes().getSession()
		 session.failure=failure
		

		
	}
}
