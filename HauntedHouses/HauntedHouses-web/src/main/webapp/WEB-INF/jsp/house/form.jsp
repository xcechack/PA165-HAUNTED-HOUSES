<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <table>
        <tr>
            <th><form:label path="name"><fmt:message key="house.name"/></form:label></th>
            <td><form:input path="name"/></td>
            <td><form:errors path="name" cssClass="error"/></td>
        </tr>
        <tr>
            <th><form:label path="address"><fmt:message key="house.address"/></form:label></th>
            <td><form:input path="address"/></td>
            <td><form:errors path="address" cssClass="error"/></td>
        </tr>
        <tr>
            <th><form:label path="history"><fmt:message key="house.history"/></form:label></th>
            <td><form:input path="history"/></td>
            <td><form:errors path="history" cssClass="error"/></td>
        </tr>
        
    </table>