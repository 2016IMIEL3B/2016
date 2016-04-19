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
    <title>Devis d'habitation - Etape 1</title>
    <link rel="stylesheet" href="../css/style.css" type="text/css" />
    <link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="form-style-10">
    <h1>Devis d'habitation</h1>
    <h2>Etape 1</h2>
    <form method="post" action="">
        <table BORDER=0>
            <tr>
                <td>Nom de l'utilisateur</td>
                <td>
                    <input type="text" name="value" value="" />
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Prénom de l'utilisateur</td>
                <td>
                    <input type="text" name="value" value="" />
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Nom du devis</td>
                <td>
                    <input type="text" name="value" value="" />
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Type d'habitation</td>
                <td>
                    <select name="typeHabitation" id="typeHabitation"/>
                        <option value="appartement">appartement</option>
                        <option value="maison">maison</option>
                    </select>
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Surface</td>
                <td>
                    <input type="text" name="value" value="" />m&sup2;
                    <br/><br/>
                </td>
            </tr>
            <tr>
                <td colspan=2>
                    <input type="button" value="Annuler" onclick="location.href='/src/main/webapp'" />
                    <input type="button" value="Suivant" onclick="location.href='/home2'" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
