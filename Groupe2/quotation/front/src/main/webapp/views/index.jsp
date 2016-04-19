<%@ include file="Default/header.jsp" %>
        <h1>Liste des devis en cours</h1>

        <table class="table">
            <tr>
                <th>Nom du Devis</th>
                <th>Etape</th>
                <th>Status</th>
            </tr>
            <c:forEach items="${quotations}" var="quotation">
                <tr>
                    <td>${quotation.name}</td>
                    <td>${quotation.nbStep}</td>
                    <td>${quotation.state}</td>
                    <c:if test="${quotation.typeQuotation.entitled == 'Voiture'}">
                        <c:choose>
                            <c:when test="${quotation.state == 'Fini'}">
                                <td><a class="btn btn-primary" href="/devis/${quotation.id}/voiture">Voir</a></td>
                            </c:when>
                            <c:otherwise>
                            <td><a class="btn btn-primary" href="/devis/${quotation.id}/voiture">Reprendre</a></td>
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                    <c:if test="${quotation.typeQuotation.entitled == 'Habitation'}">
                        <c:choose>
                            <c:when test="${quotation.state == 'Fini'}">
                                <td><a class="btn btn-primary" href="/devis/${quotation.id}/habitation">Voir</a></td>
                            </c:when>
                            <c:otherwise>
                                <td><a class="btn btn-primary" href="/devis/${quotation.id}/habitation">Reprendre</a></td>
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                    <td><a class="btn btn-danger" href="/devis/supprimer/${quotation.id}">Supprimer</a></td>
                </tr>
            </c:forEach>
        </table>
    <div class="createQuotation">
        <a class="btn btn-primary" href="/devis/0/voiture" role="button">Creer un devis Voiture</a>
        <a class="btn btn-primary" href="/devis/0/habitation" role="button">Creer un devis Habitation</a>
        <a class="btn btn-primary" href="/profil" role="button">Page de Profil</a>
    </div>
<%@ include file="Default/footer.jsp" %>
