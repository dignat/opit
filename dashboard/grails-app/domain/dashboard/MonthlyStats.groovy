package dashboard

class MonthlyStats extends VirtualMachineStats{
	String frequency = 'Monthly'
	
    static constraints = {
		frequency(blank:false)
    }

	String toString() {
		return frequency
	}
}
