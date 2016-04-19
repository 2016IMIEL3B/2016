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
    <title>Devis véhicule - Etape 4</title>
    <link rel="stylesheet" href="../css/style.css" type="text/css" />
    <link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="form-style-10">
    <h1>Devis véhicule</h1>
    <h2>Etape 1 > Etape 2 > Etape 3 > Etape 4</h2>
    <form method="post" action="servlet/result">
        <table>
            <tr>
                <td>Résumé du devis</td>
                <td>
                    <input type="textarea" name="insuranceSummary" value="" />
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Tous risques ?</td>
                <td>
                    <input type="radio" name="insuranceAllRisks" value="1"/>Oui
                    <input type="radio" name="insuranceAllRisks" value="0"/>Non
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Au tiers</td>
                <td>
                    <input type="radio" name="insuranceThird" value="1"/>Oui
                    <input type="radio" name="insuranceThird" value="0"/>Non
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Montant du devis</td>
                <td>
                    <input type=text name="insurancePrice"/>
                    <br/><br/>
                </td>
            </tr>
            <tr>
                <td colspan=2>
                    <input type="button" value="Annuler" onclick="location.href='/'" />
                    <input type="button" value="Précédent" onclick="location.href='/vehicle3'" />
                    <input type="button" value="Terminer" onclick="location.href='/vehicle5'" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
