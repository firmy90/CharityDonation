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
<jsp:include page="/WEB-INF/views/fragments/header-form.jsp"/>


<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div>

        <div class="form--steps-container">
            <div class="form--steps-counter">Krok <span>1</span>/4</div>

            <form:form action="/form" method="post" modelAttribute="donation">
                <!-- STEP 1: class .active is switching steps -->
                <div data-step="1" class="active">
                    <h3>Zaznacz co chcesz oddać:</h3>

                    <c:forEach var="cat" items="${categories}">
                        <div class="form-group form-group--checkbox">
                            <label>
                                <input type="checkbox" name="categories" value="${cat.id}"/>
                                <span class="checkbox"></span>
                                <span class="description"><c:out value="${cat.name}"/></span>
                            </label>
                        </div>
                    </c:forEach>

                    <div class="form-group form-group--buttons">
                        <button class="btn next-step">Dalej</button>
                    </div>
                </div>

                <!-- STEP 2 -->
                <div data-step="2">
                    <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                    <div class="form-group form-group--inline">
                        <label>
                            Liczba 60l worków:
                            <form:input path="quantity" type="number" step="1" min="1"/>
                        </label>
                    </div>

                    <div class="form-group form-group--buttons">
                        <button class="btn prev-step">Wstecz</button>
                        <button class="btn next-step">Dalej</button>
                    </div>
                </div>


                <!-- STEP 4 -->
                <div data-step="3">
                    <h3>Wybierz organizację, której chcesz pomóc:</h3>

                    <c:forEach items="${institutions}" var="inst">
                        <div class="form-group form-group--checkbox">
                            <label>
                                <input type="radio" name="institution" value="${inst.institutionId}"/>
                                <span class="checkbox radio"></span>
                                <span class="description">
                                <div class="title" id="institution-name"><c:out value="${inst.institutionName}"/></div>
                                <div class="subtitle"><c:out value="${inst.institutionDescription}"/></div>
                            </span>
                            </label>
                        </div>
                    </c:forEach>

                    <div class="form-group form-group--buttons">
                        <button class="btn prev-step">Wstecz</button>
                        <button class="btn next-step">Dalej</button>
                    </div>
                </div>

                <!-- STEP 5 -->
                <div data-step="4">
                    <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru</h4>
                            <div class="form-group form-group--inline">
                                <label> Ulica <form:input path="street" type="text" id="street"/> </label>
                            </div>

                            <div class="form-group form-group--inline">
                                <label> Miasto <form:input path="city" type="text" id="city"/> </label>
                            </div>

                            <div class="form-group form-group--inline">
                                <label>
                                    Kod pocztowy <form:input path="zipCode" type="text" id="zipCode" maxlength="6"/></label>
                            </div>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru</h4>
                            <div class="form-group form-group--inline">
                                <label> Data <form:input path="pickUpDate" id="pickUpDate" type="date"/> </label>
                            </div>

                            <div class="form-group form-group--inline">
                                <label> Godzina <form:input path="pickUpTime" id="pickUpTime" type="time"/> </label>
                            </div>

                            <div class="form-group form-group--inline">
                                <label>
                                    Uwagi dla kuriera
                                    <form:textarea path="pickUpComment" id="pickUpComment" rows="2"/>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group form-group--buttons">
                        <button type="button" class="btn prev-step">Wstecz</button>
                        <button type="button" class="btn next-step">Dalej</button>
                    </div>
                </div>

                <!-- STEP 6 -->
                <div data-step="5">
                    <h3>Podsumowanie Twojej darowizny</h3>

                    <div class="summary">
                        <div class="form-section">
                            <h4>Oddajesz:</h4>
                            <ul>
                                <li>
                                    <span class="icon icon-bag"></span>
                                    <label> Liczba worków: <span class="summary--text" id="summary-quantity">cztery</span></label>
                                </li>
                                <li>
                                    <span class="icon icon-bag"></span>
                                    <label> Kategorie: </label>
                                    <span class="summary--text" id="summary-categories">kategoria 1</span>
                                    <span class="summary--text" id="summary-categories1">kategoria 2</span>
                                </li>

                                <li>
                                    <span class="icon icon-hand"></span>
                                    <label>Odbiorca: <span class="summary--text" id="summary-insitutions">Fundacja</span></label>
                                </li>
                            </ul>
                        </div>

                        <div class="form-section form-section--columns">
                            <div class="form-section--column">
                                <h4>Adres odbioru:</h4>
                                <ul>
                                    <li>Prosta 51</li>
                                    <li>Warszawa</li>
                                    <li>99-098</li>
                                    <li>123 456 789</li>
                                </ul>
                            </div>

                            <div class="form-section--column">
                                <h4>Termin odbioru:</h4>
                                <ul>
                                    <li>13/12/2018</li>
                                    <li>15:40</li>
                                    <li>Brak uwag</li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="form-group form-group--buttons">
                        <button type="button" class="btn prev-step">Wstecz</button>
                        <form:button type="submit" class="btn">Potwierdzam</form:button>
                    </div>
                </div>
            </form:form>
        </div>
</section>

<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>


</body>
</html>
