package jdbc小工具;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * 泛型  构造方法QR，作用就是初始化，即为对象的属性赋值
 * @param <T>
 */
public class QR<T> {

	private DataSource dataSource;
	public QR(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public QR() {
		super();
	}

	/**
	 * update方法：做insert、update、delete操作
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql, Object... params) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();//通过连接池得到连接对象

			pstmt = con.prepareStatement(sql);//使用sql创建pstmt
			initParams(pstmt, params);//设置参数
			
			return pstmt.executeUpdate();//执行
		} catch(Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(SQLException e1) {}
		}
	}
	
	/**
	 * 给参数(param) 赋值
	 * @param pstmt
	 * @param params
	 * @throws SQLException
	 */
	private void initParams(PreparedStatement pstmt, Object... params) 
			throws SQLException {
		for(int i = 0; i < params.length; i++) {
			pstmt.setObject(i+1, params[i]);
		}
	}
	
	/**
	 * query方法：可执行查询
	 * @param sql
	 * @param rh
	 * @param params
	 * @return 需要的类型（结果集-->表格）
	 */
	public T query(String sql, RsHandler<T> rh, Object... params) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();//通过连接池得到连接对象

			pstmt = con.prepareStatement(sql);//使用sql创建pstmt
			initParams(pstmt, params);//设置参数
			
			rs = pstmt.executeQuery();//执行
			
			return rh.handle(rs);
		} catch(Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(SQLException e1) {}
		}
	}
}

// 用来把结果集转换成需要的类型！
interface RsHandler<T> {
	public T handle(ResultSet rs) throws SQLException;
}
