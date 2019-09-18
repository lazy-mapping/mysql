package mysql_web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mysql_web.domain.User;

/**
 * 针对数据库的实现
 * @author cxf
 *
 */
public class JdbcUserDaoImpl implements UserDao {
	@Override
	public void addUser(User form) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			/*
			 * 一、得到连接
			 */
			con = JdbcUtils.getConnection();
			/*
			 * 二、准备sql模板，得到pstmt
			 */
			String sql = "INSERT INTO t_user VALUES(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			/*
			 * 三、为pstmt中的问号赋值
			 */
			pstmt.setString(1, form.getUsername());
			pstmt.setString(2, form.getPassword());
			pstmt.setInt(3, form.getAge());
			pstmt.setString(4, form.getGender());
			
			/*
			 * 四、执行之
			 */
			pstmt.executeUpdate();
		} catch(Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(SQLException e) {}
		}
	}

	@Override
	public User findByUsername(String username) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			/*
			 * 一、得到连接
			 */
			con = JdbcUtils.getConnection();
			/*
			 * 二、准备sql模板，得到pstmt
			 */
			String sql = "SELECT * FROM t_user WHERE username=?";
			pstmt = con.prepareStatement(sql);
			/*
			 * 三、为pstmt中的问号赋值
			 */
			pstmt.setString(1, username);
			
			/*
			 * 四、执行之
			 */
			rs = pstmt.executeQuery();
			
			/*
			 * 五、把rs转换成User类型，返回！
			 */
			if(rs == null) {
				return null;
			}
			if(rs.next()) {
				//转换成User对象，并返回
				// ORM --> 对象关系映射！ hibernate!是另一个关系管理工具
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAge(rs.getInt("age"));
				user.setGender(rs.getString("gender"));
				return user;
			} else {
				return null;
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(SQLException e) {}
		}
	}
}
