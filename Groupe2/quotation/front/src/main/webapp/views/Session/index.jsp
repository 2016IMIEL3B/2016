<%@ include file="../Default/header.jsp" %>

<ul>
    <li>${userSession.getToken()}</li>
    <li>${userSession.getUserLike().getLastName()}</li>
</ul>

<%@ include file="../Default/footer.jsp" %>