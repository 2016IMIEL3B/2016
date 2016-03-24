<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../Default/header.jsp" %>

<form:form method="POST" action="devis/voiture/send/2" modelAttribute="car">

<form:label path="licenceDate">Date du permis</form:label>
<form:input path="licenceDate" type="text" value="" class="form-control" />

<form:label path="nbCrash">Nombre d’accident</form:label>
<form:select path="nbCrash" class="form-control">

    <option value=""></option>

</form:select>

<form:label path="bonusPenality" for="bonmal">Bonus malus</form:label>
<form:select path="bonusPenality" id="bonmal" class="form-control">

    <option value=""></option>

</form:select>

<%@ include file="../QuotationStep/quotationStepState.jsp" %>

</form:form>

<%@ include file="../Default/footer.jsp" %>