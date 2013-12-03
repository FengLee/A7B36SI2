<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:content>
	<jsp:body>
	
		<h3><fmt:message key="profile.goods.editation.title"/></h3>
		
		<div class="row">
			<jsp:include page="/WEB-INF/jsp/includes/profileMenu.jsp" />
			<div class="col-xs-12 col-sm-6 col-md-8">
				<form class="form-horizontal" role="form" id="command" action="<c:url value="/profile/${user.entityId}/products/${goods.entityId}/edit" />" method="POST">
					<div class="form-group">
						<label for="inputName" class="col-lg-2 control-label"><fmt:message key="profile.goods.name" /></label>
						<div class="col-xs-12 col-sm-6 col-md-8">
							<input type="text" class="form-control" id="inputName" name="name" value="${goods.name}">
						</div>
					</div>
					<div class="form-group">
						<label for="inputCost" class="col-lg-2 control-label"><fmt:message key="profile.goods.cost" /></label>
						<div class="col-xs-12 col-sm-6 col-md-8">
							<input type="number" step="any" class="form-control" id="inputCost" name="cost" value="${goods.cost}">
						</div>
					</div>
					<div class="form-group">
						<label for="inputDescription" class="col-lg-2 control-label"><fmt:message key="profile.goods.description" /></label>
						<div class="col-xs-12 col-sm-6 col-md-8">
							<textarea class="form-control" id="inputDescription" rows="3" name="text">${goods.text}</textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-offset-2 col-xs-12 col-sm-6 col-md-8">
							<button type="submit" class="btn btn-primary" value="Submit"><fmt:message key="submit" /></button>
							<a href="<c:url value="/profile/${user.entityId}/products/${goods.entityId}" />" class="btn btn-default"><fmt:message key="cancel" /></a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</jsp:body>
</t:content>
