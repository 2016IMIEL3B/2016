<%@ include file="../Default/header.jsp" %>

<form method="POST">

    <label for="nbpièces">Nombre de pièces</label>
    <select id="nbpièces" class="form-control">

        <option value=""></option>

    </select>

    <label for="etage">Etage (si appartement)</label>
    <select id="etage" class="form-control">

        <option value=""></option>

    </select>

    <label for="nbbain">Nombre de salle de bain</label>
    <select id="nbbain" class="form-control">

        <option value=""></option>

    </select>

    <label for="garage">Garage ?</label>
    <input id="garage" type="checkbox" value="" class="form-control">

    <%@ include file="../QuotationStep/quotationStepState.jsp" %>

<%@ include file="../Default/footer.jsp" %>