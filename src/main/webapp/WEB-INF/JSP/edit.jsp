<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    </head>
    <body>
        
      <h1>Edit User name and email</h1>    
         <form:form method="POST" action="userAdd" modelAttribute="user">
             <table>
             	<tr>
                   
                    <td><form:input path="id" name="id" value="${id }" type="hidden" />  </td>
                </tr>
                <tr>
                    <td><label>Name</label></td>
                    <td><form:input path="name" name="name" value="${name }" />  </td>
                </tr>
                <tr>
                    <td><label>Email</label></td>
                    <td><form:input path="email" name="email" value="${email}" />   </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Update"  /></td>
                </tr>
            </table>
        </form:form> 
    </body>
</html>