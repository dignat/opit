package dashboard

class ClientController {
	def scaffold = true

	def selectCompany = {
		session.tenantId = params.client

		def currentCompany = Client.get(session.tenantId)
		println "current company is"+currentCompany
		println "session.tenantId"+session.tenantId

		redirect(uri:'/')
	}


	def calligosplash = {

		
	}
}
