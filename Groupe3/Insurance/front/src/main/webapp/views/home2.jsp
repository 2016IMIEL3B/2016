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
    <title>Devis d'habitation - Etape 2</title>
    <link rel="stylesheet" href="../css/style.css" type="text/css" />
    <link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="form-style-10">
    <h1>Devis d'habitation</h1>
    <h2>Etape 1 > Etape 2</h2>
    <form method="post" action="">
        <table BORDER=0>
            <tr>
                <td>Nombre de pièces</td>
                <td>
                    <select name="nombrePièces" id="nombrePièces"/>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10 et plus</option>
                    </select>
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Etage</td>
                <td>
                    <input type="text" name="value" value="" />
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Nombre de salles de bain</td>
                <td>
                    <input type="text" name="value" value="" />
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Avec garage ?</td>
                <td>
                    <input type="radio" name="withGarage" value="Oui">Oui</input>
                    <input type="radio" name="withGarage" value="Non">Non</input>
                    <br/><br/>
                </td>
            </tr>
            <tr>
                <td colspan=2>
                    <input type="button" value="Annuler" onclick="location.href='/src/main/webapp'" />
                    <input type="button" value="Précédent" onclick="location.href='/home1'" />
                    <input type="button" value="Suivant" onclick="location.href='/home3'" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
