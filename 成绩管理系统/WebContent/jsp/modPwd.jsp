<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*"%>
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
		String opwd=request.getParameter("oldpassword");
		String npwd=request.getParameter("newpassword");
		String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Test";
		String name="sa";
		String pass="1234";
		try{
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			Connection con =DriverManager.getConnection(url,name,pass);
			Statement stmt=con.createStatement();
			String sql="update usersTable set InPwd="+ npwd +"where InNo="+hu;  
			stmt.executeUpdate(sql);
			con.close();
			out.print("<script type='text/javascript'>alert('修改成功!');window.location.href='modifypwd.jsp';</script>");
			}catch(Exception e){
				out.print("<script type='text/javascript'>alert('修改失败!请重新输入');window.location.href='modifypwd.jsp';</script>");
				}
	 %></div>
</body>
</html>