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
                        <form:label path="" for="">Conducteur principal</form:label>
                        <form:input path="client.user.lastName" class="form-control" placeholder="Nom" cssStyle="width:250px;" required="required"></form:input>
                        <form:input path="client.user.firstName" class="form-control" placeholder="prénom" cssStyle="width:250px;" required="required"></form:input>
                    </div>

                    <%--<div class="form-group">--%>
                        <%--<form:label path="" for="">Conducteur secondaire</form:label>--%>
                        <%--<form:input path="" class="form-control" placeholder="Nom" cssStyle="width:250px;"></form:input>--%>
                        <%--<form:input path="" class="form-control" placeholder="prénom" cssStyle="width:250px;"></form:input>--%>
                    <%--</div>--%>

                    <div class="form-group">
                        <form:label path="" for="quote.vehicle.sleepInside">Dors dans un garage?</form:label>
                        <form:radiobutton path="quote.vehicle.sleepInside" value="yes" label="Oui"></form:radiobutton>
                        <form:radiobutton path="quote.vehicle.sleepInside" value="no" label="non"></form:radiobutton>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="form-group">
                        <form:label path="" for="quote.habitation.address.number"> Numéro </form:label>
                        <form:input  path="quote.habitation.address.number" class="form-control" cssStyle="width:250px;" required="required"></form:input>
                    </div>

                    <div class="form-group">
                        <form:label path="" for="quote.habitation.address.street"> Nom de rue </form:label>
                        <form:input  path="quote.habitation.address.street" class="form-control" cssStyle="width:250px;" required="required"></form:input>
                    </div>

                    <div class="form-group">
                        <form:label path="" for="quote.habitation.address.postcode"> Code postal </form:label>
                        <form:input  path="quote.habitation.address.postcode" class="form-control" cssStyle="width:250px;" required="required"></form:input>
                    </div>

                    <div class="form-group">
                        <form:label path="" for="quote.habitation.address.city"> Ville </form:label>
                        <form:input  path="quote.habitation.address.city" class="form-control" cssStyle="width:250px;" required="required"></form:input>
                    </div>

                </div>
            </div>
        <form:button type="submit">Aller à l'étape suivante</form:button>
        </form:form>
    </div>
</div>


<script type="text/javascript">
    var sleepinside = ${carWizard.quote.vehicle.sleepInside};
    var price = 0;
</script>

<script type="text/javascript" src="../js/carWizard.js"></script>

<%@include file="../../footer.jsp" %>