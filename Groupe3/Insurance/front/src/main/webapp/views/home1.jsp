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
</head>
<body>
    <h1>Devis d'habitation</h1>
    <h2>Etape 1</h2>
    <form method="post" action="">
        <table BORDER=0>
            <tr>
                <td>Nom de l'utilisateur</td>
                <td>
                    <input type="text" name="value" value="" />
                </td>
            </tr>
            <tr>
                <td>Prénom de l'utilisateur</td>
                <td>
                    <input type="text" name="value" value="" />
                </td>
            </tr>
            <tr>
                <td>Nom du devis</td>
                <td>
                    <input type="text" name="value" value="" />
                </td>
            </tr>
            <tr>
                <td>Type d'habitation</td>
                <td>
                    <select name="typeHabitation" id="typeHabitation"/>
                        <option value="appartement">appartement</option>
                        <option value="maison">maison</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Surface</td>
                <td>
                    <input type="text" name="value" value="" />m&sup2;
                </td>
            </tr>
            <tr>
                <td align="right">
                    <input type="submit" value="Suivant"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
