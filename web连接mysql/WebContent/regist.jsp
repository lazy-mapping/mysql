<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function _change() {
	/*
	1. 获取img元素
	*/
	var imgEle = document.getElementById("imgEle");
	// 设置它的src为servlet
	imgEle.src = "<c:url value='/VerifyCodeServlet'/>?" + new Date().getTime();
}
</script>
  </head>
  
  <body>
<h1>注册页面</h1>
<%--
1. 显示表单页面
2. 显示服务器端的输入校验错误信息
3. 显示后台校验错误信息
4. 回显表单数据
 --%>
 <%--
 1. 在<img>元素中，让src指向一个VerifyCodeServlet，它会生成验证码图片并保存验证码文本到session中
 2. 在设置<img>的src之前，需要先在web.xml中配置Servlet
 
  --%>
<p style="color: red; font-size: 11pt; font-weight: 900;">${msg }</p>
<form action="<c:url value='/RegistServlet'/>" method="post">
	用户名：<input type="text" name="username" value="${form.username }"/>
		<span style="color: red; font-size: 10pt; font-weight: 900;">
			${errors.username }
		</span>
	<br/>
	密　码：<input type="password" name="password" value="${form.password }"/>
		<span style="color: red; font-size: 10pt; font-weight: 900;">
			${errors.password }
		</span><br/>
	确认密码：<input type="password" name="repassword" value="${form.repassword }"/>
		<span style="color: red; font-size: 10pt; font-weight: 900;">
			${errors.repassword }
		</span><br/>
	年　龄：<input type="text" name="age" value="${form.age }"/>
		<span style="color: red; font-size: 10pt; font-weight: 900;">
			${errors.age }
		</span><br/>
	性　别：<input type="text" name="gender" value="${form.gender }"/>
		<span style="color: red; font-size: 10pt; font-weight: 900;">
			${errors.gender }
		</span><br/>
	验证码：<input type="text" name="verifyCode" size="3" value="${form.verifyCode }"/>
		<img src="<c:url value='/VerifyCodeServlet'/>" id="imgEle"/>
		<a href="javascript:_change()">换一张</a>
		<span style="color: red; font-size: 10pt; font-weight: 900;">
			${errors.verifyCode }
		</span>
	<br/>
	<input type="submit" value="注册"/>
</form>
  </body>
</html>
