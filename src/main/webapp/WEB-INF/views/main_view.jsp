<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*"%>

<% String cp = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>Insert title here</title>
	
	<script
	  src="https://code.jquery.com/jquery-3.3.1.js"
	  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	  crossorigin="anonymous">
	</script>
  
  	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="//code.jquery.com/jquery.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
	<script>
	$(document).ready(function(){
		 $("#msgid").html("This is Hello World by JQuery");
	});
	</script>
</head>
<body>
<msgid id="msgid"></msgid>

<ul class="nav justify-content-center">
  <li class="nav-item">
    <a class="nav-link active" href="signup_view">회원가입</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="login_view">로그인</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="board_view">게시판</a>
  </li>
  <li class="nav-item">
    <a class="nav-link disabled" href="#">Disabled</a>
  </li>
</ul>

<c:forEach items="${login}" var="dto">
	<p>${dto.id}</p>님 환영합니다.....///////////
	<c:set var="id" value="${dto.id}" />
	<p>${id}</p>

</c:forEach>
	
</body>
</html>