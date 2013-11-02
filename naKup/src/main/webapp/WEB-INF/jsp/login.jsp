<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:content>
	<jsp:body>
	
		<c:if test="${not empty error}">
			<div class="errorblock">
				Your login attempt was not successful, try again.<br /> Caused :
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			</div>
		</c:if>
 
<%-- 		<form name='f' action="<c:url value='j_spring_security_check' />" --%>
<!-- 			method='POST'> -->
	 
<%-- 			<table> --%>
<%-- 				<tr> --%>
<%-- 					<td>User:</td> --%>
<%-- 					<td><input type='text' name='j_username' value=''> --%>
<%-- 					</td> --%>
<%-- 				</tr> --%>
<%-- 				<tr> --%>
<%-- 					<td>Password:</td> --%>
<%-- 					<td><input type='password' name='j_password' /> --%>
<%-- 					</td> --%>
<%-- 				</tr> --%>
<%-- 				<tr> --%>
<%-- 					<td colspan='2'><input name="submit" type="submit" --%>
<!-- 						value="submit" /> -->
<%-- 					</td> --%>
<%-- 				</tr> --%>
<%-- 				<tr> --%>
<%-- 					<td colspan='2'><input name="reset" type="reset" /> --%>
<%-- 					</td> --%>
<%-- 				</tr> --%>
<%-- 			</table> --%>
	 
<!-- 		</form> -->

<!-- 		<div class="container"> -->
<!-- 		    <div class="content"> -->
<!-- 		      <div class="row"> -->
<!-- 		        <div class="login-form"> -->
<!-- 		          <h2>Login</h2> -->
<%-- 		          <form action="<c:url value='j_spring_security_check' />" method='POST'> --%>
<!-- 		            <fieldset> -->
<!-- 		              <div class="clearfix"> -->
<!-- 		                <input type="text" placeholder="Username" name='j_username'> -->
<!-- 		              </div> -->
<!-- 		              <div class="clearfix"> -->
<!-- 		                <input type="password" placeholder="Password" name='j_password'> -->
<!-- 		              </div> -->
<!-- 		              <button name="submit" class="btn btn-primary" type="submit" value="submit">Sign in</button> -->
<!-- 		            </fieldset> -->
<!-- 		          </form> -->
<!-- 		        </div> -->
<!-- 		      </div> -->
<!-- 		    </div> -->
<!-- 		  </div> /container -->
		  
		  <div class="container">
			  <form class="form-horizontal" action="<c:url value='j_spring_security_check' />" method='POST'>
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="inputEmail3" placeholder="Email" name='j_username'>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
				    <div class="col-sm-10">
				      <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name='j_password'>
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      <button type="submit" name="submit" value="submit" class="btn btn-default">Sign in</button>
				    </div>
				  </div>
				</form>
			</div>
		
	</jsp:body>
</t:content>