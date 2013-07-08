<%@ page import="dashboard.Ticket" %>
<!doctype html>
<html>
  <head>
    <meta name="layout" content="main" />
    <title>Logout</title>         
  </head>
  <body>
    <div class="body">
      <h1>Logout</h1>
      
      <g:if test="${flash.message}">
        
      </g:if>
      
      <g:textArea name="history" value ="${flash.message}" readonly="true"/>
   
    </div>
  </body>
</html>