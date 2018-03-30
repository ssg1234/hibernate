<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
.err{
     color:red;
    }
</style>
</head>
<body>
<h1 align="center">Calculate Interest</h1>
<hr/>
<sf:form action="calccomp" modelAttribute="ibean" method="post">
		<table cellpadding="10" bgcolor="#e3e3e3" style="margin:0 auto">
			<tr>
				<td>Principle Amount</td>
				<td><sf:input path="amt"/></td>
				<td><sf:errors path="amt" element="div" cssClass="err"/></td>
			</tr>
			<tr>
				<td>Years</td>
				<td><sf:input path="years"/></td>
				<td><sf:errors path="years" element="div" cssClass="err"/></td>
			</tr>
			<tr>
				<td>Rate Of Interest</td>
				<td><sf:input path="rate"/></td>
				<td><sf:errors path="rate" element="div" cssClass="err"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="Calc Interest"/></td>
				
			</tr>
		</table>

	</sf:form>
</body>
</html>