package dashboard

class Average {
	
	String description
	Integer memory
	Integer consumedHostCPU
	Integer consumedHostMemory
	Integer activeGuestMemory
	BigDecimal provisonedStorage
	BigDecimal usedStorage
	BigDecimal unusedStorage
	Integer privateMem
	Integer sharedMem
	Integer activeMem
	Integer swappedMem
	Long tenantId = 1
	
	Date timestamp = new Date()
	
    static constraints = {
		description(blank:false)
		consumedHostCPU(nullable:true)
		activeGuestMemory(nullable:true)
		provisonedStorage(nullable:true)
		usedStorage(nullable:true)
		unusedStorage(nullable:true)
		privateMem(nullable:true)
		tenantId(display:false)		
    }

	String toString() {
		return description
	}
}
