package dashboard
import java.net.URL
import com.vmware.vim25.*
import com.vmware.vim25.mo.*

class AverageJob {
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
        def avg = VirtualMachineStats.createCriteria().get {
           projections {
            avg 'consumedHostCPU'
            avg 'consumedHostMemory'
            avg 'memory'
            avg 'activeGuestMemory'
            avg 'provisonedStorage'
            avg 'usedStorage'
            avg 'unusedStorage'
            avg 'privateMem'
            avg 'sharedMem'
            avg 'activeMem'
            avg 'swappedMem'  
            like("description", "${os}")
          }
          and{
          between('timestamp', ten, date)
          }

        }
      def average = new Average(description:os,consumedHostCPU:avg[0],consumedHostMemory:avg[1],memory:avg[2],activeGuestMemory:avg[3],provisonedStorage:avg[4],usedStorage:avg[5],unusedStorage:avg[6],privateMem:avg[7],sharedMem:avg[8],activeMem:avg[9],swappedMem:avg[10],timestamp:timestamp).save(failOnError:true)
      
        }
      }
    }
}

