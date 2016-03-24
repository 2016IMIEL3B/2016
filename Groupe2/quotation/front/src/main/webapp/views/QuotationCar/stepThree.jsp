<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../Default/header.jsp" %>

<form:form method="POST" action="devis/voiture/send/3" modelAttribute="car">

    <form:label path="firstName">Prénom Conducteur principal</form:label>
    <form:input path="firstName" type="text" value="" class="form-control" />
    <form:label path="lastName">Nom Conducteur principal</form:label>
    <form:input path="lastName" type="text" value="" class="form-control" />


        <label for="secondFirstName">Prénom Conducteur secondaire</label>
        <input id="secondFirstName" type="text" value="" class="form-control" />
        <label for="secondLastName">Nom Conducteur secondaire</label>
        <input id="secondLastName" type="text" value="" class="form-control" />


<form:label path="sleepGarage">Dors dans un garage ?</form:label>
<form:input path="sleepGarage" type="checkbox" value="" class="form-control" />

<form:label path="address">Adresse</form:label>
<form:input path="address" type="text" value="" class="form-control" />

<%@ include file="../QuotationStep/quotationStepState.jsp" %>

</form:form>

<%@ include file="../Default/footer.jsp" %>