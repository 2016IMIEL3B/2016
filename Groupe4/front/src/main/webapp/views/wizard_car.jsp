<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <label class="col-md-3">NOM Prénom</label>
        <form:label path="userName" class="col-md-3">${model.userName}</form:label>
    </div>
    <div class="col-md-12">
        <form:label path="quoteCar.brand" class="col-md-3">Marque</form:label>
        <form:select path = "quoteCar.brand" class="col-md-3" id="brandSelect" name="brandSelect">
            <c:forEach var="brand" items="${model.brands}">
                <option value="${brand.id}">${brand.value}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="col-md-12">
        <form:label path="quoteCar.model" class="col-md-3">Modèle</form:label>
        <form:select path = "quoteCar.model" class="col-md-3" id="modelSelect" name="modelSelect">
            <option value="1" selected="selected">Mock1</option>
            <option value="2">Mock2</option>
            <option value="3">Mock3</option>
        </form:select>
    </div>
    <div class="col-md-12">
        <form:label path="quoteCar.fuel" class="col-md-3">Carburant</form:label>
        <form:select path = "quoteCar.fuel" class="col-md-3" id="fuelSelect" name="fuelSelect">
            <c:forEach var="fuel" items="${model.fuels}">
                <option value="${fuel.id}">${fuel.value}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="col-md-12">
        <form:label path="quoteCar.taxHorsepower" class="col-md-3">Chevaux fiscaux</form:label>
        <form:input path="quoteCar.taxHorsepower" class="col-md-3" required="required" type="number" min="1" placeholder="54"/>
    </div>

    <input value="Étape suivante" name="submit" type="submit" class="submit-btn"/>
</form:form>

</body>
</html>
<%@include file="layout_footer.jsp" %>