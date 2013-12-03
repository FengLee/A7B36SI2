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
			
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th><fmt:message key="profile.goods.name"/></th>
								<th><fmt:message key="profile.goods.cost"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="goods" items="${user.goods}">
							
								<tr>
									<td><a href="<c:url value="/profile/${user.entityId}/products/${goods.entityId}" />" style="text-decoration:none;">
										${goods.name}</a>
									</td>
									<td>
										${goods.cost}
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				<div class="row action-buttons">
					<a href="<c:url value="/profile/${user.entityId}" />" class="btn btn-default">
						<span class="glyphicon glyphicon-chevron-left"></span>
						<fmt:message key="back" />
					</a>
					<a href="<c:url value="/profile/${user.entityId}/products/add" />" class="btn btn-primary">
						<span class="glyphicon glyphicon-plus"></span>
						<fmt:message key="add" />
					</a>
				</div>
			</div>
		</div>
	</jsp:body>
</t:content>
