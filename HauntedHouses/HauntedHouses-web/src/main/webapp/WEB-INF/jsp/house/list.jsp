<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<fmt:message var="title" key="house.list.title"/>
<my:layout title="${title}">
 <jsp:attribute name="body">
    
        <p><fmt:message key="house.list.allhouses"/></p>

        <table class="basic">
            <tr>
                <th>id</th>
                <th><fmt:message key="house.name"/></th>
                <th><fmt:message key="house.history"/></th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${houses}" var="house">
                <tr>
                    <td>${house.id}</td>
                    <td><c:out value="${house.name}"/></td>
                    <td><c:out value="${house.history}"/></td>
                    <td>
                        <form method="get" action="${pageContext.request.contextPath}/house/update/${house.id}">
                            <input type="submit" value="<fmt:message key='house.list.edit'/>">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/house/delete/${house.id}">
                            <input type="submit" value="<fmt:message key='house.list.delete'/>">
                        </form>
                    </td>

                </tr>
            </c:forEach>
        </table>

<form:form method="post" action="${pageContext.request.contextPath}/house/update" modelAttribute="house">
    <fieldset><legend><fmt:message key="house.list.newhouse"/></legend>
    <%@include file="form.jsp"%>
    <input type="submit" value="<fmt:message key='house.list.createhouse'/>">
    </fieldset>
</form:form>
</jsp:attribute>
</my:layout>