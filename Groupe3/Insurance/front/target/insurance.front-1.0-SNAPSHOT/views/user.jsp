<%--
  Created by IntelliJ IDEA.
  User: bmille
  Date: 22/03/2016
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edition de profil</title>
    <link rel="stylesheet" href="../css/style.css" type="text/css" />
    <link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="form-style-10">
    <h1>Edition de profil</h1>
    <form method="post" action="">
        <table BORDER=0>
            <tr>
                <td>Nom de l'utilisateur</td>
                <td>
                    <input type="text" name="value" value="" />
                    ${user.lastName}
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Prénom de l'utilisateur</td>
                <td>
                    <input type="text" name="value" value="" />
                    ${user.firstName}
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Mot de passe</td>
                <td>
                    <input type="password" name="value" value="" />
                    <br/>
                    ${user.password}
                </td>
            </tr>
            <tr>
                <td>Confirmation</td>
                <td>
                    <input type="password" name="value" value="" />
                    <br/>
                </td>
            </tr>
            <tr>
                <td colspan=2>
                    <input type="button" value="Annuler" onclick="location.href='/'" />
                    <input type="submit" value="Enregistrer"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
