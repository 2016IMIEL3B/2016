<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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

    <form:form action="/carwizard.form?_page=2" method="POST" modelAttribute="carwizard">

        <div>
            <form:label path="quoteName">Nom du devis</form:label>
            <form:input path="quoteName" ></form:input>
        </div>

        <div>
            <form:label path="listBrand">Marque</form:label>
            <form:select path="listBrand" >
                <form:option value="honda" path="listBrand">Honda</form:option>
                <form:option value="wolkswagen" path="listBrand">Wolkswagen</form:option>
            </form:select>
        </div>

        <div>
            <form:label path="model">Modèle</form:label>
            <form:input type="text" path="model"></form:input>
        </div>

        <div>
            <form:label path="listFuel">Carburant</form:label>
            <form:select path="listFuel">
                <form:option value="essence">Essence</form:option>
                <form:option value="gasoil">Gasoil</form:option>
                <form:option value="gpl">GPL</form:option>
            </form:select>
        </div>

        <div>

            <form:label path="listPower">Chevaux fiscaux</form:label>
            <form:select path="listPower">
                <form:option value="1">1CH</form:option>
                <form:option value="2">2CH</form:option>
                <form:option value="3">3CH</form:option>
                <form:option value="4">4CH</form:option>
                <form:option value="5">5CH</form:option>
            </form:select>
            <label>Chevaux fiscaux</label>
        </div>

        <form:button type="submit">Aller à l'étape suivante</form:button>



    </form:form>

</body>

</html>