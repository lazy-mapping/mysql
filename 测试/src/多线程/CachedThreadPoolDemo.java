package 多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*可变尺寸线程池，结果看来线程并发执行了*/
public class CachedThreadPoolDemo {
	public static void main(String[] args) {
		ExecutorService exec =Executors.newCachedThreadPool();
		for(int i=0; i<5; i++) {
			exec.execute(new MyRunnable(i));
		}
		exec.shutdown();
	}

}
