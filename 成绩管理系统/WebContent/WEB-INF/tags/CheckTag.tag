<%@ tag pageEncoding="gbk" import="java.sql.*" language="java"%>
<%@ attribute name="human" required="true" %>
<%@ attribute name="pwd" required="false" %>
<%@ variable name-given="ifright" scope="AT_END"%>
<% //连接数据库对象初始化
   String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Test";
   String name="sa";
   String pass="1234";
   //连接数据库
   try{
	Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
	Connection con =DriverManager.getConnection(url,name,pass);
	Statement stmt=con.createStatement();
	String sql="select * from usersTable ";
	ResultSet rs=stmt.executeQuery(sql);
	int ifright=0;
	while(rs.next()){
		if(human==rs.getString("InNo")){
			if(pwd==rs.getString("InPwd")){
				jspContext.setAttribute("ifright",0);
				break;
				}
			else
				jspContext.setAttribute("ifright",1);
			}
		else
			jspContext.setAttribute("ifright",2); 
		}
	con.close();
	}catch(Exception e){
		out.print(e.getMessage());
	}
%>
