<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="layout_header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wizard Home</title>
</head>
<body>

<form:form method="POST" action="/resultHome" modelAttribute="model">
    <h2>Étape 4/4</h2>

    <div class="col-md-12">
        <label class="col-md-3">Résumé du devis</label>
        <form:input required="required" path="quote.resume" class="col-md-3" type="text"/>
    </div>

    <div class="col-md-12">
        <label class="col-md-3">Montant</label>
        <form:input required="required" path="quote.price" class="col-md-3" type="text"/>
    </div>

    <a href="/wizard/home/3" class="btn btn-default">Etape précédente</a>
    <input value="Valider le devis" name="submit" type="submit" class="submit-btn btn btn-default"/>
</form:form>

</body>
</html>
<%@include file="layout_footer.jsp" %>