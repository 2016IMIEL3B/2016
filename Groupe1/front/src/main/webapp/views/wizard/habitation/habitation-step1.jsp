<%@include file="../../header.jsp" %>

<div class="container">
    <div class="jumbotron">
        <h1>Devis - Assurer une habitation</h1>
        <h2>Etape 1</h2>

        <form:form action="/habWizard.form?_page=2" method="POST" modelAttribute="habWizard">
            <div class="form-group">
                <form:label path="" for="quote.name">Nom du devis :</form:label>
                <form:input path="quote.name" class="form-control"></form:input>
            </div>

            <div class="form-group">
                <form:label path="" for="quote.habitation.type">Type de logement :</form:label><br>
                <form:radiobutton path="quote.habitation.type" value="appartement" label="Appartement"></form:radiobutton>
                <form:radiobutton path="quote.habitation.type" value="maison" label="Maison"></form:radiobutton>
            </div>

            <div class="form-group">
                <form:label path="" for="quote.habitation.surface">Surface du logement :</form:label>
                <form:input path="quote.habitation.surface" class="form-control"></form:input>
            </div>

            <form:button type="submit" class="btn btn-default">Aller à l'étape 2</form:button>
        </form:form>
    </div>
</div>

<%@include file="../../footer.jsp" %>