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

<section id="help" class="help">
    <h2>Lista fundacji</h2>
    <div class="help--slides active" data-id="1">

        <ul class="help--slides-items">
            <c:forEach varStatus="index" items="${institutions}" var="inst">
                <li>
                    <div class="col">
                        <div class="title"><c:out value="${inst.institutionName}"/></div>
                        <div class="subtitle"><c:out value="${inst.institutionDescription}"/></div>
                    </div>

                    <div class="col">
                        <div class="title"><a href="<c:url value="/admin/institutions/edit/${inst.institutionId}"/>">Edytuj</a>
                        </div>
                        <div><a href="<c:url value="/admin/institutions/delete/${inst.institutionId}"/>">Usuń</a></div>
                    </div>
                </li>
            </c:forEach>
            <br/>
            <li>
                <div class="col">
                    <div class="title"><a href="<c:url value="/admin/institutions/add"/>">Utwórz nową fundację</a></div>
                </div>
                <div class="col">
<%--                    <div class="title"></div>--%>

                </div>

            </li>
        </ul>
    </div>

</section>


</body>
</html>
