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
                <span style="font-size: 18px;">Adresse du propriétaire :</span> <br>
                <span>${carWizard.address.number}</span><br>
                <span>${carWizard.address.street}</span><br>
                <span>${carWizard.address.postcode}</span><br>
                <span>${carWizard.address.city}</span><br>
            </div>

            <div>
                <span style="font-size: 18px;">Informations conducteur:</span><br>
                <span>${carWizard.client.user.firstName}</span><br>
                <span>${carWizard.client.user.lastName}</span><br>
                <span>Date d'obtention du permis:</span><span>${carWizard.client.drivingLicenceDate}</span><br>
                <span>Nombre d'accidents:</span> <span>${carWizard.client.accidentNumber}</span>

            </div>

            <div>
                <span style="font-size: 18px;">Informations Véhicule:</span><br>
                <span>Modèle: </span><span>${carWizard.quote.vehicle.model.name}</span><br>
                <span>Fuel:</span><span>${carWizard.quote.vehicle.fuel}</span><br>
                <span>Chevaux fiscaux: </span><span>${carWizard.quote.vehicle.horsepower}</span>



            </div>
        </div>

        <div>
            <form:form action="/carWizard.form?_finish" method="POST" modelAttribute="carWizard">

                <div class="form-group">
                    <form:label path="" for="quote.summary">Choix de la formule</form:label><br>
                    <form:radiobutton path="quote.summary" value="allrisks" label="Tous risques"></form:radiobutton>
                    <form:radiobutton path="quote.summary" value="third" label="Au tiers"></form:radiobutton>
                </div>

                <div>Montant : <span path="quote.price" id="price"></span>€ /mois</div>

                <form:button type="submit" class="btn btn-default">Valider le devis</form:button>
            </form:form>
        </div>

    </div>
</div>

<script type="text/javascript">
    var horsepower = ${carWizard.quote.vehicle.horsepower};
    var price = 0;
</script>

<script type="text/javascript" src="../js/carWizard.js"></script>

<%@include file="../../footer.jsp" %>
