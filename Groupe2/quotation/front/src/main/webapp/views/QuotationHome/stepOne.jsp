<%@ include file="../Default/header.jsp" %>

    <form>

    <label for="nomPrenomUser">Nom / prenom de l’utilisateur</label>
    <input id="nomPrenomUser" type="text" value="" class="form-control" disabled>

    <label for="devis">Nom du devis</label>
    <input id="devis" type="text" value="" class="form-control">

    <label for="typeHab">Type d’habitation</label>
    <select id="typeHab" class="form-control">

        <option value=""></option>

    </select>

    <label for="surface">Surface</label>
    <input id="surface" type="text" value="" class="form-control">

    <%@ include file="../QuotationStep/quotationStepState.jsp" %>

<%@ include file="../Default/footer.jsp" %>