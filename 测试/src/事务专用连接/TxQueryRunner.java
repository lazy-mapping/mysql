package 事务专用连接;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

/**
 * 此处重写了父类部分方法【不含Connection参数】，达到释放连接的效果
 * 通过JdbcUtils.getConnection()得到连接！有可能是事务连接，也可能是普通的连接！
 * JdbcUtils.releaseConnection()自动完成对连接的释放！如果是普通连接，关闭之！
 *
 */
public class TxQueryRunner extends QueryRunner {
	@Override
	public int[] batch(String sql, Object[][] params) throws SQLException {
		/*
		  *  批处理
		 * 1. 得到连接 2. 执行父类super方法，传递连接对象 3. 释放连接 4. 返回值
		 */
		Connection con = JdbcUtils.getConnection();
		int[] result = super.batch(con, sql, params);
		JdbcUtils.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, Object param, ResultSetHandler<T> rsh) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		T result = super.query(con, sql, param, rsh);
		JdbcUtils.releaseConnection(con);
		return result;
	}


	@Override
	public <T> T query(String sql, Object[] params, ResultSetHandler<T> rsh) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		T result = super.query(con, sql, params, rsh);
		JdbcUtils.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		T result = super.query(con, sql, rsh, params);
		JdbcUtils.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		T result = super.query(con, sql, rsh);
		JdbcUtils.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		int result = super.update(con, sql);
		JdbcUtils.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql, Object param) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		int result = super.update(con, sql, param);
		JdbcUtils.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql, Object... params) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		int result = super.update(con, sql, params);
		JdbcUtils.releaseConnection(con);
		return result;
	}
}
