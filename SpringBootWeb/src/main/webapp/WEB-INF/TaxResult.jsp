<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">TaxResult</h1>
	
	<table cellpadding="10" bgcolor="#e3e3e3" style="margin:0 auto">
			<tr>
				<td>Employee Name</td>
				<td>${param.txtname}</td>
			</tr>
			<tr>
				<td>Annual Income</td>
				<td>${param.txtincome}</td>
			</tr>
			<tr>
				<td>Tax to be paid</td>
				<td>${taxresult}</td>
			</tr>
		</table>
</body>
</html>