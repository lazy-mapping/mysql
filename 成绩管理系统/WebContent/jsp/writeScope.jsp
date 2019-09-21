<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<title>添加成绩</title>
</head>
<body>			
<%  
String upd=request.getParameter("update");
String idstring=request.getParameter("id").trim(); 
String namestring=request.getParameter("name").trim();
String sexstring=request.getParameter("sex").trim();
String classesstring=request.getParameter("classes").trim();
String jsstring=request.getParameter("js").trim();
String sqlseverstring=request.getParameter("sqlsever").trim();
String teststring=request.getParameter( "test").trim();
String englishstring=request.getParameter("english").trim();  

//构造 SQL 语句 
String sql=""; 
if(upd.equals("u")){  
	sql="UPDATE grade SET id="+idstring+",name="+namestring+",sex="+sexstring+",classes="+classesstring+","+jsstring+",sqlsever="+sqlseverstring+",test="+teststring+",english="+englishstring+"where id="+idstring;	
	}
 if(upd.equals("i")){
	sql="insert into grade (id,name,sex,classes,js,sqlsever,test,english) values("+idstring+","+namestring+","+sexstring+","+classesstring+","+jsstring+","+sqlseverstring+","+teststring+","+englishstring+")";
	}
if(upd.equals("d")){
	sql="DELETE FROM  grade WHERE id="+idstring;
	}
	String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Test";
	String name="sa";
	String pass="1234";
	try{
	Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
	Connection con =DriverManager.getConnection(url,name,pass);
	Statement stmt=con.createStatement();
	stmt.executeUpdate(sql); //执行增删改SQLDDL语句
	stmt.close(); 
	con.close(); 
	out.print("<script type='text/javascript'>alert('操作成功!');window.location.href='insertS.jsp';</script>");
	} catch(SQLException e) { 
		out.print(e);
		//out.print("<script type='text/javascript'>alert('修改失败!请重新输入');window.location.href='insertS.jsp';</script>");
		}
%>
</body>
</html>