package 多线程;

import java.util.Date;

class MeThread extends Thread{ 
	  int pauseTime; 
	  String name; 
	  public MeThread(int x, String n) { 
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

/* 两个线程t1和t2，按照不同时间间隔 输出当前的时间。 */
  public class ThreadDemo {
	  public static void main(String[] args) {
		  MeThread t1=new MeThread(1000,"Fast Guy   ");
		  MeThread t2=new MeThread(3000,"Slow Guy\n");
          t1.start(); 
          t2.start(); 
          } 
	  }
 
