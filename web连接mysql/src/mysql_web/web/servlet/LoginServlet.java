package mysql_web.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import mysql_web.domain.User;
import mysql_web.service.UserException;
import mysql_web.service.UserService;

/**
 * 处理登录请求
 * 它是web层，所有与web相关的内容可以出现在这里！
 * 例如；request、repsonse、ServletContext，它们只能出现在web层！
 *
 */

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 依赖service
		UserService userService = new UserService();
		
		/*
		 * 1. 一句封装
		 * 把Map转换成指定类型的Bean对象。通常用来获取表单数据（request.getParameterMap()）封装到JavaBean中
		 */
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		/*
		 * 2. 输入校验（略）
		 */
		/*
		 * 3. 调用userService的login()方法，完成业务
		 */
		try {
			User user = userService.login(form);
			/*
			 * 执行到这里，说明登录成功了
			 */
			// 保存当前用户到session中
			request.getSession().setAttribute("session_user", user);
			// 重定向到index.jsp
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} catch (UserException e) {
			/*
			 * 执行到这里，说明登录失败
			 * 1. 保存异常信息、form，到reuqest域
			 * 2. 转发到login.jsp
			 */
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
	}
}
