<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>验证</title>
</head>
<body>
		<%
		//String hu="02";
		//String pwd="123456";
		//String pwd="147258";
		String type=request.getParameter("user");
		String hu=request.getParameter("number");
		String pwd=request.getParameter("password");
		String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Test";
		String name="sa";
		String pass="1234";
		   try{
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			Connection con =DriverManager.getConnection(url,name,pass);
			Statement stmt=con.createStatement();
			String sql="select * from usersTable where InNo='"+hu+"' and InPwd='"+ pwd + "'";  
			ResultSet rs=stmt.executeQuery(sql);
			if( rs.next() )
				 response.sendRedirect(type+"?hu="+hu+"&"+"pwd="+pwd);
			else{
				con.close();
				out.print("<script type='text/javascript'>alert('账号或密码错误！请重新输入');window.location.href='homePage.jsp';</script>");	
			}
			}catch(Exception e){
				out.print(e);
			}  
		%>
</body>
</html>