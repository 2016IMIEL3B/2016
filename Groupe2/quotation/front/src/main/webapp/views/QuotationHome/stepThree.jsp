<%@ include file="../Default/header.jsp" %>

<form>

    <label for="surterrains">Surface du terrains</label>
    <input id="surterrains" type="text" value="" class="form-control">

    <label for="surterrasse">Surface de la terrasse</label>
    <input id="surterrasse" type="text" value="" class="form-control">

    <label for="typechauff">Type de chauffage</label>
    <select id="typechauff" class="form-control">

        <option value=""></option>

    </select>

    <%@ include file="../QuotationStep/quotationStepState.jsp" %>

<%@ include file="../Default/footer.jsp" %>