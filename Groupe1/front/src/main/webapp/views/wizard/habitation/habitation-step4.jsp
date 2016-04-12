<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../header.jsp" %>

<div class="container">
    <div class="jumbotron">
        <h1>Devis - Assurer une habitation</h1>
        <h2>Etape 4/h2>

        Résumé du devis ${habWizard.quote.name} <br />
        <%-- ${ habWizard.user.firstName} ${habWizard.user.lastName} --%>
        <br />
        ${habWizard.quote.habitation.address.number} ${habWizard.quote.habitation.address.street}
        ${habWizard.quote.habitation.address.postCode} ${habWizard.quote.habitation.address.city}
        Etage ${habWizard.quote.habitation.floor}
        <br />
        ${habWizard.quote.habitation.type} ${habWizard.quote.habitation.surface}m²

        <form:form action="/habWizard.form?_finish" method="POST" modelAttribute="habWizard">

            <div class="form-group">
                <form:label path="" for="quote.summary">Choix de la formule</form:label><br>
                <form:radiobutton path="quote.summary" value="basic" label="Formule Basique"></form:radiobutton>
                <form:radiobutton path="quote.summary" value="full" label="Formule Complète"></form:radiobutton>
            </div>

            Montant : ${habWizard.quote.price}

            <form:button type="submit" class="btn btn-default">Valider le devis</form:button>
        </form:form>
    </div>
</div>

<%@include file="../../footer.jsp" %>