<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@include file="layout_header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wizard Home</title>
</head>
<body>

<form:form method="POST" action="/wizard/home/2" modelAttribute="model">
    <h2>Étape 1/4</h2>

    <div class="col-md-12">
        <form:label path="userName" class="col-md-3">Nom Prénom</form:label>
        <form:input path="userName" class="col-md-3" type="text" disabled="true"/>
        <%--<label class="col-md-3">NOM Prénom</label>--%>
        <%--<form:label path="userName" class="col-md-3">${model.userName}</form:label>--%>
    </div>
    <div class="col-md-12">
        <form:label path="quoteHome.typeHome" class="col-md-3">Type Habitation</form:label>
        <form:select path = "quoteHome.typeHome" class="col-md-3" id="typeSelect" name="typeSelect">
            <option value="1" selected="selected">Appartement</option>
            <option value="2">Maison</option>
            <option value="3">Studio</option>
        </form:select>
    </div>

    <div class="col-md-12">
        <form:label path="quoteHome.address" class="col-md-3">Adresse</form:label>
        <form:input required="required" path="quoteHome.address" class="col-md-3" type="text" placeholder="Rue patate"/>
    </div>

    <div class="col-md-12">
        <form:label path="quoteHome.area" class="col-md-3">Surface</form:label>
        <form:input required="required" min="2" path="quoteHome.area" class="col-md-3" type="number" placeholder="100"/>m²
    </div>

    <input value="Étape suivante" name="submit" type="submit" class="submit-btn"/>
</form:form>

</body>
</html>
<%@include file="layout_footer.jsp" %>