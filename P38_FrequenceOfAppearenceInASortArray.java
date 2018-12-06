
public class P38_FrequenceOfAppearenceInASortArray {

	public void printFrequence(int [] array,int k)
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
		System.out.print("Array: [ ");
		for(int i:array)
		{
			System.out.print(i+" ");
		}
		System.out.println("]");
		
		boolean find =false;
		int front =0;
		int back = array.length-1;
		int start =0;
		while(back>=front)
		{
			int mid = front +(back-front)/2;
			if(k==array[mid]){
				start = mid;
				//System.out.println("Start: "+start);
				find =true;
				back = mid-1;
			}
			else if(k>array[mid])
					front = mid+1;
			else
				back = mid-1;
		}
		front =0;
		back = array.length-1;
		int end =0;
		while(back>=front)
		{
			int mid = front +(back-front)/2;
			if(k==array[mid]){
				end = mid;
				//System.out.println("End: "+end);
				front = mid+1;
				find =true;
			}
			else if(k>array[mid])
					front = mid+1;
			else
				back = mid-1;
		}
		if(find)
			System.out.println("The frequence of "+k+" in array is "+(end-start+1));
		else
			System.out.println("The frequence of "+k+" in array is 0 !");
	}
	
	public static void main(String [] args)
	{

		P38_FrequenceOfAppearenceInASortArray  test = new P38_FrequenceOfAppearenceInASortArray ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int [] array = {1,2,3,3,3,3,3,4,5};
		int k=3;
		test.printFrequence(array,k);
		k=1;
		test.printFrequence(array, k);
		k =6;
		test.printFrequence(array, k);
		
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		int [] arrayOne ={0};
		k=0;
		test.printFrequence(arrayOne, k);
		k=1;
		test.printFrequence(arrayOne, k);
		
		//exception test		
		System.out.println("\nException Test:");
		int [] arrayEmpty = {};
		test.printFrequence(arrayEmpty, k);
		test.printFrequence(null, k);
	}
}
