<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../Default/header.jsp" %>

<p>Devis Complet :</p>
<span>Nom du devis :</span>
<span><c:out value="${driver.car.quotation.name}"/></span> <br>
<span>Prix :</span>
<span><c:out value="${driver.car.quotation.price}"/></span> <br>

<span>Voiture :</span>
<span><c:out value="${driver.car.mark}"/></span> <br>
<span><Model></Model> Modele :</span>
<span><c:out value="${driver.car.model}"/></span> <br>
<span>Carburant : </span>
<span><c:out value="${driver.car.fuel}"/></span> <br>
<span>Chevaux Fiscaux :</span>
<span><c:out value="${driver.car.taxableHorsePower}"/></span> <br>
<span>Dors dans un Garage :</span>
<span><c:out value="${driver.car.sleepGarage}"/></span> <br>
<span>Adresse :</span>
<span><c:out value="${driver.car.address}"/></span> <br>
<span>Assurance Tier :</span>
<span><c:out value="${driver.car.tier}"/></span> <br>

<span>Conducteur :</span>
<span>Prenom :</span>
<span><c:out value="${driver.firstName}"/></span> <br>
<span>Nom :</span>
<span><c:out value="${driver.lastName}"/></span> <br>
<span>Bonus Malus : </span>
<span><c:out value="${driver.bonusPenality}"/></span> <br>
<span>Date du permis :</span>
<span><c:out value="${driver.licenceDate}"/></span> <br>
<span>Nombre de crash :</span>
<span><c:out value="${driver.nbCrash}"/></span> <br>


<%@ include file="../Default/footer.jsp" %>