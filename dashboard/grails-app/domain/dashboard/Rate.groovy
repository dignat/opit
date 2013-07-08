package dashboard

class Rate {
	
	String currency
	BigDecimal rate

	
	

    static constraints = {
		currency blank:false
		rate (blank:false, scale:6)
    }

	String toString() {
		return currency.toString() + ' ' + rate 
	}
}
