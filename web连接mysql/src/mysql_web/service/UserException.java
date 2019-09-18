package mysql_web.service;

/**
 * 自定义异常！
 * @author cxf
 *
 * * 继承Exception
 * * 大多数异常类，没有自己的成员和方法，方法都来自于Throwable
 * * 成员不会自己来添加
 * * 异常类之间的区别在类名不同！通常我们来断定异常时通过的就是异常类名！
 * * 异常类需要自己来提供有意义构造器，因为这个东东不能继承！
 */
public class UserException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//java序列化机制，运行时JVM判断字节流传来的 类 与 本地实体类 是否版本一致。

	public UserException() {
		super();
	}

	public UserException(String message) {
		super(message);
	}
}
