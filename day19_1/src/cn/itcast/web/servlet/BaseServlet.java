package cn.itcast.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 抽象类 BaseServlet继承自HttpServlet(servlet请求对象，servlet响应对象)
 * 通过一个【参数】，可以解决用户想要在【一个页面】处理【不同请求】的问题
 * @author 王少彬。。。。
 */
@SuppressWarnings("serial")
public abstract class BaseServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp)
									throws ServletException, IOException {
		/**
		 * 设置参数method，用来获取用户的请求【AServlet中的一个方法】
		 */
		String methodName = req.getParameter("method");
		if(methodName == null || methodName.trim().isEmpty()) {
			throw new RuntimeException("您没有传递method参数！无法确定您想要调用的方法！");
		}
		/**
		 * 通过反射来调用方法，首先得到当前类的class对象，通配泛型
		 */
		Class<?  extends BaseServlet> c = this.getClass();  
		Method method = null;  	
		try {
			/**
			 * getMethod,返回一个方法对象，它反映此表示的类或接口的指定公共成员方法类对象。
			 */
			method = c.getMethod(methodName, 
					HttpServletRequest.class, HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("您要调用的方法：" + methodName + "(HttpServletRequest,HttpServletResponse)，它不存在！");
		}
		
		
		try {
			/**
			 * invoke, 在具有指定参数的方法对象上调用此方法对象表示的基础方法,
			 *   返回一个原始类型的数组。
			 */
			String result = (String)method.invoke(this, req, resp);
			/**
			 * 符串不为null或""，就帮它完成转发或重定向！
			 */
			if(result == null || result.trim().isEmpty()) {
				return;
			}
			//查看返回的字符串中是否包含冒号
			if(result.contains(":")) {
				int index = result.indexOf(":");//获取冒号的位置
				String s = result.substring(0, index);//截取出前缀，表示操作(f转发，r重定向)
				String path = result.substring(index+1);//截取出后缀，表示路径
				if(s.equalsIgnoreCase("r")) {
					resp.sendRedirect(req.getContextPath() + path);
				} else if(s.equalsIgnoreCase("f")) {
					req.getRequestDispatcher(path).forward(req, resp);
				} else {
					throw new RuntimeException("你指定的操作：" + s + "，当前版本还不支持！");
				}
			} else {
				//若没有冒号默认为转发！
				req.getRequestDispatcher(result).forward(req, resp);
			}
		} catch (Exception e) {
			System.out.println("您调用的方法：" + methodName + ",　它内部抛出了异常！");
			throw new RuntimeException(e);
		}
	}
}
