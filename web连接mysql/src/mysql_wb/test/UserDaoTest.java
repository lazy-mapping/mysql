package mysql_wb.test;

import org.junit.Test;

import mysql_web.dao.JdbcUserDaoImpl;
import mysql_web.dao.UserDao;
import mysql_web.domain.User;

/**
 * UserDao的测试类,记得删除表t_user中 李四 的记录；
 *
 */
public class UserDaoTest {
	
	@Test
	public void testAddUser() {
		UserDao userDao = new JdbcUserDaoImpl();
		
		User form = new User();
		form.setUsername("李四");
		form.setPassword("456");
		form.setAge(92);
		form.setGender("女");
		
		userDao.addUser(form);
	}
	
	@Test
	public void testFindByUsername() {
		UserDao userDao = new JdbcUserDaoImpl();
		
		User user = userDao.findByUsername("李四");
		
		System.out.println(user);
	}
}
