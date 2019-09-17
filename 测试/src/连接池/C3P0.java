package 连接池;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * c3p0连接池，开源强大好用
 */
public class C3P0 {
	/**
	 * 代码配置
	 * @throws PropertyVetoException
	 * @throws SQLException
	 */
	//@Test
	public void fun1() throws PropertyVetoException, SQLException {
		// 创建连接池对象
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		// 对池进行四大参数的配置
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb1");
		dataSource.setUser("root");
		dataSource.setPassword("123");
		
		// 池配置，可以不写
		dataSource.setAcquireIncrement(5);//增量
		dataSource.setInitialPoolSize(20);//初始化大小
		dataSource.setMinPoolSize(2);//最小空闲连接
		dataSource.setMaxPoolSize(50);//最大连接
		
		Connection con = dataSource.getConnection();
		System.out.println(con);
		con.close();
	}
	
	/**
	 * 配置文件的默认配置
	 * 文件名必须是：c3p0-config.xml  且位置在src下
	 * @throws SQLException 
	 */
	@Test
	public void fun2() throws SQLException{
		/**
		 * 在创建连接池对象时，这个对象就会自动加载配置文件！不用我们来指定
		 */
		ComboPooledDataSource dataSource  = new ComboPooledDataSource();
		
		Connection con = dataSource.getConnection();
		System.out.println(con);
		con.close();
	}
	
	/**
	 * 使用命名配置信息
	 * @throws SQLException
	 */
	//@Test
	public void fun3() throws SQLException{
		/**
		 * 构造器的参数指定命名配置元素的名称！
		 * <named-config name="oracle-config"> 
		 */
		ComboPooledDataSource dataSource  = new ComboPooledDataSource("oracle-config");
		
		Connection con = dataSource.getConnection();
		System.out.println(con);
		con.close();
	}
}
