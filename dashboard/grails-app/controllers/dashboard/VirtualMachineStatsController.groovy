package dashboard
import groovy.time.*
import org.codehaus.groovy.time.*
import net.Rounding
import groovy.sql.Sql
import java.text.SimpleDateFormat
import groovyx.net.http.*

class VirtualMachineStatsController {

def scaffold = true 

def realtime(Date startdate){
    def graphstring
    BigDecimal.mixin Rounding
    def ghz = 3000
    def vminstance = VirtualMachineStats.get(session.vmid)
    use (TimeCategory) {
    startdate = startdate - 1.hour
    } //if it is refreshing the realtime graph the update param has been passed from the view
    if(params.doupdate){
    vminstance = VirtualMachineStats.get(session.vmid)
    def description = vminstance.virtualMachine
    def items = VirtualMachineStats.findAllByVirtualMachine(description) 
    def newMap2 =[:]
            //create a map of timestamp and data depending on what has been passed 
            if(session.graphtype == "RAM"){

            items.each{
              if (it.timestamp >= startdate){
                def percentage = ((it.activeGuestMemory/it.memory) * 100).round(2)
                  newMap2.put(it.timestamp,percentage)
                }      
            }

        }else if(session.graphtype == "CPU"){
            items.each{
              if (it.timestamp >= startdate){
                 def totalghz= it.cpuCount * ghz
                def percentage = ((it.consumedHostCPU/totalghz) * 100).round(2)
                  newMap2.put(it.timestamp,percentage)
                }      
            }

        }else if(session.graphtype == "Disk"){
            items.each{
              if (it.timestamp >= startdate){
                def percentage = ((it.usedStorage/it.provisonedStorage) * 100).round(2)
                  newMap2.put(it.timestamp,percentage)
                }      
            }

         }
         // so items are not duplicated into the map and only new ones are rendered
    def newitems = newMap2 - session.newMap 
    session.newMap = newMap2
            //convert map to json format for javascript in plot.gsp
    def mydata = newitems as grails.converters.JSON

    //get size of map to pass to view
    def itemtotal = newitems.size()
    session.jsoner = mydata
    render mydata
            }

    else{
        //initial render of graph
        // get name of virtual machine to find all history for this particular machine
    def dateArray = []
    dateArray.add(startdate)
    def jsondate = dateArray as grails.converters.JSON

    vminstance = VirtualMachineStats.get(session.vmid)
    def description = vminstance.virtualMachine
    def items = VirtualMachineStats.findAllByVirtualMachine(description) 
    def newMap =[:]
            //create a map of timestamp and data depending on what has been passed 
          if(params.ram == 'true' ){
                session.graphtype = "RAM"
            items.each{
              if (it.timestamp >= startdate){
                def percentage = ((it.activeGuestMemory/it.memory) * 100).round(2)
                  newMap.put(it.timestamp,percentage)
                }      
            }

        }else if(params.cpu == 'true'  ){
                session.graphtype = "CPU"
            items.each{
              if (it.timestamp >= startdate){
                 def totalghz= it.cpuCount * ghz
                def percentage = ((it.consumedHostCPU/totalghz) * 100).round(2)
                  newMap.put(it.timestamp,percentage)
                }      
            }

         }else if(params.disk == 'true' ){
            session.graphtype = "Disk"
            items.each{
              if (it.timestamp >= startdate){
                def percentage = ((it.usedStorage/it.provisonedStorage) * 100).round(2)
                  newMap.put(it.timestamp,percentage)
                }      
            }

         }
    //so we can render the graph type onto the graph adding to an array then passing the array
    graphstring = session.graphtype

    dateArray.add(graphstring)

        session.newMap =  newMap  
            //convert map to json format for javascript in plot.gsp
    def jsonMap = newMap as grails.converters.JSON
    session.jsoner = [:]
        //get size of map to pass to view also max and min for "pretty" rendering of values 
        def maxval = newMap.max{ it.value }.value + 1
        def minval = newMap.min{ it.value }.value - 1
    def itemtotal = newMap.size()
        //render the view passing the model
    render(view: "realtime", model: [VMList: jsonMap,VMTotal:itemtotal,DateArray:jsondate,Max:maxval,Min:minval])

    }

}

    
def dataset = {
    // depending on the interval this gets the correct start date to plot the graph
    def interval = RollUpType.get(params.dataset)
    def startdate
    def currentDate = new Date()
    if(interval?.description == '1 Hour'){
        use (TimeCategory) {
        startdate = currentDate - 1.hour        
        fetchdata(startdate, 'hour')
    }
    
    } else if(interval?.description == '1 Day'){
        use (TimeCategory) {
        startdate = currentDate - 1.day
        fetchdata(startdate,'day')
        }
    } else if(interval?.description == '1 Week'){
        use (TimeCategory) {
        startdate = currentDate - 1.week
        fetchdata(startdate,'week')
        }
    } else if(interval?.description == '1 Month'){
        use (TimeCategory) {
        startdate = currentDate - 1.month
        fetchdata(startdate, 'month')
        }
    } else if(interval?.description == '1 Year'){
        use (TimeCategory) {
        startdate = currentDate - 1.year
        fetchdata(startdate, 'year')
        }
    } else if(interval?.description == 'Real Time'){
        use (TimeCategory) {
        startdate = currentDate - 1.hour        
        realtime(startdate)
        }
    }

}
    // this is for used for rendering non realtime graphs
def fetchdata(Date startdate, String duration){
    BigDecimal.mixin Rounding
    def graphstring = session.graphtype
    def vminstance = VirtualMachineStats.get(session.vmid)
    startdate = startdate 
    duration = duration
    def enddate = new Date() 
    def dateArray = []
    def ghz = 3000
    def description
    def items
    def newMap
    //start / end date / graph name all added to an array and passed into the view
    dateArray.add(startdate)
    dateArray.add(enddate)
    dateArray.add(graphstring)
    def jsondate = dateArray as grails.converters.JSON
        if(params.doupdate){
        //do update action and session the variables
        
        if(duration =='month'){
            vminstance = VirtualMachineStats.get(session.vmid)
         description = vminstance.virtualMachine
         items = MonthlyStats.findAllByVirtualMachine(description) 
         newMap =[:]
        } 
        else  if(duration =='week'){
         vminstance = VirtualMachineStats.get(session.vmid)
         description = vminstance.virtualMachine
         items = WeeklyStats.findAllByVirtualMachine(description) 
         newMap =[:]
        }
        else  if(duration =='day'){
         vminstance = VirtualMachineStats.get(session.vmid)
         description = vminstance.virtualMachine
         items = VirtualMachineStats.findAllByVirtualMachine(description) 
         newMap =[:]
        }
        else  if(duration =='year'){
         vminstance = VirtualMachineStats.get(session.vmid)
         description = vminstance.virtualMachine
         items = YearlyStats.findAllByVirtualMachine(description) 
         newMap =[:]
        }
        else{

            vminstance = VirtualMachineStats.get(session.vmid)
         description = vminstance.virtualMachine
         items = VirtualMachineStats.findAllByVirtualMachine(description) 
         newMap =[:]
        }

            //create a map of timestamp and data depending on what has been passed 
        if(graphstring == 'RAM'){
            items.each{
              if (it.timestamp >= startdate){
                def percentage = ((it.activeGuestMemory/it.memory) * 100).round(2)
                  newMap2.put(it.timestamp,percentage)
                }      
            }

        }else if(graphstring == 'CPU'){
            items.each{
              if (it.timestamp >= startdate){
                 def totalghz= it.cpuCount * ghz
                def percentage = ((it.consumedHostCPU/totalghz) * 100).round(2)
                  newMap2.put(it.timestamp,percentage)
                }      
            }

         }else if(graphstring == 'Disk'){
            items.each{
              if (it.timestamp >= startdate){
                def percentage = ((it.usedStorage/it.provisonedStorage) * 100).round(2)
                  newMap2.put(it.timestamp,percentage)
                }      
            }

         }


        def newitems = newMap2 - session.newMap 
        session.newMap = newMap2
            //convert map to json format for javascript in plot.gsp
        def mydata = newitems as grails.converters.JSON

        //get size of map to pass to view
        def itemtotal = newitems.size()
        session.jsoner = mydata
        render(view: "standard", model: [VMList: mydata,VMTotal:itemtotal, DateArray:jsondate, EndDate:enddate ])
                }
        //if no update and intial plot
        else{
        // get name of virtual machine to find all history for this particular machine
        

        if(duration =='month'){
            vminstance = VirtualMachineStats.get(session.vmid)
         description = vminstance.virtualMachine
         items = MonthlyStats.findAllByVirtualMachine(description) 
         newMap =[:]
        } 
        else  if(duration =='week'){
         vminstance = VirtualMachineStats.get(session.vmid)
         description = vminstance.virtualMachine
         items = WeeklyStats.findAllByVirtualMachine(description) 
         newMap =[:]
        }
        else  if(duration =='day'){
         vminstance = VirtualMachineStats.get(session.vmid)
         description = vminstance.virtualMachine
         items = VirtualMachineStats.findAllByVirtualMachine(description) 
         newMap =[:]
        }
        else  if(duration =='year'){
         vminstance = VirtualMachineStats.get(session.vmid)
         description = vminstance.virtualMachine
         items = YearlyStats.findAllByVirtualMachine(description) 
         newMap =[:]
        }
        else{

            vminstance = VirtualMachineStats.get(session.vmid)
         description = vminstance.virtualMachine
         items = VirtualMachineStats.findAllByVirtualMachine(description) 
         newMap =[:]
        }

            //create a map of timestamp and Consumed Memory
        if(graphstring == 'RAM'){
            items.each{
              if (it.timestamp >= startdate){
                def percentage = ((it.activeGuestMemory/it.memory) * 100).round(2)
                  newMap.put(it.timestamp,percentage)
                }      
            }

        }else if(graphstring == 'CPU'){
            items.each{
              if (it.timestamp >= startdate){
                 def totalghz= it.cpuCount * ghz
                def percentage = ((it.consumedHostCPU/totalghz) * 100).round(2)
                  newMap.put(it.timestamp,percentage)
                }      
            }

         }else if(graphstring == 'Disk'){
            items.each{
              if (it.timestamp >= startdate){
                def percentage = ((it.usedStorage/it.provisonedStorage) * 100).round(2)
                  newMap.put(it.timestamp,percentage)
                }      
            }

         }
        session.newMap =  newMap  
        //convert map to json format for javascript in plot.gsp
        def jsonMap = newMap as grails.converters.JSON
        session.jsoner = [:]
        //get size of map to pass to view

        def maxval = newMap.max{ it.value }.value + 1
        def minval = newMap.min{ it.value }.value - 1
        def itemtotal = newMap.size()
        //render the view passing the model
        render(view: "standard", model: [VMList: jsonMap,VMTotal:itemtotal, DateArray:jsondate,EndDate:enddate,Max:maxval,Min:minval])
        
    }
}

/////////////////BELOW CODE IS FOR AVERAGE MAX AND MIN /////////////////////////////
def plot2 = {

        def vminstance = VirtualMachineStats.get(session.vmid)
        def description = vminstance.virtualMachine.description


        def items = Average.findAllByDescription(description) 
        def newMap =[:]


        items.each{
                newMap.put(it.timestamp,it.consumedHostMemory)
  

        def jsonMap = newMap as grails.converters.JSON


        def itemtotal = newMap.size()


        render(view: "plot2", model: [VMList: jsonMap,VMTotal:itemtotal ])
        }


    }
    def plot3 = {

        def vminstance = VirtualMachineStats.get(session.vmid)
        def description = vminstance.virtualMachine.description

        def items = Max.findAllByDescription(description) 
        def newMap =[:]


        items.each{
                newMap.put(it.timestamp,it.consumedHostMemory)

            
            //convert map to json format for javascript in plot.gsp

        def jsonMap = newMap as grails.converters.JSON


        //get size of map to pass to view
        def itemtotal = newMap.size()


        //render the view passing the model
        render(view: "plot3", model: [VMList: jsonMap,VMTotal:itemtotal ])
        }

    }

