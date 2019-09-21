package demo.service;

import org.springframework.stereotype.Service;

import demo.dao.UserDao;

//@Component//("Normal")后缀id，等于限定名
@Service//专用，可以代替Component
//@Primary//主键，同时多个定义会冲突
//@Qualifier("Normal")//限定类
public class UserServiceNormal implements UserService {
	
	//@Autowired//自动扫描，下面是显式装配,则此处应注释
	private UserDao userDao;
	
	/* 构造函数注入*/
	public UserServiceNormal() {
		super();//无参方法
	}
	public UserServiceNormal(UserDao userDao) {
		this.userDao = userDao; //有参方法
	}
	
	/*setter方法注入*/
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void add() {
		userDao.add();
		
	}

}
