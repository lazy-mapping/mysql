package demo.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;/*不会自动导入，傻子*/

import demo.AppConfig;
import demo.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class UserServiceTest {
	
 /*   //装配歧义性，的三种解决办法
	//@Qualifier("Normal")//限定类，选择实现类，优先于首选，此处另一个Festival
	//@Qualifier("userServiceFestival")//默认限定名，首字母小写的类名；与id冲突
	@Autowired
	*/
	
	//userServiceFestival
	@Resource(name="userServiceNormal")//jdk自带的标准：javax,引入annotaions-api.jar
	private UserService userService;
	
	@Test
	public void testAdd() {
		userService.add();
	} 
}
