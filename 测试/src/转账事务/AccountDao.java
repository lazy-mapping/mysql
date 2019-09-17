package 转账事务;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AccountDao {
	/**
	 * 修改指定用户的余额！
	 * @param name
	 * @param balance
	 */
	public void updateBalance(Connection con, String username, double money) {
		try {
			String sql = "update ar_account set money=money+? where username=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			/*
			 * 3. 对参数进行赋值
			 */
			pstmt.setDouble(1, money);
			pstmt.setString(2, username);
			/*
			 * 4. 执行之
			 */
			pstmt.executeUpdate();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
