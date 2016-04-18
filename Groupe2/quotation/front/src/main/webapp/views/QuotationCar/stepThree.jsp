<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../Default/header.jsp" %>

<form:form method="POST" action="/devis/${id}/voiture/send/3" modelAttribute="driver">

    <form:label path="firstName">Prénom Conducteur principal</form:label>
    <form:input path="firstName" type="text" value="" class="form-control" />
    <form:label path="lastName">Nom Conducteur principal</form:label>
    <form:input path="lastName" type="text" value="" class="form-control" />

    <label for="secondFirstName">Prénom Conducteur secondaire</label>
    <input name="secondFirstName" id="secondFirstName" type="text" value="" class="form-control" />
    <label for="secondLastName">Nom Conducteur secondaire</label>
    <input name="secondLastName"  id="secondLastName" type="text" value="" class="form-control" />

<form:label path="car.sleepGarage">Dors dans un garage ?</form:label>
<form:checkbox path="car.sleepGarage" value="false" class="form-control" />

<form:label path="car.address">Adresse</form:label>
<form:input path="car.address" type="text" value="" class="form-control" />

<%@ include file="../QuotationStep/quotationStepState.jsp" %>

</form:form>

<%@ include file="../Default/footer.jsp" %>