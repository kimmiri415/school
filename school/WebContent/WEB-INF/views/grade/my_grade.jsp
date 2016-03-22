<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
	<div class="mg_auto" align="center">
		<h1>내 성적관리 페이지</h1>
		<table border="1">
				<tr>
					<td><h4>과목</h4></td>
					<td><h4>점수</h4></td>
				</tr>
				<tr>
					<td><h5>JAVA</h5></td>
					<td>${score.java}</td>
				</tr>
				<tr>
					<td><h5>JSP</h5></td>
					<td>${score.jsp}</td>
				</tr>
				<tr>
					<td><h5>SQL</h5></td>
					<td>${score.sql}</td>
				</tr>
				<tr>
					<td><h5>Spring</h5></td>
					<td>${score.spring}</td>
				</tr>
		</table>
	</div>
<jsp:include page="../global/footer.jsp" />