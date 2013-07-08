
<%@ page import="dashboard.Invoice" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'invoice.label', default: 'Invoice')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-invoice" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-invoice" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="invoice.client.label" default="Client" /></th>
					
						<g:sortableColumn property="invoice_No" title="${message(code: 'invoice.invoice_No.label', default: 'Invoice No')}" />
					
						<g:sortableColumn property="createDate" title="${message(code: 'invoice.createDate.label', default: 'Create Date')}" />
					
						<g:sortableColumn property="billingDate" title="${message(code: 'invoice.billingDate.label', default: 'Billing Date')}" />
					
						<g:sortableColumn property="total" title="${message(code: 'invoice.total.label', default: 'Total')}" />
						<g:sortableColumn property="rate" title="${message(code: 'invoice.rate.label', default: 'Rate')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${invoiceInstanceList}" status="i" var="invoiceInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}" onclick='document.location = "<g:createLink action='show' id="${invoiceInstance.id}"/>" '>
					
						<td><g:link action="show" id="${invoiceInstance.id}">${fieldValue(bean: invoiceInstance, field: "client")}</g:link></td>
					
						<td>${fieldValue(bean: invoiceInstance, field: "invoice_No")}</td>
					
						<td><g:formatDate date="${invoiceInstance.createDate}" /></td>
					
						<td><g:formatDate date="${invoiceInstance.billingDate}" /></td>
					
						<td>${fieldValue(bean: invoiceInstance, field: "total")}</td>
						<td>${fieldValue(bean: invoiceInstance, field: "rate")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${invoiceInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
