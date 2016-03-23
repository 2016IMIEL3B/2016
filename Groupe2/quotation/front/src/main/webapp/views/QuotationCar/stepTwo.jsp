<%@ include file="../Default/header.jsp" %>

<form method="POST">

<label for="date">Date du permis</label>
<input id="date" type="text" value="" class="form-control">

<label for="nbAcc">Nombre d’accident</label>
<select id="nbAcc" class="form-control">

    <option value=""></option>

</select>

<label for="bonmal">Bonus malus</label>
<select id="bonmal" class="form-control">

    <option value=""></option>

</select>

<%@ include file="../QuotationStep/quotationStepState.jsp" %>

<%@ include file="../Default/footer.jsp" %>