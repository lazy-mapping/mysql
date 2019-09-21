package demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.web.UserController;

@RunWith(value=SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=AppConfig.class)
@ContextConfiguration("classpath:applicationContext.xml")//xml注解方式，资源文件都放在resource中
 
public class UserControllerTest {
	@Autowired
	private UserController userController;
	@Test
	public void testadd() {
		userController.add();
	}
}
