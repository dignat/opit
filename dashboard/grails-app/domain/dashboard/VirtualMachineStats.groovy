package dashboard

class VirtualMachineStats {
	VirtualMachine virtualMachine
	String description
	Integer cpuCount
	Integer memory
	BigDecimal memoryOverhead
	String state
	String vmWareToolStatus
	String ipAddress = ''
	Integer consumedHostCPU
	Integer consumedHostMemory
	Integer activeGuestMemory
	BigDecimal provisonedStorage
	BigDecimal usedStorage
	BigDecimal unusedStorage
	Integer uptime
	Integer balloonedMem
	Integer privateMem
	Integer sharedMem
	Integer activeMem
	Integer swappedMem
	Integer compressedMem
	String heartbeat
	String guestOs
	BigDecimal percentmem
	BigDecimal percentdisk
	BigDecimal percentcpu
	Date timestamp = new Date()
	VirtualDataCenter vdc
	Long tenantId = 1
	
 static constraints = {
		compressedMem(nullable:true)
		guestOs(nullable:true)
		uptime(nullable:true)
		percentmem(nullable:true)
		percentdisk(nullable:true)
		percentcpu(nullable:true)
		tenantId(display:false)
    }

	String toString() {
		return virtualMachine.toString() + timestamp.toString() + id.toString()
	}
}
