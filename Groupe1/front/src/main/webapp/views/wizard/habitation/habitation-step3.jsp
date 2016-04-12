<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../header.jsp" %>

<div class="container">
    <div class="jumbotron">
        <h1>Devis - Assurer une habitation</h1>
        <h2>Etape 3</h2>

        <form:form action="/habWizard.form?_page=4" method="POST" modelAttribute="habWizard">

            <div class="row">
                <div class="col-lg-6">
                    <div class="form-group">
                        <form:label path="" for="quote.habitation.groundSurface">Surface du terrain</form:label>
                        <form:input path="quote.habitation.groundSurface" class="form-control" cssStyle="width: 250px;"></form:input>
                    </div>

                    <div class="form-group">
                        <form:label path="" for="quote.habitation.patioSurface">Surface de la salle de bain</form:label>
                        <form:input path="quote.habitation.patioSurface" class="form-control" cssStyle="width: 250px;"></form:input>
                    </div>

                    <div class="form-group">
                        <form:label path="" for="quote.habitation.heatingType">Type de chauffage</form:label>
                        <form:select path="quote.habitation.heatingType" class="form-control" cssStyle="width: 150px;">
                            <form:option value="electrique">Electrique</form:option>
                            <form:option value="gaz">Gaz</form:option>
                        </form:select>
                    </div>
                </div>

                <div class="col-lg-6">
                    <div class="form-group">
                        <form:label path="" for="quote.habitation.address.number">Numéro</form:label>
                        <form:input path="quote.habitation.address.number" class="form-control" cssStyle="width: 250px;"></form:input>
                    </div>

                    <div class="form-group">
                        <form:label path="" for="quote.habitation.address.street">Nom de rue</form:label>
                        <form:input path="quote.habitation.address.street" class="form-control" cssStyle="width: 250px;"></form:input>
                    </div>

                    <div class="form-group">
                        <form:label path="" for="quote.habitation.address.postcode">Code Postal</form:label>
                        <form:input path="quote.habitation.address.postcode" class="form-control" cssStyle="width: 250px;"></form:input>
                    </div>

                    <div class="form-group">
                        <form:label path="" for="quote.habitation.address.city">Ville</form:label>
                        <form:input path="quote.habitation.address.city" class="form-control" cssStyle="width: 250px;"></form:input>
                    </div>
                </div>
            </div>

            <form:button type="submit" class="btn btn-default">Aller à l'étape 4</form:button>

        </form:form>
    </div>
</div>

<%@include file="../../footer.jsp" %>