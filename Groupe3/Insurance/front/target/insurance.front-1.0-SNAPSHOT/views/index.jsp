<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
	    <title>Hello world</title>
	</head>
	<body>
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
	</body>
</html>