<%@ include file="../Default/header.jsp" %>

<form method="POST">

    <p>Resumé du devis</p>

    <label for="F1">Formule 1</label>
    <input id="F1" type="radio" value="" class="form-control">
    <label for="F2">Formule 2</label>
    <input id="F2" type="radio" value="" class="form-control">

    <label for="amountDevis">Montant du devis</label>
    <input id="amountDevis" type="text" value="" class="form-control" disabled>

    <%@ include file="../QuotationStep/quotationStepState.jsp" %>

<%@ include file="../Default/footer.jsp" %>