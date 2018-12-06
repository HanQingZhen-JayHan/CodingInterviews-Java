
public class P10_NumberOf1InBianry {
	public static void numberOf1(int n)
	{
		if(n ==0)
		{
			System.out.println("The number of 1 in Binary("+n+")is "+n);
			return;
		}
		int number=0;
		int i=n;
		while(i!=0)
		{
			i = i&(i-1);
			number++;
		}
		System.out.println("The number of 1 in Binary("+n+")is "+number);
	}
	/*
	public static void main(String [] args)
	{

        P10_NumberOf1InBianry n1b = new P10_NumberOf1InBianry();
		
		//test
		//founction test
		System.out.println("Founction Test:");
		int n =9;
        System.out.println("Binary("+n+")is "+Integer.toBinaryString(n));
		n1b.numberOf1(n);
		
		n = -9;
        System.out.println("Binary("+n+")is "+Integer.toBinaryString(n));
		n1b.numberOf1(n);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		n =0;
        System.out.println("Binary("+n+")is "+Integer.toBinaryString(n));
		n1b.numberOf1(n);
		n =0x7fffffff;
        System.out.println("Binary("+n+")is "+Integer.toBinaryString(n));
		n1b.numberOf1(n);
		n =0xffffffff;
        System.out.println("Binary("+n+")is "+Integer.toBinaryString(n));
		n1b.numberOf1(n);
		n =0x80000000;
        System.out.println("Binary("+n+")is "+Integer.toBinaryString(n));
		n1b.numberOf1(n);
		//n=
		//exception test		
		System.out.println("\nException Test:");

	}
	*/
}
