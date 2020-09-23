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
      <h2>Twoje dane: </h2>
        <div class="form-group">
          <h2> <label> Imię: </label><c:out value="${registrationData.name}"/></h2>
        </div>
        <div class="form-group">
          <h2><label> Imię: </label><c:out value="${registrationData.surname}"/></h2>
        </div>
        <div class="form-group">
          <h2> <label> Email: </label><c:out value="${registrationData.username}"/></h2>
        </div>
      <div class="form-group">
        <p><a href="<c:url value="/admin/profile"/>">Edytuj swoje dane</a></p>
      </div>
    </section>

  <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
  </body>
</html>
