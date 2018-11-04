<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String cp = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>Login</title>
	     
	<script
	  src="https://code.jquery.com/jquery-3.3.1.js"
	  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	  crossorigin="anonymous">
	</script>
  
  	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="//code.jquery.com/jquery.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
</head>
<body>

	<form action="login" method="get">
		id<input type="text" name="id">
		pw<input type="text" name="pw">
		<input type="submit" value="로그인">
	</form>
	
	<c:set var="id" value="0"/>
	<% int num = 0; %>
	<c:forEach items="${gid}" var="dto1">
		<c:set var="id" value="1"/>
		<% num = 1; %>
		
	</c:forEach>
	
	<c:forEach items="${login}" var="dto2">
		<c:set var="id" value="2"/>
		<% num = 2; %>
	</c:forEach>
	
	<%
		if(num == 1){
			%>
			<p>일치하는 아이디가 없습니다.</p>
			<% 
		} else {
			%>
			<p>비밀번호가 다릅니다.</p>
			<% 
		}
	%>
	
</body>
</html>