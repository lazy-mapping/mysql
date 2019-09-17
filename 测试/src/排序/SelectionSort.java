package 排序;
//冒泡排序
public class SelectionSort {
      public static void main(String args[]){
      int[] intArray={12,11,45,6,8,43,40,57,3,20};
      int keyValue,index,temp;
		/*
		 * System.out.println("排序前的数组"); for(int i=0;i<intArray.length;i++)
		 * System.out.print(intArray[i]+"  "); System.out.println();
		 */
      long begin ,end;
	  //begin=System.currentTimeMillis();
	  begin=System.nanoTime();
      for(int i=0; i<intArray.length;i++){
    	  index=i;
    	  keyValue=intArray[i];
    	  for(int j=i;j<intArray.length;j++)
    		  if(intArray[j]<keyValue){
    			  index=j;
    			  keyValue=intArray[j];
    		  }
    	  temp=intArray[i];
    	  intArray[i]=intArray[index];
    	  intArray[index]=temp;
      }
      //end= System.currentTimeMillis();
      end=System.nanoTime();
      System.out.print("使用了"+(end-begin)+"纳秒\n");
      
      System.out.println("排序后的数组");
      for(int i=0;i<intArray.length;i++)
    	  System.out.print(intArray[i]+"  ");
      }
 }
