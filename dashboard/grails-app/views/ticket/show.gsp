
<%@ page import="dashboard.Ticket" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ticket.label', default: 'Ticket')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-ticket" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>

				<sec:ifAllGranted roles="ROLE_ADMIN">
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				</sec:ifAllGranted>
			</ul>
		</div>
		<div id="show-ticket" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list ticket">
			
				<g:if test="${ticketInstance?.tenantId}">
				<li class="fieldcontain">
					<span id="tenantId-label" class="property-label"><g:message code="ticket.tenantId.label" default="Tenant Id" /></span>
					
						<span class="property-value" aria-labelledby="tenantId-label"><g:fieldValue bean="${ticketInstance}" field="tenantId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.tqueue}">
				<li class="fieldcontain">
					<span id="tqueue-label" class="property-label"><g:message code="ticket.tqueue.label" default="Tqueue" /></span>
					
						<span class="property-value" aria-labelledby="tqueue-label"><g:fieldValue bean="${ticketInstance}" field="tqueue"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.tid}">
				<li class="fieldcontain">
					<span id="tid-label" class="property-label"><g:message code="ticket.tid.label" default="Tid" /></span>
					
						<span class="property-value" aria-labelledby="tid-label"><g:fieldValue bean="${ticketInstance}" field="tid"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.tadminCc}">
				<li class="fieldcontain">
					<span id="tadminCc-label" class="property-label"><g:message code="ticket.tadminCc.label" default="Tadmin Cc" /></span>
					
						<span class="property-value" aria-labelledby="tadminCc-label"><g:fieldValue bean="${ticketInstance}" field="tadminCc"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.tcc}">
				<li class="fieldcontain">
					<span id="tcc-label" class="property-label"><g:message code="ticket.tcc.label" default="Tcc" /></span>
					
						<span class="property-value" aria-labelledby="tcc-label"><g:fieldValue bean="${ticketInstance}" field="tcc"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.tcreated}">
				<li class="fieldcontain">
					<span id="tcreated-label" class="property-label"><g:message code="ticket.tcreated.label" default="Tcreated" /></span>
					
						<span class="property-value" aria-labelledby="tcreated-label"><g:fieldValue bean="${ticketInstance}" field="tcreated"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.tcreator}">
				<li class="fieldcontain">
					<span id="tcreator-label" class="property-label"><g:message code="ticket.tcreator.label" default="Tcreator" /></span>
					
						<span class="property-value" aria-labelledby="tcreator-label"><g:fieldValue bean="${ticketInstance}" field="tcreator"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.tdue}">
				<li class="fieldcontain">
					<span id="tdue-label" class="property-label"><g:message code="ticket.tdue.label" default="Tdue" /></span>
					
						<span class="property-value" aria-labelledby="tdue-label"><g:fieldValue bean="${ticketInstance}" field="tdue"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.tfinalPriority}">
				<li class="fieldcontain">
					<span id="tfinalPriority-label" class="property-label"><g:message code="ticket.tfinalPriority.label" default="Tfinal Priority" /></span>
					
						<span class="property-value" aria-labelledby="tfinalPriority-label"><g:fieldValue bean="${ticketInstance}" field="tfinalPriority"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.tinitialPriority}">
				<li class="fieldcontain">
					<span id="tinitialPriority-label" class="property-label"><g:message code="ticket.tinitialPriority.label" default="Tinitial Priority" /></span>
					
						<span class="property-value" aria-labelledby="tinitialPriority-label"><g:fieldValue bean="${ticketInstance}" field="tinitialPriority"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.tlastUpdated}">
				<li class="fieldcontain">
					<span id="tlastUpdated-label" class="property-label"><g:message code="ticket.tlastUpdated.label" default="Tlast Updated" /></span>
					
						<span class="property-value" aria-labelledby="tlastUpdated-label"><g:fieldValue bean="${ticketInstance}" field="tlastUpdated"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.token}">
				<li class="fieldcontain">
					<span id="token-label" class="property-label"><g:message code="ticket.token.label" default="Token" /></span>
					
						<span class="property-value" aria-labelledby="token-label"><g:fieldValue bean="${ticketInstance}" field="token"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.towner}">
				<li class="fieldcontain">
					<span id="towner-label" class="property-label"><g:message code="ticket.towner.label" default="Towner" /></span>
					
						<span class="property-value" aria-labelledby="towner-label"><g:fieldValue bean="${ticketInstance}" field="towner"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.tpriority}">
				<li class="fieldcontain">
					<span id="tpriority-label" class="property-label"><g:message code="ticket.tpriority.label" default="Tpriority" /></span>
					
						<span class="property-value" aria-labelledby="tpriority-label"><g:fieldValue bean="${ticketInstance}" field="tpriority"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.trequestors}">
				<li class="fieldcontain">
					<span id="trequestors-label" class="property-label"><g:message code="ticket.trequestors.label" default="Trequestors" /></span>
					
						<span class="property-value" aria-labelledby="trequestors-label"><g:fieldValue bean="${ticketInstance}" field="trequestors"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.tresolved}">
				<li class="fieldcontain">
					<span id="tresolved-label" class="property-label"><g:message code="ticket.tresolved.label" default="Tresolved" /></span>
					
						<span class="property-value" aria-labelledby="tresolved-label"><g:fieldValue bean="${ticketInstance}" field="tresolved"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.tstarted}">
				<li class="fieldcontain">
					<span id="tstarted-label" class="property-label"><g:message code="ticket.tstarted.label" default="Tstarted" /></span>
					
						<span class="property-value" aria-labelledby="tstarted-label"><g:fieldValue bean="${ticketInstance}" field="tstarted"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.tstarts}">
				<li class="fieldcontain">
					<span id="tstarts-label" class="property-label"><g:message code="ticket.tstarts.label" default="Tstarts" /></span>
					
						<span class="property-value" aria-labelledby="tstarts-label"><g:fieldValue bean="${ticketInstance}" field="tstarts"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.tstatus}">
				<li class="fieldcontain">
					<span id="tstatus-label" class="property-label"><g:message code="ticket.tstatus.label" default="Tstatus" /></span>
					
						<span class="property-value" aria-labelledby="tstatus-label"><g:fieldValue bean="${ticketInstance}" field="tstatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.tsubject}">
				<li class="fieldcontain">
					<span id="tsubject-label" class="property-label"><g:message code="ticket.tsubject.label" default="Tsubject" /></span>
					
						<span class="property-value" aria-labelledby="tsubject-label"><g:fieldValue bean="${ticketInstance}" field="tsubject"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.ttimeEstimated}">
				<li class="fieldcontain">
					<span id="ttimeEstimated-label" class="property-label"><g:message code="ticket.ttimeEstimated.label" default="Ttime Estimated" /></span>
					
						<span class="property-value" aria-labelledby="ttimeEstimated-label"><g:fieldValue bean="${ticketInstance}" field="ttimeEstimated"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.ttimeLeft}">
				<li class="fieldcontain">
					<span id="ttimeLeft-label" class="property-label"><g:message code="ticket.ttimeLeft.label" default="Ttime Left" /></span>
					
						<span class="property-value" aria-labelledby="ttimeLeft-label"><g:fieldValue bean="${ticketInstance}" field="ttimeLeft"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.ttimeWorked}">
				<li class="fieldcontain">
					<span id="ttimeWorked-label" class="property-label"><g:message code="ticket.ttimeWorked.label" default="Ttime Worked" /></span>
					
						<span class="property-value" aria-labelledby="ttimeWorked-label"><g:fieldValue bean="${ticketInstance}" field="ttimeWorked"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ticketInstance?.ttold}">
				<li class="fieldcontain">
					<span id="ttold-label" class="property-label"><g:message code="ticket.ttold.label" default="Ttold" /></span>
					
						<span class="property-value" aria-labelledby="ttold-label"><g:fieldValue bean="${ticketInstance}" field="ttold"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${ticketInstance?.id}" />
					<g:link class="" controller = "ticket" action="history" id="${ticketInstance?.id}"><g:message code="history.label" default="History" /></g:link>
					<g:link class="" controller = "ticket" action="comment_view" id="${ticketInstance?.id}"><g:message code="comment.label" default="Comment" /></g:link>
					<g:link class="" controller = "ticket" action="reply_view" id="${ticketInstance?.id}"><g:message code="comment.label" default="Reply" /></g:link>
					<g:link class="" controller = "ticket" action="edit_links" id="${ticketInstance?.id}"><g:message code="links.label" default="Edit Links" /></g:link>
					<g:link class="" controller = "ticket" action="logout" id="${ticketInstance?.id}"><g:message code="logout.label" default="Logout" /></g:link>
					<sec:ifAllGranted roles="ROLE_ADMIN">
					<g:link class="edit" action="edit" id="${ticketInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					</sec:ifAllGranted>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
