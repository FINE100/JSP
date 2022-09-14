<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/menu.css">
</head>
<body>
	<nav id="topMenu">
		<ul>
			<li><a class="menuLink" href="#">About us</a></li>
			<li><a class="menuLink" href="#">Ministries</a></li>
			<li><a class="menuLink" href="#">Community</a></li>
			<li><a class="menuLink" href="#">Locations</a></li>
			<li><a class="menuLink" href="#">content</a></li>
			<c:choose>
				<c:when test="${author eq 'ADMIN'}">
					<li><a class="menulink" href="#">관리자</a></li>
				</c:when>
				<c:otherwise>				
					<li><a class="menulink" href="#">일반유저</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>
</body>
</html>