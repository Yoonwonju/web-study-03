<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Addition</title>
</head>
<body>
<%
	int num1 = 20;
	int num2 = 30;
	int add = num1 + num2;
	out.print(num1  + " + " + num2 + " = " + add);
%>
<br>
<%=add %>
<br>
<%
	out.print(num1);
%>
</body>
</html>