<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:content>
	<jsp:body>
		<div class="panel panel-default">
		  <!-- Default panel contents -->
		  <div class="panel-heading">Kategorie</div>		
		  <!-- Table -->		  
		  <table class="table">
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
		  					<td><a data-toggle="modal" href="#myModal" class="btn btn-primary">Edit</a></td>
		  				</tr>
		  			</c:forEach>
		  		</tbody>
		  </table>
		</div>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		          <h4 class="modal-title">Editace kategorie</h4>
		        </div>
		        <div class="modal-body">
		          
		        </div>
		        <div class="modal-footer">
		          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		          <button type="submit" class="btn btn-primary" ">Save changes</button>
		        </div>
		      </div><!-- /.modal-content -->
		    </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
	</jsp:body>
</t:content>