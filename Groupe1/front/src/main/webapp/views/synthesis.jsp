<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>

<nav>
    <h1>Projet Vertx</h1>
    <a href="/car/1" style="display: inline">Devis Voiture</a> |
    <a href="/habitation/1">Devis Habitation</a> |
    <a href="/profile">Profil</a> |
    <a href="/synthesis">Mes Devis</a>
</nav>

<h1>Devis en cours</h1>



<h2>Véhicule</h2>
<table>
    <tr>
        <th>Nom devis</th>
        <th>Modèle</th>
        <th>Marque</th>
        <th>Prix</th>
        <th>Résumé</th>
        <th></th>
    </tr>
    <tr>
        <c:if test="${not empty quotes}">
            <c:forEach var="quote" items="${quotes}">
                <c:if test="${quote.vehicle != null && quote.habitation == null}">
                    <td>${quote.name}</td>
                    <td>${quote.vehicle.model.name}</td>
                    <td>${quote.vehicle.model.brand.name}</td>
                    <td>${quote.price} €</td>
                    <td>${quote.summary}</td>
                    <td><a href=<c:url value="/car/${quote.step}"/>>Reprendre</a></td>
                </c:if>
            </c:forEach>
        </c:if>
    </tr>
</table>
<h2>Habitation</h2>
<table>
    <tr>
        <th>Nom devis</th>
        <th>Type</th>
        <th>Surface</th>
        <th>Prix</th>
        <th>Résumé</th>
        <th></th>
    </tr>
    <tr>
        <c:if test="${not empty quotes}">
            <c:forEach var="quote" items="${quotes}">
                <c:if test="${quote.habitation != null && quote.vehicle == null}">
                    <td>${quote.name}</td>
                    <td>${quote.habitation.type}</td>
                    <td>${quote.habitation.surface}</td>
                    <td>${quote.price} €</td>
                    <td>${quote.summary}</td>
                    <td><a href=<c:url value="/habitation/${quote.step}"/>>Reprendre</a></td>
                </c:if>
            </c:forEach>
        </c:if>
    </tr>
</table>


</body>

</html>