<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../header.jsp" %>

<div class="container">
    <div class="jumbotron">
        <h1>Devis - Assurer une habitation</h1>
        <h2>Etape 2</h2>

        <form:form action="/habWizard.form?_page=3" method="POST" modelAttribute="habWizard">
            <div class="form-group">
                <form:label path="" for="quote.habitation.roomNumber">Nombre de pièces</form:label>
                <form:select path="quote.habitation.roomNumber" class="form-control" cssStyle="width: 150px;">
                    <form:option value="1">T1</form:option>
                    <form:option value="2">T2</form:option>
                    <form:option value="3">T3</form:option>
                    <form:option value="4">T4</form:option>
                    <form:option value="5">T5</form:option>
                    <form:option value="6">T6</form:option>
                </form:select>
            </div>

            <div class="form-group">
                <form:label path="" for="quote.habitation.floor">Etage</form:label>
                <form:input path="quote.habitation.floor" class="form-control" cssStyle="width: 250px;"></form:input>
            </div>

            <div class="form-group">
                <form:label path="" for="quote.habitation.bathroomNumber">Nombre de salles de bain</form:label>
                <form:input path="quote.habitation.bathroomNumber" class="form-control" cssStyle="width: 250px;"></form:input>
            </div>

            <div class="form-group">
                <form:label path="" for="quote.habitation.garage">Garage :</form:label><br>
                <form:radiobutton path="quote.habitation.garage" value="true" label="Oui"></form:radiobutton>
                <form:radiobutton path="quote.habitation.garage" value="false" label="Non"></form:radiobutton>
            </div>

            <form:button type="submit" class="btn btn-default">Aller à l'étape 3</form:button>
        </form:form>
    </div>
</div>

<%@include file="../../footer.jsp" %>