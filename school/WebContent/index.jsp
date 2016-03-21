<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="<%=request.getContextPath()%>"></c:set>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>index</title>
</head>
<body>
	<a href="${context}/global/main.do">홈으로</a>
</body>
</html>
