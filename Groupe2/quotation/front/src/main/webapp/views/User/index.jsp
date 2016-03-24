<%@ include file="../Default/header.jsp" %>
<h1>Page de Profil</h1>

<form action="/api/profil/save" method="post">
    <div>
        <label>Nom :</label>
        <input type="text" name="lastName" />
    </div>
    <div>
        <label>Prénom :</label>
        <input type="text" name="firstName" />
    </div>
    <div>
        <label>Login :</label>
        <input type="text" name="login" />
    </div>
    <div>
        <label>Mot de Passe :</label>
        <input type="password" name="password" />
    </div>
    <input type="submit" />
</form>

<%@ include file="../Default/footer.jsp" %>