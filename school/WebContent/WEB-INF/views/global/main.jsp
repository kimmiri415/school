<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="<%=request.getContextPath()%>"></c:set>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>main</title>
</head>
<title>메인화면</title>
</head>
<body>
	<a href="${context}/member/login_form.do">로그인 화면 이동</a>
</body>
</html>
