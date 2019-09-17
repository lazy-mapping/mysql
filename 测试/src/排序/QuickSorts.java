package 排序;
//快速排序
public class QuickSorts {

    	public static int[] qsort(int arr[],int start,int end) {        
    	    int pivot = arr[start];        
    	    int i = start;        
    	    int j = end;        
    	    while (i<j) {            
    	        while ((i<j)&&(arr[j]>pivot)) {                
    	            j--;            
    	        }            
    	        while ((i<j)&&(arr[i]<pivot)) {                
    	            i++;            
    	        }            
    	        if ((arr[i]==arr[j])&&(i<j)) {                
    	            i++;            
    	        } else {                
    	            int temp = arr[i];                
    	            arr[i] = arr[j];                
    	            arr[j] = temp;            
    	        }        
    	    }        
    	    if (i-1>start) arr=qsort(arr,start,i-1);        
    	    if (j+1<end) arr=qsort(arr,j+1,end);        
    	    return (arr);    
    	}    
    	 
    	public static void main(String[] args) {        
    	    int arr[] = new int[]{12,11,45,6,8,43,40,57,3,20};       
    	    int len = arr.length-1;    
    	    long begin ,end;
    		begin=System.nanoTime();
    		
    	    arr=qsort(arr,0,len);     
    	    
    	    end=System.nanoTime();
    	    System.out.print("使用了"+(end-begin)+"纳秒\n");
    	    
    	    for (int i:arr) {            
    	        System.out.print(i+"\t");        
    	    }    
    	}
}
