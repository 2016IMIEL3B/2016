<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="layout_header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wizard Home</title>
</head>
<body>

<form:form method="POST" action="/wizard/home/2" modelAttribute="model">
        <h2>Étape 2/4</h2>

    <div>
        <form:label path="quoteHome.numberRoom" class="col-md-6">Nombre de pièces</form:label>
        <form:input path="quoteHome.numberRoom" class="col-md-6" type="text" placeholder="5"/>
    </div>

    <div>
        <form:label path="quoteHome.floor" class="col-md-6">Étage</form:label>
        <form:input path="quoteHome.floor" class="col-md-6" type="text" placeholder="0 pour RDC"/>
    </div>

    <div>
        <form:label path="quoteHome.numberBathroom" class="col-md-6">Nombre de salle de bain</form:label>
        <form:input path="quoteHome.numberBathroom" class="col-md-6" type="text" placeholder="1"/>
    </div>

    </div>
    <div>
        <label class="col-md-6">Garage</label>
        <form:radiobutton path="quoteHome.garage" value="true"/>Oui
        <form:radiobutton path="quoteHome.garage" value="false"/>Non
    </div>

    <input value="Étape suivante" name="submit" type="submit" class="submit-btn"/>
</form:form>

</body>
</html>
<%@include file="layout_footer.jsp" %>