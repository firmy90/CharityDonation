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
  <jsp:include page="/WEB-INF/views/fragments/header-register.jsp"/>

    <section class="login-page">
      <h2>Załóż konto</h2>
      <form:form method="post" action="/register" modelAttribute="registrationData">
        <div class="form-group">
          <form:input type="text" path="name" id="name" placeholder="Imię" required="true" />
        </div>
        <div class="form-group">
          <form:input type="text" path="surname" id="surname" placeholder="Nazwisko" required="true" />
        </div>
        <div class="form-group">
          <form:input type="email" path="username" id="username" placeholder="Email" required="true" />
        </div>
        <div class="form-group">
          <form:input type="password" path="password" id="password" placeholder="Hasło" required="true" />
        </div>
        <div class="form-group">
          <form:input type="password" path="password2" id="password2"  placeholder="Powtórz hasło" required="true" />
        </div>
        <div class="form-group form-group--buttons">
          <a href="/login" class="btn btn--without-border">Zaloguj się</a>
          <form:button class="btn" type="submit">Załóż konto</form:button>
        </div>
        <sec:csrfInput/>
      </form:form>
    </section>

  <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
  </body>
</html>
