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
    <title>Devis d'habitation - Etape 4</title>
    <link rel="stylesheet" href="../css/style.css" type="text/css" />
    <link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="form-style-10">
    <h1>Devis d'habitation</h1>
    <h2>Etape 1 > Etape 2 > Etape 3 > Etape 4</h2>
    <form method="post" action="">
        <table BORDER=0>
            <tr>
                <td>Résumé</td>
                <td>
                    <input type="text" name="summary" value="" />
                </td>
            </tr>
            <tr>
                <td>Formule1</td>
                <td>
                    <input type="radio" name="formule1" value="formule1"/>
                </td>
            </tr>
            <tr>
                <td>Formule2</td>
                <td>
                    <input type="radio" name="formule2" value="formule2"/>
                </td>
            </tr>
            <tr>
                <td>Prix</td>
                <td>
                    <input type="text" name="price" value="" />
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
