import dashboard.*
import CustomTimeoutSessionListener


class BootStrap {

		def springSecurityService
		def configService

    def init = { servletContext->     	
    	 
    	servletContext.addListener(CustomTimeoutSessionListener)
    	 

    	println "Beginning Bootstrap"

    	

    	if(!Client.count()){
    		

		def calligo = new Client(company:'Calligo', address1:'24 Hill Street',city:'St Helier', country:'Jersey', clientID:'ABC123').save(failOnError:true)
		def ibm = new Client(company:'IBM', address1:'10 Pall Mall',city:'London', country:'United Kingdom', clientID:'ABC123').save(failOnError:true)
		def microsoft = new Client(company:'Microsoft', address1:'2 Oxford Street ',city:'London', country:'United Kingdom', clientID:'ABC123').save(failOnError:true)
		def oracle = new Client(company:'Client', address1:'24 Hill Street',city:'London', country:'United Kingdom', clientID:'ABC123').save(failOnError:true)



    	}
    	if(!Billing.count()){
    		def calligo = Client.findByCompany("Calligo")
    		def ibm = Client.findByCompany("IBM")
    		def client = Client.findByCompany("Client")

    		def generated = new Billing(client:calligo, status:'Generated').save(failOnError:true)
    		def sent = new Billing(client:ibm, status:'Sent').save(failOnError:true)

    	}

		if(!Rate.count()){
			def calligo = Client.findByCompany("Calligo")
			def ibm = Client.findByCompany("IBM")
			def client = Client.findByCompany("Client")
	

			def nat = new Rate(client:calligo,currency:'GBP',rate:1).save(failOnError:true)
			def usd = new Rate(client:ibm,currency:'USD',rate:2.5).save(failOnError:true)
			def euro = new Rate(client:client,currency:'EURO',rate:1.8).save(failOnError:true)

		}
		

		
		
    	//contact type
    	if(!ContactType.count()){
    		def billing = new ContactType(description:'Billing').save(failOnError:true)
    		def technical = new ContactType(description:'Technical').save(failOnError:true)

    	}

		if(!Contact.count()){
			def calligo = Client.findByCompany("Calligo")
		def julian = new Contact(title:'Mr', firstName:'Julian', lastName:'Box', jobTitle:'CEO', email:'julian.box@calligo.net', client:calligo).save(failOnError:true)

    	}
		
		if(!VirtualDataCenter.count()){
			def calligo = Client.findByCompany("Calligo")
			def ibm = Client.findByCompany("IBM")
		def dataCenter = new VirtualDataCenter(description:'Development vCenter', host:'10.200.1.51', username:'administrator', password: 'Pa55word!').save(failOnError:true)
		def dataCenter2 = new VirtualDataCenter(description:'Live vCenter', host:'10.200.1.52', username:'administrator', password: 'Pa55word!').save(failOnError:true)
		def dataCenter3 = new VirtualDataCenter(description:'Live IBM vCenter', host:'10.200.1.52', username:'administrator', password: 'Pa55word!',tenantId:2).save(failOnError:true)
		calligo.addToVirtualDataCenters(dataCenter)
		calligo.addToVirtualDataCenters(dataCenter2)
		ibm.addToVirtualDataCenters(dataCenter3)
    	}
		

		
			
		if(!Product.count()){
			def acctDate= new Date() + 30

		def ram = new Product(description:'IaaS RAM GB per month', frequency:'Monthly').save(failOnError:true)	
		def cpu = new Product(description:'IaaS CPU per month', frequency:'Monthly').save(failOnError:true)	
		def disk = new Product(description:'IaaS Disk GB per month', frequency:'Monthly').save(failOnError:true)	
		def iop = new Product(description:'IaaS IOPs per month', frequency:'Monthly').save(failOnError:true)	
		def sdx = new Product(description:'SDX per transaction', frequency:'Monthly').save(failOnError:true)	
		def sugar = new Product(description:'Sugar CRM per user/month', frequency:'Monthly').save(failOnError:true)	
		def cloudbox = new Product(description:'CloudBox per user/month', frequency:'Monthly').save(failOnError:true)
		def cloudsafe = new Product(description:'CloudSafe per user/month', frequency:'Monthly').save(failOnError:true)	
		def clouddesk = new Product(description:'CloudDesk per user/month', frequency:'Monthly').save(failOnError:true)
		def cloudcore = new Product(description:'CloudCore per month', frequency:'Monthly').save(failOnError:true)
		def cloudstor = new Product(description:'CloudStor per month',frequency:'Monthly').save(failOnError:true)
		def cloudmail = new Product(description:'CloudMail per user/month',frequency:'Monthly').save(failOnError:true)
		def clouddoc = new Product(description:'CloudDoc per month', frequency:'Monthly').save(failOnError:true)
		def keyedin = new Product(description:'Keyed In Solution per month', frequency:'Monthly').save(failOnError:true)
		def trendmicro = new Product(description:'Trend Micro Systems per month', frequency:'Monthly').save(failOnError:true)
    	}	
		
		


    	if(!Item.count()){



			1.upto(10){
				Random rand = new Random()
    		    def randomInt = rand.nextInt(14) +1
    			def ranprod = Product.get(randomInt)
				def item = new Item(product:ranprod, units:randomInt).save(failOnError:true)
			}
    	}

    	if(!Invoice.count()){
    		1.upto(5){
    		def calligo = Client.findByCompany("Calligo")
    		def rate = Rate.findByCurrency("GBP")
    				def invoice = new Invoice(client:calligo, rate:rate)

    				
				1.upto(3){
				Random rand = new Random()
				def ranItem = rand.nextInt(9) +1
				def item = Item.get(ranItem)
				
				
				invoice.addToItems(item)
				
				
				invoice.save(failOnError:true)
				}
    		

    		}	


    	}

    	def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(failOnError: true)
    	def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
    	def calligo = Client.findByCompany("Calligo")
    	def normalUser = User.findByUsername('user1') ?: new User(
				username: 'user1',
				password: 'password123',
				accountExpired:false,
				accountLocked:false,
				passwordExpired:false,
				enabled: true,
				email: 'ryan.jeffs@calligo.net',
				client:calligo).save(failOnError: true)

    	if (!normalUser.authorities.contains(userRole)) {
			UserRole.create normalUser, userRole
		}

		def adminUser = User.findByUsername('Calligo') ?: new User(
				username: 'Calligo',
				password: 'Da5hboard',
				accountExpired:false,
				accountLocked:false,
				passwordExpired:false,
				enabled: true,
				email: 'ryan.jeffs@calligo.net',
				client:calligo).save(failOnError: true)

		if (!adminUser.authorities.contains(userRole)) {
		UserRole.create adminUser, userRole
	}        
	if (!adminUser.authorities.contains(adminRole)) {
		UserRole.create adminUser, adminRole
	}

		new Requestmap(url: '/js/**', configAttribute: 'IS_AUTHENTICATED_ANONYMOUSLY').save()
		new Requestmap(url: '/css/**', configAttribute: 'IS_AUTHENTICATED_ANONYMOUSLY').save()
		new Requestmap(url: '/images/**', configAttribute: 'IS_AUTHENTICATED_ANONYMOUSLY').save()
		new Requestmap(url: '/reports/**', configAttribute: 'IS_AUTHENTICATED_ANONYMOUSLY').save()
		new Requestmap(url: '/login/**', configAttribute: 'IS_AUTHENTICATED_ANONYMOUSLY').save()
		new Requestmap(url: '/logout/**', configAttribute: 'IS_AUTHENTICATED_ANONYMOUSLY').save()
		new Requestmap(url: '/*', configAttribute: 'IS_AUTHENTICATED_ANONYMOUSLY').save()

		new Requestmap(url: '/billing/**', configAttribute: 'ROLE_ADMIN,ROLE_USER').save()
		new Requestmap(url: '/invoice/**', configAttribute: 'ROLE_ADMIN,ROLE_USER').save()
		new Requestmap(url: '/serviceMonitor/**', configAttribute: 'ROLE_ADMIN,ROLE_USER').save()
		new Requestmap(url: '/solidFireStorage/**', configAttribute: 'ROLE_ADMIN,ROLE_USER').save()
		new Requestmap(url: '/ticket/**', configAttribute: 'ROLE_ADMIN,ROLE_USER').save()
		new Requestmap(url: '/virtualMachine/**', configAttribute: 'ROLE_ADMIN,ROLE_USER').save()
		new Requestmap(url: '/virtualMachineStats/**', configAttribute: 'ROLE_ADMIN,ROLE_USER').save()
		new Requestmap(url: '/virtualDataCenter/**', configAttribute: 'ROLE_ADMIN,ROLE_USER').save()


		new Requestmap(url: '/client/**', configAttribute: 'ROLE_ADMIN').save()
		new Requestmap(url: '/contact/**', configAttribute: 'ROLE_ADMIN').save()
		new Requestmap(url: '/contactType/**', configAttribute: 'ROLE_ADMIN').save()
		new Requestmap(url: '/discount/**', configAttribute: 'ROLE_ADMIN').save()
		new Requestmap(url: '/import/**', configAttribute: 'ROLE_ADMIN').save()
		new Requestmap(url: '/item/**', configAttribute: 'ROLE_ADMIN').save()
		new Requestmap(url: '/product/**', configAttribute: 'ROLE_ADMIN').save()
		new Requestmap(url: '/productPrices/**', configAttribute: 'ROLE_ADMIN').save()
		new Requestmap(url: '/purchasedProducts/**', configAttribute: 'ROLE_ADMIN').save()
		new Requestmap(url: '/rate/**', configAttribute: 'ROLE_ADMIN').save()
		new Requestmap(url: '/requestMap/**', configAttribute: 'ROLE_ADMIN').save()
		new Requestmap(url: '/role/**', configAttribute: 'ROLE_ADMIN').save()
		new Requestmap(url: '/territory/**', configAttribute: 'ROLE_ADMIN').save()
		new Requestmap(url: '/user/**', configAttribute: 'ROLE_ADMIN').save()
		new Requestmap(url: '/userRole/**', configAttribute: 'ROLE_ADMIN').save()

		if(!RollUpType.count()){
    		def hourly = new RollUpType(description:'1 Hour').save(failOnError:true)
    		def daily = new RollUpType(description:'1 Day').save(failOnError:true)
    		def weekly = new RollUpType(description:'1 Week').save(failOnError:true)
    		def monthly = new RollUpType(description:'1 Month').save(failOnError:true)
    		def yearly = new RollUpType(description:'1 Year').save(failOnError:true)
    	}
			
    	println "Ending Bootstrap"
		
    }

}
