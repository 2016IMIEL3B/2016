<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../Default/header.jsp" %>

<form:form method="POST" action="/devis/voiture/send/1" modelAttribute="car">

<label for="nomPrenomUser">Nom / prenom de l’utilisateur</label>
<input id="nomPrenomUser" type="text" value="${userSession.lastName} - ${userSession.firstName}" class="form-control" disabled/>

<form:label path="quotation.name">Nom du devis</form:label>
<form:input path="quotation.name" type="text" value="" class="form-control"></form:input>

<form:label path="mark">Marque</form:label>
<form:select path="mark" id="marks" class="form-control" onchange="changeModel()">
    <c:forEach items="${marks}" var="mark">
        <option id="${mark.id}" value="${mark.entitled}">${mark.entitled}</option>
    </c:forEach>
</form:select>

<form:label path="model">Modele</form:label>
<form:select path="model" id="models" class="form-control">
    <c:forEach items="${models}" var="model">
        <option id="${model.id}" value="${model.entitled}">${model.entitled}</option>
    </c:forEach>
</form:select>

<form:label path="fuel" >Carburant</form:label>
<form:select path="fuel" id="fuels" class="form-control">
    <c:forEach items="${fuels}" var="fuel">
        <option id="${fuel.id}" value="${fuel.entitled}">${fuel.entitled}</option>
    </c:forEach>
</form:select>

<form:label path="taxableHorsePower">Cheveaux fiscaux</form:label>
<form:select path="taxableHorsePower" class="form-control">
    <c:forEach items="${horsepowers}" var="horsepower">
        <option id="${horsepower.id}" value="${horsepower.value}">${horsepower.value}</option>
    </c:forEach>
</form:select>

<%@ include file="../QuotationStep/quotationStepState.jsp" %>

</form:form>

<script>
    function changeModel(){
        var valeur = $("#marks option:selected").attr("id");

        $.get( "/modelByMark/"+valeur, function( data ) {
            if(data != null){
                JSON.stringify(data);
                $('#models').html('');
                $.each(data, function(index, model){
                    $('#models').append('<option id="'+ model.id +'" value="'+ model.entitled +'">'+ model.entitled +'</option>');
                });
            }
        });

    }
</script>

<%@ include file="../Default/footer.jsp" %>

