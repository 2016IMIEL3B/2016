<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../../header.jsp" %>

<div class="container">
    <div class="jumbotron">
        <h1>Devis - Assurer une habitation</h1>
        <h2>Etape 4</h2>

        <div style="margin-bottom: 20px;">
            <h3>Résumé du devis : ${habWizard.quote.name}</h3>
            <h4>Devis établi au nom de : John Doe</h4>

            <div>
                <span style="font-size: 18px;">Adresse du logement :</span>
                <span>${habWizard.quote.habitation.address.number}</span>
                <span>${habWizard.quote.habitation.address.street}</span>
                <span>${habWizard.quote.habitation.address.postcode}</span>
                <span>${habWizard.quote.habitation.address.city}</span>
                <span>Etage ${habWizard.quote.habitation.floor}</span>
            </div>

            <div>
                <span style="font-size: 18px;">Caractéristiques du logement :</span>
                <span style="text-transform: capitalize">${habWizard.quote.habitation.type}</span>
                <span>type T${habWizard.quote.habitation.roomNumber}</span>
                <span>de ${habWizard.quote.habitation.surface}m²</span>

                <c:if test="${habWizard.quote.habitation.garage == true}">
                <span>Avec garage</span>
                </c:if>
                <c:if test="${habWizard.quote.habitation.garage == false}">
                <span>Pas de garage</span>
                </c:if>

                <c:if test="${habWizard.quote.habitation.bathroomNumber == 1}">
                    <span>1 salle de bain</span>
                </c:if>
                <c:if test="${habWizard.quote.habitation.bathroomNumber > 1}">
                    <span>${habWizard.quote.habitation.bathroomNumber} salles de bain</span>
                </c:if>

                <span>Chauffage ${habWizard.quote.habitation.heatingType}</span>
                <c:if test="${habWizard.quote.habitation.groundSurface == 0}">
                    <span>Pas de terrain</span>
                </c:if>
                <c:if test="${habWizard.quote.habitation.groundSurface > 0}">
                    <span>Terrain de ${habWizard.quote.habitation.groundSurface}m²</span>
                </c:if>

                <c:if test="${habWizard.quote.habitation.patioSurface == 0}">
                    <span>Pas de terrasse</span>
                </c:if>
                <c:if test="${habWizard.quote.habitation.patioSurface > 0}">
                    <span>Terrasse de ${habWizard.quote.habitation.patioSurface}m²</span>
                </c:if>
            </div>
        </div>

        <div>
            <form:form action="/habWizard.form?_finish" method="POST" modelAttribute="habWizard">

                <div class="form-group">
                    <form:label path="" for="quote.summary">Choix de la formule</form:label><br>
                    <form:radiobutton path="quote.summary" value="basic" label="Formule Basique"></form:radiobutton>
                    <form:radiobutton path="quote.summary" value="full" label="Formule Complète"></form:radiobutton>
                </div>

                Montant : ${habWizard.quote.price}

                <form:button type="submit" class="btn btn-default">Valider le devis</form:button>
            </form:form>
        </div>

    </div>
</div>

<%@include file="../../footer.jsp" %>