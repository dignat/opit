<!doctype html>
<html>
  <head>
    <meta name="layout" content="main" />
    <title>RT Links create</title>         
  </head>
  <body>
    <div class="body">
      <h1>RT Links create</h1>
      
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:set var="ticket" value="${dashboard.Ticket.get(params.id)}"/>
      <g:form action="links" id="${ticket?.id}" controller="ticket" method="post" >
      <g:hiddenField name="id" value="${ticket?.tid}" /> 
        <div class="dialog">
          <table>
            <tbody>            
              <tr class="prop">
                <td class="name">
                  <label for="dependOn">Depend On:</label>
                </td>
                <td>
                  <input type="url" id="dependOn" name="dependOn"/>
                </td>
              </tr> 
              <tr class="prop">
                <td class="name">
                  <label for="refersTo">Refers to:</label>
                </td>
                <td>
                  <input type="url" id="refersTo" name="refersTo"/>
                </td>
              </tr> 
          
             </tbody>
           </table>
        <div class="buttons">
          <span class="button">
            <input class="save" type="submit" value="Submit" />
          </span>
        </div>
      </g:form>
    </div>
    <g:form>
        <fieldset class="buttons">
          <g:hiddenField name="id" value="${ticketInstance?.id}" />
          <g:link class="" controller = "ticket" action="history" id="${ticket?.id}"><g:message code="history.label" default="History" /></g:link>
          <g:link class="" controller = "ticket" action="comment_view" id="${ticket?.id}"><g:message code="comment.label" default="Comment" /></g:link>
          <g:link class="" controller = "ticket" action="reply_view" id="${ticket?.id}"><g:message code="comment.label" default="Reply" /></g:link>
          
          <g:link class="" controller = "ticket" action="logout" id="${ticket?.id}"><g:message code="logout.label" default="Logout" /></g:link>
          <sec:ifAllGranted roles="ROLE_ADMIN">
          <g:link class="edit" action="edit" id="${ticket?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
          <g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
          </sec:ifAllGranted>
        </fieldset>
      </g:form>
  </body>
</html>