
public class P31_TheMaxSumofArray {

	public void printMaxSum(int [] array)
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
		
		long maxSum = Long.MIN_VALUE;//if maxSum is Integer ,maxSum may be overflow
		long sum =-1;                                  //if sum is Integer,sum may be overflow
		for(int k:array)
		{
			if(sum<0)
				sum=k;
			else
				sum +=k;
			if(sum>maxSum)
				maxSum = sum;
		}
		System.out.println("The max sum of subarray in array is "+maxSum);
	}
	/*
	public static void main(String [] args)
	{

		P31_TheMaxSumofArray  test = new P31_TheMaxSumofArray ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int [] array = {4,-5,2,3,-1,9,30,-6,5};
		test.printMaxSum(array);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		int [] arrayOne ={0};
		test.printMaxSum(arrayOne);
		int [] arrayPositive = {1,2,3,4,5,6,7,8};
		test.printMaxSum(arrayPositive);
		int [] arrayNegative = {-8,-7,-6,-5,-4,-3,-2,-1};
		test.printMaxSum(arrayNegative);
		
		//exception test		
		System.out.println("\nException Test:");
		int [] arrayEmpty = {};
		test.printMaxSum(arrayEmpty);
		test.printMaxSum(null);
		
	}
	*/
}
