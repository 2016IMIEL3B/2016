<%--
  Created by IntelliJ IDEA.
  User: Jerome
  Date: 21/03/2016
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@page session="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <c:url value="/login" var="loginUrl"/>
        <form action="${loginUrl}" method="post">
            <c:if test="${param.error != null}">
                <p>
                    Invalid username and password.
                </p>
            </c:if>
            <c:if test="${param.logout != null}">
                <p>
                    You have been logged out.
                </p>
            </c:if>
            <p>
                <label for="username">Username</label>
                <input type="text" id="username" name="username"/>
            </p>
            <p>
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>
            </p>
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <button type="submit" class="btn">Log in</button>
        </form>
    </body>
</html>