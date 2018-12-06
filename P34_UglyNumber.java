
public class P34_UglyNumber {

	public void printUglyNumber(int k)
	{
		if(k<1)
		{
			System.out.println("The k is illegal! k= "+k);
			return;
		}
	}
	
	public static void main_temp(String [] args)
	{

		P34_UglyNumber  test = new P34_UglyNumber ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int k=1500;
		test.printUglyNumber(k);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		k=1;
		test.printUglyNumber(k);
		k=Integer.MAX_VALUE;
		test.printUglyNumber(k);
		
		//exception test		
		System.out.println("\nException Test:");
		test.printUglyNumber(0);
	}
}
