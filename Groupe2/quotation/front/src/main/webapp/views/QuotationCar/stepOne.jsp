<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../Default/header.jsp" %>

<form:form method="POST" action="devis/voiture/send/1" modelAttribute="car">

<label for="nomPrenomUser">Nom / prenom de l’utilisateur</label>
<input id="nomPrenomUser" type="text" value="" class="form-control" disabled></input>

<form:label path="quotation.name">Nom du devis</form:label>
<form:input path="quotation.name" type="text" value="" class="form-control"></form:input>

<form:label path="mark">Marque</form:label>
<form:select path="mark" class="form-control">
    <c:forEach items="${marks}" var="mark">
        <option value="${mark.entitled}">${mark.entitled}</option>
    </c:forEach>
</form:select>

<form:label path="model">Modèle</form:label>
<form:select path="model" class="form-control">
    <c:forEach items="${models}" var="model">
        <option value="${model.entitled}">${model.entitled}</option>
    </c:forEach>
</form:select>

<form:label path="fuel" >Carburant</form:label>
<form:select path="fuel" class="form-control">
    <c:forEach items="${fuels}" var="fuel">
        <option value="${fuel.entitled}">${fuel.entitled}</option>
    </c:forEach>
</form:select>

<form:label path="taxableHorsePower">Cheveaux fiscaux</form:label>
<form:select path="taxableHorsePower" class="form-control">
        <option value=""></option>
</form:select>

<%@ include file="../QuotationStep/quotationStepState.jsp" %>

</form:form>

<%@ include file="../Default/footer.jsp" %>