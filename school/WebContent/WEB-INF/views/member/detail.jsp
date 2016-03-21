<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="<%=request.getContextPath()%>"></c:set>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Document</title>
</head>
<body>
	
	<form action="${context}/global/main.do">
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
		<input type="submit" value="로그아웃" name="logout" />
	</form>
</body>
</html>