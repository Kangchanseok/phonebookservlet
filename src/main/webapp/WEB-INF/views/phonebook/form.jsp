<%@page import="phonebook.vo.PhoneBookVo"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<PhoneBookVo> list = (List<PhoneBookVo>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PhoneBook (Model 2)</title>
</head>
<body>

	<h1>주소록</h1>
	
	<form>검색어<input type="hidden" name="a" value="find" />
		<input type="text" name="name" id="name" />
		<input type="submit" value="검색" />
	
	<table border="1">
	<style type="text/css">
		th {width:200px;text-alingn:left; background-color:skyblue; color:white}</style>
		<tr >
			<th>이름</th>
			<th>휴대전화</th>
			<th>집전화번호</th>
			<th>도구</th>
		</tr>
	</table>
	<% for (PhoneBookVo vo: list) { %>
	<table border="1">
		<style type="text/css">
		td {width:200px;text-alingn:center; background-color:gray; color:white}</style>
		
		<tr>
			<td><center><%= vo.getName() %></center></td>
			<td><center><%= vo.getPhoneNum() %></center></td>
			<td><center><%= vo.getTel() %></center></td>
			<td colspan="2">
				<center><form action="<%= request.getContextPath() %>/pb"
					method="POST">
					<input type="hidden" name="a" value="delete" />
					<input type="hidden" name="no" value="<%= vo.getNo() %>" />	
					<input type="submit" value="삭제" /></form></center>
				</form>
			</td>
		</tr>
	</table>
	<br />
	<% } %>

	<p>
		<a href="<%= request.getContextPath() %>/pb?a=index">새 주소 추가</a>
	</p>
	
</body>
</html>