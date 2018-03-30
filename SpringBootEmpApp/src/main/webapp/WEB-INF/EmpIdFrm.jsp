<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="HeadSection.jsp" %>
<body>
<%@include file="Header.jsp" %>
<section>

<h2>View Employee By Id</h2>
<form action="viewbyid" align="center">
	Employee Id: <input type="text" name="txteid"/>
	<input type="submit" value="search"/>

</form>
</section>

<%@include file="Footer.jsp" %>
</body>
</html>