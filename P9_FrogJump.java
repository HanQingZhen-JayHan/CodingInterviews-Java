
public class P9_FrogJump {
	public static void jumpCount(int n)
	{
		if(n<=0)
		{
	        System.out.println("The n is exception! n= "+n);
	        return;
		}
		int [] fibo ={1,2};
		int fibonacci =0;
		if(n<=2)
		{
			System.out.println("The total count is "+fibo[n-1]);
			return;
		}
		int i =n-2;
		while(i>0)
		{
			fibonacci = fibo[0]+fibo[1];
			fibo[0]=fibo[1];
			fibo[1]=fibonacci;
			i--;
			System.out.println("The fibonacci is "+fibonacci);
		}
		System.out.println("The total count is "+fibonacci);
	}
	
	/*
	public static void main(String [] args)
	{    
        P9_FrogJump fj = new P9_FrogJump();
		//test
		//founction test
		System.out.println("Founction Test:");
		int n =5;
		fj.jumpCount(n);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		n=0;
		fj.jumpCount(n);
		n=1;
		fj.jumpCount(n);
		//exception test		
		System.out.println("\nException Test:");
		n =-5;
		fj.jumpCount(n);
	}
	*/
}
