<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>

<header class="header--form-page">
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
                        <li><a href="/admin" class = "btn btn--without-border">Profil</a></li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('USER')">
                        <li><a href="#" class = "btn btn--without-border">Profil</a></li>
                    </sec:authorize>
                    <li><a href="#" class="btn btn--without-border">Moje zbiórki</a></li>
                    <li><form method="post" action="/logout"><button class=" btn btn--without-border">Wyloguj</button><sec:csrfInput/></form></li>
                </ul>
            </sec:authorize>

        </ul>

        <ul>
            <li><a href="<c:url value="/"/>" class="btn btn--without-border active">Start</a></li>
            <li><a href="<c:url value="/"/>#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="<c:url value="/"/>#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="<c:url value="/"/>#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="<c:url value="/"/>#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <h2>
            Dziękujemy za przesłanie formularza Na maila prześlemy wszelkie
            informacje o odbiorze.
        </h2>
    </div>
</header>