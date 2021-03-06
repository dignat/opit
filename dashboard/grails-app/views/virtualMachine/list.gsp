
<%@ page import="dashboard.VirtualMachine" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'virtualMachine.label', default: 'VirtualMachine')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-virtualMachine" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<sec:ifAllGranted roles="ROLE_ADMIN">
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				</sec:ifAllGranted>
			</ul>
		</div>

		<div id="list-virtualMachine" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="description" title="${message(code: 'virtualMachine.description.label', default: 'Description')}" />
						
						<g:sortableColumn property="guestOs" title="${message(code: 'virtualMachine.guestOs.label', default: 'Guest OS')}" />

						<g:sortableColumn property="heartbeat" title="${message(code: 'virtualMachine.heartbeat.label', default: 'Heartbeat')}" />

						<g:sortableColumn property="vmWareToolStatus" title="${message(code: 'virtualMachine.vmWareToolStatus.label', default: 'VM Tools Status')}" />

						<g:sortableColumn property="percentmem" title="${message(code: 'virtualMachine.activeGuestMemory.label', default: 'Current RAM')}" />

						<g:sortableColumn property="percentcpu" title="${message(code: 'virtualMachine.consumedHostCPU.label', default: 'Current CPU')}" />

						<g:sortableColumn property="percentdisk" title="${message(code: 'virtualMachine.usedStorage.label', default: 'Used Disk')}" />

					
					</tr>
				</thead>
				<tbody>
				<g:each in="${virtualMachineInstanceList}" status="i" var="virtualMachineInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}" onclick='document.location = "<g:createLink action='show' id="${virtualMachineInstance.id}"/>" '>
					
						<td style ="width:100px"><g:link action="show" id="${virtualMachineInstance.id}">${fieldValue(bean: virtualMachineInstance, field: "description")}</g:link></td>
					

						<td><g:if test="${virtualMachineInstance?.guestOs?.contains('Linux')}">
							Linux 
						    <img class = "vmicon" src="${resource(dir: 'images', file: 'linux-icon.png')}" alt="Calligo"/>
						</g:if>
						<g:if test="${virtualMachineInstance?.guestOs?.contains('Windows')}">
							Windows
						    <img class = "vmicon" src="${resource(dir: 'images', file: 'Windows-icon.png')}" alt="Calligo"/>
						</g:if></td>


						<td><g:if test="${virtualMachineInstance?.heartbeat == 'green'}">
						    Good
						    <img class = "vmicon" src="${resource(dir: 'images', file: 's-green.png')}" alt="Calligo"/>
						</g:if>
						<g:elseif test="${virtualMachineInstance?.heartbeat== 'gray'}">
						    Unknown
						    <img class = "vmicon" src="${resource(dir: 'images', file: 's-grey.png')}" alt="Calligo"/>
						</g:elseif>
						<g:if test="${virtualMachineInstance?.heartbeat == 'red'}">
						    None
						 	<img class = "vmicon" src="${resource(dir: 'images', file: 's-red.png')}" alt="Calligo"/>
						</g:if>
						<g:if test="${virtualMachineInstance?.heartbeat == 'yellow'}">
						    Intermittent
							<img class = "vmicon" src="${resource(dir: 'images', file: 's-amber.png')}" alt="Calligo"/>

						</g:if></td>

						<td><g:if test="${virtualMachineInstance?.vmWareToolStatus == 'toolsOk'}">
						    OK
						    <img class = "vmicon" src="${resource(dir: 'images', file: 'tools-ok.png')}" alt="Calligo"/>
						</g:if>
						<g:elseif test="${virtualMachineInstance?.vmWareToolStatus== 'toolsOld'}">
						    Old
						    <img class = "vmicon" src="${resource(dir: 'images', file: 'tools-old.png')}" alt="Calligo"/>
						</g:elseif>
						<g:if test="${virtualMachineInstance?.vmWareToolStatus == 'toolsNotInstalled'}">
						    Not installed
						    <img class = "vmicon" src="${resource(dir: 'images', file: 'tools-not-installed.png')}" alt="Calligo"/>
						</g:if>
						<g:if test="${virtualMachineInstance?.vmWareToolStatus == 'toolsNotRunning'}">
						    Not running
						<img class = "vmicon" src="${resource(dir: 'images', file: 'tools-not-running.png')}" alt="Calligo"/>

						</g:if></td>


						<td><div class="progressbar" rel = "${virtualMachineInstance?.percentmem}"><span class="text">${virtualMachineInstance?.percentmem} %</span></div></td>

						<td><div class="progressbar" rel = "${virtualMachineInstance?.percentcpu}"><span class="text">${virtualMachineInstance?.percentcpu} %</span></div></td>

						<td><div class="progressbar" rel = "${virtualMachineInstance?.percentdisk}"><span class="text">${virtualMachineInstance?.percentdisk} %</span></div></td>
					
					</tr>
				</g:each>


 				
				</tbody>
			</table>	
		<!--	<div class="pagination">
				<g:paginate total="${virtualMachineInstanceTotal}" />
			</div>-->

			<script>
			$("div.progressbar").each (function () {
    var element = this;

   $(element).progressbar({
        value: parseInt($(element).attr("rel"))

    });
});
				</script>	

				<script type="text/javascript">
  setInterval("my_function();",30000);
  
    function my_function(){
        window.location = location.href;
    }
</script>	
		</div>
	</body>
</html>
