<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

    <body>
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

    </body>

</html>
