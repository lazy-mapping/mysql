package jdbc_mysql;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class JdbcUtilsTest {
	@Test
	public void fun() throws SQLException{
		Connection con =JdbcUtils.getConnection();
		System.out.println(con);
	}
}
