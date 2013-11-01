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
		
		<a data-toggle="modal" href="#registrationModal" class="btn btn-primary btn-lg"><fmt:message key="register" /></a>

		  <div class="modal fade" id="registrationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		          <h4 class="modal-title"><fmt:message key="register" /></h4>
		        </div>
		        <div class="modal-body">
		          <fmt:message key="register.description" />
		        </div>
		        <div class="modal-footer">
		          <button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="register.cancel" /></button>
					<a class="btn btn-primary" href="<c:url value="/registration"/>">
						<fmt:message key="register.button" />
					</a>
		        </div>
		      </div>
		    </div>
		  </div>
		  
	</jsp:body>
</t:content>