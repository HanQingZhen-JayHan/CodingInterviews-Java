
public class P52_ConstructArrayMultiply {

	public void constructArrayMultiply( int [] arrayA)
	{
		if(arrayA == null )
		{System.out.println("The arrayA is NULL!");
		return;
		}
		if(arrayA.length<=0)
		{
			System.out.println("The arrayA is EMPTY !");
			return;
		}
		System.out.print("The arrayA :[ ");
		for(int k:arrayA)
		{
			System.out.print(k+" ");
		}
		System.out.println("]");
		int length = arrayA.length;
		long [] arrayB = new long[arrayA.length];
		long [] C = new long [arrayA.length];
		long [] D = new long [arrayA.length];
		C[0] = 1;
		D[length-1] = 1;
		for(int i = 0 ;i<length-1;i++)
		{
			C[i+1] =C[i]*arrayA[i];
			D[length-2-i] = D[length-1-i]*arrayA[length-1-i];
		}
		for(int i=0; i<length;i++)
			arrayB[i]=C[i]*D[i];
		
		System.out.print("The arrayB :[ ");
		for(long k:arrayB)
		{
			System.out.print(k+" ");
		}
		System.out.println("]");
	}
	
	public static void main(String [] args)
	{

		P52_ConstructArrayMultiply  test = new P52_ConstructArrayMultiply ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int [] array = {1,2,3,4,5,6,7,8,9};
		test.constructArrayMultiply(array);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		int [] arrayOne ={1};
		test.constructArrayMultiply(arrayOne);
		int [] arrayTwo ={1,2};
		test.constructArrayMultiply(arrayTwo);
		int [] arraySame = {2,2,2,2,2,2,2,2,2,2};
		test.constructArrayMultiply(arraySame);
		
		
		//exception test		
		System.out.println("\nException Test:");
		int [] arrayEmpty = {};
		test.constructArrayMultiply(arrayEmpty);
		test.constructArrayMultiply(null);
	}
}
