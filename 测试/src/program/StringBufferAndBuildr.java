package program;

public class StringBufferAndBuildr {
	
	private static final String base ="base string. ";
	private static final int count=2000000;
	
	public static void stringTest() {
		long begin ,end;
		begin=System.currentTimeMillis();
		String test=new String(base);
		for(int i=0; i<count/100; i++) {
			test= test+" add ";
		}
		end= System.currentTimeMillis();
		System.out.print("String使用了"+(end-begin)+"毫秒\n");
	}//超级慢
	
	public static void stringBufferTest() {
		long begin ,end;
		begin=System.currentTimeMillis();
		StringBuffer test=new StringBuffer(base);
		for(int i=0; i<count/100; i++) {
			test= test.append(" add ");
		}
		end= System.currentTimeMillis();
		System.out.print("StringBuffer使用了"+(end-begin)+"毫秒\n");
	}//多线程安全 
	
	public static void stringBuilderTest() {
		long begin ,end;
		begin=System.currentTimeMillis();
		StringBuilder test=new StringBuilder(base);
		for(int i=0; i<count/100; i++) {
			test= test.append(" add ");
		}
		end= System.currentTimeMillis();
		System.out.print("StringBuilder使用了"+(end-begin)+"毫秒");
	}//单线程效率高，线程不安全
	
	
	/* 单线程程序，测试3个类的运行时间 */
	public static void main(String[] args) {
		stringTest();
		stringBufferTest();
		stringBuilderTest();
	}

}
