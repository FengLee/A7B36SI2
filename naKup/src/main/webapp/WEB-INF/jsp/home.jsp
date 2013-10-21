<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<t:content>
	<jsp:body>
	
		lokalizovany pozdrav: <fmt:message key="hello" />
		<div>
		  <a href="/naKup/people">klikni</a>
		</div>
		
	</jsp:body>
</t:content>


