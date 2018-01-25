<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Send new Message</title>
</head>
<body>
	<form:form modelAttribute="message" method="post">
		<form:select path="recipient.id" items="${users }" itemValue="id" itemLabel="username"></form:select>
		<br>
		<form:textarea path="text" />
		<input type="submit" value="Send">
	</form:form>
</body>
</html>