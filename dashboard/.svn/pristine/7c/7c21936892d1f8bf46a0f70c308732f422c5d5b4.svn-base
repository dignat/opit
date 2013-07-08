<%@ page import="dashboard.Ticket" %>
<!doctype html>
<html>
  <head>
    <meta name="layout" content="main" />
    <title>Write comment</title>         
  </head>
  <body>
    <div class="body">
      <h1>Write a comment</h1>
      
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
    
<g:set var="ticket" value="${dashboard.Ticket.get(params.id)}"/>
    
      <g:form action="comment"   id="${ticket?.id}" controller="ticket" method="post">
       <g:hiddenField name="id" value="${ticket?.tid}" /> 

        <div class="dialog">
          
                  <label for="comment">Text:</label>
               
                  <textarea name="comment">Comment...
                  </textarea>
                </br></br>
                
          
             
                 <!--- <label for="file">File</label>
               
                  <input type="file"  name="attachment_1" id="attachment_1"/></br></br>!-->
             
              
                  
               
        </div>
        <div class="buttons">
         
            <input class="button white" type="submit" value="Submit" />
        
        </div>
      </g:form>

    </div>
    <g:form>
        <fieldset class="buttons">
          <g:hiddenField name="id" value="${ticketInstance?.id}" />
          <g:link class="" controller = "ticket" action="history" id="${ticket?.id}"><g:message code="history.label" default="History" /></g:link>
        
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