<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>멤버 가입</h1>
		</div>
		<div>
			<form id="frm" action="memberInsert.do" onsubmit="return formCheck()"
				method="post">
				<div>
					<table border="1">

						<tr>
							<th width="150">아이디</th>
							<td width="280"><input type="text" id="memberId"
								name="memberId" required="required">
								<button type="button" id="btn" value="No" onclick="idCheck()">중복체크</button></td>

						</tr>
						<tr>
							<th>패스워드</th>
							<td><input type="password" id="memberPassword"
								name="memberPassword" required="required"></td>
						</tr>
						<tr>
							<th>패스워드 확인</th>
							<td><input type="password" id="pwc" name="pwc"
								required="required"></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><input type="text" id="memberName" name="memberName"></td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td><input type="tel" id="memberTel" name="memberTel"></td>
						</tr>
					</table>
				</div>
				<br>
				<div>
					<input type="hidden" name="memberAuthor" value="USER"> 
					<input type="submit" value="등록">&nbsp;&nbsp; 
					<input type="reset" value="취소">&nbsp;&nbsp; 
					<input type="button" value="목록" onclick="location.href ='memberSelectList.do'">

				</div>
			</form>

		</div>

	</div>
	<script type="text/javascript">
		function formCheck() {
			let pass1 = document.getElementById("memberPassword").value;
			let pass2 = document.getElementById("pwc").value;

			let idChecked = document.getElementById("btn").value;
			if (idChecked == 'No') {
				alert("아이디 중복체크를 해주세요.");
				return false;
			}

			if (pass1 != pass2) {
				alert("패스워드가 일치하지 않습니다.");
				document.getElementById("memberPassword").value = "";
				document.getElementById("pwc").value = "";
				document.getElementById("memberPassword").focus();
				return false;

			}

			return true;
		}

		// Ajex를 이용해서 id 중복체크를 한다. 
	function idCheck() {
			let id = document.getElementById("memberId").value;

/*			const xhttp = new XMLHttpRequest();
			xhttp.onload = function() {
				if (this.readyState == 4 && this.status == 200) {
					 responseResult(this.response);
				}
			}

			xhttp.open("GET", "ajaxMemberIdCheck.do?id=" + id);
			xhttp.send(); */

			//fetch를 사용한 ajax
			fetch('ajaxMemberIdCheck.do?id' + id)
			.then(response => response.text()) 
			.then(data=> responseResult(data));			
		}
		
		function responseResult(data) { //fetch 처리 call Back 
					if (data == '1') {
					alert("사용할 수 있는 아이디입니다.");
					document.getElementById("btn").value = "Yes";// 버튼 누르면 콘솔창에서 button 소스 value=yes 로 변해있음
					document.getElementById("memberPassword").focus();
				} else {
					alert("사용할 수 없는 아이디입니다.")
					document.getElementById("memberId").value = "";
					document.getElementById("memberId").focus();
				}
			
		}
	</script>
</body>
</html>