<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>

<nav>
    <h1>Projet Vertx</h1>
    <a href="/car" style="display: inline">Devis Voiture</a> |
    <a href="/habitation">Devis Habitation</a> |
    <a href="/profile">Profil</a> |
    <a href="/synthesis/">Mes Devis</a>
</nav>

<h1>Devis - Assurer une habitation</h1>

<form action="<c:url value='/habitation.do'/>" method="POST">


</form>


</body>

</html>
