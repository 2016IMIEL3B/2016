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
        <label class="col-md-6">Résumé du devis</label>
        <label class="col-md-6">Pouf pouf</label>
    </div>
    <div>
        <label class="col-md-6">Type de contract</label>
        <form:radiobutton path="quoteHome.formula" value="0"/>Formule 1
        <form:radiobutton path="quoteHome.formula" value="1"/>Formule 2
        <form:radiobutton path="quoteHome.formula" value="2"/>Formule 2
    </div>
    <div>
        <label class="col-md-6">Montant</label>
        <label class="col-md-6">10000000000€</label>
    </div>

    <input value="Valider le devis" name="submit" type="submit" class="submit-btn"/>
</form:form>

</body>
</html>
<%@include file="layout_footer.jsp" %>