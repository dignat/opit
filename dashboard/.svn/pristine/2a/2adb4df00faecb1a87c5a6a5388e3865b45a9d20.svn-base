package dashboard

class VirtualDataCenterController {
	def scaffold = true

	def selectVdc = {
		session.vdcid = params.host
		def currentCompany = VirtualDataCenter.get(session.vdcid)

		redirect(controller: 'virtualMachine' ,action:'list')
	}

	




}
