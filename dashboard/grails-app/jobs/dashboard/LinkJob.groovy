package dashboard
import java.net.URL
import groovy.xml.MarkupBuilder
import groovy.sql.Sql

class LinkJob {
    static triggers = {
      simple repeatInterval: 60000 // execute job once in 5 seconds
    }
	

    def execute() {
        // execute job
	/*	def addres = new XmlSlurper().parse('http://www.ecb.int/stats/eurofxref/eurofxref-daily.xml')
			
			
		 addres.Cube.Cube.Cube.each{cube->
			def currenc = cube.@currency.text()
			//println currenc
			def rat = cube.@rate.text()
			//println rat
			def euro_gbp = addres.Cube.Cube.Cube[5].@rate.text().toBigDecimal()
			
		def gbp_euro = 1.div(euro_gbp)
		//println gbp_euro
		def euro_usd = addres.Cube.Cube.Cube[0].@rate.text().toBigDecimal()
		def gbp_usd = gbp_euro.multiply(euro_usd)
		//println gbp_usd
		
		
        
		def xml = new MarkupBuilder(new FileWriter(new File('./web-app/xml/rate.xml')))
		//def writer = new File("./web-app/xml/rate.xml")
		//writer << xml.bind{
		xml.Rates{
			Rates(currency:'GBP',rate:"1.00")
			Rates(currency:'EURO', rate:"${gbp_euro}")
			Rates(currency:'USD',rate:"${gbp_usd}")
		}
		//}	

		
		def xmlrate = new XmlSlurper().parse('./web-app/xml/rate.xml')

		xmlrate.Rates.each{rates->
			def currency = rates.@currency.text()
			//println currency
			def rate = rates.@rate.text()
			//println rate

			
		


			
			


			

			


			def xmlsize = Rate.findAll()


			//println xmlsize.size()

			
			if(xmlsize.size()<3){

def exrate = new Rate(rates.attributes()).save(failOnError:true)
			}else{

				
				def rate1 = Rate.get(1)
				rate1.rate = 1.000
				rate1.save()
				def rate2 =  Rate.get(2)
				rate2.rate = gbp_euro.toBigDecimal()
				rate2.save()
				def rate3 = Rate.get(3)
				rate3.rate=gbp_usd.toBigDecimal()
				rate3.save()

				//do nothing
			}
			/*if(xmlsize.size()>3){

				def sql = groovy.sql.Sql.newInstance(
      "jdbc:mysql://localhost/rates?userUnicode=yes&characterEncoding=utf8",
      "root",
      "Pa55word",
      "com.mysql.jdbc.Driver")

				sql.execute("truncate rate")
			}*/

			
	//	}

//}



		
			
			
			
		
		 }
			 
		
		/*addres.Cube.Cube.Cube[0].'@rate'.each{
			def rate = it.@rate
			println rate
			def exrate = new Rate(rate:rate).save(failOnError:true)
		 
		}
		*/
		
    
}


