
public class P32_TheFrequenceOf1From1ToN {

	public void printFrequenceOf1(int n)
	{
		if(n<1)
		{
			System.out.println("The n is illegal! n = "+n);
			return;
		}
		
	}
	
	public static void main_temp(String [] args)
	{

		P32_TheFrequenceOf1From1ToN  test = new P32_TheFrequenceOf1From1ToN ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int n=5;
		test.printFrequenceOf1(n);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		n=1;
		test.printFrequenceOf1(n);
		//n= Integer.MAX_VALUE;
		test.printFrequenceOf1(n);
		
		//exception test		
		System.out.println("\nException Test:");
		n =0;
		test.printFrequenceOf1(n);
	}
}
