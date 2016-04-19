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
    <title>Devis véhicule - Etape 3</title>
    <link rel="stylesheet" href="../css/style.css" type="text/css" />
    <link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="form-style-10">
    <h1>Devis véhicule</h1>
    <h2>Etape 1 > Etape 2 > Etape 3</h2>
    <form method="post" action="servlet/result">
        <table>
            <tr>
                <td>Conducteur secondaire</td>
                <td>
                    <input type="text" name="carInsuranceSecondaryDriver" value="" />
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Garage</td>
                <td>
                    <input type="radio" name="vehicleInGarage" value="1"/>Oui
                    <input type="radio" name="vehicleInGarage" value="0"/>Non
                    <br/>
                </td>
            </tr>
            <tr>
                <td colspan=2>
                    <input type="button" value="Annuler" onclick="location.href='/src/main/webapp'" />
                    <input type="button" value="Précédent" onclick="location.href='/vehicle2'" />
                    <input type="button" value="Suivant" onclick="location.href='/vehicle4'" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>