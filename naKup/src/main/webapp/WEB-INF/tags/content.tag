<%@tag description="Overall Page template" pageEncoding="UTF-8"%>

<html>
  	<head>
  		<meta charset="utf-8">  		
  		<title>Nakup lokalne</title>
  		<link type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  		<link type="text/css" href="${pageContext.request.contextPath}/gui/css/screen.css" rel="stylesheet">
	</head>
	<header>
		<div id="header">
	    	<jsp:include page="/WEB-INF/jsp/includes/header.jsp" />
	    </div>
	</header>
  	<body>
	    <div id="body">
	      	<jsp:doBody/>
	    </div>
  	</body>
  	<footer>
  		<div id="footer">
	    	<jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
	    </div>
  	</footer>
  	<script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.10.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</html>