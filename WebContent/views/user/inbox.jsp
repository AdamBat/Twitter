<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inbox</title>
</head>
<body>
	<h2>Your messages</h2>
	<h4>Sent</h4>
	<table>
		<tr>
			<th>Recipient</th>
			<th>Text</th>
		<tr>
			<c:forEach var="msg" items="${sent }">
				<tr>
					<td>${msg.recipient.username }</td>
					<td>${msg.text }</td>
				</tr>

			</c:forEach>
	</table>
	<h4>Received</h4>
	<table>
		<tr>
			<th>Sender</th>
			<th>Text</th>
		<tr>
			<c:forEach var="msg" items="${received }">
				<tr>
					<td>${msg.sender.username }</td>
					<td>${msg.text }</td>
				</tr>

			</c:forEach>
	</table>
</body>
</html>