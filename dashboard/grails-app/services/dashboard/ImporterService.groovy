package dashboard

class ImporterService {
static transactional = false

    def masterImport(importInstance) {


		String file = new String(importInstance.file)


			file.toCsvReader(['skipLines':'1']).eachLine { tokens ->

			def description = 	tokens[0]
			def currentproduct 

			currentproduct = Product.findByDescription(description)

			if(!currentproduct){

				currentproduct = new Product(description:tokens[0], 
                 		      frequency:tokens[3],
                 		      importid:importInstance.importid)
				
			}


			
			def currentproductprice = 	new ProductPrices(unitPrice:tokens[2], 
                 		      setupPrice:tokens[1],
                 		      importid:importInstance.importid)

			currentproduct.addToProductprices(currentproductprice)
			currentproduct.save(failOnError:true)

			}


    	}
	}
