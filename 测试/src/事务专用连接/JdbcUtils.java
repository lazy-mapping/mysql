package 事务专用连接;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 第三次修改版本，比较健壮
 * @author 王少彬。。。。
 *
 */
public class JdbcUtils {
	// 配置文件的默认配置！要求你必须给出c3p0-config.xml！！！
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

	// 它是事务专用连接【线程-连接-映射】。每个线程（通过其get或set方法）有自己独立初始化的变量副本
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	/**
	 * 使用连接池返回一个连接对象
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection con = tl.get();
		// 当con不等于null，说明已经调用过beginTransaction()，表示开启了事务！
		if (con != null)
			return con;
		return dataSource.getConnection();
	}

	/**
	 * 返回连接池对象！
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * 开启事务 
	 * @throws SQLException
	 *  保证dao中使用的连接是刚刚创建的！ 还要让commitTransaction或rollbackTransaction可以获取到！
	 */
	public static void beginTransaction() throws SQLException {
		Connection con = tl.get();
		if (con != null)
			throw new SQLException("已经开启了事务，就不要重复开启了！");
		con = getConnection();// 给con赋值，表示事务已经开始了
		con.setAutoCommit(false);//给con设置为手动提交！

		tl.set(con);// 把当前线程的连接保存起来，即保存当前事务线程副本！
	}

	/**
	 * 提交事务 
	 * @throws SQLException
	 *  获取beginTransaction提供的Connection，然后调用commit方法 
	 */
	public static void commitTransaction() throws SQLException {
		Connection con = tl.get();// 获取当前线程的专用连接
		if (con == null)
			throw new SQLException("还没有开启事务，不能提交！");
		con.commit();
		con.close();//连接归还连接池了，并未关闭
		// 把它设置为null，表示事务已经结束了！
		tl.remove();// 从tl中移除连接，关闭事务
	}

	/**
	 * 提交事务 
	 * @throws SQLException
	  * 获取beginTransaction提供的Connection，然后调用rollback方法
	 */
	public static void rollbackTransaction() throws SQLException {
		Connection con = tl.get();
		if (con == null)
			throw new SQLException("还没有开启事务，不能回滚！");
		con.rollback();
		con.close();
		tl.remove();
	}

	/**
	 * 释放连接
	 * @param connection
	 * @throws SQLException
	 */
	public static void releaseConnection(Connection connection) throws SQLException {
		Connection con = tl.get();
		/**
		  *  如果con == null即没有事务，那么connection一定不是事务专用的！
		 *   如果con != null即有事务，那么需要判断参数连接是否与【当前事务专用连接】con不等
		 */
		if (con == null)
			connection.close();
		if (con != connection)
			connection.close();
	}
}
