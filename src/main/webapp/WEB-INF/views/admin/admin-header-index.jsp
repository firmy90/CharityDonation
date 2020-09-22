<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>

<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li class="logged-user">
            <sec:authorize access="isAuthenticated()">
                Witaj ${pageContext.request.userPrincipal.principal.username}
                <ul class="dropdown">
                    <li><a href="/admin" class = "btn btn--without-border">Profil</a></li>
                    <li><form method="post" action="/logout"><button class=" btn btn--without-border">Wyloguj</button><sec:csrfInput/></form></li>
                </ul>
            </sec:authorize>

        </ul>

        <ul>
            <li><a href="<c:url value="/admin"/>" class="btn btn--without-border active">Start</a></li>
            <li><a href="<c:url value="/admin/institutions"/>" class="btn btn--without-border">Fundacje</a></li>
            <li><a href="<c:url value="/admin/admins"/>" class="btn btn--without-border">Administratorzy</a></li>
            <li><a href="<c:url value="/admin/users"/>" class="btn btn--without-border">Użytkownicy</a></li>
        </ul>
    </nav>
    <div class="slogan container container--70">
        <div class="slogan--item">
            <h1>
                Witaj administratorze!<br/>
            </h1>
        </div>
    </div>

</header>