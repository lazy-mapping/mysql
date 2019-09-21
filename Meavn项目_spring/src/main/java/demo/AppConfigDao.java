package demo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import demo.dao.UserDao;
import demo.dao.UserDaoCache;
import demo.dao.UserDaoNormal;
import demo.service.UserService;
import demo.service.UserServiceNormal;

@Configuration//spring配置类
public class AppConfigDao {
	@Bean//用于显示装配：例如第三方库加载类，不能自动扫描，spring可以识别
	
	public UserDao userDaoNormal() {
		System.out.println("创建UserDaoNormal的对象，显式装配");
		return new UserDaoNormal();
	}
	
	@Bean
	@Primary
	public UserDao userDaoCache() {
		System.out.println("创建UserDaoCache的对象，显式装配");
		return  new UserDaoCache();
	}
	/*此处UserDao有两种方法，即装配歧义性，三种解决方案*/
	@Bean//用于显示装配：例如第三方库加载类，不能自动扫描
	public UserService userServiceNormal(@Qualifier("userDaoCache") UserDao uesrDao) {
		System.out.println("创建UserService的对象，显式装配");
		//UserDao uesrDao = userDaoNormal();//参数的使用显得更优雅
		//return new UserServiceNormal(uesrDao);//构造方法的返回值
		UserServiceNormal userService = new UserServiceNormal();
		userService.setUserDao(uesrDao);
		return userService;//set方法返回值
	}
}