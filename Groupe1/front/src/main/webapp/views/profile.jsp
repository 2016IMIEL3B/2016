<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>




<div class="container">
    <div class="jumbotron">
        <h1>Page profil</h1>


<h2>${user.firstName} ${user.lastName}</h2>
<table>
    <tr>
        <th>Adresse :</th>

        <td>${user.address.number} ${user.address.street} ${user.address.postcode} ${user.address.city}</td>

    </tr>
    <tr>
        <th>Login :</th>
        <td>${user.login}</td>
    </tr>


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
                <td>${user.login}</td>
            </tr>

        </table>
    </table>
    </div>
</div>

<%@include file="footer.jsp" %>