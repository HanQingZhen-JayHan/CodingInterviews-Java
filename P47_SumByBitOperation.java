
public class P47_SumByBitOperation {

	public void add(long n, long m)
	{
		System.out.println("n =  "+n+", m= "+m);
		if(n == 0)
		{
			System.out.println("n+m = "+m);
			return;
		}
		if(m == 0)
		{
			System.out.println("n+m = "+n);
			return;
		}
		long stardard = n+m;
		System.out.println("Standard: n+m = "+stardard);
		long sum = 0;
		long carry = 0;
		sum = n^m;
		carry = (n&m)<<1;
		while(carry!=0)
		{
			n=sum;
			m = carry;
			sum = n^m;
			carry = (n&m)<<1;
		}

		System.out.println("BitOperation answer: n+m = "+sum);
		
	}
	
	public static void main(String [] args)
	{

		P47_SumByBitOperation  test = new P47_SumByBitOperation ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int n=5;
		int m=6;
		test.add(n, m);
		n=99999999;
		m=11111111;
		test.add(n, m);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		n =0;
		test.add(n, m);
		n=Integer.MAX_VALUE;
		test.add(n, m);
		m=0;
		test.add(n, m);
		m= Integer.MAX_VALUE;
		test.add(n, m);
		n = Integer.MIN_VALUE;
		test.add(n, m);
		m=Integer.MIN_VALUE;
		test.add(n, m);
		
		
		//exception test		
		System.out.println("\nException Test:");
	}
}
