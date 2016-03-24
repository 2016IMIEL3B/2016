<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>

<nav>
    <h1>Projet Vertx</h1>
    <a href="/car/1" style="display: inline">Devis Voiture</a> |
    <a href="/habWizard.form">Devis Habitation</a> |
    <a href="/profile">Profil</a> |
    <a href="/synthesis">Mes Devis</a>
</nav>
<hr/>

<h1>Devis - Assurer une habitation</h1>
<h2>Etape 1</h2>

<form:form action="/habwizard.form?_page=2" method="POST" modelAttribute="habWizard">
    <form:label path="" for="quote.name">Nom du devis :</form:label>
    <form:input path="quote.name"></form:input>
    <br>

    <form:label path="" for="quote.habitation.type">Type de logement :</form:label>
    <form:radiobutton path="quote.habitation.type" value="appartement" label="Appartement"></form:radiobutton>
    <form:radiobutton path="quote.habitation.type" value="maison" label="Maison"></form:radiobutton>
    <br>

    <form:label path="" for="quote.habitation.surface">Surface du logement :</form:label>
    <form:input path="quote.habitation.surface"></form:input>
    <br>

    <form:button type="submit">Aller à l'étape 2</form:button>
</form:form>


</body>

</html>
