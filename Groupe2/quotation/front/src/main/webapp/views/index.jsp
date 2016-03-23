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
                </tr>
            </c:forEach>
        </table>
<%@ include file="Default/footer.jsp" %>
