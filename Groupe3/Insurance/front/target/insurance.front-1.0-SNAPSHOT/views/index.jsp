<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
	    <title>Hello world</title>
		<link rel="stylesheet" href="../css/style.css" type="text/css" />
		<link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
	</head>
	<body>
	<div class="form-style-10">
	    <h1><b>Message from controller : ${message}</b></h1>
	    <h3>Accueil</h3>
	    <div>
	    	<input type="button" onclick="document.location.href='/demo/demotp1';" value="Acceuil1"/>
			<input type="button" onclick="document.location.href='/demo/demotp2';" value="Acceuil2"/>
	    </div>
	    <h3>Form</h3>
	    <div>
			<input type="button" onclick="document.location.href='../form';" value="formtp1"/>
		</div>
	</div>
	</body>
</html>