package 多线程;
/*多个并行线程合并成一个运行*/
class SumRunnable implements Runnable{
	int sum=0,n;
	SumRunnable(int n){
		this.n=n; 
	}
	public void run() {
		for(int i=0; i<=n; i++) {
			sum=sum+i;
		}
    }
	public int getSum() {
		return sum;
	}
}
public class ThreadJoinDemo {
	public static void main(String[] args) { 
		int n=100;
	    SumRunnable r=new SumRunnable(n);
	    Thread t=new Thread(r);
	    t.start();
	    try {
	    	t.join();//线程合并
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	        }
	    System.out.print("1+...+"+n+"的和为"+r.getSum());
	 }
}
