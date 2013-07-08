
<%@ page import="dashboard.VirtualMachine" %>
<%@ page  import grails.converters.JSON %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'virtualMachine.label', default: 'VirtualMachine')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
                  
		<a href="#show-virtualMachine" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" controller="virtualMachine" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
          <g:form controller="virtualMachineStats" action="dataset">
<g:select style="float:right;"name="dataset" from="${dashboard.RollUpType.list()}"  noSelection="['':'Time Range']" onchange="submit()" optionKey="id" optionValue="description">
</g:select>
</g:form>
		</div>

		<div id="show-virtualMachine" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>

			
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
var data;
var dashboard;
var chart;
var control;
var vms;
var json;
var vmtotal;
var mydata;
var startdate;
var enddate;
var datearray;
var max;
var min;
var graphstring;
  // Load the Visualization API and the controls package.
  // Packages for all the other charts you need will be loaded
  // automatically by the system.
  google.load('visualization', '1.0', {'packages':['controls']});

  // Set a callback to run when the Google Visualization API is loaded.
  

//recieve list from VirtualMachineController
function drawDashboard() {
 vms = ${VMList};

datearray = ${DateArray };
 vmtotal =  ${VMTotal };
  max =  ${Max };
   min =  ${Min };
    graphstring = datearray[2];


startdate = datearray[0].toString();
enddate = datearray[1];
//var dateformat = new Date(startdate);



   dashboard = new google.visualization.Dashboard(
       document.getElementById('dashboard'));

    control = new google.visualization.ControlWrapper({
     'controlType': 'ChartRangeFilter',
     'containerId': 'control',
     'options': {
       // Filter by the date axis.
       'filterColumnIndex': 0,
       'ui': {
         'chartType': 'LineChart',
         'chartOptions': {
           'chartArea': {'width': '90%'},
           'hAxis': {'baselineColor': '#FF0000'}
         },
         // Thus, this view has two columns: the date (axis) and the consumed memory (line series).
         'chartView': {
           'columns': [0, 1]
         },
         // 1 hour in milliseconds
         'minRangeSize': 360000
       }
     },
     // Initial range: March 2nd -- March 16th.
     'state': {'range': {'start': new Date(startdate), 'end':  new Date(enddate)}}
   });

    chart = new google.visualization.ChartWrapper({
     'chartType': 'LineChart',
     'containerId': 'chart',
     'options': {
       // Use the same chart area width as the control for axis alignment. Min and Max for the Vertical Axis
       'chartArea': {'height': '80%', 'width': '90%'},
       'hAxis': {'slantedText': false},
       'vAxis': {'viewWindow': {'min': min, 'max': max}},
       'legend': {'position': 'none'}
     },
     // Convert the first column from 'date' to 'string'.
     'view': {
       'columns': [
         {
           'calc': function(dataTable, rowIndex) {
             return dataTable.getFormattedValue(rowIndex, 0);
           },
           'type': 'string'
         }, 1]
     }
   });
//column data formats
    data = new google.visualization.DataTable();
   data.addColumn('datetime', 'Date');
   data.addColumn('number', graphstring);
  // data.addColumn('number', 'CPU');
   //data.addColumn('datetime', 'Date');

// for each key in json map
for(var index in vms) {

//format groovy Date String to required datetime format

var newindex = index.substring(0, index.length -2);
var dt  = newindex.toString().split(/\-|\s/);

dat = new Date(dt.slice(0,3).join('/')+' '+dt[3]);
//add row per item in array
data.addRow([dat, vms[index]]);

}

//} //bind control to the chart and draw the graph using the imported data
   dashboard.bind(control, chart);
   dashboard.draw(data);
}
//below executes each interval call above only on page load RJ
function changeDial() {
 
/*mydata = <g:remoteFunction action="fetchdata"
                         params="\'doupdate=\' + doupdate" onSuccess="checkData();"/>*/
                  


    }
//attempt to redraw new row
function checkData() {
  var e = mydata.responseText
       

    var dat2 = e.slice(2,23); //get date
    var data2 = e.slice(25,29); //get value
    var bits = dat2.split(/\D/); //split date into arrays
    var date2 = new Date(bits[0], --bits[1], bits[2], bits[3], bits[4], bits[5]); //convert to datetime format
    var integ = parseInt(data2) //convert value to interger
    if (dat2){
        console.log(date2)
       data.addRow([date2, integ])
       control.draw();
       dashboard.draw(data);

    }
      

}



$(document).ready(function(){

 move = setInterval("changeDial()",60000);


  });


google.setOnLoadCallback(drawDashboard);


</script>


<div id="dashboard">
      <!--Divs that will hold each control and chart-->  
<div>
</div>
      <div id="chart"></div>
      <div id="control"></div>
    </div>

			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${virtualMachineInstance?.id}" />
          <g:hiddenField name="doupdate" value="${true}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
