<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>留言板</title>
</head>
<body><div align="center"  >
<h3>留言</h3>
		<form action="doMessage.jsp" method="post">
		留言给谁:<input type="text" name="author"><br><br>
		留言内容:<textarea rows="10" cols="30" name="content"></textarea><br><br>
		我的名称：<input type="text" name="name"><br><br>
		<input type="submit" value="我要留言">
		</form>
		<br><br>
		<a href="showMessage.jsp">查看留言</a> &nbsp
		<a href="">删除留言</a>
		 <h3><a href="student.jsp">返回</a></h3>
		</div>
</body>
</html>