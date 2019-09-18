package mysql_web.service;

import mysql_web.dao.DaoFactory;
import mysql_web.dao.UserDao;
import mysql_web.domain.User;

/**
 * 业务层
 * 封装的是业务，可以理解成功能，例如本项目中有两个功能：登录和注册
 * 那么本类就有两个方法：login()、regist()
 *
 */
public class UserService {
	// 把具体的实现类的创建，隐藏到工厂中了！，类似于spring框架
	private UserDao userDao = DaoFactory.getUserDao();
	
	
	/**
	 * 注册功能
	 * @param form
	 */
	public void regist(User form) throws UserException {
		/*
		 * 1. 校验用户名
		 *   > 如果已经注册，那么抛出异常（异常信息为：用户名已被注册！）
		 * 2. 完成插入
		 */
		/*
		 * 1. 校验用户名
		 */
		User user = userDao.findByUsername(form.getUsername());
		if(user != null) throw new UserException("用户名已被注册！");
		
		/*
		 * 2. 插入User对象
		 */
		userDao.addUser(form);
	}
	
	public User login(User form) throws UserException {
		/*
		 * 1. 使用form的username进行校验
		 */
		User user = userDao.findByUsername(form.getUsername());
		/*
		 * 判断user是否为null，若为null，说明用户名错误，所以抛出异常
		 */
		if(user == null) throw new UserException("用户名不存在！");
		/*
		 * 判断form和user密码是否相同
		 * 若不同，说明密码错误，所以抛出异常
		 */
		if(!user.getPassword().equals(form.getPassword())) {
			throw new UserException("密码错误！");
		}
		
		/*
		 * 若执行到这里，说明没有错误，登录成功了，返回当前user对象！
		 */
		return user;
	}
}
