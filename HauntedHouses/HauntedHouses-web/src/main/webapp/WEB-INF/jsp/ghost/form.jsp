<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <table>
        <tr>
            <th><form:label path="name"><fmt:message key="ghost.name"/></form:label></th>
            <td><form:input path="name"/></td>
            <td><form:errors path="name" cssClass="error"/></td>
        </tr>
        <tr>
            <th><form:label path="house.name"><fmt:message key="ghost.house.name"/></form:label></th>
            <td><form:input path="house.name"/></td>
            <td><form:errors path="house.name" cssClass="error"/></td>
        </tr>
        <tr>
            <th><form:label path="power.name"><fmt:message key="ghost.power.name"/></form:label></th>
            <td><form:input path="power.name"/></td>
            <td><form:errors path="power.name" cssClass="error"/></td>
        </tr>
        <tr>
            <th><form:label path="info"><fmt:message key="ghost.info"/></form:label></th>
            <td><form:input path="info"/></td>
            <td><form:errors path="info" cssClass="error"/></td>
        </tr>
        
    </table>
