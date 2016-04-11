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
<h2>Succès</h2>

Step 1 : ${habWizard.step1} <br/>
Step 2 : ${habWizard.step2} <br/>
Step 3 : ${habWizard.step3} <br/>



</body>

</html>
