<%-- 
    Document   : users
    Created on : Mar 3, 2023, 9:22:29 AM
    Author     : alexc
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Manage Users</h1>
        <table method="post">
            <thead>
                <tr>
                    <th>Email</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Role</th>
                    <th></th>
                    <th></th>
                </tr>
                <tr>
                    <th>${user.email}</th>
                </tr>
            </thead>
            <tbody>
               
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>
                    ${user.email}
                    </td>
                    <td>
                    ${user.getFirstName()}
                    </td>
                    <td>
                    ${user.getLastName()}
                    </td>
                    <td>
                    ${user.Role()}
                    </td>
                    <td>
                        <a href="user? action=editUser&userEmail=${user.email}">Edit</a>
                    </td>
                    <td>
                        <a href="user? action=deleteUser;userEmail=${user.email}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
               
            </tbody>
            
        </table>
    </body>
</html>
