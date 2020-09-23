<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>

<header>
<%--<header class="header--form-page">--%>
    <nav class="container container--70">
        <ul class="nav--actions">
            <li class="logged-user">
                <sec:authorize access="!isAuthenticated()">
            <li><a href="<c:url value="/login"/>" class="btn btn--small btn--without-border">Zaloguj</a></li>
            <li><a href="<c:url value="/register"/>" class="btn btn--small btn--highlighted">Załóż konto</a></li>
            <sec:csrfInput/>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                Witaj ${pageContext.request.userPrincipal.principal.username}
                <ul class="dropdown">
                    <sec:authorize access="hasRole('ADMIN')">
                        <li><a href="<c:url value="/admin"/>" class = "btn btn--without-border">Główna</a></li>
                        <li><a href="<c:url value="/admin/profil"/>" class = "btn btn--without-border">Profil</a></li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('USER')">
                        <li><a href="<c:url value="/home/profile"/>" class = "btn btn--without-border">Profil</a></li>
                        <li><a href="#" class="btn btn--without-border">Moje zbiórki</a></li>
                    </sec:authorize>
                    <li><form method="post" action="/logout"><button class=" btn btn--without-border">Wyloguj</button><sec:csrfInput/>
                    </form></li>
                </ul>
            </sec:authorize>

        </ul>

        <ul>
            <li><a href="<c:url value="/home"/>" class="btn btn--without-border active">Start</a></li>
            <li><a href="<c:url value="/home"/>#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="<c:url value="/home"/>#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <sec:authorize access="hasRole('USER')">
                <li><a href="<c:url value="/home/form"/>#form" class="btn btn--without-border">Przekaż dary</a></li>
            </sec:authorize>
            <li><a href="<c:url value="/home"/>#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

</header>