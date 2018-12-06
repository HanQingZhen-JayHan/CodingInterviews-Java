
public class P33_MinimumOfIntegerPermutation {

	public void minimum(int [] array)
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
		
		
	}
	public static void main_temp(String [] args)
	{

		P33_MinimumOfIntegerPermutation  test = new P33_MinimumOfIntegerPermutation ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int [] array = {3,32,321};
		test.minimum(array);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		int [] arrayOne ={0};
		test.minimum(arrayOne);
		
		//exception test		
		System.out.println("\nException Test:");
		int [] arrayEmpty = {};
		test.minimum(arrayEmpty);
		test.minimum(null);
	}
}
