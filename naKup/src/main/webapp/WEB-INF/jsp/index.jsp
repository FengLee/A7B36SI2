<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:content>
	<jsp:body>
		<div class="container">
		<div class="row">
			<c:forEach items="${listGoods}" begin="${begin}" end="${end}" var="item">
				<div class="col-lg-3">
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
						</div>
					</div>
				</div>
			</c:forEach>
						
						
			<div class="col-lg-3">
					<div class="panel panel-default">
			<div class="panel panel-body">
			<div class="row">
				<div class="col-md-1">
					<p><img src="http://wallpaperscraft.com/image/61956/256x256.jpg?orig=1" height="100" width="100" class="img-rounded"></p>
				</div>
				<div class="col-md-4 col-md-offset-4">
					<div class="row">
						<div class="col-md-4">
							<p>Nazev:</p>
						</div>
						<div class="col-md-2 col-md-offset-3">
							<p>Jablko</p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<p>Cena:</p>
						</div>
						<div class="col-md-2 col-md-offset-3">
							<p>60</p>
						</div>
					</div>
				</div>
			</div>			
			<div class="row">
				<div class="col-md-1">
					<p>Popis:</p>
				</div>
				<div class="col-md-4 col-md-offset-4">
					<p>Blabla</p>	
				</div>	
			</div>
			</div>
			</div>
			</div>
						
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
				<c:forEach begin="1" end="${count}" varStatus="numb">					
					<c:choose>
						<c:when test="${numb == currentPage}">
							<li class="active"><a href="${numb}"><c:out value="${numb}"/></a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${numb}"><c:out value="${numb}"/></a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${currentPage == 1}">
						<li class="active"><span>1 <span class="sr-only">(current)</span></span></li>
					</c:when>
					<c:otherwise>
						<li><a href="1">1</a></li>
					</c:otherwise>
				</c:choose>
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