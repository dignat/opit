<%@ page import="dashboard.Min" %>
<%@ page import="dashboard.Max" %>
<%@ page import="dashboard.Average" %>
<!doctype html>
<html>
  <head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'Summary.label', default: 'Summary')}" />
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
var vms1 = ${VMList1};
var vms2 = ${VMList2};

var vms3 = new Array(vms,vms1,vms2);
//get pretty list and total as variables for use here
var json = JSON.stringify(vms);


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
           'chartArea': {'width': '90%'},
           'hAxis': {'baselineColor': '#FF0000'}
         },
         // Thus, this view has two columns: the date (axis) and the consumed memory (line series).
         'chartView': {
           'columns': [0, 2]
         },
         // 1 hour in milliseconds
         'minRangeSize': 360000
       }
     },
     // Initial range: March 2nd -- March 16th.
     'state': {'range': {'start': new Date(2013, 3, 2), 'end': new Date(2013, 4,26)}}
   });

   var chart = new google.visualization.ChartWrapper({
     'chartType': 'LineChart',
     'containerId': 'chart',
     'options': {
       // Use the same chart area width as the control for axis alignment. Min and Max for the Vertical Axis
       'chartArea': {'height': '80%', 'width': '90%'},
       'hAxis': {'slantedText': false},
       'vAxis': {'viewWindow': {'min': 0, 'max': 3250}},
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
         }, 1,2,3]
     }
   });
//column data formats
   var data = new google.visualization.DataTable();
   data.addColumn('datetime', 'Date');
   data.addColumn('number', 'RAM average');
   data.addColumn('number', 'RAM min');
   data.addColumn('number', 'RAM max');

  


// for each key in json map
for(var index in vms) {
 // for(var CPU in vms){
  for(var index1 in vms1){
    for(var index2 in vms2){
 

//format groovy Date String to required datetime format

var newindex = index.substring(0, index.length -2);
var dt  = newindex.toString().split(/\-|\s/);

dat = new Date(dt.slice(0,3).join('/')+' '+dt[3]);

var newindex1 = index1.substring(0, index1.length -2);
var dt1  = newindex1.toString().split(/\-|\s/);

dat1 = new Date(dt1.slice(0,3).join('/')+' '+dt1[3]);

var newindex2 = index2.substring(0, index2.length -2);
var dt2  = newindex2.toString().split(/\-|\s/);

dat2 = new Date(dt2.slice(0,3).join('/')+' '+dt2[3]);
 dat =dat1=dat2;

//add row per item in array
data.addRow([dat, vms[index], vms1[index1], vms2[index2]]);

}
}


}

//} //bind control to the chart and draw the graph using the imported data
   dashboard.bind(control, chart);
   dashboard.draw(data);

}
</script>

<div id="dashboard">
      <!--Divs that will hold each control and chart-->  

      <div id="chart"></div>
      <div id="control"></div>
    </div>
  
      <g:form>
        <fieldset class="buttons">
          <g:hiddenField name="id" value="${averageInstance?.id}" />
        </fieldset>
      </g:form>
    </div>
  </body>
</html>