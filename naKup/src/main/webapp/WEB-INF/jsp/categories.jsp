<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:content>
	<jsp:body>
				 	  
		  <div class="table-responsive">
		  <div class="col-xs-4">
		  	<table class="table table-bordered">
		  		<thead>
		  			<tr>
		  				<th>Id</th>
		  				<th>Jmeno</th>
		  				<th></th>
		  			</tr>
		  		</thead>		  		
		  		<tbody>		  				
		  			<c:forEach items="${listCategory}" var="item">
		  				<tr>
		  					<td><c:out value="${item.getEntityId()}"/></td>
		  					<td><c:out value="${item.getName()}"/></td>
		  					<td><a href="/naKup/${item.getName()}/edit" class="btn btn-primary">Edit</a></td>		  					
		  				</tr>
		  			</c:forEach>
		  		</tbody>
		  		</table>
		  		</div>
		  </div>		 
		
	</jsp:body>
</t:content>