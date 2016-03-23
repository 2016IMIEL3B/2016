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
    <title>Devis véhicule - Etape 1</title>
    <link rel="stylesheet" href="../css/style.css" type="text/css" />
    <link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="form-style-10">
    <h1>Devis véhicule</h1>
    <h2>Etape 1</h2>
    <form method="post" action="servlet/result">
        <table>
            <tr>
                <td>Nom de l'utilisateur</td>
                <td>
                    <input type="text" name="userLastName" value="" />
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Prénom de l'utilisateur</td>
                <td>
                    <input type="text" name="userFirstName" />
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Nom du devis</td>
                <td>
                    <input type=text name="insuranceName"/>
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Marque</td>
                <td>
                    <input type=text name="insuranceName"/>
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Marque</td>
                <td>
                    <select name="vehicleBrand">
                        <option value="volvo">Volvo</option>
                        <option value="saab">Saab</option>
                        <option value="mercedes">Mercedes</option>
                        <option value="audi">Audi</option>
                    </select>
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Modèle</td>
                <td>
                    <input type=text name="vehicleModel"/>
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Carburant</td>
                <td>
                    <select name="vehicleFuel">
                        <option value="gazoil">Gazoil</option>
                        <option value="essence">Essence</option>
                        <option value="sans-plomb 98">Sans-plomb 98</option>
                    </select>
                    <br/>
                </td>
            </tr>
            <tr>
                <td>Chevaux fiscaux</td>
                <td>
                    <input type=text name="vehicleHorspowerTax"/>
                    <br/>
                </td>
            </tr>
            <tr>
                <td colspan=2>
                    <input type="submit" value="Suivant"/>
                    <input type="reset" value="Retablir">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
