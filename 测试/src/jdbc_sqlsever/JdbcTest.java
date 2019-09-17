package jdbc_sqlsever;


import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;


public class JdbcTest {
	@Test
	public  void main(){ 
		try{
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Test";
			Connection con =DriverManager.getConnection(url,"sa","1234");
			System.out.println(con+"测试连接是否成功");
		}catch(Exception e){
			throw new RuntimeException(e);//ClassNotFoundException,SQLException
			} 
	}
}


