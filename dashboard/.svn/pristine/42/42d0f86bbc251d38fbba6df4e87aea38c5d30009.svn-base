<!doctype html>
<html>
  <head>
    <meta name="layout" content="main" />
    <title>RT User create</title>         
  </head>
  <body>
    <div class="body">
      <h1>RT User create</h1>
      
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:form action="save" controller="usersRT" method="post" >
        <div class="dialog">
          <table>
            <tbody> 
             <tr class="prop">
                <td class="name">
                  <label for="userId">User Id:</label>
                </td>
                <td>
                  <input type="text" id="userId" name="userId"/>
                </td>
              </tr>            
              <tr class="prop">
                <td class="name">
                  <label for="name">User Name:</label>
                </td>
                <td>
                  <input type="text" id="name" name="username"/>
                </td>
              </tr> 
              <tr class="prop">
                <td class="name">
                  <label for="password">Password:</label>
                </td>
                <td>
                  <input type="password" id="password" name="password"/>
                </td>
              </tr> 
          
              <tr class="prop">
                <td class="name">
                  <label for="email">Email</label>
                </td>
                <td>
                  <input type="email" id="email" name="email"/>
                </td>
              </tr> 
              <tr class="prop">
                <td class="name">
                  <label for="realName">Real Name:</label>
                </td>
                <td>
                  <input type="text" id="realName" name="realName"/>
                </td>
              </tr> 
              <tr class="prop">
                <td class="name">
                  <label for="organization">Gecos:</label>
                </td>
                <td>
                  <input type="text" id="organization" name="gecos"/>
                </td>
              </tr>
              <tr class="prop">
                <td class="name">
                  <label for="comments">Comments:</label>
                </td>
                <td>
                  <input type="text" id="comments" name="comments"/>
                </td>
              </tr>  
              <tr class="prop">
                <td class="name">
                  <label for="privileged">Privileged:</label>
                </td>
                <td>
                  <input type="text" id="privileged" name="privileged"/>
                </td>
              </tr> 
              
            </tbody>
          </table>
        </div>
        <div class="buttons">
          <span class="button">
            <input class="save" type="submit" value="Submit" />
          </span>
        </div>
      </g:form>
    </div>
  </body>
</html>