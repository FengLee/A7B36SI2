<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<t:content>
	<jsp:body>
	
		<h3><fmt:message key="profile.title"/></h3>
		
		<div class="row">
			<jsp:include page="/WEB-INF/jsp/includes/profileMenu.jsp" />
			<div class="col-xs-12 col-sm-6 col-md-8">
				<div class="row">
					<div class="col-xs-4">
						<fmt:message key="profile.username"/>:
					</div>
					<div class="col-xs-12 col-sm-6 col-md-8">
						<strong>${user.firstName} ${user.lastName}</strong>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-4">
						<fmt:message key="profile.address"/>:
					</div>
					<div class="col-xs-12 col-sm-6 col-md-8">
						${user.street}<p>
						${user.city}<p>
						${user.zip}
					</div>
				</div>
				<div class="row">
					<div class="col-xs-4">
						<fmt:message key="profile.description"/>:
					</div>
					<div class="col-xs-12 col-sm-6 col-md-8">
						${user.description}
					</div>
				</div>
			</div>
		</div>
	</jsp:body>
</t:content>
