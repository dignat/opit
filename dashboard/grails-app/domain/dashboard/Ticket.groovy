package dashboard

class Ticket {
	String tid
	String tlastUpdated
	String tsubject
	String tresolved
	String tstatus
	String tqueue
	String token
	String towner
	String tcreator
	String tpriority
	String tinitialPriority
	String tfinalPriority
	String trequestors
	String tcc
	String tadminCc
	String tcreated
	String tstarts
	String tstarted
	String tdue
	String ttold
	String ttimeEstimated
	String ttimeWorked
	String ttimeLeft
	Long tenantId = 1
	
    static constraints = {
		tenantId(display:false)
		tqueue(blank:false)
		tid(blank:false)
		
		
    }

	String toString() {
		
	}
}
