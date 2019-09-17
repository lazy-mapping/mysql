package jdbc_mysql;

/**
 *PreapredStatement子接口；预编译。防止SQL攻击
 *优点，pstmp与sql模板绑定，先发送语句、参数给数据库并编译，二次使用直接执行
 *mysql预处理默认是 关闭的
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;

import org.junit.Test;

public class User {
	String driverClassName="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/mydb1?useServerPrepStmts=true&cachePrepStmts=true\";";
	String name="root";
	String pwd="1234";
	
	public boolean login(String username ,String password) throws Exception{
		Class.forName(driverClassName);
		Connection con= DriverManager.getConnection(url,name,pwd);
	   /**
	    *很早以前，有漏洞的语句
		*Statement stmt =con.createStatement();
		*String sql="select * from t_user where username='"+username+"' and password='"+password+"'";
		*ResultSet rs=stmt.executeQuery(sql);
		*/
		String sql="select * from t_user where username=? and password=?";
		PreparedStatement pstmt =con.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet rs=pstmt.executeQuery();//两个方法，发送查询语句
		return rs.next();
	}
	
	/**
	 * 登录
	 * 使用username和password去查询数据
	 * 若查出结果集，说明正确！返回true
	 * 若查出不出结果，说明用户名或密码错误，返回false
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception 
	 */
	@Test
	public void fun1() throws Exception{
		//SQL攻击语句，填写内容是 ：sql片段，而不是：字段值
		/*
		 * String username="a' or 'a'='a"; String password="a' or 'a'='a";
		 */
	    String username="zhangsan"; String password="123";
		boolean bool =login(username,password);
		System.out.println(bool);
	}
}
