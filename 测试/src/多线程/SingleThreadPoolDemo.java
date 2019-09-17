package 多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*单任务线程池，运行结果一致*/
public class SingleThreadPoolDemo {
	public static void main(String[] args) {
		ExecutorService exec =Executors.newSingleThreadExecutor();
		for(int i=0; i<5; i++) {
			exec.execute(new MyRunnable(i));
		}
		exec.shutdown();
	}

}
