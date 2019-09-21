package hello01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan/* 无配置类时用这个*/
public class ApplicationSpring {

	public static void main(String[] args) {
		
		System.out.println("ApplicationSpring is running....测试例子");
		//初始化Spring容器
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext.xml");/*失败*/
		//ApplicationContext context = new  AnnotationConfigApplicationContext(ApplicationSpring.class);
		
		//配置类路径
		//ApplicationContext context = new  AnnotationConfigApplicationContext(AppConfig.class);
		
	     //从容器中获取对象，getBean方法
		 MessagePrinter printer = context.getBean(MessagePrinter.class);//直接加载类
		 //MessagePrinter printer = (MessagePrinter) context.getBean("MessagePrinter01");//自定义名称bean的id，重载方法
		 //MessageService service = context.getBean(MessageService.class);
		 
	     //System.out.println(printer);//输出  类名，哈希值；
		 //System.out.println(service);
		 
		// printer.setService(service); 
		 printer.printMessage();
	}
}
