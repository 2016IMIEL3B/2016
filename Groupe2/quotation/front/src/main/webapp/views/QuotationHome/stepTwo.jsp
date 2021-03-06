<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ include file="../Default/header.jsp" %>

<form:form method="POST" action="/devis/${id}/habitation/send/2" modelAttribute="home">

    <form:label path="nbRoom">Nombre de pieces</form:label>
    <form:select path="nbRoom" class="form-control">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
    </form:select>

    <form:label path="floor">Etage (si appartement)</form:label>
    <form:select path="floor" class="form-control">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
    </form:select>

    <form:label path="nbBathroom">Nombre de salle de bain</form:label>
    <form:select path="nbBathroom" class="form-control">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
    </form:select>

    <form:label path="garage">Garage ?</form:label>
    <form:checkbox path="garage" value="false" class="form-control" />

    <%@ include file="../QuotationStep/quotationStepState.jsp" %>

</form:form>

<%@ include file="../Default/footer.jsp" %>