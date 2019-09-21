package hello01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {
	@Autowired(required=false) //后缀属性，表示注入的对象是可选的
	private Power power;//eclipse不会检查类是否实现
	@Autowired //加自动装配，就不需要实现 多参数构造方法，即下面多参方法注释
	private MessageService service;
	
	public  MessagePrinter() {
		super();
		System.out.println("MessagePrinter的无参构造方法"+this.toString());
	} //无参调用方法

	@Autowired//自动调用set方法
	public void setService(MessageService service) {
		 this.service = service;
		 System.out.println("setService的有参方法");
	 		} 
	/*@Autowired//自动调用set方法,加一个参数；效率高，成员变量自动装配效率低
	public void setService(MessageService service , Power power) {
		 this.service = service;
		 this.power = power;
		 System.out.println("setService的多参数的方法，不同参数的方法重载");
	 		} 
	*/
	public void printMessage() {
		if(power != null) {
			power.supply();//加一个电源类
		}
		else  
			System.out.println("电源类未实现。。。为了测试@Autowired的required属性");
		
		if(service != null) {
			System.out.println(this.service.getMessage());//一个hello world，xml方式的context注解不完整则会失败
		}
		else  
			System.out.println("hello world未实现。。。为了测试空指针异常");
	}
}
