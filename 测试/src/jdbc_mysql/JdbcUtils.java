package jdbc_mysql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * 一般形式的连接工具，增强版在：jdbc小工具  
 * @author 王少彬。。。。
 *
 */
public class JdbcUtils {
	private static Properties props = null;
	//静态代码块只执行一次
	static {
		// 给props进行初始化，即加载dbconfig.properties文件到props对象中
		try {
			InputStream in=JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			props = new Properties();
			props.load(in);
		}catch(IOException e){
			throw new RuntimeException(e);
		}
		try {
			Class.forName(props.getProperty("driverClassName"));
		}catch(ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(props.getProperty("url"),
				props.getProperty("username"),
				props.getProperty("password"));
	}
}
