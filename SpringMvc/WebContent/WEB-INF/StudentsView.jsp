<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">${title}</h1>
<hr size="2" style ="color:red"/>
<table cellpadding="10" bgcolor="wheat" style="margin: 0 auto">
<tr>
	<td><spring:message code="stuid"/></td>
	<td><spring:message code="stuname"/></td>
	<td><spring:message code="marks"/></td>
	<td><spring:message code="dept"/></td>
	<td><spring:message code="dob"/></td>
</tr>

<c:forEach items="${slist}" var="s">
	<tr>
		<td>${s.sid}</td>
		<td>${s.sname}</td>
		<td>${s.marks}</td>
		<td>${s.dept}</td>
		<td>${s.dob}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>