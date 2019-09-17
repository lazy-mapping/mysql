package ThreadLocal;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * ThreadLocal对象的用法，解决多线程并发访问问题
 * ThreadLocal通常用在一个类的成员上， 使用当前线程做key 
 * 多个线程访问它时，每个线程都有自己的副本，互不干扰！
 * Spring中把Connection放到了ThreadLocal中！
 * 我们会再次修改JdbcUtils类！，给它添加一个ThreadLocal<Connection>
 */
public class ThreadLocalDemo {
	@Test
	public void fun1() {
		final ThreadLocal<String> tl = new ThreadLocal<String>();
		//tl.set("成功");//存
		
		new Thread() {
			public void run() {
			    tl.set("不是成功");
				System.out.println("内部类访问：" + tl.get());
			}
		}.start();
		System.out.println("主线程访问："+tl.get());//取
	}
	
	@Test
	public void fun2() {
		//成员变量
		final Map<Thread, String> map = new HashMap<Thread, String>();
		
		map.put(Thread.currentThread(), "hello");//put方法给 值
		System.out.println(Thread.currentThread().getName());//读取本线程名字
		System.out.println(map.get(Thread.currentThread()));//get方法读值
		
		//内部类，访问map
		new Thread() {
			public void run() {
				System.out.println(Thread.currentThread().getName());//读取本线程名字
				System.out.println(map.get(Thread.currentThread()));//get方法读值
			}
		}.start();
	}
}

