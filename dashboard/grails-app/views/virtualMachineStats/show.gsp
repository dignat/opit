
<%@ page import="dashboard.VirtualMachineStats" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'virtualMachineStats.label', default: 'VirtualMachineStats')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-virtualMachineStats" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link  action="realtime" id="${virtualMachineStatsInstance?.id}" params="[cpu:true]"><g:message code="default.plot1.label" args="[entityName]" default="CPU"/></g:link></li>
				<li><g:link  action="realtime" id="${virtualMachineStatsInstance?.id}" params="[ram:true]"><g:message code="default.plot1.label" args="[entityName]" default="RAM"/></g:link></li>
				<li><g:link  action="realtime" id="${virtualMachineStatsInstance?.id}" params="[disk:true]"><g:message code="default.plot1.label" args="[entityName]" default="Disk"/></g:link></li>
				<li><g:link  action="chart" id="${virtualMachineStatsInstance?.id}" ><g:message code="default.plot1.label" args="[entityName]" default="Total Used Memory"/></g:link></li>
				<li><g:link  action="chart_storage" id="${virtualMachineStatsInstance?.id}" ><g:message code="default.plot1.label" args="[entityName]" default="Total Used Storage"/></g:link></li>
				<li><g:link class="list" controller="virtualMachine" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>

			<!--	<li><g:link  action="highstock" id="${virtualMachineStatsInstance?.id}" ><g:message code="default.plot1.label" args="[entityName]" default="highstock"/></g:link></li>-->
				<li><g:link  action="remote" id="${virtualMachineStatsInstance?.id}"><g:message code="default.remote.label" args="[entityName]" default="Connect to Server"/></g:link></li>
			<!--	<li><g:link  action="plot2" id="${virtualMachineStatsInstance?.id}"><g:message code="default.plot2.label" args="[entityName]" default="Plot2 Graph"/></g:link></li>
				<li><g:link  action="plot3" id="${virtualMachineStatsInstance?.id}"><g:message code="default.plot3.label" args="[entityName]" default="Plot3 Graph"/></g:link></li>
				<li><g:link  action="plot4" id="${virtualMachineStatsInstance?.id}"><g:message code="default.plot4.label" args="[entityName]" default="Plot4 Graph"/></g:link></li>
				<li><g:link  action="plot5" id="${virtualMachineStatsInstance?.id}"><g:message code="default.plot5.label" args="[entityName]" default="Plot5 Graph"/></g:link></li>-->
			</ul>
		</div>
		<div id="show-virtualMachineStats" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list virtualMachineStats">
			
				<g:if test="${virtualMachineStatsInstance?.compressedMem}">
				<li class="fieldcontain">
					<span id="compressedMem-label" class="property-label"><g:message code="virtualMachineStats.compressedMem.label" default="Compressed Mem" /></span>
					
						<span class="property-value" aria-labelledby="compressedMem-label"><g:fieldValue bean="${virtualMachineStatsInstance}" field="compressedMem"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${virtualMachineStatsInstance?.uptime}">
				<li class="fieldcontain">
					<span id="uptime-label" class="property-label"><g:message code="virtualMachineStats.uptime.label" default="Uptime" /></span>
					
						<span class="property-value" aria-labelledby="uptime-label"><g:fieldValue bean="${virtualMachineStatsInstance}" field="uptime"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${virtualMachineStatsInstance?.activeGuestMemory}">
				<li class="fieldcontain">
					<span id="activeGuestMemory-label" class="property-label"><g:message code="virtualMachineStats.activeGuestMemory.label" default="Active Guest Memory" /></span>
					
						<span class="property-value" aria-labelledby="activeGuestMemory-label"><g:fieldValue bean="${virtualMachineStatsInstance}" field="activeGuestMemory"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${virtualMachineStatsInstance?.activeMem}">
				<li class="fieldcontain">
					<span id="activeMem-label" class="property-label"><g:message code="virtualMachineStats.activeMem.label" default="Active Mem" /></span>
					
						<span class="property-value" aria-labelledby="activeMem-label"><g:fieldValue bean="${virtualMachineStatsInstance}" field="activeMem"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${virtualMachineStatsInstance?.balloonedMem}">
				<li class="fieldcontain">
					<span id="balloonedMem-label" class="property-label"><g:message code="virtualMachineStats.balloonedMem.label" default="Ballooned Mem" /></span>
					
						<span class="property-value" aria-labelledby="balloonedMem-label"><g:fieldValue bean="${virtualMachineStatsInstance}" field="balloonedMem"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${virtualMachineStatsInstance?.consumedHostCPU}">
				<li class="fieldcontain">
					<span id="consumedHostCPU-label" class="property-label"><g:message code="virtualMachineStats.consumedHostCPU.label" default="Consumed Host CPU" /></span>
					
						<span class="property-value" aria-labelledby="consumedHostCPU-label"><g:fieldValue bean="${virtualMachineStatsInstance}" field="consumedHostCPU"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${virtualMachineStatsInstance?.consumedHostMemory}">
				<li class="fieldcontain">
					<span id="consumedHostMemory-label" class="property-label"><g:message code="virtualMachineStats.consumedHostMemory.label" default="Consumed Host Memory" /></span>
					
						<span class="property-value" aria-labelledby="consumedHostMemory-label"><g:fieldValue bean="${virtualMachineStatsInstance}" field="consumedHostMemory"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${virtualMachineStatsInstance?.cpuCount}">
				<li class="fieldcontain">
					<span id="cpuCount-label" class="property-label"><g:message code="virtualMachineStats.cpuCount.label" default="Cpu Count" /></span>
					
						<span class="property-value" aria-labelledby="cpuCount-label"><g:fieldValue bean="${virtualMachineStatsInstance}" field="cpuCount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${virtualMachineStatsInstance?.heartbeat}">
				<li class="fieldcontain">
					<span id="heartbeat-label" class="property-label"><g:message code="virtualMachineStats.heartbeat.label" default="Heartbeat" /></span>
					
						<span class="property-value" aria-labelledby="heartbeat-label"><g:fieldValue bean="${virtualMachineStatsInstance}" field="heartbeat"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${virtualMachineStatsInstance?.ipAddress}">
				<li class="fieldcontain">
					<span id="ipAddress-label" class="property-label"><g:message code="virtualMachineStats.ipAddress.label" default="Ip Address" /></span>
					
						<span class="property-value" aria-labelledby="ipAddress-label"><g:fieldValue bean="${virtualMachineStatsInstance}" field="ipAddress"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${virtualMachineStatsInstance?.memory}">
				<li class="fieldcontain">
					<span id="memory-label" class="property-label"><g:message code="virtualMachineStats.memory.label" default="Memory" /></span>
					
						<span class="property-value" aria-labelledby="memory-label"><g:fieldValue bean="${virtualMachineStatsInstance}" field="memory"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${virtualMachineStatsInstance?.memoryOverhead}">
				<li class="fieldcontain">
					<span id="memoryOverhead-label" class="property-label"><g:message code="virtualMachineStats.memoryOverhead.label" default="Memory Overhead" /></span>
					
						<span class="property-value" aria-labelledby="memoryOverhead-label"><g:fieldValue bean="${virtualMachineStatsInstance}" field="memoryOverhead"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${virtualMachineStatsInstance?.privateMem}">
				<li class="fieldcontain">
					<span id="privateMem-label" class="property-label"><g:message code="virtualMachineStats.privateMem.label" default="Private Mem" /></span>
					
						<span class="property-value" aria-labelledby="privateMem-label"><g:fieldValue bean="${virtualMachineStatsInstance}" field="privateMem"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${virtualMachineStatsInstance?.provisonedStorage}">
				<li class="fieldcontain">
					<span id="provisonedStorage-label" class="property-label"><g:message code="virtualMachineStats.provisonedStorage.label" default="Provisoned Storage" /></span>
					
						<span class="property-value" aria-labelledby="provisonedStorage-label"><g:fieldValue bean="${virtualMachineStatsInstance}" field="provisonedStorage"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${virtualMachineStatsInstance?.sharedMem}">
				<li class="fieldcontain">
					<span id="sharedMem-label" class="property-label"><g:message code="virtualMachineStats.sharedMem.label" default="Shared Mem" /></span>
					
						<span class="property-value" aria-labelledby="sharedMem-label"><g:fieldValue bean="${virtualMachineStatsInstance}" field="sharedMem"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${virtualMachineStatsInstance?.state}">
				<li class="fieldcontain">
					<span id="state-label" class="property-label"><g:message code="virtualMachineStats.state.label" default="State" /></span>
					
						<span class="property-value" aria-labelledby="state-label"><g:fieldValue bean="${virtualMachineStatsInstance}" field="state"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${virtualMachineStatsInstance?.swappedMem}">
				<li class="fieldcontain">
					<span id="swappedMem-label" class="property-label"><g:message code="virtualMachineStats.swappedMem.label" default="Swapped Mem" /></span>
					
						<span class="property-value" aria-labelledby="swappedMem-label"><g:fieldValue bean="${virtualMachineStatsInstance}" field="swappedMem"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${virtualMachineStatsInstance?.timestamp}">
				<li class="fieldcontain">
					<span id="timestamp-label" class="property-label"><g:message code="virtualMachineStats.timestamp.label" default="Timestamp" /></span>
					
						<span class="property-value" aria-labelledby="timestamp-label"><g:formatDate date="${virtualMachineStatsInstance?.timestamp}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${virtualMachineStatsInstance?.unusedStorage}">
				<li class="fieldcontain">
					<span id="unusedStorage-label" class="property-label"><g:message code="virtualMachineStats.unusedStorage.label" default="Unused Storage" /></span>
					
						<span class="property-value" aria-labelledby="unusedStorage-label"><g:fieldValue bean="${virtualMachineStatsInstance}" field="unusedStorage"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${virtualMachineStatsInstance?.usedStorage}">
				<li class="fieldcontain">
					<span id="usedStorage-label" class="property-label"><g:message code="virtualMachineStats.usedStorage.label" default="Used Storage" /></span>
					
						<span class="property-value" aria-labelledby="usedStorage-label"><g:fieldValue bean="${virtualMachineStatsInstance}" field="usedStorage"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${virtualMachineStatsInstance?.virtualMachine}">
				<li class="fieldcontain">
					<span id="virtualMachine-label" class="property-label"><g:message code="virtualMachineStats.virtualMachine.label" default="Virtual Machine" /></span>
					
						<span class="property-value" aria-labelledby="virtualMachine-label">${virtualMachineStatsInstance?.virtualMachine?.encodeAsHTML()}</span>
					
				</li>
				</g:if>
			
				<g:if test="${virtualMachineStatsInstance?.vmWareToolStatus}">
				<li class="fieldcontain">
					<span id="vmWareToolStatus-label" class="property-label"><g:message code="virtualMachineStats.vmWareToolStatus.label" default="Vm Ware Tool Status" /></span>
					
						<span class="property-value" aria-labelledby="vmWareToolStatus-label"><g:fieldValue bean="${virtualMachineStatsInstance}" field="vmWareToolStatus"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${virtualMachineStatsInstance?.id}" />
					 <g:hiddenField name="ram" value="${true}" />
					  <g:hiddenField name="cpu" value="${true}" />
					   <g:hiddenField name="disk" value="${true}" />
					<sec:ifAllGranted roles="ROLE_ADMIN">
					<g:link class="edit" action="edit" id="${virtualMachineStatsInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					</sec:ifAllGranted>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
