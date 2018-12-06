
public class P8_RotateArrayMin {
	public static void  findMin(int [] array)
	{
		
		if(array == null){
			System.out.println("The array is excepiton!");
			return;
		}
		if(array.length<=0){
			System.out.println("The array is excepiton!");
			return;
		}
		if(array.length ==1| array[0]< array[array.length-1]){
			System.out.println("The min data of array is : "+array[0]);
			return;
		}
		int length = array.length;
		int left =0;
		int right = length -1;

		while(right!=left+1)
		{
			int middle = left + (right - left)/2;
			if(array[middle]==array[left]  && array[middle]==array[right] && array[left]==array[right])
			{
				int min = ScanOrder( array,  left , right);
				System.out.println("The min data of array is : "+min);
				return;
			}
			else if(array[middle]>=array[left])
				left = middle;
			else if(array[middle] <= array[right])
				right = middle;
		}
		System.out.println("The min data of array is : "+array[right]);
	}
	
	private static int ScanOrder(int [] array, int left, int right) {
		// TODO Auto-generated method stub
		int min =array[left];
		for(int i =left+1;i<= right;i++)
			if(array[i]<min)
				min = array[i];
		return min;
	}
/*
	public static void main(String [] args)
	{
       
        P8_RotateArrayMin RotateArray = new P8_RotateArrayMin();
		//test
		//founction test
		System.out.println("Founction Test:");
		int [] array = {3,4,5,6,7,0,1,2};
		RotateArray.findMin(array);
		//boundary test		
		System.out.println("\nBoundary Test:");
		int [] array_b = {0,1};
		RotateArray.findMin(array_b);
		int [] array_e ={0,1,1,1,1,1,1};
		int [] array_f ={1,1,1,1,1,1,0};
		int [] array_g ={1,0,1,1,1,1};
		int [] array_h ={1,1,1,1,5,5,0,1,1,1,1,1,1,1,1,1};
		int [] array_i ={1,1,1,1,1,1};
		RotateArray.findMin(array_e);
		RotateArray.findMin(array_f);
		RotateArray.findMin(array_g);
		RotateArray.findMin(array_h);
		RotateArray.findMin(array_i);
		//exception test		
		System.out.println("\nException Test:");
		int [] array_c = {};
		int [] array_d = null;
		RotateArray.findMin(array_c);
		RotateArray.findMin(array_d);
	}
	*/
}
