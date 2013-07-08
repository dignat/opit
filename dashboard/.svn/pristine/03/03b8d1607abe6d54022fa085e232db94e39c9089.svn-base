
<%@ page import="dashboard.Invoice" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'invoice.label', default: 'Invoice')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-invoice" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-invoice" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list invoice">
			
				<g:if test="${invoiceInstance?.client}">
				<li class="fieldcontain">
					<span id="client-label" class="property-label"><g:message code="invoice.client.label" default="Client" /></span>
					
						<span class="property-value" aria-labelledby="client-label"><g:link controller="client" action="show" id="${invoiceInstance?.client?.id}">${invoiceInstance?.client?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${invoiceInstance?.invoice_No}">
				<li class="fieldcontain">
					<span id="invoice_No-label" class="property-label"><g:message code="invoice.invoice_No.label" default="Invoice No" /></span>
					
						<span class="property-value" aria-labelledby="invoice_No-label"><g:fieldValue bean="${invoiceInstance}" field="invoice_No"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${invoiceInstance?.createDate}">
				<li class="fieldcontain">
					<span id="createDate-label" class="property-label"><g:message code="invoice.createDate.label" default="Create Date" /></span>
					
						<span class="property-value" aria-labelledby="createDate-label"><g:formatDate date="${invoiceInstance?.createDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${invoiceInstance?.billingDate}">
				<li class="fieldcontain">
					<span id="billingDate-label" class="property-label"><g:message code="invoice.billingDate.label" default="Billing Date" /></span>
					
						<span class="property-value" aria-labelledby="billingDate-label"><g:formatDate date="${invoiceInstance?.billingDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${invoiceInstance?.total}">
				<li class="fieldcontain">
					<span id="total-label" class="property-label"><g:message code="invoice.total.label" default="Total" /></span>
					
						<span class="property-value" aria-labelledby="total-label"><g:fieldValue bean="${invoiceInstance}" field="total"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${invoiceInstance?.items}">
				<li class="fieldcontain">
					<span id="items-label" class="property-label"><g:message code="invoice.items.label" default="Items" /></span>
					
						<g:each in="${invoiceInstance.items}" var="i">
						<span class="property-value" aria-labelledby="items-label"><g:link controller="item" action="show" id="${i.id}">${i?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${invoiceInstance?.id}" />
					<g:link class="edit" action="edit" id="${invoiceInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
			<g:jasperReport jasper="report10" format="PDF" name="Invoice">
				<g:hiddenField name="invoice_id" value="${invoiceInstance?.id}"/>					
			</g:jasperReport>
		</div>
	</body>
</html>
