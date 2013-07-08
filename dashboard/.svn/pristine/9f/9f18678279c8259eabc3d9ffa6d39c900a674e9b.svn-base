package dashboard

class JobSchedulerService {
	
	def grailsApplication
	
	def test() {
		def monitors = ServiceMonitor.getAll()
		monitors.each() {
			println it.host + ' - up ' + isUp(it.host)
		}
	} 

 	def isUp(String site) {
		try {
			def url = site.toURL()
			return url.text != ""
		}
		catch(Exception e) {
		}
		return false
    }

	
}
