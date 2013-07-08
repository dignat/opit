<!doctype html>
<html>
  <head>
    <meta name="layout" content="main" />
    <title>Recover password</title>         
  </head>
  <body>
    <div class="body">
      <h1>Recover password</h1>
      
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:form action="forgotPassword" controller="login" method="post" >
        <div class="dialog">
          <table>
            <tbody>            
              <tr class="prop">
                <td class="name">
                  <label for="username">User Name:</label>
                </td>
                <td>
                  <input type="text" id="username" name="username"/>
                </td>
              </tr> 
          
              <tr class="prop">
                <td class="name">
                  <label for="password_new">New Password</label>
                </td>
                <td>
                  <input type="password" id="password_new" name="password_new"/>
                </td>
              </tr> 
               <tr class="prop">
                <td class="name">
                  <label for="password_new2">Confirm Password</label>
                </td>
                <td>
                  <input type="password" id="password_new2" name="password_new2"/>
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