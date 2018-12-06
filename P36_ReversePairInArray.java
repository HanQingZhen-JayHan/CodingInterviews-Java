
public class P36_ReversePairInArray {

	public void printReversePairs(int [] array)
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
		if(array.length==1)
		{
			System.out.println("The sum of reverse pairs is : 0");
			return;
		}
		System.out.print("The array :[ ");
		for(int k:array)
		{
			System.out.print(k+" ");
		}
		System.out.println("]");
		
		int sum =0;
		int front =0;
		int end =array.length-1;
		while(front != end)
		{
			for(int back = end;back>front;back--)
			{
				if(array[front]>array[back])
				{
					sum++;
					System.out.println("( "+array[front]+","+array[back]+" )");
				}
			}
			front++;
		}
		
		System.out.println("The sum of reverse pairs is : "+sum);
	}
	public static void main(String [] args)
	{

		P36_ReversePairInArray  test = new P36_ReversePairInArray ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int [] array = {7,5,6,4};
		test.printReversePairs(array);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		int [] arrayOne ={1};
		test.printReversePairs(arrayOne);
		int [] arrayTwo ={2,1};
		test.printReversePairs(arrayTwo);
		int [] arrayNo = {1,2,3,4,5,6,7,8,9};
		test.printReversePairs(arrayNo);
		int [] arraySame = {2,2,2,2,2,2,2,2,2,2};
		test.printReversePairs(arraySame);
		int [] arrayAll = {9,8,7,6,5,4,3,2,1};
		test.printReversePairs(arrayAll);
		
		//exception test		
		System.out.println("\nException Test:");
		int [] arrayEmpty = {};
		test.printReversePairs(arrayEmpty);
		test.printReversePairs(null);
	}
}
