<%@page contentType="text/html;charset=gbk" import="java.sql.*"%>
<html>
	<body>
		<%
		try{
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Test";
		Connection con =DriverManager.getConnection(url,"sa","1234");
		String sql="select * from TB";
		Statement sta=con.createStatement();
		ResultSet rs=sta.executeQuery(sql);
		while(rs.next()){
			out.print(rs.getString("sn0")+"&nbsp");
			out.print(rs.getString("sname")+"&nbsp");
			out.print(rs.getString("sage")+"<br>");
		}
			con.close();
		
		}catch(Exception e){
			out.print(e.getMessage());
			}
		%>
	</body>
</html>