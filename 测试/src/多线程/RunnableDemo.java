package 多线程;
import java.util.Date;
/*Runnable接口只有一个函数，run()*/
class MyThread implements  Runnable{
	int pauseTime;
	String name;
	public MyThread(int x, String n) {
		pauseTime=x;
		name=n;
	}
	
	public void run() {
		while(true) {
			try {
				System.out.print(name+":"+new Date(System.currentTimeMillis()));
				Thread.sleep(pauseTime);
			}catch(Exception e) {
				System.out.print(e);
			}
		}
	}
}
/*两个线程t1和t2，按照不同时间间隔  输出当前的时间。*/
public class RunnableDemo {
	public static void main(String[] args) {
		MyThread r1=new MyThread(1000,"Fast Guy\n");
		MyThread r2=new MyThread(3000,"Slow Guy\n");
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);
		t1.start();
		t2.start();
	}
}
