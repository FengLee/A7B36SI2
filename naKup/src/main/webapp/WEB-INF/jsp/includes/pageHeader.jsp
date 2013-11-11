<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-default navbar-static-top" role="navigation">

	<div class="navbar-left page-header-left">
		<h3>NaKup lokalne</h3>
	</div>
	
	<div class="navbar-right page-header-right">
		<c:if test="${pageContext['request'].userPrincipal != null}">
			<fmt:message key="loggedUserFrame.user" />:
			<b><sec:authentication property="principal" /></b>
			
			<a href="<c:url value="/j_spring_security_logout" />" class="btn btn-default navbar-btn">
				<span class="glyphicon glyphicon-log-out"></span>
				<fmt:message key="loggedUserFrame.logout" />
			</a>
		</c:if>
		<c:if test="${pageContext['request'].userPrincipal == null}">
			<a href="<c:url value="/login" />" class="btn btn-default navbar-btn"><fmt:message key="loggedUserFrame.login" /></a>
			<a href="<c:url value="/registration"/>" class="btn btn-default navbar-btn"><fmt:message key="register" /></a>
		</c:if>
	</div>

</nav>