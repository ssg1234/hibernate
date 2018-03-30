<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Student Details For The Dept ${param.cbodept}</h1>
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
		<td>${s.stuId}</td>
		<td>${s.stuName}</td>
		<td>${s.marks}</td>
		<td>${s.dept}</td>
		<td><fmt:formatDate value="${s.dob}" pattern="dd/MM/yyyy"/></td>
	</tr>
</c:forEach>
</table>
<hr />
</body>
</html>