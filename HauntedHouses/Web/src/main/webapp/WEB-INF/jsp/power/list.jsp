<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<fmt:message var="title" key="power.list.title"/>
<my:layout title="${title}">
 <jsp:attribute name="body">

        <table class="basic">
            <tr>
                <th><fmt:message key="power.id"/></th>
                <th><fmt:message key="power.name"/></th>
                <th><fmt:message key="power.description"/></th>
            </tr>
            <c:forEach items="${powers}" var="power">
                <tr>
                    <td><c:out value="${power.id}"/></td>
                    <td><c:out value="${power.name}"/></td>
                    <td><c:out value="${power.description}"/></td>
                    <td>
                        <form method="get" action="${pageContext.request.contextPath}/power/update/${power.id}">
                            <input type="submit" value="<fmt:message key='power.list.edit'/>">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/power/delete/${power.id}">
                            <input type="submit" value="<fmt:message key='power.list.delete'/>">
                        </form>
                    </td>

                </tr>
            </c:forEach>
        </table>

<form:form method="post" action="${pageContext.request.contextPath}/power/update" modelAttribute="power">
    <fieldset><legend><fmt:message key="power.list.newpower"/></legend>
    <%@include file="form.jsp"%>
    <input type="submit" value="<fmt:message key='power.list.createPower'/>">
    </fieldset>
</form:form>
</jsp:attribute>
</my:layout>