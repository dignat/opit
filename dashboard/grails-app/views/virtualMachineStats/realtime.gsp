
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

<script type = "text/javascript">
$(document).ready(function () {
    $(window).resize(function(){
        drawChart();
    });
});
</script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>

<script type="text/javascript">

var data;
var options;
var dashboard;
var chart;
var control;
var vms;
var json;
var vmtotal;
var mydata;
var datearray;
var max;
var min;
var graphstring;



    function drawChart() {
      vms = ${VMList};
      datearray = ${DateArray };
        max =  ${Max };
        min =  ${Min };
        graphstring = datearray[1];
      startdate = datearray[0]

      options = {
      
     
      vAxis: {minValue:0, maxValue:100},
      
      animation: {
      duration: 1000,
      easing: 'in'
      }
    };

           
           chart = new google.visualization.LineChart(document.getElementById('demo-1'));
           data = new google.visualization.DataTable();

           data.addColumn('datetime', 'Date');
           data.addColumn('number', graphstring);

               for(var index in vms) {
                //format groovy Date String to required datetime format
                var newindex = index.substring(0, index.length -2);
                var dt  = newindex.toString().split(/\-|\s/);
                dat = new Date(dt.slice(0,3).join('/')+' '+dt[3]);
                //add row per item in array
                data.addRow([dat, vms[index]]);
                }        
          chart.draw(data, options);
      }

  // Load the Visualization API and the controls package.
  // Packages for all the other charts you need will be loaded
  // automatically by the system.

//below executes each interval call above only on page load RJ
function changeDial() {
 
mydata = <g:remoteFunction action="realtime"
                         params="\'doupdate=\' + doupdate" onSuccess="checkData();"/>
                  
    }
//attempt to redraw new row
function checkData() {
  var e = mydata.responseText
       
    var dat2 = e.slice(2,23); //get date
    var data2 = e.slice(25,29); //get value
    var bits = dat2.split(/\D/); //split date into arrays
    var date2 = new Date(bits[0], --bits[1], bits[2], bits[3], bits[4], bits[5]); //convert to datetime format
    var integ = parseFloat(data2) //convert value to interger
    if (dat2){
        console.log(date2)
       data.addRow([date2, integ])
       chart.draw(data, options);

    }
      

}



$(document).ready(function(){

 move = setInterval("changeDial()",10000);


  });

google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);


window.onresize = drawChart;


</script>


    <div id="demo-1" style="min-width: 300px; height:400px; margin: 0 auto" ></div>



			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${virtualMachineInstance?.id}" />
          <g:hiddenField name="doupdate" value="${true}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
