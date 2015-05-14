<%--
  Project: wizSpringMVC
  FileName: studentView  
  Date: 2015-05-14
  Time: 오후 4:27
  Author: Hadeslee 
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>
이름 : ${studentinfo.name}<br>
나이 : ${studentinfo.age}<br>
학년 : ${studentinfo.classNum}<br>
반 : ${studentinfo.gradeNum}
</body>
</html>