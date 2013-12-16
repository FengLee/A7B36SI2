<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:content>
	<jsp:body>
		
		
		<h3><fmt:message key="category.title"/></h3>
		
		<div class="panel-body row">						
			<div class="col-xs-12 col-sm-6 col-md-8">
				<form class="form-horizontal" role="form" id="command" action="${pageContext.request.contextPath}/${category.getName()}/edit" method="POST">
					<div class="form-group">
						<label for="inputFirstname" class="col-lg-2 control-label"><fmt:message key="category.name" /></label>
						<div class="col-xs-12 col-sm-6 col-md-8">
							<input type="text" class="form-control" id="inputFirstname" name="name" value="${category.getName()}">
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-offset-2 col-xs-12 col-sm-6 col-md-8">
							<button type="submit" class="btn btn-primary" value="Submit"><fmt:message key="submit" /></button>
							<a href="${pageContext.request.contextPath}/categories" class="btn btn-default"><fmt:message key="cancel" /></a>
						</div>
					</div>							
				</form>
			</div>
		</div>
		
	</jsp:body>
</t:content>>