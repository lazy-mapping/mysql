package 排序;
//冒泡排序
public class BubbleSort {
    public static void main(String args[]){
    int[] intArray={12,11,45,6,8,43,40,57,3,20};
		/*
		 * System.out.println("排序前的数组"); for(int i=0;i<intArray.length;i++)
		 * System.out.print(intArray[i]+"  "); System.out.println();
		 */
    int temp;
    long begin ,end;
   	begin=System.nanoTime();
   	
    for(int i=0; i<intArray.length;i++){
  	  for(int j=i+1;j<intArray.length;j++)
  		  if(intArray[j]<intArray[i]){
  			temp=intArray[i];
  			intArray[i]=intArray[j];
  			intArray[j]=temp;
  		  }
    }
    
    end= System.nanoTime();
	System.out.print("使用了"+(end-begin)+"纳秒\n");
    System.out.println("排序后的数组");
    for(int i=0;i<intArray.length;i++)
  	  System.out.print(intArray[i]+"  ");
    }
}