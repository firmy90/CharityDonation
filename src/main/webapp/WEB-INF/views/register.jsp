<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pl">
<jsp:include page="/WEB-INF/views/fragments/head.jsp"/>
<body>
<sec:authorize access="hasRole('ADMIN')">
    <jsp:include page="/WEB-INF/views/fragments/header-user.jsp"/>
</sec:authorize>
<sec:authorize access="hasRole('USER')">
    <jsp:include page="/WEB-INF/views/fragments/admin-header.jsp"/>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
    <jsp:include page="/WEB-INF/views/fragments/header-register.jsp"/>
</sec:authorize>

<section class="login-page">
    <h2>Rejestracja </h2>
    <form:form method="post" modelAttribute="registrationData">
        <div class="form-group">
            <form:input type="text" path="name" id="name" placeholder="Imię" required="true"/>
            <h3 style="color: red"><form:errors path="name" class="title"/></h3>
        </div>
        <div class="form-group">
            <form:input type="text" path="surname" id="surname" placeholder="Nazwisko" required="true"/>
            <h3 style="color: red"><form:errors path="surname" class="title"/></h3>
        </div>
        <div class="form-group">
            <form:input type="email" path="username" id="username" placeholder="Email" required="true"/>
            <h3 style="color: red"><form:errors path="username"/></h3>
        </div>
        <div class="form-group">
            <form:input type="password" path="password" id="password" placeholder="Hasło" required="true"/>
            <h3 style="color: red"><form:errors path="password"/></h3>
        </div>
        <div class="form-group">
            <form:input type="password" path="password2" id="password2" placeholder="Powtórz hasło" required="true"/>
            <h3 style="color: red"><form:errors path="password2"/></h3>
        </div>
        <div class="form-group form-group--buttons">
            <form:button class="btn" type="submit">Zapisz</form:button>
        </div>
        <sec:csrfInput/>
    </form:form>
</section>

<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>
