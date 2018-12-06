
public class P40_AppearOnce {

	public void findAppearOnce(int [] array)
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
		int result =0;
		for(int k :array)
		{
			result ^=k;
		}
		int bitIndex =0;
		while(true)
		{
			if((result&1 )==1)
			{
				break;
			}
			bitIndex++;
			result =result>>1;
		}
		int first = 0;
		int second =0;
		for(int k:array)
		{
			if(check(k,bitIndex))
				first ^=k;
			else
				second ^=k;
		}
		System.out.println("The first data : "+first+", the second data: "+second);
	}
	public boolean check(int n, int bitIndex )
	{
		return (n&(1<<bitIndex) )!=0;
	}
	public static void main(String [] args)
	{

		P40_AppearOnce  test = new P40_AppearOnce ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int [] array ={2,4,3,6,3,2,5,5};
		test.findAppearOnce(array);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		int [] arrayTwo ={0,1};
		test.findAppearOnce(arrayTwo);
		int [] arrayTwoTwo={1,2,0,2};
		test.findAppearOnce(arrayTwoTwo);
		
		//exception test		
		System.out.println("\nException Test:");
		int [] arrrayEmpty = {};
		test.findAppearOnce(arrrayEmpty);
		test.findAppearOnce(null);
	}
}
