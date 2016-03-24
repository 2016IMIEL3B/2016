<%@include file="header.jsp" %>

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

<%@include file="footer.jsp" %>