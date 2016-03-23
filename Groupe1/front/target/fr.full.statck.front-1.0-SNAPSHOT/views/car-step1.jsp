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
    <h1>Assurer une voiture</h1>

    <form>

        <div>
            <label>Nom du devis</label>
            <input type="text" name="inputQuoteName" >
        </div>

        <div>
            <label>Marque</label>
            <select name="listBrand">
                <option value="honda" name="">Honda</option>
                <option value="wolkswagen" name="">Wolkswagen</option>
            </select>
        </div>

        <div>
            <label>Modèle</label>
            <input type="text" name="inputModel">
        </div>

        <div>
            <label>Carburant</label>
            <select name="listFuel">
                <option value="essence" name="">Essence</option>
                <option value="gasoil" name="">Gasoil</option>
                <option value="gpl" name="">GPL</option>
            </select>
        </div>

        <div>
            <label>Chevaux fiscaux</label>
            <select name="listPower">
                <option value="1" name="">1ch</option>
                <option value="2" name="">2ch</option>
                <option value="3" name="">3ch</option>
                <option value="4" name="">4ch</option>
                <option value="5" name="">5ch</option>
                <option value="6" name="">6ch</option>
            </select>
        </div>

        <input type="submit" value="Etape suivante">



    </form>

</body>

</html>