<%@ include file="../Default/header.jsp" %>

<form method="POST">

<label for="nomPrenomUser">Nom / prenom de l’utilisateur</label>
<input id="nomPrenomUser" type="text" value="" class="form-control" disabled>

<label for="devis">Nom du devis</label>
<input id="devis" type="text" value="" class="form-control">

<label for="marque">Marque</label>
<select id="marque" class="form-control">

    <option value=""></option>

</select>

<label for="modele">Modèle</label>
<select id="modele" class="form-control">

    <option value=""></option>

</select>

<label for="carburant">Carburant</label>
<select id="carburant" class="form-control">

    <option value=""></option>

</select>

<label for="cheveux">Cheveux fiscaux</label>
<select id="cheveux" class="form-control">

    <option value=""></option>

</select>

<%@ include file="../QuotationStep/quotationStepState.jsp" %>

<%@ include file="../Default/footer.jsp" %>