<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록Servlet</title>
<style type="text/css">
table{border-collapse:collapse}
td{width:200px;height:20px;text-alingn:left; background-color:skyblue}</style>
</head>

<body>
	<h1>찬석 주소록</h1>
	<p>검색어<input type="text" name="email" id="email" />
	<input type="submit" value="검색" /></p>
	<table>
	<tr>
		<td>이름</td>
		<td>휴대전화</td>
		<td>전화번호</td>
		<td>도구</td>
	</tr>
	</table>
	<p>
	<a href="<%= request.getContextPath() %>/pb?a=index">새 주소 추가</a>
	</p>
</body>

</html>