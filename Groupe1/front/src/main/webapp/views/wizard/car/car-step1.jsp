<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../header.jsp" %>

<div class="container">
    <div class="jumbotron">
        <h1>Devis: Assurer une voiture</h1>
        <h2>Etape 1</h2>

        <form:form action="/carWizard.form?_page=2" method="POST" modelAttribute="carWizard">

            <div class="form-group">
                <form:label path="" for="quote.name">Nom du devis</form:label>
                <form:input path="quote.name" class="form-control" cssStyle="width:250px;" required="required"></form:input>
            </div>

            <div class="form-group">
                <form:label path="" for="quote.vehicle.model.brand">Marque</form:label>
                <form:select path="quote.vehicle.model.brand">
                    <form:option value="honda">Honda</form:option>
                    <form:option value="wolkswagen">Wolkswagen</form:option>
                </form:select>
            </div>

            <div class="form-group">
                <form:label path="" for="quote.vehicle.model"> Modèle</form:label>
                <form:input  path="quote.vehicle.model.name" class="form-control" cssStyle="width:250px;"></form:input>

            </div>

            <div class="form-group">
                <form:label path="" for="quote.vehicle.fuel">Carburant</form:label>
                <form:select path="quote.vehicle.fuel">
                    <form:option value="essence">Essence</form:option>
                    <form:option value="gasoil">Gasoil</form:option>
                    <form:option value="gpl">GPL</form:option>
                </form:select>

            </div>

            <div class="form-group">
                <form:label path="" for="quote.vehicle.horsepower"> Chevaux fiscaux</form:label>
                <form:select path="quote.vehicle.horsepower">
                    <form:option value="1">1CH</form:option>
                    <form:option value="2">2CH</form:option>
                    <form:option value="3">3CH</form:option>
                    <form:option value="4">4CH</form:option>
                    <form:option value="5">5CH</form:option>
                </form:select>
            </div>

            <form:button type="submit">Aller à l'étape suivante</form:button>
        </form:form>
    </div>
</div>

<%@include file="../../footer.jsp" %>