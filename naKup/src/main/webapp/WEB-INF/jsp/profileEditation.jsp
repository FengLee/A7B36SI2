<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:content>
	<jsp:body>
		
		
		<h3><fmt:message key="profile.title"/></h3>
		
		<div class="panel-body row">
			<jsp:include page="/WEB-INF/jsp/includes/profileMenu.jsp" />
			<div class="col-xs-12 col-sm-6 col-md-8">
				<form class="form-horizontal" role="form" id="command" action="${pageContext.request.contextPath}/profile/${user.entityId}/edit" method="POST">
					<div class="form-group">
						<label for="inputFirstname" class="col-lg-2 control-label"><fmt:message key="register.firstname" /></label>
						<div class="col-xs-12 col-sm-6 col-md-8">
							<input type="text" class="form-control" id="inputFirstname" name="firstName" value="${user.firstName}">
						</div>
					</div>
					<div class="form-group">
						<label for="inputLastname" class="col-lg-2 control-label"><fmt:message key="register.lastname" /></label>
						<div class="col-xs-12 col-sm-6 col-md-8">
							<input type="text" class="form-control" id="inputLastname" name="lastName" value="${user.lastName}">
						</div>
					</div>
					<div class="form-group">
						<label for="inputStreet" class="col-lg-2 control-label"><fmt:message key="register.street" /></label>
						<div class="col-xs-12 col-sm-6 col-md-8">
							<input type="text" class="form-control" id="inputStreet" name="street" value="${user.street}">
						</div>
					</div>
					<div class="form-group">
						<label for="inputCity" class="col-lg-2 control-label"><fmt:message key="register.city" /></label>
						<div class="col-xs-12 col-sm-6 col-md-8">
							<input type="text" class="form-control" id="inputCity" name="city" value="${user.city}">
						</div>
					</div>
					<div class="form-group">
						<label for="inputCode" class="col-lg-2 control-label"><fmt:message key="register.zipcode" /></label>
						<div class="col-xs-12 col-sm-6 col-md-8">
							<input type="text" class="form-control" id="inputCode" name="psc" value="${user.zip}">
						</div>
					</div>
					<div class="form-group">
						<label for="inputDescription" class="col-lg-2 control-label"><fmt:message key="register.desctiption.field" /></label>
						<div class="col-xs-12 col-sm-6 col-md-8">
							<textarea class="form-control" id="inputDescription" rows="3" name="popis">${user.description}</textarea>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-lg-offset-2 col-xs-12 col-sm-6 col-md-8">
							<button type="submit" class="btn btn-primary" value="Submit"><fmt:message key="submit" /></button>
							<a href="${pageContext.request.contextPath}/profile/${user.entityId}" class="btn btn-default"><fmt:message key="cancel" /></a>
						</div>
					</div>
				</form>
			</div>
		</div>
		
	</jsp:body>
</t:content>
