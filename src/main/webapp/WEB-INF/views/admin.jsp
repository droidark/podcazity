<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Admin page</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<!--  <form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script> -->

	<div class="success">
		Dear <strong>${user}</strong>, Welcome to Admin Page.
		<br/>
		Would you like to <a href="<c:url value='/newUser' />">Add Some Users</a> to keep yourself busy?
		<br/>
		<!-- <c:url value="/logout" var="logoutUrl" /> -->
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
    		<input type="submit" value="Logout" />
		</form:form>
	</div>
</body>
</html>