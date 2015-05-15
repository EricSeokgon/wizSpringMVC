<%--
  Project: wizSpringMVC
  FileName: createPage  
  Date: 2015-05-15
  Time: 오전 9:45
  Author: Hadeslee 
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>createPage</title>
</head>
<body>
createPage.jsp
<br>

<%
    String conPath = request.getContextPath();
%>

<form action="<%= conPath%>/student/create">
    이름 : <input type="text" name="name" value="${student.name}"><br>
    아이디 : <input type="text" name="id" value="${student.id}"><br>
    <input type="submit" value="전송">
</form>

</body>
</html>