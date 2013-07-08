package dashboard

class VirtualMachineController {
 def scaffold = true      


	def show(Long id) {
        def virtualMachineInstance = VirtualMachineStats.get(id)
		session.vmid = id

		def virtualMachineStatsInstance = VirtualMachineStats.createCriteria().get{
			eq('virtualMachine', virtualMachineInstance)
			maxResults(1)
			order('timestamp', 'desc')
		}

        if (!virtualMachineInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'virtualMachineStats.label', default: 'VirtualMachineStats'), id])
            redirect(action: "list")
            return
        }
			redirect(controller:'virtualMachineStats', action: 'show', id:id)
       
    }	


	def updateDials = {
				def vm = VirtualMachine.get(25)
				def virtualMachineStatsInstance = VirtualMachineStats.createCriteria().get{
				eq('virtualMachine', vm)
				maxResults(1)
				order('timestamp', 'desc')
				}
				def vminstance = virtualMachineStatsInstance
				render(view: "/login/show", model: [vminstance:vminstance])

	}

	def list(Integer max) {

			def result
			params.max = Math.min(params.max ? params.int('max') : 10, 100)

			def currentvdc = VirtualDataCenter?.get(session?.vdcid)
			if (!currentvdc){	
			flash.message = "Select a VDC"		
				redirect(action: "updateDials")
				
			}
			else if (currentvdc){
				def vms = VirtualMachine?.findAllByVdc(currentvdc) 

				def vdcsize = vms.size()

				 result = VirtualMachineStats.createCriteria().list(){
						eq('vdc', currentvdc)
						maxResults(vdcsize)
						order('timestamp', 'desc')
						}

				[virtualMachineInstanceList: result,virtualMachineInstanceTotal:result.size()]

			} 
			
	}

	def vmindex = {


	}
	
	def chart = {

  render(view:'chart')
}




}


