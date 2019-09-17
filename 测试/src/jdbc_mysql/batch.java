package jdbc_mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

/**
 * 批处理   mysql默认关闭批处理，url加上“?rewriteBatchedStatements\=true”
 * 统计记录           select count(*) from t_user;
 * 删除1万条记录  delete from t_user where username!="zhangsan";
 * 看表结构           describe t_user;
 */
public class batch {
	/**
	 * pstmt对象内部有集合
	 * 1. 用循环疯狂向pstmt中添加sql参数，它自己有模板，使用一组参数与模板罚没可以匹配出一条sql语句
	 * 2. 调用它的执行批方法，完成向数据库发送！
	 * @throws SQLException 
	 */
	@Test
	public void fun5() throws SQLException {
		/*
		 * pstmt：
		 * > 添加参数到批中
		 * > 执行批！
		 */
		Connection con = JdbcUtils.getConnection();
		String sql = "INSERT INTO t_user VALUES(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// 疯狂的添加10000条
		for(int i = 0; i < 10000; i++) {
			pstmt.setString(1, "姓名"+i+1);
			pstmt.setString(2, "stu_" + i);
			pstmt.setInt(3, i);
			pstmt.setString(4, i%2==0?"男":"女");
			
			pstmt.addBatch();//添加批！这一组参数就保存到集合中了。
		}
		long start = System.currentTimeMillis();
		pstmt.executeBatch();//执行批！
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);//处理时间412764, 301
	}
}
