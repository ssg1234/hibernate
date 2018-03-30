<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="HeadSection.jsp" %>
<body>
	<%@include file="Header.jsp" %>
		<section>
			<h2>Employee Details</h2>
			<div align="center">Page: ${param.pno}</div>
			<table id="tlist">
				<tr>
				<th>Employee Img</th>
				<th>Employee ID</th>
				<th>Employee Name</th>
				<th>Salary</th>
				<th>Department</th>
				</tr>
				
				<c:forEach items="${elist}" var="e">
				<tr>
				
					<td><img src="viewimg?imgname=${e.img}" height="75" width="75"/></td>
					<td>${e.empId}</td>
					<td>${e.empName}</td>
					<td>${e.sal}</td>
					<td>${e.dept.deptName}</td>	
					
				</tr>
				
				</c:forEach>
				
			</table>
			<div align="center" id="home" style="margin-top: 10px">
			<c:if test="${param.pno gt 1}">
				<a href="${pgurl}pno=${param.pno-1}">prev</a>
			    	
			</c:if>
			
			<c:if test="${param.pno lt lastpg}">
			    	<a href="${pgurl}pno=${param.pno+1}">next</a>
			</c:if>
			</div>
		</section>
	<%@include file="Footer.jsp" %>
</body>
</html>