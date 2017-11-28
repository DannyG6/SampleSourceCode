<%-- 
    Document   : UserView
    Created on : Nov 27, 2017, 5:30:38 PM
    Author     : DannyG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <table border="1">
            <c:choose>
                <c:when test = "${status == 1}">
                    <tr><td>id</td><td>name</td><td>email</td></tr>
                    <c:forEach items="${userList}" var="user">
                        <tr><td> ${user.id}</td><td><a href="UserDetail?userId=${user.id}"> ${user.name}</a></td><td>${user.email}</td></tr>
                    </c:forEach>
                </c:when>
                <c:when test = "${status == 0}">
                    <tr><td>name</td><td>role</td></tr>
                    <tr><td>${userSingle.name}</td><td>${userSingle.role.name}</td></tr>
                </c:when>
            </c:choose>
        </table>
        <hr>
        <button id="createUser">CREATE USER</button>
        <button id="deleteUser">DELETE USER</button>
        <button id="editUser">EDIT USER</button>
        <br><br>
        <div id="multiForm"></div>
    </body>
</html>

<script>
    $(document).ready(function () {
        $("#createUser").click(function () {
            $("#multiForm").load("UserCreate");
        });
    });
    $(document).ready(function () {
        $("#deleteUser").click(function () {
            $("#multiForm").html("Function not available");
        });
    });
    $(document).ready(function () {
        $("#editUser").click(function () {
            $("#multiForm").html("Function not available");
        });
    });
</script>