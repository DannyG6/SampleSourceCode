<%-- 
    Document   : UserCreate
    Created on : Nov 27, 2017, 9:21:25 PM
    Author     : DannyG
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User</title>
    </head>
    <body>
        <form action="UserCreate" method="POST">
            <input type="text" name="name" placeholder="name" required=""><br>
            <input type="email" name="email" placeholder="email" required=""><br>
            <select name="role_id" required="">
                <c:forEach items="${roleList}" var="role">
                    <option value="${role.id}">${role.name}</option>
                </c:forEach>
            </select>
            <input type="submit">
        </form>
    </body>
</html>
