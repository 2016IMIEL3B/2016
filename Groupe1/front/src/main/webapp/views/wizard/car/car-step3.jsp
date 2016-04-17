<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../header.jsp" %>

<div class="container">
    <div class="jumbotron">

        <h1>Devis: Assurer une voiture</h1>
        <h2>Etape 3</h2>

        <form:form action="/carWizard.form?_page=4" method="POST" modelAttribute="carWizard">
            <div class="row">
                <div class="col-lg-6">
                    <div class="form-group">
                        <form:label path="" for="quote.Usera.firstname">Conducteur principal</form:label>
                        <form:input path="quote.usera.firtname" class="form-control" cssStyle="width:250px;"></form:input>

                    </div>

                    <div class="form-group">
                        <form:label path="" for="quote.Usera.lastname"></form:label>
                        <form:input path="quote.usera.lastname" class="form-control" cssStyle="width:250px;"></form:input>
                    </div>

                    <div class="form-group">
                        <form:label path="" for="quote.usera.">Conducteur secondaire</form:label>
                        <form:input path="quote.usera." class="form-control" cssStyle="width:250px;"></form:input>
                    </div>

                    <div class="form-group">
                        <form:label path="" for="quote.vehicle.sleepInside">Dors dans un garage?</form:label>
                        <form:input  path="quote.vehicle.sleepInside" class="form-control" cssStyle="width:250px;"></form:input>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="form-group">
                        <form:label path="" for"quote.habitation.address.number"> Numéro </form:label>
                        <form:input  path="quote.habitation.address.number" class="form-control" cssStyle="width:250px;"></form:input>
                    </div>

                    <div class="form-group">
                        <form:label path="" for"quote.habitation.address.street"> Nom de rue </form:label>
                        <form:input  path="quote.habitation.address.street" class="form-control" cssStyle="width:250px;"></form:input>
                    </div>

                    <div class="form-group">
                        <form:label path="" for"quote.habitation.address.postcode"> Code postal </form:label>
                        <form:input  path="quote.habitation.address.postcode" class="form-control" cssStyle="width:250px;"></form:input>
                    </div>

                    <div class="form-group">
                        <form:label path="" for"quote.habitation.address.city"> Ville </form:label>
                        <form:input  path="quote.habitation.address.city" class="form-control" cssStyle="width:250px;"></form:input>
                    </div>

                </div>
            </div>
        <form:button type="submit">Aller à l'étape suivante</form:button>
        </form:form>
    </div>
</div>











<%@include file="../../footer.jsp" %>