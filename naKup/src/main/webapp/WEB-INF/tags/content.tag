<%@tag description="Overall Page template" pageEncoding="UTF-8"%>

<html>
  	<head>
  		<meta charset="utf-8">  		
  		<title>Nakup lokalne</title>
  		<link type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  		<link type="text/css" href="${pageContext.request.contextPath}/gui/css/screen.css" rel="stylesheet">
	</head>
	<header>
		<jsp:include page="/WEB-INF/jsp/includes/pageHeader.jsp" />
	</header>
	<body>
		<div class="container">
			<div class="panel panel-primary">
				<div class="panel-heading">
		    		<jsp:include page="/WEB-INF/jsp/includes/panelHeader.jsp" />
		    	</div>
		  		<div class="panel-body">
		      		<jsp:doBody/>
		      	</div>
		  	</div>
	  	</div>
  	</body>
  	<footer>
    	<jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
  	</footer>
  	<script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.10.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
  	<script src="${pageContext.request.contextPath}/gui/js/scripts.js"></script>
</html>