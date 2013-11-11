<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<t:content>
	<jsp:body>
		
		
			
				
					
				<h3><fmt:message key="orders.title"/></h3>
					
					<div class="row">
						<jsp:include page="/WEB-INF/jsp/includes/profileMenu.jsp" />
						<div class="table-responsive">
							<div class="col-xs-4">
								<table class="table table-bordered">
									<thead>
										<tr>
											<th><fmt:message key="orders.id"/></th>
											<th><fmt:message key="orders.from"/></th>
										</tr> 
									</thead>
									<tbody>
										<c:forEach items="${listOrders}" var="item">
											<tr>
												<td><c:out value="${item.getEntityId()}"/></td>
												<td><c:out value="${item.getFrom()}"/></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>						
					</div>
				
			
		
		
	</jsp:body>
</t:content>