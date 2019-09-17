package 连接池;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

/**
 * DBCP连接池，没有C3P0的好用
 * @author 王少彬。。。。
 *
 */
public class dbcp {
	@Test
	public void fun1() throws SQLException {
		/*
		 * 1. 创建连接池对象
		 * 2. 配置四大参数
		 * 3. 配置池参数
		 * 4. 得到连接对象
		 */
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb1");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		
		Connection con = dataSource.getConnection();
		System.out.println(con.getClass().getName());
		Connection con1 = new MyConnection(con);
		System.out.println(con1.getClass().getName()+"  --->被包装过了");
		
		/**
		 * 连接池内部使用四大参数创建了连接对象！即mysql驱动提供的Connection
		 * 连接池使用mysql的连接对象进行了装饰，只对close()方法进行了增强！
		 * 装饰之后的Connection的close()方法，用来把当前连接归还给池！
		 */
		con1.close();//把连接归还给池！
	}
}
/**
 * 	装饰流用于文件加密的例子	
 * @author 王少彬。。。。
 *
 */
class MyInputStream extends InputStream {
			private InputStream in;
			private int key;
			
			public MyInputStream(InputStream in, int key){
				this.in = in;
				this.key = key;
			}
		
			@Override
			public int read() throws IOException {
				return this.in.read() - key;
			}
}