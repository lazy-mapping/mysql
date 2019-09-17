package 多线程;
/*静态方法的线程休眠    优先级   线程让步 */
class MyThread1 extends Thread{
	public void run() {
		Thread.yield();//线程1让步
		for(int i=0; i<10; i++){
			System.out.print("MyThread-1- 第"+(i+1)+"次执行！    ");
			try {
				//Thread.sleep(1000);//此处不注释，可以看出休眠调度使得两个线程交替运行
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
class MyThread2 extends Thread{
	public void run() {
		for(int i=0; i<10; i++){
			System.out.print("MyThread-2- 第"+(i+1)+"次执行！\n");
			try {
				//Thread.sleep(1000);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
public class ThreadSleepDemo {
	  public static void main(String[] args) { 
		  MyThread1 t1=new MyThread1(); 
		  MyThread2 t2=new MyThread2();
		  /*优先级仍然 无法保证 线程的执行次序，概率大*/
		  //t1.setPriority(1);//优先级默认5，运行时注释2个休眠语句
		  //t2.setPriority(10);
		  t1.start(); 
		  t2.start(); 
  } 
}
