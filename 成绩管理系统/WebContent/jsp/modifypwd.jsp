<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改密码</title>
</head>
<body><div align="center"  >
<%
	String hu=request.getParameter("hu");
	String pwd=request.getParameter("pwd");
%>	<h2>修改密码</h2><br><br>
   <form action="modPwd.jsp" method="post" name="form">
       旧密码<input type="text" name="oldpassword" size="20"><br><br>
       新密码<input type="text" name="newpassword" size="20"><br><br>
       <input type="hidden" name="hu" value=<%=hu%>   id="hu">
       <input type="hidden" name="pwd" value=<%=pwd%>  id="pwd">
       <input type="submit" value="修改">
    </form>
	<br><br>
	<a href="student.jsp">返回</a>
</div>
</body>
</html>