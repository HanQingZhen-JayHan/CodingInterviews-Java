
public class P41_SumOfTwoDataIsS {

	public void findTwoMembers(int [] array, int sum)
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
		System.out.print("The array: [ ");
		for(int k:array)
			System.out.print(k+" ");
		System.out.println("] , sum = "+sum);
		
		int start = 0;
		int end  = array.length-1;
		while(end>start)
		{
			if(array[start]+array[end] == sum)
			{
				//System.out.println("Find the two members: "+array[start]+"+"+array[end]);
				break;
			}
			else if(array[start]+array[end] > sum)
				end--;
			else
				start++;
		}
		if(start != end)
			System.out.println("Find the two members: "+sum+" = "+array[start]+" + "+array[end]);
		else
			System.out.println("NOT Find the two members!");
	}
	
	public static void main(String [] args)
	{

		P41_SumOfTwoDataIsS  test = new P41_SumOfTwoDataIsS ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int [] array = {-5,-4,0,2,3,9,30,51};
		int sum = 30;
		test.findTwoMembers(array, sum);
		sum = 52;
		test.findTwoMembers(array, sum);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		int [] arrayOne ={0};
		test.findTwoMembers(arrayOne, sum);
		sum =0;
		test.findTwoMembers(arrayOne, sum);
		int [] arrayTwo ={-1,1};
		test.findTwoMembers(arrayTwo, sum);
		
		//exception test		
		System.out.println("\nException Test:");
		int [] arrayEmpty = {};
		test.findTwoMembers(arrayEmpty, sum);
		test.findTwoMembers(null, sum);
	}
}
