<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" import="javax.servlet.jsp.PageContext" %>
<body>
<H1>Page de login</H1>
<form id="form" action="<c:url value='/login.do'/>" method="POST">
    Username:<br>
    <input type="text" name="username" value="" class="input-text input-email<c:if test="${not empty param.err}"> input-error</c:if>"/><br><br>
    Password:<br>
    <input type="password" name="password" value="" class="input-text input-pass<c:if test="${not empty param.err}"> input-error</c:if>"/>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div class="submit-container">
        <input value="Login" name="submit" type="submit" class="submit-btn"/>
    </div>
</form>
</body>