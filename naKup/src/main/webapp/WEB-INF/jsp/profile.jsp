<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<sec:authentication property="principal" var="principal"/>

<t:content>
	<jsp:body>
		
		<div class="container">
			<div class="page-body">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3><fmt:message key="profile.title"/></h3>
					</div>
					<div class="panel-body row">
						<c:if test="${user.login == principal}">
						    <div class="list-group col-xs-4 menu-left">
								<a href="#" class="list-group-item"><fmt:message key="profile.edit.profile"/></a>
								<a href="#" class="list-group-item"><fmt:message key="profile.edit.products"/></a>
								<a href="#" class="list-group-item"><fmt:message key="profile.edit.orders"/></a>
							</div>
						</c:if>
						<c:if test="${user.login != principal}">
						    <div class="list-group col-xs-4 menu-left">
								<a href="#" class="list-group-item"><fmt:message key="profile.send.message"/></a>
							</div>
						</c:if>
						<div class="col-xs-4">
							<div class="row">
								<div class="col-xs-4">
									<fmt:message key="profile.username"/>:
								</div>
								<div class="col-xs-4">
									${user.firstName} ${user.lastName}
								</div>
							</div>
							<div class="row">
								<div class="col-xs-4">
									<fmt:message key="profile.address"/>:
								</div>
								<div class="col-xs-4">
									${user.street}<p>
									${user.city}<p>
									${user.psc}
								</div>
							</div>
							<div class="row">
								<div class="col-xs-4">
									<fmt:message key="profile.description"/>:
								</div>
								<div class="col-xs-4">
									${user.popis}
								</div>
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</div>
		
		
		
	</jsp:body>
</t:content>