<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../Default/header.jsp" %>

<form:form method="POST" action="/devis/${id}/habitation/send/3" modelAttribute="home">

    <form:label path="surfaceGround">Surface du terrains</form:label>
    <form:input path="surfaceGround" type="text" value="" class="form-control" />

    <form:label path="surfaceTerrace">Surface de la terrasse</form:label>
    <form:input path="surfaceTerrace" type="text" value="" class="form-control" />

    <form:label path="heaterType">Type de chauffage</form:label>
    <form:select path="heaterType" class="form-control">
        <c:forEach items="${heaterType}" var="heaterType">
            <option value="${heaterType.entitled}">${heaterType.entitled}</option>
        </c:forEach>
    </form:select>

    <%@ include file="../QuotationStep/quotationStepState.jsp" %>

</form:form>

<%@ include file="../Default/footer.jsp" %>