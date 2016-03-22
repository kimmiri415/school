<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />

<div class="mg_auto" style="width: 1000px;">
	<h1>detail 페이지</h1>
	<table border="1">
		<tr>
			<td rowspan="4"></td>
			<td><h4>아이디</h4></td>
			<td><input type="text" name="id" value="" /></td>
		</tr>
		<tr>
			<td><h4>이름</h4></td>
			<td><input type="text" name="name" value="" /></td>
		</tr>
		<tr>
			<td><h4>비밀번호</h4></td>
			<td><input type="password" name="password" value="" /></td>
		</tr>
		<tr>
			<td><h4>주소</h4></td>
			<td><input type="text" name="addr" value="" /></td>
		</tr>
		<tr>
			<td><input type="file" name="file" value="" /></td>
			<td><h4>생년월일</h4></td>
			<td><input type="date" /></td>
		</tr>
	</table>

	<div>
		<form action="${context}/grade/my_grade.do">
			<input type="submit" value="내 성적 보기" />
		</form>
	</div>
	<form action="${context}/global/main.do">
		<input type="submit" value="로그아웃" name="logout" />
	</form>
</div>
<jsp:include page="../global/footer.jsp" />