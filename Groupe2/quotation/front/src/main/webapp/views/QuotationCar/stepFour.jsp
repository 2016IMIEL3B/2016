<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../Default/header.jsp" %>

<form:form method="POST" action="devis/voiture/send/4" modelAttribute="car">

<p>Resumé du devis</p>

<form:label path="insurance">Tous risques ?</form:label>
<form:input path="insurance" name="choice" type="radio" value="" class="form-control" />
<label for="assurance">Au tiers</label>
<input id="assurance" name="choice" type="radio" value="" class="form-control" />

<label for="amountDevis">Montant du devis</label>
<input id="amountDevis" type="text" value="" class="form-control" disabled />

<%@ include file="../QuotationStep/quotationStepState.jsp" %>

</form:form>

<%@ include file="../Default/footer.jsp" %>