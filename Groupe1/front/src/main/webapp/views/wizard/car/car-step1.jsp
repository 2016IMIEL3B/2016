<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="../../header.jsp" %>

    <h1>Assurer une voiture</h1>

    <form:form action="/carWizard.form?_page=2" method="POST" modelAttribute="CarWizard">


            <form:label path="" for="quote.name">Nom du devis</form:label>
            <form:input path="quote.name" ></form:input>


            <form:label path="" for="quote.vehicle.model.brand">Marque</form:label>
            <form:select path="quote.vehicle.model.brand">
                <form:option value="honda">Honda</form:option>
                <form:option value="wolkswagen">Wolkswagen</form:option>
            </form:select>

        <br>
            <form:label path="" for="quote.vehicle.model"> Modèle</form:label>
            <form:input  path="quote.vehicle.model.name"></form:input>


        <br>
            <form:label path="" for="quote.vehicle.fuel">Carburant</form:label>
            <form:select path="quote.vehicle.fuel">
                <form:option value="essence">Essence</form:option>
                <form:option value="gasoil">Gasoil</form:option>
                <form:option value="gpl">GPL</form:option>
            </form:select>

        <br>

            <form:label path="" for="quote.vehicle.horsepower"> Chevaux fiscaux</form:label>
            <form:select path="quote.vehicle.horsepower">
                <form:option value="1">1CH</form:option>
                <form:option value="2">2CH</form:option>
                <form:option value="3">3CH</form:option>
                <form:option value="4">4CH</form:option>
                <form:option value="5">5CH</form:option>
            </form:select>
        <br>

        <form:button type="submit">Aller à l'étape suivante</form:button>



    </form:form>

<%@include file="../../footer.jsp" %>