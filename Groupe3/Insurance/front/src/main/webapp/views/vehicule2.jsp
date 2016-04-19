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
    <title>Devis véhicule - Etape 2</title>
    <link rel="stylesheet" href="../css/style.css" type="text/css" />
    <link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="form-style-10">
    <h1>Devis véhicule</h1>
    <h2>Etape 1 > Etape 2</h2>
    <form method="post" action="servlet/result">
        <table>
            <tr>
                <td>Date du permis</td>
                <td>
                    <input type="date" name="userDrivingLicenseDate" value="" />
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Nombre d'accident</td>
                <td>
                    <input type="text" name="userAccidentNumber" />
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Bonus - Malus</td>
                <td>
                    <input type=text name="userBonusMalus"/>
                    <br/><br/>
                </td>
            </tr>
            <tr>
                <td colspan=2>
                    <input type="button" value="Annuler" onclick="location.href='/src/main/webapp'" />
                    <input type="button" value="Précédent" onclick="location.href='/vehicle1'" />
                    <input type="button" value="Suivant" onclick="location.href='/vehicle3'" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
