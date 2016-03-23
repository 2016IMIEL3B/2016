<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="layout_header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wizard car 3</title>
</head>
<body>
<form:form method="POST" action="/car/step/3" modelAttribute="model">
    <h2>Étape 3/4</h2>

    <div class="col-md-12">
        <label class="col-md-6">Conducteur principale</label>
        <form:input path="quoteCar.driver" class="col-md-6" type="text" placeholder="Pascal Duchamps"/>
    </div>
    <div>
        <label class="col-md-6">Conducteur secondaire</label>
        <form:input path="quoteCar.secondaryDriver" class="col-md-6" type="text" placeholder="Jean-Michel Crapaud"/>
    </div>
    <div>
        <label class="col-md-6">Dors dans un garage</label>
        <form:radiobutton path="quoteCar.garage" value="true"/>Oui
        <form:radiobutton path="quoteCar.garage" value="false"/>Non
    </div>
    <div>
        <label class="col-md-6">Si oui, adresse</label>
        <form:input path="quoteCar.address" class="col-md-6" type="text" placeholder="Rue des patates"/>
    </div>

    <input value="Étape suivante" name="submit" type="submit" class="submit-btn"/>
</form:form>

</body>
</html>
<%@include file="layout_footer.jsp" %>