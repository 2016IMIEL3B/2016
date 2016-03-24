<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<body>

<nav>
	<h1>Projet Vertx</h1>
	<a href="/car/1" style="display: inline">Devis Voiture</a> |
	<a href="/habWizard.form">Devis Habitation</a> |
	<a href="/profile">Profil</a> |
	<a href="/synthesis">Mes Devis</a>
</nav>
<hr/>

	<h1>Demo Spring sécurity</h1>
	<br />
	Message: ${message}
    <br />
	<a href="/logout">Déconnexion</a><br />
	<a href="/private/client">Vers une page pour utilisateur authentifié sans rôle particulier</a><br />
	<a href="/private/admin">Vers une page pour utilisateur authentifié ayant le rôle ROLE_ADMIN</a>
</body>

</html>
