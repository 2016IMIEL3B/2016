<%@ include file="../Default/header.jsp" %>

<ul>
    <li>${userSession.getToken()}</li>
    <li>${userSession.getUser().getLastName()}</li>
</ul>

<%@ include file="../Default/footer.jsp" %>