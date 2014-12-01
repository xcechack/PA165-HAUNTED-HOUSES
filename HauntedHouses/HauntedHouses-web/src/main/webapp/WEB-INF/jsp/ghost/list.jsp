<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<fmt:message var="title" key="ghost.list.title"/>
<my:layout title="${title}">
 <jsp:attribute name="body">

        <p><fmt:message key="ghost.list.allghosts"/></p>

        <table class="basic">
            <tr>
                <th><fmt:message key="ghost.id"/></th>
                <th><fmt:message key="ghost.name"/></th>
                <th><fmt:message key="ghost.house.name"/></th>
                <th><fmt:message key="ghost.power.name"/></th>
                <th><fmt:message key="ghost.info"/></th>
            </tr>
            <c:forEach items="${ghosts}" var="ghost">
                <tr>
                    <td><c:out value="${ghost.id}"/></td>
                    <td><c:out value="${ghost.name}"/></td>
                    <td><c:out value="${ghost.house.name}"/></td>
                    <td><c:out value="${ghost.power.name}"/></td>
                    <td><c:out value="${ghost.info}"/></td>
                    <td>
                        <form method="get" action="${pageContext.request.contextPath}/ghost/update/${ghost.id}">
                            <input type="submit" value="<fmt:message key='ghost.list.edit'/>">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/ghost/delete/${ghost.id}">
                            <input type="submit" value="<fmt:message key='ghost.list.delete'/>">
                        </form>
                    </td>

                </tr>
            </c:forEach>
        </table>

<form:form method="post" action="${pageContext.request.contextPath}/ghost/update" modelAttribute="ghost">
    <fieldset><legend><fmt:message key="ghost.list.newghost"/></legend>
    <%@include file="form.jsp"%>
    <input type="submit" value="<fmt:message key='ghost.list.createGhost'/>">
    </fieldset>
</form:form>
</jsp:attribute>
</my:layout>