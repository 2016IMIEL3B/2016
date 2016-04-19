<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../Default/header.jsp" %>

    <p>Devis Complet :</p>
    <span>Nom du devis :</span>
    <span><c:out value="${home.quotation.name}"/></span> <br>
    <span>Type habitation :</span>
    <span><c:out value="${home.homeType}"/></span> <br>
    <span>Surface :</span>
    <span><c:out value="${home.surface}"/></span> <br>
    <span>Nomre de pieces : </span>
    <span><c:out value="${home.nbRoom}"/></span> <br>
    <span>Etage :</span>
    <span><c:out value="${home.floor}"/></span> <br>
    <span>Nombre de salle de bain :</span>
    <span><c:out value="${home.nbBathroom}"/></span> <br>
    <span>Garage ? :</span>
    <span><c:out value="${home.garage}"/></span> <br>
    <span>Surface du terrain :</span>
    <span><c:out value="${home.surfaceGround}"/></span> <br>
    <span>Surface de la Terrasse :</span>
    <span><c:out value="${home.surfaceTerrace}"/></span> <br>
    <span>Type de chauffage :</span>
    <span><c:out value="${home.heaterType}"/></span> <br>
    <span>Forumle(s) :</span>
    <span><c:out value="${home.formul}"/></span> <br>
    <span>Prix :</span>
    <span><c:out value="${home.quotation.price}"/></span>
