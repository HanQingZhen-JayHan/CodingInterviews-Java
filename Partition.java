import java.util.Random;


public class Partition {

	public static void minK(int [] array , int k)
	{
		if(array == null)
		{
			System.out.println("The array is NULL!");
			return;
		}
		if(array.length <=0)
		{
			System.out.println("The array is EMPTY!");
			return;
		}
		if(k>array.length||k<=0)
		{
			System.out.println("The k is outboundary of array! k= "+k);
			return;
		}
		if(array.length ==1)
		{
			System.out.println("The minimum "+k+" members of array is: ");
			System.out.println(array[0]);
			return;
		}
		if(array.length ==k)
		{
			System.out.println("The minimum "+k+" members of array is: ");
			for(int i:array)
			     System.out.print(i+" ");
			System.out.println();
			return;
		}
		int start = 0;
		int end = array.length-1;
		int target = k;
		int index = quickSortDeformation(array,start,end);
		while(target != index)
		{
			if(target > index)
				index = quickSortDeformation(array,index+1,end);
			else
				index = quickSortDeformation(array,start,index-1);
		}
		System.out.println("The minimum "+k+" members of array is: ");
		for(int i =0;i<target;i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}

	private static int quickSortDeformation(int[] array, int start, int end) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int rand = start;
		if(end>start)
			rand =start + random.nextInt(end - start);
		swap(array,rand,end);
		int mark = end;
		while(end > start)
		{
			while(array[start]<=array[mark]  && end>start)
				start++;
			while(array[end]>= array[mark] && end >start)
				end--;
			if(end>start)
			{
				swap(array,start,end);
			}
		}
		swap(array,start,mark);
		return start;
	}

	private static void swap(int[] array, int i, int j) {
		// TODO Auto-generated method stub
		if (i == j) {   return;   }  
      
		int temp = array[i];
		array[i]= array[j];
		array[j]= temp;
		
		//data[i]+data[j] have a risk: int overflow
//        data[i] = data[i] + data[j];  
//        data[j] = data[i] - data[j];  
//        data[i] = data[i] - data[j]; 
	}
}
