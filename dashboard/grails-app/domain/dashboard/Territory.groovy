package dashboard

class Territory {
	String description
	
    static constraints = {
		description(blank:false)
    }

	String toString() {
		return description
	}
}
