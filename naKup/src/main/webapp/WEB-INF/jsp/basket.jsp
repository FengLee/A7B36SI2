<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:content>
	<jsp:body>
	
		<h3><fmt:message key="cart.title"/></h3>
		
		<div class="table-responsive" id="cart-noajax-table">
			<table class="table">
				<thead>
					<tr>
						<th><fmt:message key="cart.goods.name" /></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${goods}" var="item">
						<tr>
							<td>${item.getName()}</td>
							<td>
								<form action="<c:url value="/cart/remove/${item.getEntityId()}" />" method="POST">
									<input type="submit" value="Remove" class="btn btn-danger" />
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="row action-buttons">
				<form action="<c:url value="/cart/empty" />" method="POST">
					<input type="submit" value="<fmt:message key="cart.goods.empty" />" class="btn btn-danger" />
				</form>
				<form action="<c:url value="/cart/send" />" method="POST">
					<input type="submit" value="<fmt:message key="cart.goods.send" />" class="btn btn-primary" />
				</form>
			</div>
		</div>
		
	</jsp:body>
</t:content>
