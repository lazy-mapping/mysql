<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>查询成绩</title>
</head>
<body><div align="center"  >
	<h2>按学号查询成绩</h2>
	<br><br>
   <form action="idScope.jsp" method="post" name="form">
       学号<input type="text" name="id" size="20"><br><br>
       <input type="submit" value="提交">
    </form>
	<br><br>
	<a href="student.jsp">返回</a>
</div>
</body>
</html>