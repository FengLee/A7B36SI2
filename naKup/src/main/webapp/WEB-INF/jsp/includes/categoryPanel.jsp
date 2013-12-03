<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="bs-sidebar hidden-print affix">
	<ul class="nav bs-sidenav">
		<c:forEach items="${categories}" var="item">
			<li><a href="${pageContext.request.contextPath}/category/${item.getName()}"><c:out value="${item.getName()}"/></a></li>
		</c:forEach>		
	</ul>
</div>