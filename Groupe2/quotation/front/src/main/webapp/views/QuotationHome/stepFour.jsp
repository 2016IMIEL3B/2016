<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../Default/header.jsp" %>

<form:form method="POST" action="devis/habitation/send/4" modelAttribute="home">

    <p>Resumé du devis</p>

    <form:label path="formul">Formule 1</form:label>
    <form:input path="formul" name="choice" type="radio" value="" class="form-control" />
    <label for="F2">Formule 2</label>
    <input id="F2" name="choice" type="radio" value="" class="form-control" />

    <label for="amountDevis">Montant du devis</label>
    <input id="amountDevis" type="text" value="" class="form-control" disabled />

    <%@ include file="../QuotationStep/quotationStepState.jsp" %>

</form:form>

<%@ include file="../Default/footer.jsp" %>