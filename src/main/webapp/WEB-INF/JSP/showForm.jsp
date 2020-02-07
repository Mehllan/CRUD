<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter The Staff Details</h3>
        <form:form method="POST" action="userAdd" modelAttribute="user">
             <table>
                <tr>
                    <td><label>Name</label></td>
                    <td><form:input path="name" name="name"  /></td>
                </tr>
                <tr>
                    <td><label>Email</label></td>
                    <td><form:input path="email" name="email"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"  /></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>