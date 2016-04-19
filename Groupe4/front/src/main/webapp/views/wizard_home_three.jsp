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

    <div class="col-md-12">
        <form:label path="quoteHome.groundArea" class="col-md-3">Surface du terrain</form:label>
        <form:input path="quoteHome.groundArea" class="col-md-3" type="number" placeholder="5"/>m²
    </div>

    <div class="col-md-12">
        <form:label path="quoteHome.terraceArea" class="col-md-3">Surface de la terrasse</form:label>
        <form:input path="quoteHome.terraceArea" class="col-md-3" type="number" placeholder="0"/>m²
    </div>

    <div class="col-md-12">
        <form:label path="quoteHome.typeHeating" class="col-md-3">Type de chauffage</form:label>
        <form:select path = "quoteHome.typeHeating" class="col-md-3" id="typeHeatingSelect" name="typeHeatingSelect">
            <option value="1" selected="selected">Fioul</option>
            <option value="2">Gaz</option>
            <option value="3">Bois</option>
        </form:select>
    </div>

    <div class="col-md-12">
        <label class="col-md-3">Type de contract</label>
        <div class="col-md-3">
            <form:radiobutton path="quoteHome.formula" value="0"/>Formule 1
            <form:radiobutton path="quoteHome.formula" value="1"/>Formule 2
            <form:radiobutton path="quoteHome.formula" value="2"/>Formule 2
        </div>
    </div>

    <a href="/wizard/home/2" class="btn btn-default">Etape précédente</a>
    <input value="Étape suivante" name="submit" type="submit" class="submit-btn btn btn-default"/>
</form:form>

</body>
</html>
<%@include file="layout_footer.jsp" %>