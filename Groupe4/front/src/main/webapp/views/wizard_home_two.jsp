<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <label class="col-md-6">NOM Prénom</label>
            <form:label path="userName" class="col-md-6">${model.userName}</form:label>

    </div>
    <div>
        <form:label path="quoteHome.typeHome" class="col-md-6">Type Habitation</form:label>
        <form:select path = "quoteHome.typeHome" class="col-md-6" id="typeSelect" name="typeSelect">
            <option value="0">Type Habitation</option>
            <option value="1">Appartement</option>
            <option value="2">Maison</option>
            <option value="3">Studio</option>
        </form:select>
    </div>
    <div>
        <form:label path="quoteHome.area" class="col-md-6">Surface</form:label>
        <form:input path="quoteHome.area" class="col-md-6" type="text" placeholder="100"/>m²
    </div>

    <input value="Étape suivante" name="submit" type="submit" class="submit-btn"/>
</form:form>

</body>
</html>
<%@include file="layout_footer.jsp" %>