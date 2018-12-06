
public class P46_AddFrom1ToNBySpecialMethod {

	public void accumulation(int n)
	{
		if(n <1){
			System.out.println("The n has exception! n= "+n);
		return;}
		System.out.println("n = "+n);
		System.out.println("Formula answer: n*(n+1)/2=1+...+n = "+(n*(n+1)/2));
		Accumulation [] acc = new Accumulation[n];
		for(int i =0;i<n;i++)
			acc[i]= new Accumulation();
		acc[0].display(); //globle varible
		acc[n-1].reset();
		
	}
	
	public static void main(String [] args)
	{

		P46_AddFrom1ToNBySpecialMethod  test = new P46_AddFrom1ToNBySpecialMethod ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int n =10;
		test.accumulation(n);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		n=1;
		test.accumulation(n);
		n=100;
		//n = Integer.MAX_VALUE; // will be overflow  
		test.accumulation(n);
		
		//exception test		
		System.out.println("\nException Test:");
		test.accumulation(0);
	}
}
class Accumulation{
	public static int n;
	public static int sum;
	
	public Accumulation()
	{
		n++;
		sum +=n;
	}
	public void reset()
	{
		n=0;
		sum =0;
	}
	public void display()
	{
		System.out.println("Construct answer: 1+...+n = "+sum);
	}
}