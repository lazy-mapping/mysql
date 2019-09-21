package hello01;

import org.springframework.stereotype.Component;

@Component//自动发现
public class MessageService {
	
	public  MessageService() {
		super();
		System.out.println("MessageService...无参调用方法");
	}//无参调用方法
	
	public String getMessage() {
		return "Hello World!";
	}
}
