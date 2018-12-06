
public class P9_Fibonacci {

	public static void sequnceN(int n)
	{
		if(n<0)
		{
			System.out.println("The N <0!");
			return;
		}
		if(n<=1)
		{
			System.out.println("The Fibonacci is: "+n+", when N= "+n);
			return;
		}
		long fib1=0;
		long fib2=1;
		long fibonacci =0;
		int i=n;
		while(i>0)
		{
			System.out.println(fibonacci);
			fibonacci = fib1+fib2;
			fib2 =fib1;
			fib1 = fibonacci;
			i--;
		}
		System.out.println("The Fibonacci is: "+fibonacci+", when N= "+n);
	}
	/*
	public static void main(String [] args)
	{

        P9_Fibonacci fibonacci = new P9_Fibonacci();
        
		//test
		//founction test
		System.out.println("Founction Test:");
		int n=5;
		fibonacci.sequnceN(n);
		//boundary test		
		System.out.println("\nBoundary Test:");
		n =0;
		fibonacci.sequnceN(n);
		n =1;
		fibonacci.sequnceN(n);
		n =10;
		fibonacci.sequnceN(n);
		
		//exception test		
		System.out.println("\nException Test:");
		n=-1;
		fibonacci.sequnceN(n);
	}
	*/
}
