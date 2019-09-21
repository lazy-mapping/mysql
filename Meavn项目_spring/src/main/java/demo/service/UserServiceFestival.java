package demo.service;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component  //("Festival")后缀id，等于限定名，与默认冲突
@Primary//主键，首选bean对象，针对接口有多个实现类的情况
//@Qualifier("Festival")//限定类
public class UserServiceFestival implements UserService {
	@Override//失败，解决?编译器1.6
	public void add() {
	System.out.println("注册用户并发送优惠券");
	}
}
