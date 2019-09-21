package web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import domain.Customer;
import service.CustomerService;

/**
 * Web层
 * @author cxf
 *
 */
@SuppressWarnings("serial")
public class CustomerServlet extends BaseServlet {
	private CustomerService customerService = new CustomerService();
	
	/**
	 * 添加客户
	 */
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 封装表单数据到Customer对象
		 * 2. 补全：cid，使用uuid
		 * 3. 使用service方法完成添加工作
		 * 4. 向request域中保存成功信息
		 * 5. 转发到msg.jsp
		 */
		Customer c = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		c.setCid(CommonUtils.uuid());
		customerService.add(c);
		request.setAttribute("msg", "恭喜，添加客户成功！");
		return "f:/msg.jsp";
	}
	
	/**
	 * 查询所有
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 调用service得到所有客户
		 * 2. 保存到request域
		 * 3. 转发到list.jsp
		 */
		request.setAttribute("cstmList", customerService.findAll());
		return "f:/list.jsp";
	}
	
	/**
	 * 编辑之前的加载工作
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String preEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 获取cid
		 * 2. 使用cid来调用service方法，得到Customer对象
		 * 3. 把Customer保存到request域中
		 * 4. 转发到edit.jsp显示在表单中
		 */
		String cid = request.getParameter("cid");
		Customer cstm = customerService.load(cid);
		request.setAttribute("cstm", cstm);
		return "f:/edit.jsp";
	}
	
	/**
	 * 编辑方法
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 封装表单数据到Customer对象中
		 * 2. 调用service方法完成修改
		 * 3. 保存成功信息到request域
		 * 4. 转发到msg.jsp显示成功信息
		 */
		// 已经封装了cid到Customer对象中
		Customer c = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		customerService.edit(c);
		request.setAttribute("msg", "恭喜，编辑客户成功！");
		return "f:/msg.jsp";
	}
	
	public String query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 封装表单数据到Customer对象中，它只有四个属性（cname、gender、cellphone、email）
		 *   它就是一个条件
		 * 2. 使用Customer调用service方法，得到List<Customer>
		 * 3. 保存到request域中
		 * 4. 转发到list.jsp
		 */
		Customer criteria = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		List<Customer> cstmList = customerService.query(criteria);
		request.setAttribute("cstmList", cstmList);
		return "/list.jsp";
	}
}
