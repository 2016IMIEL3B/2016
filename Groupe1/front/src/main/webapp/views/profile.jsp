<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>


<div class="container">
    <div class="jumbotron">
        <h1>Page profil</h1>

        <h2>${user.firstname} ${user.lastname}</h2>

        <a class="btn btn-default" href="/synthesis">Mes devis</a>

        <h3>Address</h3>
        <address>
            ${user.address.number} ${user.address.street}<br>
            ${user.address.postcode}, ${user.address.city}<br>
        </address>

        <h3>Account</h3>
        <table>
            <tr>
                <th>Login :</th>
                <td>${user.account.login}</td>
            </tr>

        </table>

    </div>
</div>

<%@include file="footer.jsp" %>