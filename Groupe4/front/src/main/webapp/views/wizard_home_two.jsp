<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="layout_header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wizard Home</title>
</head>
<body>

<form:form method="POST" action="/wizard/home/3" modelAttribute="model">
        <h2>Étape 2/4</h2>

    <div class="col-md-12">
        <form:label path="quoteHome.numberRoom" class="col-md-3">Nombre de pièces</form:label>
        <form:input path="quoteHome.numberRoom" class="col-md-3" min="1" required="required" type="number" placeholder="5"/>
    </div>

    <div class="col-md-12">
        <form:label path="quoteHome.floor" class="col-md-3">Étage</form:label>
        <form:input path="quoteHome.floor" class="col-md-3" required="required" type="number" placeholder="0"/>
    </div>

    <div class="col-md-12">
        <form:label path="quoteHome.numberBathroom" class="col-md-3">Nombre de salle de bain</form:label>
        <form:input path="quoteHome.numberBathroom" class="col-md-3" min="1" required="required" type="number" placeholder="1"/>
    </div>
    
    <div class="col-md-12">
        <label class="col-md-3">Garage</label>
        <div class="col-md-3">
            <form:radiobutton path="quoteHome.garage" value="true"/>Oui
            <form:radiobutton path="quoteHome.garage" value="false"/>Non
        </div>
    </div>

    <a href="/wizard/home/1" class="btn btn-default">Etape précédente</a>
    <input value="Étape suivante" name="submit" type="submit" class="btn btn-default submit-btn"/>
</form:form>

</body>
</html>
<%@include file="layout_footer.jsp" %>