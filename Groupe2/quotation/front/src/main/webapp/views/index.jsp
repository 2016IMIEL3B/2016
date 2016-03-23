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
                    <td><a class="button" href="/devis/">Reprendre</a></td>
                    <td><a class="button" href="/devis/supprimer/${quotation.id}">Supprimer</a></td>
                </tr>
            </c:forEach>
        </table>
    <div class="createQuotation">
        <a class="btn btn-primary" href="/quotation/car" role="button">Creer un devis Voiture</a>
        <a class="btn btn-primary" href="/quotation/home" role="button">Creer un devis Habitation</a>
    </div>
<%@ include file="Default/footer.jsp" %>
