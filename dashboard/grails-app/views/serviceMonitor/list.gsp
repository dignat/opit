
<%@ page import="dashboard.ServiceMonitor" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'serviceMonitor.label', default: 'ServiceMonitor')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-serviceMonitor" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<sec:ifAllGranted roles="ROLE_ADMIN">
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				</sec:ifAllGranted>
			</ul>
		</div>
		<div id="list-serviceMonitor" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="description" title="${message(code: 'serviceMonitor.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="host" title="${message(code: 'serviceMonitor.host.label', default: 'Host')}" />
					
						<g:sortableColumn property="status" title="${message(code: 'serviceMonitor.status.label', default: 'Status')}" />
					
						<g:sortableColumn property="launchDate" title="${message(code: 'serviceMonitor.launchDate.label', default: 'Launch Date')}" />
					
						<g:sortableColumn property="upDays" title="${message(code: 'serviceMonitor.upDays.label', default: 'Up Days')}" />
					
						<g:sortableColumn property="status" title="${message(code: 'serviceMonitor.status.label', default: 'Status')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${serviceMonitorInstanceList}" status="i" var="serviceMonitorInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}" onclick='document.location = "<g:createLink action='show' id="${serviceMonitorInstance.id}"/>" '>
					
						<td><g:link action="show" id="${serviceMonitorInstance.id}">${fieldValue(bean: serviceMonitorInstance, field: "description")}</g:link></td>
					
						<td>${fieldValue(bean: serviceMonitorInstance, field: "host")}</td>
					
						<td>${fieldValue(bean: serviceMonitorInstance, field: "status")}</td>
					
						<td><g:formatDate date="${serviceMonitorInstance.launchDate}" /></td>
					
						<td>${fieldValue(bean: serviceMonitorInstance, field: "upDays")}</td>
					

						<td><g:if test="${serviceMonitorInstance?.status == 'green'}">
    Guest operating system is responding normally.
    <img src="${resource(dir: 'images', file: 'green-ok-icon.png')}" alt="Calligo"/>
</g:if>
<g:elseif test="${serviceMonitorInstance?.status== 'gray'}">
    VMware Tools are not installed or not running.
    <img src="${resource(dir: 'images', file: 'FAQ-icon.png')}" alt="Calligo"/>
</g:elseif>
<g:if test="${serviceMonitorInstance?.status == 'red'}">
    No heartbeat. Guest operating system may have stopped responding.
        <img src="${resource(dir: 'images', file: 'red-cross-icon.png')}" alt="Calligo"/>
</g:if>
<g:if test="${serviceMonitorInstance?.status == 'yellow'}">
    Intermittent heartbeat. May be due to guest load.
<img src="${resource(dir: 'images', file: 'yellow-ok-icon.png')}" alt="Calligo"/>

</g:if>		</td>
<script type="text/javascript">
  setInterval("my_function();",30000);
  
    function my_function(){
        window.location = location.href;
    }
</script>
					</tr>
				</g:each>
				</tbody>
			</table>
		</div>
	</body>
</html>
