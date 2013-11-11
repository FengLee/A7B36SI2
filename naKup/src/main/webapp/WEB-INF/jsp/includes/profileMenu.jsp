<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authentication property="principal" var="principal"/>

<c:if test="${user.login == principal}">
    <div class="list-group col-xs-4 menu-left">
		<a href="/naKup/profile/${user.entityId}/edit" class="list-group-item"><fmt:message key="profile.edit.profile"/></a>
		<a href="#" class="list-group-item"><fmt:message key="profile.edit.products"/></a>
		<a href="/naKup/profile/${user.entityId}/orders" class="list-group-item"><fmt:message key="profile.edit.orders"/></a>
	</div>
</c:if>
<c:if test="${user.login != principal}">
    <div class="list-group col-xs-4 menu-left">
		<a href="#" class="list-group-item"><fmt:message key="profile.send.message"/></a>
	</div>
</c:if>