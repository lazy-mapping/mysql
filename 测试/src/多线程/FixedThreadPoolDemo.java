package 多线程;
import java.util.concurrent.*;

/*静态线程池，Executors类*/
class MyRunnable implements Runnable{
	int count;
	MyRunnable(int count){
		this.count=count;
	}
	public void run() {
		for(int i=0; i<3; i++){
			System.out.print("任务"+ count +",第"+(i+1)+"次运行  ");
		}
		System.out.print("\n");
	}
}

/*运行结果不固定！！！并发执行*/
public class FixedThreadPoolDemo {
	public static void main(String[] args) {
		ExecutorService exec =Executors.newFixedThreadPool(2);
		for(int i=0; i<5; i++) {
			exec.execute(new MyRunnable(i));
		}
		exec.shutdown();
	}
}
