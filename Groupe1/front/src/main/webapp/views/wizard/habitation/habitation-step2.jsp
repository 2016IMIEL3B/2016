<%@include file="../../header.jsp" %>

<div class="container">
    <div class="jumbotron">
        <h1>Devis - Assurer une habitation</h1>
        <h2>Etape 2</h2>

        Nom du devis: ${habWizard.quote.name} <br />
        Type de logement: ${habWizard.quote.habitation.type} <br />
        Surface: ${habWizard.quote.habitation.surface}m²

        <form:form action="/habwizard.form?_page=3" method="POST" modelAttribute="habWizard">
            <div class="form-group">
                <form:label path="" for="quote.habitation.roomNumber">Nombre de pièces</form:label>
                <form:input path="quote.habitation.roomNumber" class="form-control"></form:input>
            </div>

            <form:button type="submit" class="btn btn-default">Aller à l'étape 3</form:button>
        </form:form>
    </div>
</div>

<%@include file="../../footer.jsp" %>