package dashboard

class ServiceMonitor {
	String description
	String host = ''
	Integer pollingInterval = 300
	String verification = ''
	String emailAlert = ''
	Date launchDate = new Date() - 120
	String status = 'down'
	Integer upDays = new Date() - launchDate
	Long tenantId = 1
		
    static constraints = {
		description(blank:false)
		host()
		status()
		launchDate()
		upDays()
		pollingInterval()
		verification()
		emailAlert()
		tenantId(display:false)
    }

	String toString() {
		return description + ' ' + status 
	}
	
}
