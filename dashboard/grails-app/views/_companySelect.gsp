
<div>
	<sec:ifAnyGranted  roles="ROLE_ADMIN,ROLE_USER">
<g:form controller="virtualDataCenter" action="selectVdc">
<g:select style="float:right;"name="host" from="${dashboard.VirtualDataCenter.findAllByTenantId(session.tenantId)}"  noSelection="['':'Show from permissible VDCs']" onchange="submit()" optionKey="id" optionValue="description">
</g:select>
</g:form>
</sec:ifAnyGranted>
<sec:ifAllGranted roles="ROLE_ADMIN">
<g:form controller="client" action="selectCompany">
<g:select style="float:right;" name="client" from="${dashboard.Client.list()}"  noSelection="['':'Show from permissible Clients']" onchange="submit()" optionKey="id" optionValue="company">
</g:select>
</g:form>
</sec:ifAllGranted>
</div>