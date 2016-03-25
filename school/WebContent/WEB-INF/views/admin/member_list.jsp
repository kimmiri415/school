<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div id="detail">
	<div class="joinTop">
		<h2 class="text-center">전체학생 목록</h2>
	</div>
	<div class="joinCenter row">
		<table>
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>주소</td>
			<td>학번</td>
			<td>생년월일</td>
			<td>Java</td>
			<td>Sql</td>
			<td>Jsp</td>
			<td>Spring</td>
		</tr>
		
		
		</table>
		
		<div clas="input_button text-center">
			<button id="updateBtn">수정 폼 이동</button>
			<button id="deleteBtn">탈퇴하기</button>
		</div>
	</div>
</div>