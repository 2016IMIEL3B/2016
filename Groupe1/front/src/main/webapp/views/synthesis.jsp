<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<div class="container">
    <div class="jumbotron">
        <h1>Devis en cours</h1>

        <h2>Véhicule</h2>
        <table class="table">
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
                            <td><a class="btn btn-default" href=<c:url value="/carWizard.form/quote/${quote.id}"/>>Reprendre</a></td>
                        </c:if>
                    </c:forEach>
                </c:if>
            </tr>
        </table>
        <h2>Habitation</h2>
        <table class="table">
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
                            <td>
                                <a class="btn btn-default" href=<c:url value="/habWizard.form/quote/${quote.id}"/>>Reprendre</a>
                            </td>
                        </c:if>
                    </c:forEach>
                </c:if>
            </tr>
        </table>
    </div>
</div>

<%@include file="footer.jsp" %>