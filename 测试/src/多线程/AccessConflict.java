package 多线程;

class DataClass{
	private int data=0;
	public synchronized void increase() {
		int nd=data;
		try {
			Thread.sleep(100);
		}catch(Exception e) {System.out.print("异常！");}
			data=nd+1;
		}
		public int getData() {
			return data;
		}
}

class NThread extends Thread{
	DataClass d;
	NThread(DataClass d){
	this.d=d;	
	}
	boolean alive=true;
	public void run() {
		for(int i=0; i<100;i++) {
			d.increase();
		}
		alive=false;
	}
}
public class AccessConflict {
	public static void main(String[] args) {
		DataClass d=new DataClass();
		NThread t1=new NThread(d);
		NThread t2=new NThread(d);
		t1.start();
		t2.start();
		while(t1.alive||t2.alive);
		System.out.println("data="+d.getData());/*访问冲突，没有获得数据*/
	}

}
