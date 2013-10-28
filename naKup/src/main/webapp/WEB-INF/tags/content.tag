<%@tag description="Overall Page template" pageEncoding="UTF-8"%>

<html>
  	<head>
  		<meta charset="utf-8">
  		<title>Nakup lokalne</title>
  		<link type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
  	<body>
	    <div id="header">
	    	<jsp:include page="/WEB-INF/jsp/includes/header.jsp" />
	    </div>
	    <div id="body">
	      	<jsp:doBody/>
	    </div>
	    <div id="footer">
	    	<jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
	    </div>
	    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.10.2.min.js"></script>
		<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
  	</body>
</html>