<!doctype html>
<html>
  <head>
    <meta name="layout" content="main" />
    <title>History Ticket</title>         
  </head>


  <body>
    <ul>
    
  </ul>
    <div class="body">
      <h1>Ticket History</h1>
      
      
      
      <g:textArea name="totalHistory" value ="${totalHistory}" readonly="true"/>
   
    </div>
  </br></br>
    <g:form>
        <fieldset class="buttons">
          <g:hiddenField name="id" value="${ticketInstance?.id}" />
         
          <g:link class="" controller = "ticket" action="comment_view" id="${ticket?.id}"><g:message code="comment.label" default="Comment" /></g:link>
          <g:link class="" controller = "ticket" action="reply_view" id="${ticket?.id}"><g:message code="comment.label" default="Reply" /></g:link>
          <g:link class="" controller = "ticket" action="edit_links" id="${ticket?.id}"><g:message code="links.label" default="Edit Links" /></g:link>
          <g:link class="" controller = "ticket" action="logout" id="${ticket?.id}"><g:message code="logout.label" default="Logout" /></g:link>
          <sec:ifAllGranted roles="ROLE_ADMIN">
          <g:link class="edit" action="edit" id="${ticket?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
          <g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
          </sec:ifAllGranted>
        </fieldset>
      </g:form>
  </body>
</html>