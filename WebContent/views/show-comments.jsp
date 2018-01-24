<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comments</title>
</head>
<body>
	<h3>Comments for a tweet:</h3>
	<h5>${tweet.title }: ${tweet.tweet_text }</h5>
	<br>
	<c:forEach var="com" items="${comments}">
		${com.created } -  ${com.user.username } -${com.text }
		<br>
	</c:forEach>
	
	<form:form action="${pageContext.request.contextPath }/comments/add/${tweet.id }" method="post" modelAttribute="comment">
Add your comment<form:textarea path="text"/>
<input type="submit" value="Add comment">
	</form:form>
</body>
</html>