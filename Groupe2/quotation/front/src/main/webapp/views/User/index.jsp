<%@ include file="../Default/header.jsp" %>
<h1>Page de Profil</h1>

<span>Formulaire de création d'un Utilisateur :</span>

<form:form  method="post" action="/profil/save" modelAttribute="user">

    <form:input cssStyle="display: none" path="id"/>
    <form:label path="lastName">Nom :</form:label>
    <form:input path="lastName" />
    <form:label path="firstName">Prénom :</form:label>
    <form:input path="firstName" />
    <form:label path="login">Login :</form:label>
    <form:input path="login" />
    <form:label path="password">Password :</form:label>
    <form:input path="password" />

    <input type="submit" value="Créer"/>
</form:form>

<%@ include file="../Default/footer.jsp" %>