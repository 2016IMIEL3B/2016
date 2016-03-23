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
    <title>Devis d'habitation - Etape 3</title>
    <link rel="stylesheet" href="../css/style.css" type="text/css" />
    <link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="form-style-10">
    <h1>Devis d'habitation</h1>
    <h2>Etape 1 > Etape 2 > Etape 3</h2>
    <form method="post" action="">
        <table BORDER=0>
            <tr>
                <td>Surface du terrain</td>
                <td>
                    <input type="text" name="value" value="" />
                </td>
            </tr>
            <tr>
                <td>Surface de la terrasse</td>
                <td>
                    <input type="text" name="value" value="" />
                </td>
            </tr>
            <tr>
                <td>Type de chauffage</td>
                <td>
                    <select name="typeHeating" id="typeHeating"/>
                    <option value="Electrique">Electrique</option>
                    <option value="Gaz">Gaz</option>
                    <option value="Fuel">Fuel</option>
                    <option value="Geothermique">Geothermique</option>
                    <option value="Solaire">Solaire</option>
                    <option value="Autre">Autre</option>
                    </select>
                </td>
            </tr>
            <tr>

                <td align="right">
                    <input type="button" value="Précédent"/>
                    <input type="submit" value="Suivant"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
