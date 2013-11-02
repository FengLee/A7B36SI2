<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:content>
	<jsp:body>
	
		<div class="container">
			<form class="form-horizontal" role="form" id="command" action="/naKup/addUser" method="POST">
			
				<div class="page-header">
				  <h1><fmt:message key="register" /></h1>
				</div>
				<div class="form-group">
					<label for="userTypeRadios1" class="col-lg-2 control-label"><fmt:message key="register.userType" /></label>
					<div class="radio-inline">
					  <label>
					    <input type="radio" name="customer" id="userTypeRadios1" value="true" checked>
					    <fmt:message key="customer" />
					  </label>
					</div>
					<div class="radio-inline">
					  <label>
					    <input type="radio" name="customer" id="userTypeRadios1" value="false">
					    <fmt:message key="vendor" />
					  </label>
					</div>
				</div>
			  <div class="form-group">
			    <label for="inputEmail" class="col-lg-2 control-label"><fmt:message key="email" /></label>
			    <div class="col-lg-10">
			      <input type="email" class="form-control" id="inputEmail" placeholder="Email" name="login">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword" class="col-lg-2 control-label"><fmt:message key="password" /></label>
			    <div class="col-lg-10">
			      <input type="text" class="form-control" id="inputPassword" placeholder="Password" name="password">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputFirstname" class="col-lg-2 control-label"><fmt:message key="register.firstname" /></label>
			    <div class="col-lg-10">
			      <input type="text" class="form-control" id="inputFirstname" placeholder="Firstname" name="firstName">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputLastname" class="col-lg-2 control-label"><fmt:message key="register.lastname" /></label>
			    <div class="col-lg-10">
			      <input type="text" class="form-control" id="inputLastname" placeholder="Lastname" name="lastName">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputStreet" class="col-lg-2 control-label"><fmt:message key="register.street" /></label>
			    <div class="col-lg-10">
			      <input type="text" class="form-control" id="inputStreet" placeholder="Street" name="street">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputCity" class="col-lg-2 control-label"><fmt:message key="register.city" /></label>
			    <div class="col-lg-10">
			      <input type="text" class="form-control" id="inputCity" placeholder="City" name="city">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputCode" class="col-lg-2 control-label"><fmt:message key="register.zipcode" /></label>
			    <div class="col-lg-10">
			      <input type="text" class="form-control" id="inputCode" placeholder="Code" name="psc">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputDescription" class="col-lg-2 control-label"><fmt:message key="register.desctiption.field" /></label>
			    <div class="col-lg-10">
			      <textarea class="form-control" id="inputDescription" rows="3" name="popis"></textarea>
			    </div>
			  </div>
	
			  <div class="form-group">
			    <div class="col-lg-offset-2 col-lg-10">
			      <button type="submit" class="btn btn-default" value="Submit"><fmt:message key="submit" /></button>
			    </div>
			  </div>
			</form>
		</div>
		  
	</jsp:body>
</t:content>