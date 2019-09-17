package program;
//计算器类，JUnit测试
public class Cclt {
	
	  private static int result; // 结果数
	   
	    public void add(int n) {
	        result = result + n;
	    }
	    public void substract(int n) {
	        result = result - 1;  //Bug: 应该是 result =result-n
	    }
	    public void square(int n) {
	        result = n * n;
	    }
	    public void divide(int n)  throws Exception{
			if(n==0){
				throw new Exception("除数不能为零！");
			}
			result = result / n;
		}
	    public void squareRoot(int n) {
	        for (; ;) ;            //有Bug：空循环 
	    }
	    public void clear() {     // 清零
	        result = 0;
	    }
	    public int getResult() {
	        return result;
	    }
}
