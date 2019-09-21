<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>成绩管理系统</title>
</head>
<body><div align="center"  >
<br><br>
			<h3>成绩管理系统</h3>
			<form action="check.jsp" method="post" name="form">
			    账号：<input type="text" name="number" size="20" ><br><br>
			    密码：<input type="password" name="password" size="20"><br><br>
			        <input type="radio" name="user" value="teacher.jsp">教师
				    <input type="radio" name="user" value="student.jsp" checked="ok">学生
				    <br><br>
				    <input type="submit" value="登录" >
			</form>
			<br></div>
</body>
</html>