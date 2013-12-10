<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:content>
		
	<jsp:body>
		<ol class="breadcrumb">
		  <li><a href="${pageContext.request.contextPath}/">Home</a></li>
		  <c:forEach items="${breadcrumb}" var="item">
		  	<li><a href="${pageContext.request.contextPath}/category/${item}"><c:out value="${item}"/></a></li>
		  </c:forEach>		  
		</ol>		
		<div class="container">
		<div class="row">		
			<c:forEach items="${listGoods}" begin="${begin}" end="${end}" var="item">
				<%-- <div class="col-lg-3">
					<div class="panel panel-default">
						<div class="panel panel-body">
							<div class="row">
								<div class="col-md-1">
									<p><img src="${item.getPicture()}" height="100" width="100" class="img-rounded"></p>
								</div>
								<div class="col-md-4 col-md-offset-4">
									<div class="row">
										<div class="col-md-4">
											<p><fmt:message key="goods.name"/></p>
										</div>
										<div class="col-md-2 col-md-offset-2">
											<p><c:out value = "${item.getName()}"/></p>
										</div>
									</div>
									<div class="row">
										<div class="col-md-4">
											<p><fmt:message key="goods.cost"/></p>
										</div>
										<div class="col-md-2 col-md-offset-2">
											<p><c:out value="${item.getCost()}"/></p>
										</div>
									</div>
								</div>
							</div>			
							<div class="row">
								<div class="col-md-1">
									<p><fmt:message key="goods.desc"/></p>
								</div>
								<div class="col-md-4 col-md-offset-4">
									<p><c:out value="${item.getText()}"/></p>	
								</div>	
							</div>
							<div class="row">
								<form action="<c:url value="/cart/add/${item.getEntityId()}" />" method="POST">
									<input type="submit" value="Add to cart" class="btn btn-primary" />
								</form>
							</div>
						</div>
					</div>
				</div> --%>
					<div class="col-sm-6 col-md-4">
    					<div class="thumbnail">
      						<img src="${item.getPicture()}" height="100" width="100" class="img-rounded">
      					<div class="caption">
        					<h3><c:out value="${item.getName()}"/></h3>
        					<p>
        						<fmt:message key="goods.cost"/>
        						<span style="padding-left: 10px"><c:out value="${item.getCost()}"/></span>
        					</p>
        					<p>
        						<fmt:message key="goods.desc"/>
        						<br>
        						<c:out value="${item.getText()}"/>
        					</p>
        					<p><form action="<c:url value="/cart/add/${item.getEntityId()}" />" method="POST">
                               		<input type="submit" value="<fmt:message key="cart.add"/>" class="btn btn-primary" />
                               </form></p>
      					</div>
   					 	</div>
  					</div>
			</c:forEach>					
			</div>
			
			<ul class="pagination">
				<c:choose>
					<c:when test="${prevBool}">
						<li class="disabled"><span>&laquo;</span></li>
					</c:when>
					<c:otherwise>
						<li><a href="${prev}">&laquo;</a></li>
					</c:otherwise>
				</c:choose>				
				<c:if test="${catBool == true}">
				<c:forEach begin="1" end="${numbPages }" varStatus="numb">					
					<c:choose>
						<c:when test="${numb.getCurrent() == currentPage}">
							<li class="active"><a href="${category}/${numb.getCurrent()}"><c:out value="${numb.getCurrent()}"/></a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${category}/${numb.getCurrent()}"><c:out value="${numb.getCurrent()}"/></a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</c:if>
				<c:if test="${catBool == false}">
				<c:forEach begin="1" end="${numbPages }" varStatus="numb">					
					<c:choose>
						<c:when test="${numb.getCurrent() == currentPage}">
							<li class="active"><a href="${numb.getCurrent()}"><c:out value="${numb.getCurrent()}"/></a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${numb.getCurrent()}"><c:out value="${numb.getCurrent()}"/></a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</c:if>				
		  		<c:choose>
					<c:when test="${nextBool}">
						<li class="disabled"><span>&raquo;</span></li>
					</c:when>
					<c:otherwise>
						<li><a href="${next}">&raquo;</a></li>
					</c:otherwise>
				</c:choose>	  		
			</ul>
									
		</div>		
	</jsp:body>	
</t:content>
