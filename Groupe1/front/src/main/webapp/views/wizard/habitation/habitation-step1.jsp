<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../header.jsp" %>

<div class="container">
    <div class="jumbotron">
        <h1>Devis - Assurer une habitation</h1>
        <h2>Etape 1</h2>

        <form:form action="/habWizard.form?_page=2" method="POST" modelAttribute="habWizard">
            <div class="form-group">
                <form:label path="" for="quote.name">Nom du devis :</form:label>
                <form:input path="quote.name" class="form-control" cssStyle="width: 250px;" required="required"></form:input>
            </div>

            <div class="form-group">
                <form:label path="" for="quote.habitation.type">Type de logement :</form:label><br>
                <form:radiobutton path="quote.habitation.type" value="appartement" label="Appartement" checked="checked"></form:radiobutton>
                <form:radiobutton path="quote.habitation.type" value="maison" label="Maison"></form:radiobutton>
            </div>

            <div class="form-group">
                <form:label path="" for="quote.habitation.surface">Surface du logement (en m²) :</form:label>
                <form:input path="quote.habitation.surface" id="surface" class="form-control" cssStyle="width: 250px;" required="required"></form:input>
                <div class="alert alert-danger" role="alert" id="surfaceAlert" style="display: none;">Veuillez saisir une surface de logement valide.</div>
            </div>

            <form:button type="submit" class="btn btn-default">Aller à l'étape 2</form:button>
        </form:form>
    </div>
</div>

<script type="text/javascript" src="../js/habWizard.js"></script>

<%@include file="../../footer.jsp" %>