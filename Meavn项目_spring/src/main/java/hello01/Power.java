package hello01;

//import org.springframework.stereotype.Component;

//@Component//此处注释，为了测试@Autowired的required属性
public class Power {
	
	public Power() {
		super();
	}
	
	public void supply() {
		System.out.println("电源供电中。。。。");
	}
}