    def plot4 = {
       def vminstance = VirtualMachineStats.get(session.vmid)
        def description = vminstance.virtualMachine.description

        def items = Min.findAllByDescription(description) 
        def newMap =[:]

            //create a map of timestamp and Consumed Memory
        items.each{
                newMap.put(it.timestamp,it.consumedHostMemory)
                //newMap.put(it.timestamp,it.consumedHostCPU)
            
            //convert map to json format for javascript in plot.gsp

        def jsonMap = newMap as grails.converters.JSON


        //get size of map to pass to view
        def itemtotal = newMap.size()

        //render the view passing the model
        render(view: "plot4", model: [VMList: jsonMap,VMTotal:itemtotal ])
        }


    }
    def plot5 = {

        def max = new Max()
        max = Max.get(params.id)
        def description_m = max.description
        def items1 = Max.findAllByDescription(description_m)
        def newMap1=[:]
        items1.each{
            newMap1.put(it.timestamp,it.consumedHostMemory)

            def jsonMap1 = newMap1 as grails.converters.JSON

        

        def average = new Average()
        average = Average.get(params.id)
        def description_av = average.description
        def items2 = Average.findAllByDescription(description_av)
        def newMap2=[:]

        items2.each{
            newMap2.put(it.timestamp, it.consumedHostMemory)

            def jsonMap2 = newMap2 as grails.converters.JSON

        

        def min = new Min()
        min = Min.get(params.id)
        def description = min.description

        def items = Min.findAllByDescription(description) 
        def newMap =[:]

        
        items.each{
                newMap.put(it.timestamp,it.consumedHostMemory)
                

        def jsonMap = newMap as grails.converters.JSON


        //get size of map to pass to view
        def itemtotal = newMap.size()

        def itemtotal1 = newMap1.size()
        def itemtotal2 = newMap2.size()



        //render the view passing the model
        render(view: "plot5", model:[VMList:jsonMap,VMTotal:itemtotal,
           VMList1:jsonMap1,VMTotal1:itemtotal,
            VMList2:jsonMap2, VMTotal2:itemtotal2])
        }

}
        
}

        
    }

//Creating SSH and RDP connections to the selected server
//Only works when client is using a windows machine 
// putty must be installed in root of C drive for SSH
def remote = {

println session.vmid
def vminstance = VirtualMachineStats.get(session.vmid)
def os = vminstance?.guestOs
def ip =  vminstance?.ipAddress

    

if (System.properties['os.name'].toLowerCase().contains('windows')) {
    println "it's Windows"


if(os.toLowerCase().contains('linux')){


def putty = new File( 'C:\\putty.exe' )


if( !putty.exists() ){

flash.message = 'File not found at  C:\\putty.exe Download Putty and place the .exe file in this directory'
downloadputty()
redirect(action:"show", id:vminstance.id)

} else {


            def antubuntu = new AntBuilder()   // create an antbuilder
            antubuntu.exec(outputproperty:"cmdOut",
                             errorproperty: "cmdErr",
                             resultproperty:"cmdExit",
                             failonerror: "true",
                             executable: 'C:\\putty.exe') {
                                             arg(line:ip)
                             }

            redirect(action:'list')
        }
}

else if (os.toLowerCase().contains('windows')) {

def antwindows = new AntBuilder()   // create an antbuilder
antwindows.exec(outputproperty:"cmdOut",
             errorproperty: "cmdErr",
             resultproperty:"cmdExit",
             failonerror: "true",
             executable: 'C:\\Windows\\System32\\mstsc.exe') {
                             arg(line:"""/v: $ip""")
             }
            redirect(action:'list')
}


} 


else {
    flash.message = 'Please Use A Windows Machine'
    redirect(action:"show", id:vminstance.id)
    }





}



def downloadputty = {
      def file = new File("c:/putty2.exe")
      response.setHeader("Content-Type", "application/octet-stream;")
      response.setHeader("Content-Disposition", "attachment, filename=\" putty.exe\"")
      response.setHeader("Content-Length", "${file.size()}")

     response.outputStream << file.text.bytes
    }

/*def highstock = {


def today = new Date()
def sdf = new SimpleDateFormat("yyyy")
def todayYear = sdf.format(today)


def sql = Sql.newInstance("jdbc:mysql://localhost/calligo",
        "root",
        "Pa55word!",
        "com.mysql.jdbc.Driver")
// define the SQL query to execute
def sqlQuery="SELECT timestamp,percentmem FROM calligo1.virtual_machine_stats where virtual_machine_id = 17 order by timestamp"

def chart = [:]

sql.eachRow(sqlQuery){ row ->

chart.put(row.timestamp.toString(), row.percentmem)
}
def itemtotal = chart.size
def mydata = chart as grails.converters.JSON
//println "mydata is" + mydata

   render(view: "highstock", model: [VMList: mydata,VMTotal:itemtotal])
}*/



def vmconsole = {

      def http = new HTTPBuilder("")

      http.request(Method.POST, ContentType.ANY){


      uri.path = "/api/sessions"
     uri.query = [query:"type=vm&filter=status==POWERED_ON&fields=name,containerName", user:'root', pass:'Mn4£dss2Z', format:'l']

      response.success = {resp, text->
      resp.headers.each{h->
  //println "${h.name}:${h.value}"
       }
    }
      resp.getHeaders('Set-Cookie').each{ 

    def name = it.name
    def str = 'RT_SID_example.com.80='
    def s= it.value.split(';')[0]
    def baseDomain =  s.split('=').first()

   //cookies.add(session)
  

   //def c = cookies.join()


    }
  }

    http.request(Method.GET, ContentType.ANY){

      uri.path = "/api/query"
    "vcloud-authorization: n/+ZglmIwJ2SbWlyz04XC5sHUDJqefU1mCMa9TFu9lk="
 
  }



}


def list () {


  flash.message = "You do not have permissions to see this."
  redirect (controller: 'virtualMachine' , action:'list')


}

def chart ={
  def vminstance = VirtualMachineStats.get(session.vmid)
        def description = vminstance.virtualMachine.description

        def items = VirtualMachineStats.findAllByDescription(description) 
        def newMap =[]
        def newMap1 =[]
        def newMap2 =[]
        def newMap3 =[]
        def newMap4=[]

        items.each{
                
                def list =it.activeGuestMemory
                def list1 = it.privateMem
                def list2 = it.memoryOverhead
                def list3 = it.consumedHostMemory
                def list4 = it.memory

                  
            newMap.add(list)
            newMap1.add(list1)
            newMap2.add(list2)
            newMap3.add(list3)
            newMap4.add(list4)
            //convert map to json format for javascript in plot.gsp

        def jsonMap = newMap as grails.converters.JSON
        def jsonMap1 = newMap1 as grails.converters.JSON
        def jsonMap2 = newMap2 as grails.converters.JSON
        def jsonMap3 = newMap3 as grails.converters.JSON
        def jsonMap4 = newMap4 as grails.converters.JSON

        //get size of map to pass to view
        def itemtotal = newMap.size()


    render(view:'chart', model: [VMList: jsonMap,VMList1: jsonMap1,VMList2: jsonMap2,VMList3: jsonMap3,VMList4: jsonMap4,VMTotal:itemtotal])

}

    







}

def chart_storage ={
   def vminstance = VirtualMachineStats.get(session.vmid)
        def description = vminstance.virtualMachine.description

        def items = VirtualMachineStats.findAllByDescription(description) 
        def newMap =[]
        def newMap1 =[]
        def newMap2 =[]
        def newMap3 =[]
        def newMap4=[]

        items.each{
                
                def list =it.usedStorage
                def list1 = it.unusedStorage
                def list2 = it.provisonedStorage
                

                  
            newMap.add(list)
            newMap1.add(list1)
            newMap2.add(list2)
           
            //convert map to json format for javascript in plot.gsp

        def jsonMap = newMap as grails.converters.JSON
        def jsonMap1 = newMap1 as grails.converters.JSON
        def jsonMap2 = newMap2 as grails.converters.JSON
        

        //get size of map to pass to view
        def itemtotal = newMap.size()


    render(view:'chart_storage', model: [VMList: jsonMap,VMList1: jsonMap1,VMList2: jsonMap2,VMTotal:itemtotal])

}



}

}
