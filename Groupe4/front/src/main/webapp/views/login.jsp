<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="layout_header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row content">
    <br>
    <form name="f" action="/login.do" method="post">
        <fieldset>
            <legend>Connexion</legend>
            <c:if test="${not empty param.err}">
                <div class="alert alert-error">
                    Utilisateur inconnu (Verifier votre login et mot de passe).
                </div>
            </c:if>
            <c:if test="${param.logout}">
                <div class="alert alert-success">
                    You have been logged out.
                </div>
            </c:if>
            <label for="username">Username</label>
            <input type="text" id="username" name="username"/>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
            <div class="form-actions">
                <button type="submit" class="btn">Log in</button>
            </div>
        </fieldset>
    </form>
</div>
<%@include file="layout_footer.jsp" %>