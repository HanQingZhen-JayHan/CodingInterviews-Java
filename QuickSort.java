
public class QuickSort {

	public void sort(int [] array)
	{
		if(array == null )
		{System.out.println("The array is NULL!");
		return;
		}
		if(array.length<=0)
		{
			System.out.println("The array is EMPTY !");
			return;
		}
		
		int start = 0;
		int end = array.length-1;
		recursion(array,start,end);
		//display(array);
	}

	private void recursion(int[] array, int start, int end) {
		// TODO Auto-generated method stub
		if(end < start)
			return;
		int target = array[start];
		int index_start = start;
		int index_end  = end;
		while(index_end!=index_start)
		{
			while(index_end>index_start && target <= array[index_end]) // fill the hole（target）
				index_end--;
			if(index_end > index_start){
				array[index_start] = array[index_end];
				index_start++;
			}
			while(index_end >index_start && target >= array[index_start]) //fill the hole (index_end)
				index_start++;
			if(index_end > index_start){
				array[index_end] = array[index_start];
				index_end--;
			}
		}
		array[index_start] = target;    //find the right position
		recursion(array,start,index_start-1);
		recursion(array,index_start+1,end);
	}
	
	public void display(int [] array)
	{
		if(array!= null && array.length>0)
		{
			System.out.print("The array has "+array.length+" elements: [");
			for(int k:array)
			{
				System.out.print(k+" ");
			}
			System.out.println("]");
		}
	}
}
