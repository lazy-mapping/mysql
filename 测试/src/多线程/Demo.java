package 多线程;
/*前台线程，后台线程，没看懂 ？*/
class MyThread3 extends Thread{
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("MyThread3 第"+(i+1)+"次执行!   ");
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyThread4 extends Thread{
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("MyThread4 第"+(i+1)+"次执行!\n");
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class Demo {

	public static void main(String[] args) {
		MyThread3 t3=new MyThread3(); 
		MyThread4 t4=new MyThread4();
		t4.setDaemon(true);//判断or设置 后台线程，另一个方法isDaemon()
		t3.start(); 
		t4.start(); 
	}
}
