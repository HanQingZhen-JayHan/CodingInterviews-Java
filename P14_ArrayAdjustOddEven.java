
public class P14_ArrayAdjustOddEven {

	public static void sort(int [] array)
	{
		if(array == null)
		{
			System.out.println("The array is  NULL!");
			return;
		}
		if(array.length <=0)
		{
			System.out.println("The arrray is empty!");
			return;
		}
		if(array.length ==1)
		{
			display(array);
			return;
		}
		int index_x=0;
		int index_y=array.length-1;
		
		while(index_y > index_x)
		{
			while(index_x<index_y && !Funcation(array[index_x]))
				index_x++;
			while(index_x<index_y && Funcation(array[index_y]))
				index_y--;
			if(index_y > index_x){
			int temp = array[index_x];
			array[index_x] = array[index_y];
			array[index_y] = temp;
			}
		}
	}
	
	private static boolean Funcation(int i) {
		// TODO Auto-generated method stub
		return isEven(i);
	}

	private static boolean isEven(int i) {
		// TODO Auto-generated method stub
		return ( i&1) ==  0 ;
	}

	private static void display(int[] array) {
		// TODO Auto-generated method stub
		if(array != null )
		{
			System.out.println("The array contains: ");
			for (int i : array) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
/*
	public static void main(String [] args)
	{

		P14_ArrayAdjustOddEven  test = new P14_ArrayAdjustOddEven ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int [] array = {1,2,3,4,5,6};
		test.sort(array);
		test.display(array);
		int [] array_negative = {1,-1,2,-2,3,-3};
		test.sort(array_negative);
		test.display(array_negative);
		int [] array_complex  = {1,3,5,7,9,2,4,6,8,10};
		test.sort(array_complex);
		test.display(array_complex);
		int [] array_complex1  = {2,4,6,8,10,1,3,5,7,9};
		test.sort(array_complex1);
		test.display(array_complex1);
		//boundary test		
		System.out.println("\nBoundary Test:");
		int [] array_single={0};
		test.sort(array_single);
		test.display(array_single);
		int [] array_odd={1,3,5,7,9};
		test.sort(array_odd);
		test.display(array_odd);
		int [] array_even={2,4,6,8,10};
		test.sort(array_even);
		test.display(array_even);

		
		//exception test		
		System.out.println("\nException Test:");
		int [] array_empty = {};
		test.sort(array_empty);
		test.display(array_empty);
		int [] array_null = null;
		test.sort(array_null);
		test.display(array_null);
	}
	*/
}
