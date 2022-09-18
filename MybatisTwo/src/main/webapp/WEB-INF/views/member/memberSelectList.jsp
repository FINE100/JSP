<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>멤버 전체 목록</h1></div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<td width="150" align="center">아이디</td>
					<td width="150" align="center">이 름</td>
					<td width="150" align="center">전화번호</td>
					<td width="150" align="center">권 한</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${members }" var="m"> 
					<tr onMouseover="this.style.backgroundColor='yellow';"
						onMouseout="this.style.backgroundColor='white';"
						onclick="selectMember('${m.memberId }')">
						<td>${m.memberId }</td>
						<td>${m.memberName }</td>
						<td>${m.memberTel }</td>
						<td>${m.memberAuthor }</td>
					</tr>		
				</c:forEach>
			</tbody>
		</table>		
	</div><br>
	<div>
		<button type="button" onclick="location.href='memberJoinForm.do'">멤버추가</button>&nbsp;&nbsp;
		<button type="button" onclick="location.href='main.do'">홈</button>
	</div>
	<div>
		<form id="frm" method="post">
			<input type="hidden" id="memberId" name="memberId">
		</form>
	</div>
</div>
<script type="text/javascript">
	function selectMember(id) {
		document.getElementById("memberId").value = id;
		frm.action = "memberSelect.do";
		frm.submit();
	}
</script>
=======
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<div>
			<h1>멤버 전체 목록</h1>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th width=" 150" align="center">아이디</th>
						<th width=" 150" align="center">패스워드</th>
						<th width=" 150" align="center">이 름</th>
						<th width=" 150" align="center">연락처</th>
						<th width=" 150" align="center">권 한</th>
					</tr>
				</thead>
				<tbody>
					<!-- memberList.java의 request.setAtrriubet("members", members)에서 "members" 부분 -->
					<!-- m의 의미. member[0] member[1].. 한 행씩 읽을 때 배열 대신 표현-->

					<c:forEach items="${members}" var="m">
						<tr onMouseover="this.style.backgroundColor='yellow';"
							onMouseout="this.style.backgroundColor='white';"
							onclick="selectMember('${m.memberId}')">
							<td align="center">${m.memberId }</td>
							<td align="center">${m.memberPassword }</td>
							<td align="center">${m.memberName }</td>
							<td align="center">${m.memberTel }</td>
							<td align="center">${m.memberAuthor }</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
		<br>
		<div>
			<button type="button" onclick="location.href='memberJoinForm.do'">멤버추가</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='main.do'">홈</button>

		</div>
		<!-- 화면에 안보이는 히든 폼. post방식으로 동작 되게끔 한다 -->
		<div>
			<form id="frm" method="post">
				<input type="hidden" id="memberId" name="memberId">
			</form>
			</div>
		</div>
 <script type="text/javascript">
		function selectMember(id){		//form의 name = id 
			document.getElementById("memberId").value = id;
			frm.action = "memberSelect.do";
			frm.submit();
	}
</script>


>>>>>>> branch 'master' of https://github.com/FINE100/JSP.git
</body>
</html>