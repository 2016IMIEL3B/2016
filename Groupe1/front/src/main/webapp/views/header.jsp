<%--
  Created by IntelliJ IDEA.
  User: Manon
  Date: 24/03/2016
  Time: 14:20
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../lib/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../style/style.css">

    <script type="text/javascript" src="../lib/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="../lib/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>

<script type="text/javascript">
    $(document).ready(function(){
        var url = "${requestScope['javax.servlet.forward.request_uri']}";

        switch(url) {
            case "/":
                $('#navHome').addClass("active");
                break;
            case "/carWizard.form":
                $('#navCarW').addClass("active");
                break;
            case "/habWizard.form":
                $('#navHabW').addClass("active");
                break;
            case "/profile":
                $('#navProfile').addClass("active");
                break;
            case "/synthesis":
                $('#navSynthesis').addClass("active");
                break;
            default:
                $('#navHome').addClass("active");
        }
    });
</script>

    <!-- Fixed navbar -->
    <nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">Project Vertx</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li id="navHome"><a href="/">Accueil</a></li>
                    <li id="navCarW"><a href="/carWizard.form">Devis véhicule</a></li>
                    <li id="navHabW"><a href="/habWizard.form">Devis habitation</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><i class="glyphicon glyphicon-user"></i></li>
                    <li id="navProfile"><a href="/profile">Profil</a></li>
                    <li id="navSynthesis"><a href="/synthesis">Mes devis</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </nav>
