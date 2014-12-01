<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<fmt:message var="title" key="resident.list.title"/>
<my:layout title="${title}">
 <jsp:attribute name="body">

        <p><fmt:message key="resident.list.allresidents"/></p>

        <table class="basic">
            <tr>
                <th><fmt:message key="resident.id"/></th>
                <th><fmt:message key="resident.firstName"/></th>
                <th><fmt:message key="resident.lastName"/></th>
                <th><fmt:message key="resident.age"/></th>
            </tr>
            <c:forEach items="${residents}" var="resident">
                <tr>
                    <td><c:out value="${resident.id}"/></td>
                    <td><c:out value="${resident.firstName}"/></td>
                    <td><c:out value="${resident.lastName}"/></td>
                    <td><c:out value="${resident.age}"/></td>
                    <td>
                        <form method="get" action="${pageContext.request.contextPath}/resident/update/${resident.id}">
                            <input type="submit" value="<fmt:message key='resident.list.edit'/>">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/resident/delete/${resident.id}">
                            <input type="submit" value="<fmt:message key='resident.list.delete'/>">
                        </form>
                    </td>

                </tr>
            </c:forEach>
        </table>

<form:form method="post" action="${pageContext.request.contextPath}/resident/update" modelAttribute="resident">
    <fieldset><legend><fmt:message key="resident.list.newresident"/></legend>
    <%@include file="form.jsp"%>
    <input type="submit" value="<fmt:message key='resident.list.createresident'/>">
    </fieldset>
</form:form>
</jsp:attribute>
</my:layout>