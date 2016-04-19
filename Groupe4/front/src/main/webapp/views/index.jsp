<%@include file="layout_header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row content">
	<div class="col-sm-8 text-left">
	  <h1>Welcome</h1>
	  <p>Voici l'application de gestion de devis voiture et habitation.</p>
	  <hr>
	</div>
	
	<div class="col-sm-2 sidenav margin_top_20" >
	  <a href="/wizard/car/1">
	    <div class="well">
	      <p>Création d'un devis voiture</p>
	    </div>
	  </a>

	  <a href="/wizard/home/1">
	    <div class="well">
	      <p>Création d'un devis habitation</p>
	    </div>
	  </a>

	</div>
</div>

<%@include file="layout_footer.jsp" %>

