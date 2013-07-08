package dashboard

class RateController {
	def scaffold = true


	def calculate = {

		def invoiceinstance = Invoice.get(params.id)

		def client = invoiceinstance.client

		def items = Invoice.findAllByClient()
		def newMap = []

		items.each{
			newMap.put(it.total)
		}

		def nat = Rate.findByName('National Rate')
		def usd = Rate.findByName('USD')
		def euro = Rate.findByName('EURO')

		def ratetotal = newMap
		ratetotal.each{
			switch(it){
				case 'nat':
				render (template: "natRateCalculator")
				break
				case 'usd':
				render (template : "usdRateCalculator")
				break
				case 'euro':
				render (template : "euroRateCalculator")
				break
			}
		}











	}
}
