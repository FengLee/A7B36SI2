<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:content>
	<jsp:body>
	
<%-- 		<form:form method="POST" action="/naKup/addUser"> --%>
<%-- 		   <table> --%>
<%-- 			    <tr> --%>
<%-- 			        <td><form:label path="firstName">firstName</form:label></td> --%>
<%-- 			        <td><form:input path="firstName" /></td> --%>
<%-- 			    </tr> --%>
<%-- 			    <tr> --%>
<%-- 			        <td><form:label path="lastName">lastName</form:label></td> --%>
<%-- 			        <td><form:input path="lastName" /></td> --%>
<%-- 			    </tr> --%>
<%-- 			    <tr> --%>
<%-- 			        <td><form:label path="login">login</form:label></td> --%>
<%-- 			        <td><form:input path="login" /></td> --%>
<%-- 			    </tr> --%>
<%-- 			    <tr> --%>
<%-- 			        <td colspan="2"> --%>
<!-- 			            <input type="submit" value="Submit"/> -->
<%-- 			        </td> --%>
<%-- 			    </tr> --%>
<%-- 			</table>   --%>
<%-- 		</form:form> --%>
		<div class="container">
			<form class="form-horizontal" role="form" id="command" action="/naKup/addUser" method="POST">
			
			  <div class="form-group">
			    <label for="inputEmail" class="col-lg-2 control-label">Email</label>
			    <div class="col-lg-10">
			      <input type="email" class="form-control" id="inputEmail" placeholder="Email" name="login">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword" class="col-lg-2 control-label">Password</label>
			    <div class="col-lg-10">
			      <input type="text" class="form-control" id="inputPassword" placeholder="Password" name="password">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputFirstname" class="col-lg-2 control-label">Firstname</label>
			    <div class="col-lg-10">
			      <input type="text" class="form-control" id="inputFirstname" placeholder="Firstname" name="firstName">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputLastname" class="col-lg-2 control-label">Lastname</label>
			    <div class="col-lg-10">
			      <input type="text" class="form-control" id="inputLastname" placeholder="Lastname" name="lastName">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputStreet" class="col-lg-2 control-label">Street</label>
			    <div class="col-lg-10">
			      <input type="text" class="form-control" id="inputStreet" placeholder="Street" name="street">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputCity" class="col-lg-2 control-label">City</label>
			    <div class="col-lg-10">
			      <input type="text" class="form-control" id="inputCity" placeholder="City" name="city">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputCode" class="col-lg-2 control-label">Code</label>
			    <div class="col-lg-10">
			      <input type="text" class="form-control" id="inputCode" placeholder="Code" name="psc">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputDescription" class="col-lg-2 control-label">Description</label>
			    <div class="col-lg-10">
			      <textarea class="form-control" id="inputDescription" rows="3" name="popis"></textarea>
			    </div>
			  </div>
			  
	
			  <div class="form-group">
			    <div class="col-lg-offset-2 col-lg-10">
			      <button type="submit" class="btn btn-default" value="Submit">Submit</button>
			    </div>
			  </div>
			</form>
		</div>
		  
	</jsp:body>
</t:content>