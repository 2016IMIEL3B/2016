<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
    <h1>Assurer une voiture: Partie 2</h1>

    <form >

        <div>
            <form:label for="quote.usera.drivingLicenceDate">Date du permis</form:label>
            <from:input type="date" path="quote.usera.drivingLicenceDate"></from:input>
        </div>

        <div>
            <from:label for="quote.usera.accidentNumber">Nombre d'accidents</from:label>
            <from:input type="text" path="quote.usera.accidentNumber"></from:input>
        </div>

        <div>
            <from:label for="quote.usera.bonus">Bonus Malus</from:label>
            <from:input type="text" path="quote.usera.bonus"></from:input>
        </div>

        <form:button type="submit">Aller à l'étape suivante</form:button>
    </form>

</body>

</html>