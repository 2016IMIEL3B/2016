<%@ include file="../Default/header.jsp" %>
<h1>Page de Profil</h1>

<span>Modification du profil</span>

<form:form  method="post" action="/profil/save" modelAttribute="user">

    <form:input cssStyle="display: none" path="id"/>
    <form:label path="lastName">Nom :</form:label>
    <form:input path="lastName" />
    <form:label path="firstName">Prenom :</form:label>
    <form:input path="firstName" />
    <form:label path="login">Login :</form:label>
    <form:input path="login" />
    <form:label path="password">Password :</form:label>
    <form:input path="password" />

    <input type="submit" value="Sauvegarder"/>
</form:form>

<a class="btn btn-primary" href="/" role="button">Page d'accueil</a>

<%@ include file="../Default/footer.jsp" %>