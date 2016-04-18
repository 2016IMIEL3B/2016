<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="layout_header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wizard car</title>
</head>
<body>

<form:form method="POST" action="/wizard/car/2" modelAttribute="model">
        <h2>Étape 1/4</h2>

        <div class="col-md-12">
            <label class="col-md-6">NOM Prénom</label>
            <form:label path="userName" class="col-md-6">${model.userName}</form:label>

    </div>
    <div>
        <form:label path="quoteCar.brand" class="col-md-6">Marque</form:label>
        <form:select path = "quoteCar.brand" class="col-md-6" id="brandSelect" name="brandSelect">
            <option value="0">Marque</option>
            <option value="1">Renault</option>
            <option value="2">Peugeot</option>
            <option value="3">Ford</option>
        </form:select>
    </div>
    <div>
        <form:label path="quoteCar.model" class="col-md-6">Modèle</form:label>
        <form:select path = "quoteCar.model" class="col-md-6" id="modelSelect" name="modelSelect">
            <option value="0">Modèle</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
        </form:select>
    </div>
    <div>
        <form:label path="quoteCar.fuel" class="col-md-6">Carburant</form:label>
        <form:select path = "quoteCar.fuel" class="col-md-6" id="fuelSelect" name="fuelSelect">
            <option value="0">Carburant</option>
            <option value="1">Diesel</option>
            <option value="2">Essence</option>
            <option value="3">Gpl</option>
        </form:select>
    </div>
    <div>
        <form:label path="quoteCar.taxHorsepower" class="col-md-6">Chevaux fiscaux</form:label>
        <form:input path="quoteCar.taxHorsepower" class="col-md-6" type="text" placeholder="54"/>
    </div>

    <input value="Étape suivante" name="submit" type="submit" class="submit-btn"/>
</form:form>

</body>
</html>
<%@include file="layout_footer.jsp" %>