<%@ include file="../Default/header.jsp" %>

<form method="POST">

<label for="condp">Conducteur principal</label>
<input id="condp" type="text" value="" class="form-control">

<label for="conds">Conducteur secondaire</label>
<input id="conds" type="text" value="" class="form-control">

<label for="garage">Dors dans un garage ?</label>
<input id="garage" type="checkbox" value="" class="form-control">

<label for="adresse">Adresse</label>
<input id="adresse" type="text" value="" class="form-control">

<%@ include file="../QuotationStep/quotationStepState.jsp" %>

<%@ include file="../Default/footer.jsp" %>