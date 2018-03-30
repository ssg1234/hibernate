<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">View Student By Dept</h1>
	<hr />
	<div style="width:200px;margin: 0 auto">
		<form action = "students">
		Choose Department
		<select name="cbodept">
			<option value ="ece">ece</option>
			<option value ="cse">cse</option>
		</select>
		<input type ="submit" value ="search"/>
		</form>
	</div>
</body>
</html>