package jdbc小工具;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

/**
 * dbutils工具包的应用     commons-dbutils-1.4.jar
 * @author 王少彬。。。。
 * getDataSource()连接数据库   在这里没有设置为成员变量，就是为了避免事务问题
 */
public class Dbutils {
	@Test
	public void update() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "insert into students values(?,?,?,?)";
		Object[] params = {1002, "liSi", 88, "female"};
		qr.update(sql, params);
	}
	
	@Test
	public void selectOne() throws SQLException {
		// 创建QueryRunner，需要提供数据库连接池对象
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from students where sid=?";
		Object[] params = {1001};
		// 执行query()方法，需要给出结果集处理器，即ResultSetHandler的实现类对象
		// 我们给的是BeanHandler，它实现了ResultSetHandler
		// 它需要一个类型，然后它会把rs中的数据封装到指定类型的javabean对象中，然后返回javabean
		Students stu = qr.query(sql, new BeanHandler<Students>(Students.class), params);
		
		System.out.println(stu);
	}
	
	/**
	 * BeanListHandler的应用，它是多行处理器
	 * 每行对象一个Stu对象！
	 * @throws Exception
	 */
	@Test
	public void selectAll() throws Exception {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from students";
		List<Students> stuList = qr.query(sql, new BeanListHandler<Students>(Students.class));
		
		System.out.println(stuList);
	}
	
	/**
	 * MapHandler的应用，它是单行处理器，把一行转换成一个Map对象，无序
	 * @throws SQLException 
	 */
	@Test
	public void selectMapOne() throws SQLException  {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from students where sid=?";
		Object[] params = {1001};
		Map<String, Object> map = qr.query(sql, new MapHandler(), params);
		
		System.out.println(map);
	}
	
	/**
	 * MapListHandler，它是多行处理器，把每行都转换成一个Map，即List<Map>
	 * @throws SQLException
	 */
	@Test
	public void selectMapAll() throws SQLException  {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from students";
		List<Map<String,Object>> mapList = qr.query(sql, new MapListHandler());
		
		System.out.println(mapList);
	}
	
	/**
	 * ScalarHandler，它是单行单列时使用，最为合适！
	 * @throws SQLException
	 */
	@Test
	public void count() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select count(*) from students";
		Number cnt = (Number)qr.query(sql, new ScalarHandler());
		/**
		 * cnt是未知类型：Integer、Long、BigInteger，因为驱动版本问题，其父类Number类型写上最安全
		 *后面转换为想要的类型，此处为long
		 */
		long c = cnt.longValue();
		
		System.out.println(c);
	}
}
