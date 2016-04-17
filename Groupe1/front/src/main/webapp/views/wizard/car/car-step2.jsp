<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../header.jsp" %>

<div class="container">
    <div class="jumbotron">
        <h1>Devis: Assurer une voiture</h1>
        <h2>Etape 2</h2>

        <form:form action="/carWizard.form?_page=3" method="POST" modelAttribute="carWizard">

            <div class="form-group">
                <form:label path="" for="">Date du permis</form:label>
                <form:input type="date" path="" class="form-control" cssStyle="width:250px;" required="required"></form:input>

            </div>

            <div class="form-group">
                <form:label path="" for="">Nombre d'accidents</form:label>
                <form:input type="text" path=""  class="form-control" cssStyle="width:250px;" required="required" ></form:input>
            </div>

            <div class="form-group">
                <form:label path="" for="">Bonus Malus</form:label>
                <form:input type="text" path="" class="form-control" cssStyle="width:250px;" ></form:input>
            </div>

            <form:button type="submit">Aller à l'étape suivante</form:button>
        </form:form>

    </div>
</div>

<%@include file="../../footer.jsp" %>