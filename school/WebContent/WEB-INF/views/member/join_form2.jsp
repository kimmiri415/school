<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />

<div class="mg_auto" style="width: 1000px;">
	<form action="${context}/member/join.do">
		<h1>회원가입 폼</h1>
		<table>
			<tr>
				<td><h3>아이디 :</h3></td>
				<td><input type="text" name="id" value="" autofocus="autofocus"
					required="required" /></td>
			</tr>
			<tr>
				<td><h3>비밀번호 :</h3></td>
				<td><input type="password" name="password" value=""
					required="required" /></td>
			</tr>
			<tr>
				<td><h3>비밀번호확인 :</h3></td>
				<td><input type="password" name="passwordCheck" value=""
					required="required" /></td>
			</tr>
			<tr>
				<td><h3>이름 :</h3></td>
				<td><input type="text" name="name" value="" required="required" /></td>
			</tr>
			<tr>
				<td><h3>주소 :</h3></td>
				<td><input type="text" name="addr" value="" /></td>
			</tr>
			<tr>
				<td><h3>생년월일 :</h3></td>
				<td><input type="date" name="birth" value="" /></td>
			</tr>
		</table>
		<div>
			<input type="reset" value="취소" /> <input type="submit" value="회원가입" />  <input
				type="button" onclick="location='${context}/global/main.do'"
				value="홈으로">
		</div>
	</form>
</div>

<jsp:include page="../global/footer.jsp" />