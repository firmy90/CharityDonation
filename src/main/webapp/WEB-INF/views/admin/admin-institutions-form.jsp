<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Charity</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/admin/admin-header.jsp"/>

<section class="help">
    <h2>Lista fundacji</h2>
    <form:form method="post" modelAttribute="institution">
        <form:input path="institutionName" type="text" id="institutionName" placeholder="Nazwa instytucji" required="true" />
        <form:input path="institutionDescription" type="text" id="institutionDescription" placeholder="Opis instytucji" required="true" />
        <button type="submit">Utwórz</button>
    </form:form>


</section>


</body>
</html>
