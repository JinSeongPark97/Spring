<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 아래 3개는 같은 방식에 해당함. -->
결과는 ${msg}<br>
결과는 ${requestScope.msg}<br>
<%
String ss = (String)request.getAttribute("msg");
out.println("결과는 " + ss);
%>
</body>
</html>