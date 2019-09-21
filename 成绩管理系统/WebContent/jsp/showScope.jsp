<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" import="java.sql.*"%>
<html>
	<head>
		<title>查询成绩</title>
	</head>
	<body><br><br>
		<center>
			<h2>成绩查询</h2>
			<br>
<%
String dbName="Test";
String tbName="View_grade";
try{
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName="+dbName;
			Connection con =DriverManager.getConnection(url,"sa","1234");
			DatabaseMetaData dmd=con.getMetaData();
			/*product表有库名、库扩展名、表名、字段名*/
			ResultSet dmd_rs=dmd.getColumns(null,null,tbName,null);
			int col_count=0;
			out.print("<table border='1' align='center' width='50%'>");
			out.print("<tr>");
			while(dmd_rs.next()){ 
				col_count++;
				out.print("<th>"+dmd_rs.getString(4)+"</th>");
			 }
			out.print("</tr>");
			dmd_rs.close();
			Statement sta=con.createStatement();
			ResultSet rs=sta.executeQuery("select * from "+tbName);
			while(rs.next()){
					out.print("<tr align='center'>");
				for(int i=1;i<=col_count;i++)
					out.print("<td>"+rs.getString(i)+"</td>");
					out.print("</tr>");
			}
			con.close();
			out.print("</table>");
		}catch(Exception e){
			out.print(e);
			}
%>
			<h2><a href="student.jsp">返回</a></h2>
		</center>
	</body>
</html>