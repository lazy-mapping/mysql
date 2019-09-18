package mysql_wb.test;

import org.junit.Test;

import mysql_web.domain.User;
import mysql_web.service.UserException;
import mysql_web.service.UserService;

/**
 * UserDao的测试类，记得删除表t_user中 李四 的记录
 *delete from t_user where username="李四";
 */
public class UserServiceTest {
	private UserService userService= new UserService();
	//@Test
	public void testRegist() throws UserException {
		User form = new User();
		form.setUsername("李四");
		form.setPassword("456");
		form.setAge(92);
		form.setGender("女");
		userService.regist(form);
}
	
	@Test
	public void testLogin() throws UserException {
		User form = new User();
		form.setUsername("李四");
		form.setPassword("456");
		User user=userService.login(form);
		System.out.println(user);
	}
}
