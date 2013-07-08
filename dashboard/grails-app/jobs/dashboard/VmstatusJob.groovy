package dashboard
import java.net.URL
import com.vmware.vim25.*
import com.vmware.vim25.mo.*
import net.Rounding
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;


class VmstatusJob {
    static triggers = {
      simple repeatInterval: 60000l // execute job once in 60 seconds
    }

    def execute() {
        // execute job
def allMachines = VirtualMachine.findAll()
def machinesexisting = []



def instance = new ServiceInstance("https://10.20.20.210/sdk".toURL(), "dashboard", "D45hboard!", true)
		def mB = 1048576
		def gB = 1073741824
		def day = 86400
		def ghz = 3000
		def about = instance.serviceContent.about
		BigDecimal.mixin Rounding
		def rootFolder = instance.rootFolder
		//render "<p>Root folder: ${rootFolder.name}"


		def dataCenter = new InventoryNavigator(rootFolder).searchManagedEntities("Datacenter")
			dataCenter.each {			
			new InventoryNavigator(it.vmFolder).searchManagedEntities("VirtualMachine").each {

				def os = it.name
				def cpuCount = it.config.hardware.numCPU
				def memory = it.config.hardware.memoryMB
				def memoryOverhead = it.summary.runtime.memoryOverhead/mB
				def state = it.runtime.powerState.toString()
				def vmWareToolStatus = it.summary.guest.toolsStatus.toString()
				def ip = it.guest.ipAddress.toString()
				def consumedHostCPU = it.summary.quickStats.distributedCpuEntitlement
				def consumedHostMemory = it.summary.quickStats.hostMemoryUsage
				def activeGuestMemory = it.summary.quickStats.guestMemoryUsage				
				def usedStorage = (it.summary.storage.committed)/gB
				def unusedStorage = (it.summary.storage.uncommitted)/gB
				def provisonedStorage = usedStorage+unusedStorage
				def uptime = it.summary.quickStats.uptimeSeconds
				def balloonedMem = it.summary.quickStats.balloonedMemory
				def privateMem = it.summary.quickStats.privateMemory
				def sharedMem = it.summary.quickStats.sharedMemory
				def activeMem = it.summary.quickStats.guestMemoryUsage
				def swappedMem = it.summary.quickStats.swappedMemory
				def compressedMem = it.summary.quickStats.compressedMemory
				def heartbeat = it.summary.quickStats.guestHeartbeatStatus.toString()
				def guestOS = it.guest.guestFullName

				//remove machines that are no longer in vcloud director
				allMachines.each{
					if(it.description==os){		
						machinesexisting <<it

					}

				}

				 //create VM if it doesnt exist					
				 def createvm = VirtualMachine.findByDescription(os)
				 if(!createvm){
				 	def vdc = VirtualDataCenter.get(1)
				 	def vmz = new VirtualMachine(description:os, vdc:vdc).save(failOnError:true)
				 }
				//populate vm name and the vdc it belongs too
				def vmname = VirtualMachine.findByDescription(os) 
				def vdc = vmname.vdc
				//also get the tenant id to stop URL manipulation
				def tenant = vmname.tenantId

				//calc percentage stats
				def totalghz = cpuCount * ghz
                def percentcpu = ((consumedHostCPU/totalghz) * 100).round(2)
                def percentdisk = ((usedStorage/provisonedStorage) * 100).round(2)
                def percentmem = ((activeGuestMemory/memory) * 100).round(2)



                //create the vm stats object
				def vm = new VirtualMachineStats(virtualMachine:vmname,description:os, cpuCount:cpuCount, memory:memory, memoryOverhead:memoryOverhead, state:state, vmWareToolStatus:vmWareToolStatus, ipAddress:ip, 
				consumedHostCPU:consumedHostCPU, consumedHostMemory:consumedHostMemory, activeGuestMemory:activeGuestMemory, provisonedStorage:provisonedStorage, usedStorage:usedStorage, 
				unusedStorage:unusedStorage, uptime:uptime, balloonedMem:balloonedMem, privateMem:privateMem, sharedMem:sharedMem, activeMem:activeMem,
				swappedMem:swappedMem, compressedMem:compressedMem, heartbeat:heartbeat , guestOs:guestOS,percentcpu:percentcpu,percentdisk:percentdisk,percentmem:percentmem,vdc:vdc,tenantId:tenant).save(failOnError:true)

			
			
				//this could be removed as we have a new list page
			def oldvm =	ServiceMonitor.findByDescription(os)
			if (oldvm){
			oldvm.delete(flush: true)
			}
			


			new ServiceMonitor(description:os, host: ip, pollingInterval:60000l, verification:'', emailAlert:'ryan.jeffs@calligo.net',status:heartbeat).save(failOnError:true) 	
			
		}

		instance.serverConnection.logout()



    }

    	//compare the 2 lists of items and remove any vms that dont exist
    def diff = allMachines - machinesexisting
    diff.each {

    	def vmtoremove = VirtualMachine.get(it.id)
    		//remove stats first else an error will be thrown
    	 VirtualMachineStats.executeUpdate("delete VirtualMachineStats v where v.virtualMachine =?", [vmtoremove])






    	vmtoremove.delete()
    }	

}
	}