<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your home page</title>
</head>
<body>
	<h2>Thanks for logging in</h2>
	<br>
	<h4>Welcome to your home page</h4>
	<table>
		<tr>

			<th>Created</th>
			<th>Ttitle</th>
			<th>Text</th>
			<th>Details</th>
		</tr>
		<c:forEach var="tweet" items="${tweets}">
			<tr>
				<td><c:out value="${tweet.created }"></c:out></td>
				<td><c:out value="${tweet.title }"></c:out></td>
				<td><c:out value="${tweet.tweet_text }"></c:out></td>
				<td><a href='<c:url value="/tweet/comments/${tweet.id }" ></c:url>'>Comments</a></td><br>
			</tr>
		</c:forEach>
	</table>

	<form:form method="post" modelAttribute="tweet"
		action="${pageContext.request.contextPath }/tweet/add">
	Title<form:input path="title" />
		<form:errors></form:errors>
		<br>
	Text<form:textarea path="tweet_text" />
		<form:errors></form:errors>
		<br>
		<input type="submit" value="Add new tweet">
	</form:form>
	<br>
	<form:form action="${pageContext.request.contextPath }/user/delete">
		<input type="submit" value="DELETE ACCOUNT">
	</form:form>
</body>
</html>