package dashboard
import java.net.URL
import com.vmware.vim25.*
import com.vmware.vim25.mo.*

class MaxJob {
    static triggers = {
      simple startDelay : 600001, repeatInterval: 300001
    }

    def execute() {
      def cal = Calendar.instance   
      cal.add(Calendar.MINUTE, -10)
      def ten = cal.getTime()
      def date= new Date()
      def dateList = [ten,date]

      def des = VirtualMachine.createCriteria()
      def result = des.list{        
      property("description")
      }
     
      result.each{
      def name = it.description
      }       
     
      def instance = new ServiceInstance("https://10.20.20.210/sdk".toURL(), "dashboard", "D45hboard!", true)
      def rootFolder = instance.rootFolder
      def dataCenter = new InventoryNavigator(rootFolder).searchManagedEntities("Datacenter")
			dataCenter.each {
		
  			new InventoryNavigator(it.vmFolder).searchManagedEntities("VirtualMachine").each {

  				def os = it.name
  				def timestamp = new Date()
          def maximum = VirtualMachineStats.createCriteria().get {
            projections {
              max 'consumedHostCPU'
              max 'consumedHostMemory'
              max 'memory'
              max 'activeGuestMemory'
              max 'provisonedStorage'
              max 'usedStorage'
              max 'unusedStorage'
              max 'privateMem'
              max 'sharedMem'
              max 'activeMem'
              max 'swappedMem'
              like("description", "${os}")
            }
            and{
            between('timestamp', ten, date)
            }
     
          }
        def max = new Max(description:os,consumedHostCPU:maximum[0],consumedHostMemory:maximum[1],memory:maximum[2],activeGuestMemory:maximum[3],provisonedStorage:maximum[4],usedStorage:maximum[5],unusedStorage:maximum[6],privateMem:maximum[7],sharedMem:maximum[8],activeMem:maximum[9],swappedMem:maximum[10],timestamp:timestamp).save(failOnError:true)

        }
      }
    }    
}

