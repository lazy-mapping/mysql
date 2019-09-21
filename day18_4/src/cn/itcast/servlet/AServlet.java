package cn.itcast.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * 获取JNDI的资源(java命名和目录接口，服务器上配置资源)
 * @author cxf
 *
 */
public class AServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 创建JNDI的上下文对象
		 */
		try {
			
			Context cxt = new InitialContext();
			
			// 2查询出入口
			//Context envContext = (Context)cxt.lookup("java:comp/env");
			// 3. 再进行二次查询，找到我们的资源
			// 使用的是名称与<Resource>元素的name对应
			//DataSource dataSource = (DataSource)envContext.lookup("jdbc/dataSource");
			//合并为一句
			DataSource dataSource = (DataSource)cxt.lookup("java:comp/env/jdbc/dataSource");
			
			Connection con = dataSource.getConnection();
			System.out.println(con);
			
			con.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
