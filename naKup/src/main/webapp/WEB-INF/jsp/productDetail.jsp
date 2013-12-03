<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:content>
	<jsp:body>
	
		<h3><fmt:message key="profile.goods.title"/></h3>
		
		<div class="row">
			<jsp:include page="/WEB-INF/jsp/includes/profileMenu.jsp" />
			<div class="col-xs-12 col-sm-6 col-md-8">
				<div class="row">
					<div class="col-xs-4">
						<fmt:message key="profile.goods.name"/>:
					</div>
					<div class="col-xs-12 col-sm-6 col-md-8">
						<strong>${goods.name}</strong>
					</div>
				</div>
				<p>
				<div class="row">
					<div class="col-xs-4">
						<fmt:message key="profile.goods.cost"/>:
					</div>
					<div class="col-xs-12 col-sm-6 col-md-8">
						${goods.cost}
					</div>
				</div>
				<p>
				<div class="row">
					<div class="col-xs-4">
						<fmt:message key="profile.goods.category"/>:
					</div>
					<div class="col-xs-12 col-sm-6 col-md-8">
						${goods.category.name}
					</div>
				</div>
				<p>
				<div class="row">
					<div class="col-xs-4">
						<fmt:message key="profile.goods.description"/>:
					</div>
					<div class="col-xs-12 col-sm-6 col-md-8">
						${goods.text}
					</div>
				</div>
				<p>
				<form action="<c:url value="/profile/${user.entityId}/products/${goods.entityId}/delete" />" method="POST">
					<div class="row action-buttons">
						<a href="<c:url value="/profile/${user.entityId}/products" />" class="btn btn-default">
							<span class="glyphicon glyphicon-chevron-left"></span>
							<fmt:message key="back" />
						</a>
						<a href="<c:url value="/profile/${user.entityId}/products/${goods.entityId}/edit" />" class="btn btn-primary">
							<span class="glyphicon glyphicon-edit"></span>
							<fmt:message key="edit" />
						</a>
						<button type="submit" class="btn btn-danger" value="Submit">
							<span class="glyphicon glyphicon-edit"></span>
							<fmt:message key="delete" />
						</button>
					</div>
				</form>
			</div>
		</div>
	</jsp:body>
</t:content>
