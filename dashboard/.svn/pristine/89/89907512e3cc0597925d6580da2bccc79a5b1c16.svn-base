package dashboard
import java.net.URL
import com.vmware.vim25.*
import com.vmware.vim25.mo.*
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;


class PerfJob {
    static triggers = {
      simple repeatInterval: 30000l // execute job once in 5 seconds
    }

     def execute() {
        // execute job

		def instance = new ServiceInstance("https://10.20.20.210/sdk".toURL(), "dashboard", "D45hboard!", true)
		def rootFolder = instance.rootFolder
		
		def dataCenter = new InventoryNavigator(rootFolder).searchManagedEntities("Datacenter")
			dataCenter.each {

		def vm = 	new InventoryNavigator(it.vmFolder).searchManagedEntity("VirtualMachine","LifeRay")

				def os = vm.name


				PerformanceManager perfMgr = instance.getPerformanceManager()
				PerfCounterInfo[] perfCounters = perfMgr.getPerfCounter()

				for (int i = 0; i < perfCounters.length; i++) {
	PerfCounterInfo perfCounterInfo = perfCounters[i]
	String perfCounterString = perfCounterInfo?.getNameInfo()?.getLabel() + " (" + perfCounterInfo?.getGroupInfo()?.getKey() +")Rollup is:"+ perfCounterInfo.getRollupType()+") in "+ perfCounterInfo?.getUnitInfo()?.getLabel()+ "( " + perfCounterInfo?.getStatsType().toString()+ ")"
	//	println(perfCounterInfo.getKey() + " : " + perfCounterString);
}



				def READ_RATE = 173;
				def WRITE_RATE = 174;

			PerfProviderSummary summary = perfMgr.queryPerfProviderSummary(vm)
			int perfInterval = summary.getRefreshRate()//default is 20seconds
			//VM start end interval
			def queryAvailablePerfMetric = perfMgr.queryAvailablePerfMetric(vm, null, null, perfInterval)
		


//below code will fill an array based on the counter id we wish to retrieve
			def list = new ArrayList<PerfMetricId>()
			for (int i2 = 0; i2 < queryAvailablePerfMetric?.length; i2++) {
				PerfMetricId perfMetricId = queryAvailablePerfMetric[i2]
				//println "countid"+perfMetricId?.getCounterId().toString()
				if (READ_RATE == perfMetricId.getCounterId() || WRITE_RATE == perfMetricId.getCounterId()) {
					list.add(perfMetricId)


				}
			}
			//counter ids
			PerfMetricId[] pmis = list.toArray(new PerfMetricId[list.size()])
			//println "pmis"+pmis.toString()
			//buildings the query
			PerfQuerySpec qSpec = new PerfQuerySpec()
			qSpec.setEntity(vm.getMOR())
			qSpec.setMetricId(pmis)
			qSpec.intervalId = perfInterval
			qSpec.maxSample = 1 //sample size NB:CPUs return 1 per core


					PerfEntityMetricBase[] pembs = perfMgr.queryPerf(qSpec)
			for (int i = 0; pembs != null && i < pembs.length; i++) {
				PerfEntityMetricBase val = pembs[i]
				PerfEntityMetric pem = (PerfEntityMetric) val
				PerfMetricSeries[] vals = pem.getValue()
				PerfSampleInfo[] infos = pem.getSampleInfo()

				for (int j = 0; vals != null && j < vals.length; ++j) {
					PerfMetricIntSeries val1 = (PerfMetricIntSeries) vals[j]
					long[] longs = val1.getValue()
					for (int k = 0; k < longs.length; k++) {
						//println(infos[k]?.getTimestamp()?.getTime().toString() + " : " + longs[k] + "instance is:" +vals[k].getId().getInstance().toString())
						
					}
				}
			}

			
		}

		instance.serverConnection.logout()



    }
    
}

