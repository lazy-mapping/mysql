package 事务专用连接;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
/**
 * 支持事务
 * @author 王少彬。。。。
 *数据访问层
 */
public class AccountDao {
	public static void update(String name, double money) throws SQLException {
		// QueryRunner类简化SQL查询,可以看DButils_read中的介绍
		QueryRunner qr = new TxQueryRunner();
		String sql = "update ar_account set money=money+? where username=?";
		Object[] params = { money, name };
		// 我们需要自己来提供连接，保证多次调用使用的是同一个连接！
		qr.update(sql, params);
		/**
		 *   释放连接的操作被封装在TxQueryRunner中了
		 * Connection con=JdbcUtils.getConnection(); 
		 * qr.update(sql, params);
		 * JdbcUtils.releaseConnection(con);//调用完关闭
		 */
		}
}
