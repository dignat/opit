
<%@ page import="dashboard.VirtualMachine" %>
<!doctype html>
<html>
  <head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'virtualMachine.label', default: 'VirtualMachine')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
    <script src= "${resource(dir:'js',file: 'highcharts.js')}"></script>
<script src="${resource(dir:'js',file: 'exporting.js')}"></script>


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
        function();
    });
});
</script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>

<script type="text/javascript">
/*
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
        vms1 = ${VMList1};
        vms2 = ${VMList2};
        vms3 = ${VMList3};
        for(index in vms,vms1, vms2,vms3){
          var newindex = index.substring(0, index.length -2);
        

        var data = google.visualization.arrayToDataTable([
          ['Task', 'Total Memory'],
          ['Active Guest Memory',   vms[index]],
          ['Active Memory',      vms1[index]],
          ['Memory Overhead',  vms2[index]],
          ['Consumed Host Memory', vms3[index]],
          
        ]);
}
        var options = {
          title: 'Used Memory'
        };

        var chart = new google.visualization.PieChart(document.getElementById('demo-1'));
        chart.draw(data, options);
      }

      google.load("visualization", "1", {packages:["corechart"]});

 google.setOnLoadCallback(drawChart);
window.onresize = drawChart;
*/
$(function () {
    var chart;
    var vms;
    vms = ${VMList};
        vms1 = ${VMList1};
        vms2 = ${VMList2};
        
        for(index in vms,vms1, vms2){
          var newindex = index.substring(0, index.length -2);
}

    $(document).ready(function () {
     
        
      // Build the chart
        $('#demo-1').highcharts({
 
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: 'Used Storage'
            },
            tooltip: {
              pointFormat: '{series.name}: <b>{point.percentage}%</b></br>',
              percentageDecimals: 0
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: false
                    },
                    showInLegend: true
                }
            },
            series: [{
                type: 'pie',
                name: 'Storage usage',
                data: [
                    ['Used Storage',   vms[index]],
                    ['Unused Storage',       vms1[index]],
                    {
                        name: 'Provisoned Sotrage',
                        y: vms2[index],
                        sliced: true,
                        selected: true
                    },
                    
                    
                ]
            }]
        });

    });
    
});

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
