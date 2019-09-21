<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
			Object obj=application.getAttribute("box");
			if(obj==null)
				response.sendRedirect("message.jsp");
			ArrayList<String> al=(ArrayList<String>)obj;
			out.print("<table border='1' width='50%' align='center'>");
			out.print("<td width='10%'>序号</td>");
			out.print("<td width='20%'>收到留言</td>");
			out.print("<td >内容</td>");
			out.print("<td width='20%'>时间</td>");
			out.print("<td width='20%'>留言的人</td>");
			out.print("</tr>");
			int index=0;
			for(int i=al.size()-1;i>0;i--){
				out.print("<tr align='center'>");
				String msg=al.get(i);
				String[] sub_msgs=msg.split("@#@");
				index++;
				out.print("<td width='10%'>"+index+"</td>");
				out.print("<td width='20%'>"+sub_msgs[0]+"</td>");
				out.print("<td >"+sub_msgs[1]+"</td>");
				out.print("<td width='20%'>"+sub_msgs[2]+"</td>");
				out.print("<td width='20%'>"+sub_msgs[3]+"</td>");
				out.print("</tr>");
			}
			out.print("</table>");
		%>
		<h3><a href="message.jsp">返回</a></h3>
</body>
</html>