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
  <jsp:include page="/WEB-INF/views/fragments/header-user.jsp"/>

    <section class="login-page">
      <form:form method="post" modelAttribute="registrationData">
        <form:hidden path="username"/>
        <h2>Edycja administratora <c:out value="${registrationData.username}"/></h2>
        <div class="form-group">
          <form:input type="text" path="name" id="name" placeholder="Imię" required="true" />
          <h3 style="color: red"> <form:errors path="name" /></h3>
        </div>
        <div class="form-group">
          <form:input type="text" path="surname" id="surname" placeholder="Nazwisko" required="true" />
          <h3 style="color: red"> <form:errors path="surname" /></h3>
        </div>
        <div class="form-group">
          <form:input type="password" path="password" id="password" placeholder="Hasło" required="true" />
          <h3 style="color: red"> <form:errors path="password" /></h3>
        </div>
        <div class="form-group">
          <form:input type="password" path="password2" id="password2"  placeholder="Powtórz hasło" required="true" />
          <h3 style="color: red"> <form:errors path="password2" /></h3>
        </div>
        <div class="form-group form-group--buttons">
          <form:button class="btn" type="submit">Uaktualnij</form:button>
        </div>
        <sec:csrfInput/>
      </form:form>
    </section>

  <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
  </body>
</html>
