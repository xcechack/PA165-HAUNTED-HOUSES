<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <table>
        <tr>
            <th><form:label path="firstName"><fmt:message key="resident.firstName"/></form:label></th>
            <td><form:input path="firstName"/></td>
            <td><form:errors path="firstName" cssClass="error"/></td>
        </tr>
        <tr>
            <th><form:label path="lastName"><fmt:message key="resident.lastName"/></form:label></th>
            <td><form:input path="lastName"/></td>
            <td><form:errors path="lastName" cssClass="error"/></td>
        </tr>
        <tr>
            <th><form:label path="age"><fmt:message key="resident.age"/></form:label></th>
            <td><form:input path="age"/></td>
            <td><form:errors path="age" cssClass="error"/></td>
        </tr>
    </table>
