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

<h1>Page profil</h1>

<h2>${user.firstname} ${user.lastname}</h2>
<table>
    <tr>
        <th>Adresse :</th>
        <td>${user.address.number} ${user.address.street} ${user.address.postode} ${user.address.city}</td>

    </tr>
    <tr>
        <th>Login :</th>
        <td>${user.account.login}</td>
    </tr>

</table>
<a href="/synthesis">Voir mes devis</a>
</body>

</html>