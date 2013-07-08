<%@ page import="dashboard.VirtualMachine" %>
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
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-virtualMachine" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">


  // Load the Visualization API and the controls package.
  // Packages for all the other charts you need will be loaded
  // automatically by the system.
  google.load('visualization', '1.0', {'packages':['controls']});

  // Set a callback to run when the Google Visualization API is loaded.
  google.setOnLoadCallback(drawDashboard);

//recieve list from VirtualMachineController
function drawDashboard() {
var vms = ${VMList};
//get pretty list and total as variables for use here
var json = JSON.stringify(vms)
var vmtotal =  ${VMTotal};

  var dashboard = new google.visualization.Dashboard(
       document.getElementById('dashboard'));

   var control = new google.visualization.ControlWrapper({
     'controlType': 'ChartRangeFilter',
     'containerId': 'control',
     'options': {
       // Filter by the date axis.
       'filterColumnIndex': 0,
       'ui': {
         'chartType': 'LineChart',
         'chartOptions': {
           'chartArea': {'width': '50%'},
           'hAxis': {'baselineColor': 'none'}
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
     'state': {'range': {'start': new Date(2013, 2, 2), 'end': new Date(2013, 2, 26)}}
   });

   var chart = new google.visualization.ChartWrapper({
     'chartType': 'LineChart',
     'containerId': 'chart',
     'options': {
       // Use the same chart area width as the control for axis alignment. Min and Max for the Vertical Axis
       'chartArea': {'height': '50%', 'width': '50%'},
       'hAxis': {'slantedText': false},
       'vAxis': {'viewWindow': {'min': 0, 'max': 100}},
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
   var data = new google.visualization.DataTable();
   data.addColumn('datetime', 'Date');
   data.addColumn('number', 'CPU');
 //data.addColumn('number', 'CPU');
   //data.addColumn('datetime', 'Date');

  


// for each key in json map
//for(var index in vms) {
  for(var CPU in vms){

//format groovy Date String to required datetime format

var cpu = CPU.substring(0, CPU.length -2);
var r  = cpu.toString().split(/\-|\s/);

dat = new Date(r.slice(0,3).join('/')+' '+r[3]);

//add row per item in array
data.addRow([dat, vms[CPU]]);

}

//} //bind control to the chart and draw the graph using the imported data
   dashboard.bind(control, chart);
   dashboard.draw(data);

}



$(document).ready(function(){

 move = setInterval("changeDial(1)",5000);


  });









</script>

<div id="dashboard" style = "width:500px; height:200px">
      <!--Divs that will hold each control and chart-->     
      <div id="chart"></div>
      <div id="control"></div>
    </div>
	
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${virtualMachineInstance?.id}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
