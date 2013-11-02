<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:content>
	<jsp:body>
		<div class="panel panel-default">
		  <!-- Default panel contents -->
		  <div class="panel-heading">Zboží</div>		
		  <!-- Table -->		  
		  <table class="table">
		  		<thead>
		  			<tr>
		  				<th>Id</th>
		  				<th>Jmeno</th>
		  			</tr>
		  		</thead>		  		
		  		<tbody>		  				
		  			<c:forEach items="${listGoods}" var="item">
		  				<tr>
		  					<td><c:out value="${item.getEntityId()}"/></td>
		  					<td><c:out value="${item.getName()}"/></td>
		  				</tr>
		  			</c:forEach>
		  		</tbody>
		  </table>
		</div>
		
	</jsp:body>
</t:content>