<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../../header.jsp" %>

<div class="container">
    <div class="jumbotron">
        <h1>Devis: Assurer une voiture</h1>
        <h2>Etape 4</h2>


        <div style="margin-bottom: 20px;">
            <h3>Résumé du devis : ${carWizard.quote.name}</h3>
            <h4>Devis établi au nom de : John Doe</h4>

            <div>
                <span style="font-size: 18px;">Adresse du propriétaire :</span>
                <span>${carWizard.quote.habitation.address.number}</span>
                <span>${carWizard.quote.habitation.address.street}</span>
                <span>${carWizard.quote.habitation.address.postcode}</span>
                <span>${carWizard.quote.habitation.address.city}</span>
            </div>
            <div>
                <span>${carWizard.Usera.drivingLicenceDate}</span>
                <span>${carWizard.Usera.accidentNumber}</span>
                <span>${carWizard.Usera.bonus}</span>
            </div>

            <div>
                <span>${carWizard.Usera.firstName}</span>
                <span>${carWizard.Usera.LastName}</span>
                <span>${carWizard.Usera.isSecondary}</span>
            </div>

            <div>
                <span>${carWizard.quote.vehicle.model}</span>
                <span>${carWizard.quote.vehicle.fuel}</span>
                <span>${carWizard.quote.vehicle.horsepower}</span>
                <span>${carWizard.quote.vehicle.sleepInside}</span>

            </div>
        </div>

        <div>
            <form:form action="/carWizard.form?_finish" method="POST" modelAttribute="carWizard">

                <div class="form-group">
                    <form:label path="" for="quote.summary">Choix de la formule</form:label><br>
                    <form:radiobutton path="quote.summary" value="allrisks" label="Tous risques"></form:radiobutton>
                    <form:radiobutton path="quote.summary" value="third" label="Au tiers"></form:radiobutton>
                </div>

                Montant : ${carWizard.quote.price}

                <form:button type="submit" class="btn btn-default">Valider le devis</form:button>
            </form:form>
        </div>

    </div>
</div>

<%@include file="../../footer.jsp" %>
