<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../Default/header.jsp" %>

<form:form method="POST" action="/devis/${id}/voiture/send/3" modelAttribute="driver">

<p>Resumé du devis</p>

<%--<form:label path="car.insurance">Touorm:label>--%>
<%--<form:radiobuttons path="car.tier" value="false" class="form-control" />--%>
    <label for="car.tier">Tous Risque</label>
    <form:radiobutton path="car.tier" class="form-control" value="False"/>
    <label for="car.tier">Tiers</label>
    <form:radiobutton path="car.tier" class="form-control" value="True"/>

    <label for="amountDevis">Montant du devis</label>
    <input id="amountDevis" type="text" value="" class="form-control" disabled />

<%@ include file="../QuotationStep/quotationStepState.jsp" %>

</form:form>

<%@ include file="../Default/footer.jsp" %>