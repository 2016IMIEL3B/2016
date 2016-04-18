<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
	    <title>Home</title>
		<link rel="stylesheet" href="../css/style.css" type="text/css" />
		<link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
	</head>
	<div class="form-style-10">
	    <h1><b>Devis d'assurance en ligne</b></h1>
		<h2>Connecté en tant que login</h2>
		<input type="button" onclick="document.location.href='/user';" value="Editer mon profil"/>
	    <h3>Demande de devis</h3>
	    <div colspan=2>
			<input type="button" onclick="document.location.href='/vehicle1';" value="Demande de devis véhicule"/>
			<br/><br/>
			<input type="button" onclick="document.location.href='/home1';" value="Demande de devis habitation"/>
		</div>
        <h3>Devis en cours</h3>

        <div colspan=2>
            <tr>
                <td>Nom </td>
                <td>Etape</td>
            </tr>
            <c:forEach var="insurance" items="${insurances}" varStatus="counter">
                    <tr>
                        <td><c:out value="${insurance.name}"/></td>
                        <td><c:out value="${insurance.step}"/></td>
                        <td>
                            <input type="button" onclick="document.location.href='/${insurance.step}';" value="Reprendre le devis"/>
                        </td>
                        <td>
                            <input type="button" onclick="document.location.href='/delete${insurance.step}';" value="Supprimer le devis"/>
                        </td>
                    </tr>

			</c:forEach>
		</div>
	</div>
	</body>
</html>