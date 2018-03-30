<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tax Form</title>
</head>
<body>
	<h1 align="center">Tax Form</h1>
	<hr />
	<form action="tax" >
		<table cellpadding="10" bgcolor="#e3e3e3" style="margin:0 auto">
			<tr>
				<td>Employee Name</td>
				<td><input type="text" name="txtname"/></td>
			</tr>
			<tr>
				<td>Annual Income</td>
				<td><input type="text" name="txtincome"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="Calc Tax"/></td>	
			</tr>
		</table>

	</form>
</body>
</html>