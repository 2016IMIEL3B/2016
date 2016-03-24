<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<h2>Etape 2</h2>

Nom du devis: ${habWizard.quote.name} <br />
Type de logement: ${habWizard.quote.habitation.type} <br />
Surface: ${habWizard.quote.habitation.surface}m²

<form:form action="/habwizard.form?_page=3" method="POST" modelAttribute="habWizard">


    <form:button type="submit">Aller à l'étape 3</form:button>
</form:form>

</body>

</html>
