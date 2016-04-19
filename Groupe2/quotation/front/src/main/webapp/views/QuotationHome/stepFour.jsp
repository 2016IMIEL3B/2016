<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../Default/header.jsp" %>

<form:form method="POST" action="/devis/${id}/habitation/send/4" modelAttribute="home">

    <p>Resumé du devis</p>
    <form:label path="quotation.name">Nom du devis :</form:label>
    <form:input path="quotation.name" type="text" value="" class="form-control" disabled="true"/>
    <form:label path="homeType">Type habitation :</form:label>
    <form:input path="homeType" type="text" value="" class="form-control" disabled="true"/>
    <form:label path="surface">Surface :</form:label>
    <form:input path="surface" type="text" value="" class="form-control" disabled="true"/>
    <form:label path="nbRoom">Nomre de pieces : </form:label>
    <form:input path="nbRoom" type="text" value="" class="form-control" disabled="true"/>
    <form:label path="floor">Etage :</form:label>
    <form:input path="floor" type="text" value="" class="form-control" disabled="true"/>
    <form:label path="nbBathroom">Nombre de salle de bain :</form:label>
    <form:input path="nbBathroom" type="text" value="" class="form-control" disabled="true"/>
    <form:label path="garage">Garage ? :</form:label>
    <form:input path="garage" type="text" value="" class="form-control" disabled="true"/>
    <form:label path="surfaceGround">Surface du terrain :</form:label>
    <form:input path="surfaceGround" type="text" value="" class="form-control" disabled="true"/>
    <form:label path="surfaceTerrace">Surface de la Terrasse :</form:label>
    <form:input path="surfaceTerrace" type="text" value="" class="form-control" disabled="true"/>
    <form:label path="heaterType">Type de chauffage :</form:label>
    <form:input path="heaterType" type="text" value="" class="form-control" disabled="true"/>


    <p>Formule :</p>
    <c:forEach items="${formul}" var="formul">
        <form:label path="formul">${formul.entitled}</form:label>
        <form:checkbox path="formul" value="${formul.entitled}" class="form-control" />
    </c:forEach>


    <form:label path="quotation.price">Montant du devis :</form:label>
    <form:input path="quotation.price" type="text" value="" class="form-control" disabled="true"/>

    <%@ include file="../QuotationStep/quotationStepState.jsp" %>

</form:form>

<%@ include file="../Default/footer.jsp" %>