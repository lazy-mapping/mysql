<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学生菜单</title>
</head>
<body ><div align="center" list-style:none;>
	<br><br>
		<%
		String type=request.getParameter("hu");
		String hu=request.getParameter("hu");
		String pwd=request.getParameter("pwd");
		%> 
		<h3>学生菜单</h3> 
	<br>		
 	  <a href="modifypwd.jsp?hu=<%=hu%>&pwd=<%=pwd%>">修改密码</a><br><br>	
	  <a href="showScope.jsp">查看全部成绩</a><br><br>
	  <a href="selectScope.jsp">按学号查询成绩</a><br><br>
	  <a href="message.jsp">留言板</a><br><br>
	  <a href="homePage.jsp">退出</a><br><br>
	   </div>
</body>
</html>