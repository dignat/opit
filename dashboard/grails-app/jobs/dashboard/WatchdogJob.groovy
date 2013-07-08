package dashboard

class WatchdogJob {
	
	JobSchedulerService jobSchedulerService
	
    static triggers = {
      simple repeatInterval: 15000l // execute job once in 15 seconds
    }

    def execute() {
        // execute job
		// println "Watchdog ${new Date().toString()}"
		//jobSchedulerService.test()
    }
}
