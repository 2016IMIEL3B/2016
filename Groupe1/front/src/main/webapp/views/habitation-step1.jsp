<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>

<nav>
    <h1>Projet Vertx</h1>
    <a href="/car/1" style="display: inline">Devis Voiture</a> |
    <a href="/habitation/1">Devis Habitation</a> |
    <a href="/profile">Profil</a> |
    <a href="/synthesis">Mes Devis</a>
</nav>
<hr/>

<h1>Devis - Assurer une habitation</h1>
<h2>Etape 1</h2>

<form:form action="/habitation/2" method="POST" modelAttribute="habStep1">
    <form:label path="name">Nom du devis :</form:label>
    <form:input path="name" cssStyle="dis"></form:input>

    <form:label path="type">Type d'appartement :</form:label>
    <form:radiobutton path="type" value="appartement" label="Appartement"></form:radiobutton>
    <form:radiobutton path="type" value="maison" label="Maison"></form:radiobutton>


    <form:label path="surface">Surface du logement :</form:label>
    <form:input path="surface"></form:input>

    <form:button type="submit">Aller à l'étape 2</form:button>
</form:form>


</body>

</html>
