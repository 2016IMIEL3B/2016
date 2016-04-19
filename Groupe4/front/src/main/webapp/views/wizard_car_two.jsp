<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="layout_header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Wizard car 2</title>
</head>
<body>

<form:form method="POST" action="/wizard/car/3" modelAttribute="model">
    <h2>Étape 2/4</h2>

    <div class="col-md-12">
        <label class="col-md-3">Date du permis</label>
        <form:input path="quoteCar.dateLicence" class="col-md-3" type="date" placeholder="12/02/02"/>
    </div>
    <div class="col-md-12">
        <label class="col-md-3">Nombre d'accident</label>
        <form:input path="quoteCar.numberAccident" class="col-md-3" required="required" type="number" placeholder="2"/>
    </div>
    <div class="col-md-12">
        <label class="col-md-3">Bonus / Malus</label>
        <form:input path="quoteCar.bonusMalus" class="col-md-3" required="required" type="number" placeholder="0.5"/>
    </div>

    <input value="Étape suivante" name="submit" type="submit" class="submit-btn"/>
</form:form>

</body>
</html>
<%@include file="layout_footer.jsp" %>