package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AServlet extends BaseServlet{
	public void addUser(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException, IOException{
		System.out.println("addUser()...");
		throw new IOException("测试一下，父类会抛出异常！！！");
	}
	
	public void editUser(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
				System.out.println("editUser()...");
	}
	
	public void deleteUser(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
				System.out.println("deleteUser()...");
	}
	
	public void loadUser(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
				System.out.println("loadUser()...");
	}
}
