<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>      
        <title>Formulaire d'inscription</title>
        <link rel="stylesheet" href="style.css" />
		<link rel="stylesheet" href="../css/style.css" type="text/css" />
		<link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <h1>Formulaire d'inscription</h1>
        <form method="post" action="servlet/result"> 
	        <span id="message"></span>
	        <table>
		        <tr> 
	                <td>Login</td>
	                <td>
		                <input type="text" name="login" value="" />
		                <br/>
	                </td>
		        </tr>
		        <tr>
	                <td>Password</td>
	                <td>
		                <input type="password" name="password" />
		                <br/>
	                </td>
		        </tr>
		        <tr>
	                <td>Confirmation du Mot de passe</td>
	                <td>
		                <input type=password name="password2"/>
		                <br/>
	                </td>
		        </tr>
		        <tr>
	                <td colspan=2>
	                    <input type="submit" value="Envoyer"/>
	               		<input type="reset" value="Retablir">
	                </td>
		        </tr>
	        </table>
        </form>
        <h1>Formulaire id demotp3</h1>
        
        
        
        <form method="get" action="/demo/demotp3"> 
	        <table>
		        <tr> 
	                <td>id : </td>
	                <td>
		                <input type="text" name="id" value="" />
	                </td>
		        </tr>
		        <tr>
	                <td colspan=2>
	                    <input type="submit" value="Envoyer"/>
	                </td>
		        </tr>
	        </table>
        </form>
		<h1>Formulaire Personne demotp4</h1>
        <form method="post" action="/controller/DemoController"> 
	        <table BORDER=0>
		        <tr> 
	                <td>last name : </td>
	                <td>
		                <input type="text" name="lastName"/>
	                </td>
		        </tr>
		        <tr> 
	                <td>first name : </td>
	                <td>
		                <input type="text" name="firstName" />
	                </td>
		        </tr>
		        <tr>
	                <td colspan=2>
	                    <input type="submit" value="Envoyer"/>
	                </td>
		        </tr>
	        </table>
        </form>
        <h1>Formulaire objet demotp5</h1>
        <form method="post" action="/demo/demotp5"> 
	        <table BORDER=0>
		        <tr> 
	                <td>value : </td>
	                <td>
		                <input type="text" name="value" value="" />
	                </td>
		        </tr>
		        <tr>
	                <td colspan=2>
	                    <input type="submit" value="Envoyer"/>
	                </td>
		        </tr>
	        </table>
        </form>
    </body>
</html>