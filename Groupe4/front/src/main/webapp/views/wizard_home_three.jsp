<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="layout_header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wizard Home</title>
</head>
<body>

<form:form method="POST" action="/wizard/home/4" modelAttribute="model">
        <h2>Étape 3/4</h2>

    <div>
        <form:label path="quoteHome.groundArea" class="col-md-6">Surface du terrain</form:label>
        <form:input path="quoteHome.groundArea" class="col-md-6" type="number" placeholder="5"/>m²
    </div>

    <div>
        <form:label path="quoteHome.terraceArea" class="col-md-6">Surface de la terrasse</form:label>
        <form:input path="quoteHome.terraceArea" class="col-md-6" type="number" placeholder="0"/>m²
    </div>

    <div>
        <form:label path="quoteHome.typeHeating" class="col-md-6">Type de chauffage</form:label>
        <form:select path = "quoteHome.typeHeating" class="col-md-6" id="typeHeatingSelect" name="typeHeatingSelect">
            <option value="1" selected="selected">Fioul</option>
            <option value="2">Gaz</option>
            <option value="3">Bois</option>
        </form:select>
    </div>

    <input value="Étape suivante" name="submit" type="submit" class="submit-btn"/>
</form:form>

</body>
</html>
<%@include file="layout_footer.jsp" %>