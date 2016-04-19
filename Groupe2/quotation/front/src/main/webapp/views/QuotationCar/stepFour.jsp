<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../Default/header.jsp" %>

<form:form method="POST" action="/devis/${id}/voiture/send/3" modelAttribute="driver">

<p>Resumé du devis</p>
    <br />
    <label >Voiture Principal :</label><br />
    <form:label path="car.quotation.name">Nom du devis :</form:label>
    <form:input path="car.quotation.name" type="text" value="" class="form-control" disabled="true"/>
    <form:label path="car.mark">Marque :</form:label>
    <form:input path="car.mark" type="text" value="" class="form-control" disabled="true"/>
    <form:label path="car.model">Modele :</form:label>
    <form:input path="car.model" type="text" value="" class="form-control" disabled="true"/>
    <form:label path="car.fuel">Type de Carburant : </form:label>
    <form:input path="car.fuel" type="text" value="" class="form-control" disabled="true"/>
    <form:label path="car.taxableHorsePower">Chevaux Fiscaux :</form:label>
    <form:input path="car.taxableHorsePower" type="text" value="" class="form-control" disabled="true"/>
    <form:label path="car.taxableHorsePower">Garage :</form:label>
    <form:checkbox path="car.sleepGarage" value="car.sleepGarage" class="form-control" />
    <form:label path="car.address">Adresse :</form:label>
    <form:input path="car.address" type="text" value="" class="form-control" disabled="true"/>

    <br /><br />
    <label >Conducteur Principal :</label> <br />
    <form:label path="firstName">Prenom :</form:label>
    <form:input path="firstName" type="text" value="" class="form-control" disabled="true"/>
    <form:label path="lastName">Nom :</form:label>
    <form:input path="lastName" type="text" value="" class="form-control" disabled="true"/>
    <form:label path="nbCrash">Nombre d'accident :</form:label>
    <form:input path="nbCrash" type="text" value="" class="form-control" disabled="true"/>
    <form:label path="bonusPenality">Bonus Malus :</form:label>
    <form:input path="bonusPenality" type="text" value="" class="form-control" disabled="true"/>
    <form:label path="licenceDate">Date du permis :</form:label>
    <form:input path="licenceDate" type="text" value="" class="form-control" disabled="true"/>
</form:form>
<br /><br />
<label >Conducteur Secondaire :</label> <br />
<form:label path="secondDriver.firstName">Prenom :</form:label>
<form:input path="secondDriver.firstName" type="text" value="" class="form-control" disabled="true"/>
<form:label path="secondDriver.lastName">Nom :</form:label>
<form:input path="secondDriver.lastName" type="text" value="" class="form-control" disabled="true"/>
<br /><br />

<form:form method="POST" action="/devis/${id}/voiture/send/4" modelAttribute="driver">
    <label for="car.tier">Tous Risque</label>
    <form:radiobutton path="car.tier" class="form-control" value="False"/>
    <label for="car.tier">Tiers</label>
    <form:radiobutton path="car.tier" class="form-control" value="True"/>

    <label for="car.quotation.price">Montant du devis</label>
    <input id="amountDevis" type="text" value="399.99" class="form-control" disabled />

<%@ include file="../QuotationStep/quotationStepState.jsp" %>

</form:form>

<%@ include file="../Default/footer.jsp" %>