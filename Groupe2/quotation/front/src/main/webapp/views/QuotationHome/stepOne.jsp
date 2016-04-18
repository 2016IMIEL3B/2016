<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../Default/header.jsp" %>

<form:form method="POST" action="/devis/habitation/send/1" modelAttribute="home">

    <label for="nomPrenomUser">Nom / prenom de l’utilisateur</label>
    <input id="nomPrenomUser" type="text" value="" class="form-control" disabled>

    <form:label path="quotation.name">Nom du devis</form:label>
    <form:input path="quotation.name" type="text" value="" class="form-control"></form:input>

    <form:label path="homeType">Type d’habitation</form:label>
    <form:select path="homeType" class="form-control">
        <c:forEach items="${homeType}" var="homeType">
            <option value="${homeType.entitled}">${homeType.entitled}</option>
        </c:forEach>
    </form:select>

    <form:label path="surface">Surface</form:label>
    <form:input path="surface" type="text" value="" class="form-control" />

    <%@ include file="../QuotationStep/quotationStepState.jsp" %>

</form:form>

<%@ include file="../Default/footer.jsp" %>