<%@include file="../../header.jsp" %>

<h1>Devis - Assurer une habitation</h1>
<h2>Etape 1</h2>

<form:form action="/habWizard.form?_page=2" method="POST" modelAttribute="habWizard">
    <form:label path="" for="quote.name">Nom du devis :</form:label>
    <form:input path="quote.name"></form:input>
    <br>

    <form:label path="" for="quote.habitation.type">Type de logement :</form:label>
    <form:radiobutton path="quote.habitation.type" value="appartement" label="Appartement"></form:radiobutton>
    <form:radiobutton path="quote.habitation.type" value="maison" label="Maison"></form:radiobutton>
    <br>

    <form:label path="" for="quote.habitation.surface">Surface du logement :</form:label>
    <form:input path="quote.habitation.surface"></form:input>
    <br>

    <form:button type="submit">Aller à l'étape 2</form:button>
</form:form>

<%@include file="../../footer.jsp" %>