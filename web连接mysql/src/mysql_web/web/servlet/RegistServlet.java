package mysql_web.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import mysql_web.domain.User;
import mysql_web.service.UserException;
import mysql_web.service.UserService;

/**
 * 处理注册请求！
 * @author cxf
 *
 */

public class RegistServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//处理post请求编码
		response.setContentType("text/html;charset=utf-8");//处理响应编码
		
		// 依赖service
		UserService userService = new UserService();
		
		/*
		 * 1. 一句封装
		 * 2. 前端校验
		 *   > 失败：向request域保存错误信息，转发到regist.jsp
		 * 3. 完成业务（调用UserService#regist()）
		 *   > 失败：向request域保存异常信息，转发到regist.jsp
		 * 4. 输出成功信息
		 */
		// 一句封装
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		/*
		 * 前端校验
		 * 使用map类型来做错误信息集！
		 * key为当前表单项名称，例如username、password
		 * value为错误信息
		 */
		// 创建错误集对象
		Map<String,String> errors = new HashMap<String,String>();
		
		/*
		 * 校验用户名
		 * 1. 非空校验：用户名不能为空！
		 * 2. 长度校验：用户名长度必须在3~15之间！
		 */
		String username = form.getUsername();
		if(username == null || username.trim().isEmpty()) {//非空校验
			errors.put("username", "用户名不能为空！");
		} else if(username.length() < 3 || username.length() > 15) {//长度校验
			errors.put("username", "用户名长度必须在3~15之间！");
		}
		
		// 校验密码
		String password = form.getPassword();
		if(password == null || password.trim().isEmpty()) {//非空校验
			errors.put("password", "密码不能为空！");
		} else if(password.length() < 3 || password.length() > 15) {//长度校验
			errors.put("password", "密码长度必须在3~15之间！");
		}
		
		// 校验确认密码
		String repassword = form.getRepassword();
		if(repassword == null || repassword.trim().isEmpty()) {//非空校验
			errors.put("repassword", "确认密码不能为空！");
		} else if(!password.equals(repassword)) {//是否相同校验
			errors.put("repassword", "两次密码输入不一致！");
		}
		
		// 校验年龄
		int age = form.getAge();
		if(age < 16 || age > 70) {
			errors.put("age", "年龄必须是16 ~ 70之间！");
		}
		
		//////////////////////////////////////////////////////
		
		/*
		 * 性别
		 */
		String gender = form.getGender();
		if(gender == null || gender.trim().isEmpty()) {//非空校验
			errors.put("gender", "性别不能为空！");
		} else if(!gender.equals("男") && !gender.equals("女")) {//性别校验
			errors.put("gender", "性别只能是\"男\"或\"女\"！");
		}
		
		/*
		 * 验证码
		 */
		String verifyCode = form.getVerifyCode();
		String session_vcode = (String)request.getSession().getAttribute("vCode");
		if(verifyCode == null || verifyCode.trim().isEmpty()) {//非空校验
			errors.put("verifyCode", "验证码不能为空！");
		} else if(!verifyCode.equalsIgnoreCase(session_vcode)) {
			errors.put("verifyCode", "验证码错误！");
		}
		
		/*
		 * 查看是否存在错误，若存在，把errors保存到request域
		 * 回显：把用户填写的表单数据，归还给页面，让页面显示！把form保存到request中
		 * 并转发到regist.jsp
		 */
		if(errors.size() > 0) {
			// 保存errors到request域
			request.setAttribute("errors", errors);
			// 保存表单数据，为了页面的回显
			request.setAttribute("form", form);
			// 转发到regist.jsp
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		
		/*
		 * 调用userService方法完成业务逻辑
		 */
		try {
			userService.regist(form);
			/*
			 * 执行到这里，说明注册成功！
			 *   输出“成功信息”
			 */
			response.getWriter().print("恭喜，注册成功！");
		} catch (UserException e) {
			/*
			 * 执行到这里，说明注册失败了！
			 *   获取异常信息，保存到request域，保存form到request域，转发回regist.jsp
			 */
			// 保存异常信息到request域
			request.setAttribute("msg", e.getMessage());
			// 保存表单数据，为了页面的回显
			request.setAttribute("form", form);
			// 转发到regist.jsp
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
	}
}
