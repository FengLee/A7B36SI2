<%@tag description="Overall Page template" pageEncoding="UTF-8"%>

<html>
  	<head>
  		<meta charset="utf-8">
  		<title>Nakup lokalne</title>
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
  	</body>
</html>