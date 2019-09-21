<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 	<%	
	    String  o_au=request.getParameter("author");
		String au=new String(o_au.getBytes("iso8859-1"),"utf-8");
		String  o_na=request.getParameter("name");
		String na=new String(o_au.getBytes("iso8859-1"),"utf-8");
		String _con=request.getParameter("content");
		String con=new String(_con.getBytes("iso8859-1"),"utf-8");
		if(au==null || con==null)
			response.sendRedirect("message.jsp");
		else if(au.trim().length()==0 || con.trim().length()==0)
			response.sendRedirect("message.jsp");
		else{
		Date d=new  Date();
		SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now=sdf.format(d);
		String msg=au+"@#@"+con+"@#@"+now+"@#@"+na;
		Object obj=application.getAttribute("box");
		ArrayList<String>al_msgs=null;
		if(obj==null){
			al_msgs=new ArrayList<String>();
			al_msgs.add(msg);
			application.setAttribute("box",al_msgs);
		}else{
			al_msgs=(ArrayList<String>)obj;
			al_msgs.add(msg);
		}
		response.sendRedirect("showMessage.jsp");
		}
		%>
</body>
</html>