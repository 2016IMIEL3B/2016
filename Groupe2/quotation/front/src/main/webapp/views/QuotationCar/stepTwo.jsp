<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ include file="../Default/header.jsp" %>

<form:form method="POST" action="/devis/${id}/voiture/send/2" modelAttribute="driver">

<form:label path="licenceDate">Date du permis</form:label>
<input type="text" path="licenceDate" class= "date form-control" name = "licenceDate"
       pattern="(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-](19|20)\d\d" />

<form:label path="nbCrash">Nombre d’accident</form:label>
<form:select path="nbCrash" class="form-control">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
</form:select>

<form:label path="bonusPenality" for="bonmal">Bonus malus</form:label>
<form:select path="bonusPenality" id="bonmal" class="form-control">
    <option value="1">0.7</option>
    <option value="2">0.8</option>
    <option value="3">0.9</option>
    <option value="4">1</option>
    <option value="5">1.1</option>
    <option value="6">1.2</option>
    <option value="7">1.3</option>
</form:select>

<%@ include file="../QuotationStep/quotationStepState.jsp" %>

</form:form>

<%@ include file="../Default/footer.jsp" %>