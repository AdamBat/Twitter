<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register form</title>
</head>
<body>
	<form:form path="register" modelAttribute="user" method="post">
		<br>
Username<form:input path="username" />
		<form:errors path="username"></form:errors>
		<br>
Password:<form:password path="password" />
		<form:errors path="password"></form:errors>
		<br>
E-mail<form:input path="email" />
		<form:errors path="email"></form:errors>
		<input type="submit" value="Register">
	</form:form>
	<h3>${error }</h3>
</body>
</html>