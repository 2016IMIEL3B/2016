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
            <label>Date du permis</label>
            <input type="date" name="dateLicense">
        </div>

        <div>
            <label>Nombre d'accidents</label>
            <input type="text" name="inputAccident">
        </div>

        <div>
            <label>Bonus Malus</label>
            <input type="text" name="bonusMalus">
        </div>

        <input type="submit" value="Valider">
    </form>

</body>

</html>