package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 处理页面的转发forward或重定向redirect
 * @author 王少彬。。。。
 *   运行步骤：先在servers上启动项目，然后运行该java程序，
 */
@SuppressWarnings("serial")
public class BServlet extends BaseServlet {
	public String fun1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("fun1()...转发，地址栏不变");
		return "/index.jsp";
	}

	public String fun2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("fun2()...重定向，地址栏变了");
		return "r:/index.jsp";
	}

	public String fun3(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("fun3()...空白版，地址栏不变");
		return null;
	}
}
