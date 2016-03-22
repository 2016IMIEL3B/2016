<%@include file="layout_header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wizard car</title>
</head>
<body>

<div style="border-bottom: double">
    <h2>Étape 1/4</h2>

    <div class="col-md-12">
        <label class="col-md-6">NOM Prénom</label>
        <label class="col-md-6">${user_name}</label>
    </div>
    <div>
        <label class="col-md-6">Marque</label>
        <select class="col-md-6" id="brandSelect" name="brandSelect">
            <option value="0">Marque</option>
            <option value="1">Renault</option>
            <option value="2">Peugeot</option>
            <option value="3">Ford</option>
        </select>
    </div>
    <div>
        <label class="col-md-6">Modèle</label>
        <select class="col-md-6" id="modelSelect" name="modelSelect">
            <option value="0">Modèle</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
        </select>
    </div>
    <div>
        <label class="col-md-6">Carburant</label>
        <select class="col-md-6" id="fuelSelect" name="fuelSelect">
            <option value="0">Carburant</option>
            <option value="1">Diesel</option>
            <option value="2">Essence</option>
            <option value="3">Gpl</option>
        </select>
    </div>
    <div>
        <label class="col-md-6">Chevaux fiscaux</label>
        <input class="col-md-6" type="text" placeholder="54"/>
    </div>

    <input value="Étape suivante" name="submit" type="submit" class="submit-btn"/>
</div>
<div style="border-bottom: double">
    <h2>Étape 2/4</h2>

    <div class="col-md-12">
        <label class="col-md-6">Date du permis</label>
        <input class="col-md-6" type="text" placeholder="54"/>
    </div>
    <div>
        <label class="col-md-6">Nombre d'accident</label>
        <input class="col-md-6" type="text" placeholder="54"/>
    </div>
    <div>
        <label class="col-md-6">Bonus / Malus</label>
        <input class="col-md-6" type="text" placeholder="54"/>
    </div>

    <input value="Étape suivante" name="submit" type="submit" class="submit-btn"/>
</div>
<div style="border-bottom: double">
    <h2>Étape 3/4</h2>

    <div class="col-md-12">
        <label class="col-md-6">Conducteur principale</label>
        <input class="col-md-6" type="text" placeholder="54"/>
    </div>
    <div>
        <label class="col-md-6">Conducteur secondaire</label>
        <input class="col-md-6" type="text" placeholder="54"/>
    </div>
    <div>
        <label class="col-md-6">Dors dans un garage</label>
        <div class="col-md-6" class="btn-group" role="group" aria-label="...">
            <button type="button" class="btn btn-default">Oui</button>
            <button type="button" class="btn btn-default">Non</button>
        </div>
    </div>
    <div>
        <label class="col-md-6">Si oui, adresse</label>
        <input class="col-md-6" type="text" placeholder="54"/>
    </div>

    <input value="Étape suivante" name="submit" type="submit" class="submit-btn"/>
</div>
<div style="border-bottom: double">
    <h2>Étape 4/4</h2>

    <div class="col-md-12">
        <label class="col-md-6">Résumé du devis</label>
        <label class="col-md-6">Pouf pouf</label>
    </div>
    <div>
        <label class="col-md-6">Type de contract</label>
        <div class="col-md-6" class="btn-group" role="group" aria-label="...">
            <button type="button" class="btn btn-default">Tiers</button>
            <button type="button" class="btn btn-default">Tous risque</button>
        </div>
    </div>
    <div>
        <label class="col-md-6">Montant</label>
        <input class="col-md-6" type="text" placeholder="54"/>
    </div>

    <input value="Étape suivante" name="submit" type="submit" class="submit-btn"/>
</div>

</body>
</html>
<%@include file="layout_footer.jsp" %>