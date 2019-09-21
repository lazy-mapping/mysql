  package hello01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;/*eclipse不会自动引入此类，傻子*/

@RunWith(SpringJUnit4ClassRunner.class)

//@ContextConfiguration(classes=AppConfig.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AppTest {
	
	@Autowired
	private MessagePrinter printer01;//应用于多个对象时，id只有一个,name可以有多个
	 
	@Test//普通单元测试
	public void testPlay() {
		//配置类路径
		//@SuppressWarnings("resource")
		//ApplicationContext context = new  AnnotationConfigApplicationContext(AppConfig.class);
	     //从容器中获取对象，getBean方法
		// MessagePrinter printer = context.getBean(MessagePrinter.class);
	   printer01.printMessage();
	}
}
