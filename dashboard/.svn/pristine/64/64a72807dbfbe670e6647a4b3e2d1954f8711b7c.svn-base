<%@ page import="dashboard.Invoice" %>



<div class="fieldcontain ${hasErrors(bean: invoiceInstance, field: 'client', 'error')} required">
	<label for="client">
		<g:message code="invoice.client.label" default="Client" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="client" name="client.id" from="${dashboard.Client.list()}" optionKey="id" required="" value="${invoiceInstance?.client?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: invoiceInstance, field: 'invoice_No', 'error')} ">
	<label for="invoice_No">
		<g:message code="invoice.invoice_No.label" default="Invoice No" />
		
	</label>
	<g:textField name="invoice_No" readonly="readonly" value="${invoiceInstance?.invoice_No}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: invoiceInstance, field: 'createDate', 'error')} required">
	<label for="createDate">
		<g:message code="invoice.createDate.label" default="Create Date" />
		<span class="required-indicator">*</span>
	</label>
	${invoiceInstance?.createDate?.toString()}
</div>

<div class="fieldcontain ${hasErrors(bean: invoiceInstance, field: 'billingDate', 'error')} required">
	<label for="billingDate">
		<g:message code="invoice.billingDate.label" default="Billing Date" />
		<span class="required-indicator">*</span>
	</label>
	${invoiceInstance?.billingDate?.toString()}
</div>

<div class="fieldcontain ${hasErrors(bean: invoiceInstance, field: 'rate', 'error')} required">
	<label for="rate">
		<g:message code="invoice.client.label" default="Rate" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="rate" name="rate.id" from="${dashboard.Rate.list()}" optionKey="id" required="" value="${rateInstance?.rate?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: invoiceInstance, field: 'total', 'error')} required">
	<label for="total">
		<g:message code="invoice.total.label" default="Total" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="total" value="${fieldValue(bean: invoiceInstance, field: 'total')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: invoiceInstance, field: 'items', 'error')} ">
	<label for="items">
		<g:message code="invoice.items.label" default="Items" />
		
	</label>
	<g:select name="items" from="${dashboard.Item.list()}" multiple="multiple" optionKey="id" size="5" value="${invoiceInstance?.items*.id}" class="many-to-many"/>
</div>

