<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
    <h1>Page Voiture Wizard</h1>

    <form  >

        <div>
            <label>Date du permis</label>
            <input type="date" name="dateLicense">
        </div>

        <div>
            <label>Nombre d'accidents</label>
            <input type="text" name="inputAccident">
        </div>

        <div>
            <label>Bonus Malus</label>
            <input type="text" name="bonusMalus">
        </div>


    </form>

</body>

</html>