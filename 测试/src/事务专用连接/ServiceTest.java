package 事务专用连接;

import java.sql.SQLException;
import org.junit.Test;
/**
 * 业务层，测试
 * @author 王少彬。。。。
 *
 */
public class ServiceTest {
	@Test
	public void serviceMethod() throws Exception {
		try {
			JdbcUtils.beginTransaction();
			
			AccountDao.update("黄福财", -100);
		    //if(true) throw new RuntimeException("测试异常处理，表格ar_account无变化");
			AccountDao.update("许继龙", 100);
			
			JdbcUtils.commitTransaction();
		} catch (Exception e) {
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
			}
			throw e;
		}
	}
}
