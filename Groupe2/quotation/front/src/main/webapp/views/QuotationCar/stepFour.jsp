<%@ include file="../Default/header.jsp" %>

<form method="POST">

<p>Resumé du devis</p>

<label for="ttrisques">Tous risques ?</label>
<input id="ttrisques" name="choice" type="radio" value="" class="form-control">
<label for="tiers">Au tiers</label>
<input id="tiers" name="choice" type="radio" value="" class="form-control">

<label for="amountDevis">Montant du devis</label>
<input id="amountDevis" type="text" value="" class="form-control" disabled>

<%@ include file="../QuotationStep/quotationStepState.jsp" %>

<%@ include file="../Default/footer.jsp" %>