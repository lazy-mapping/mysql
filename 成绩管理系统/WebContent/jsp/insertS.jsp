<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>添加成绩</title>
</head>
<body><div align="center"  >
			<h3>修改成绩</h3>
			<form action="writeScope.jsp" method="post" name="form">
			    学号：<input type="text" name="id" size="20" ><br><br>
			    姓名：<input type="text" name="name" size="20" ><br><br>
			    性别：<select  name="sex" >
			    			<option value="男" >  男 </option>
			    			<option value="女" >  女 </option>
			    	</select><br><br>
			    班级：<input type="text" name="classes" size="20" ><br><br>
			   JSP：<input type="text" name="js" size="20" ><br><br>
			数据库：<input type="text" name="sqlsever" size="20" ><br><br>
		    软件测试：<input type="text" name="test" size="20"><br><br>
			    英语：<input type="text" name="english" size="20" ><br><br>
			        <input type="radio" name="update" value="u" checked="ok">更新
			        <input type="radio" name="update" value="i">插入
				    <input type="radio" name="update" value="d">删除
				    <br><br>
				    <input type="submit" value="提交" >
			</form><br><br>
			 <h3><a href="teacher.jsp">返回</a></h3>
			</div>
</body>
</html>