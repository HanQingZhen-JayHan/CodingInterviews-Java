
public class P41_TheSumOfPositiveSequenceIsS {

	public void printContinuePositiveSequence(int sum)
	{
		if(sum<=0)
		{
			System.out.println("The Sum is illegal! sum= "+sum);
			return;
		}
		
		int start = 1;
		int end  = 2;
		int sum2 = start+end;
		System.out.println("Sum =  "+sum);
		while(start<(sum/2 +1)  || end <(sum/2 +1))
		{
			if(sum2 == sum )
			{
				for(int i =start;i<=end ;i++)
					System.out.print(i+" + ");
				System.out.println("= ");
			}
			if(sum2>sum)
			{
				sum2 -= start;
				start++;
			}
			else
			{
				end++;
				sum2 += end;
			}
		}
		
	}
	public static void main(String [] args)
	{

		P41_TheSumOfPositiveSequenceIsS  test = new P41_TheSumOfPositiveSequenceIsS ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int sum = 15;
		test.printContinuePositiveSequence(sum);
		sum = 4;
		test.printContinuePositiveSequence(sum);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		sum = 3;
		test.printContinuePositiveSequence(sum);
		//sum = Integer.MAX_VALUE;
		sum =100;
		test.printContinuePositiveSequence(sum);
		
		//exception test		
		System.out.println("\nException Test:");
		sum = 0;
		test.printContinuePositiveSequence(sum);
		sum =-1;
		test.printContinuePositiveSequence(sum);
	}
}
