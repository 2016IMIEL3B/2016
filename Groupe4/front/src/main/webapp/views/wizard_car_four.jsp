<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="layout_header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wizard car 4</title>
</head>
<body>

<form:form method="POST" action="/result" modelAttribute="model">
    <h2>Étape 4/4</h2>

    <div class="col-md-12">
        <label class="col-md-3">Intitulé du devis</label>
        <form:input path="quote.name" class="col-md-3" required="required" type="text"/>
    </div>
    <div class="col-md-12">
        <label class="col-md-3">Résumé du devis</label>
        <form:textarea path="quote.resume" class="col-md-3"/>
    </div>
    <div class="col-md-12">
        <label class="col-md-3">Montant</label>
        <form:input path="quote.price" class="col-md-3" required="required" type="number"/>
    </div>

    <input value="Valider le devis" name="submit" type="submit" class="submit-btn"/>
</form:form>

</body>
</html>
<%@include file="layout_footer.jsp" %>