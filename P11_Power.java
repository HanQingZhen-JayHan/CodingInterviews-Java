
public class P11_Power {
	public static void power(double base, int exponent)
	{
		if(exponent == 0)
		{
			System.out.println(base+"^"+exponent+" = 1");
			return;
		}
		if(base ==0)
		{
			System.out.println(base+"^"+exponent+" = 0");
			return;
		}
		if(base ==1 | exponent ==1)
		{
			System.out.println(base+"^"+exponent+" = "+base);
			return;
		}	
		double result = 0.0;
		if(exponent <0)
			result =1/recursionCalculate(base,-exponent); //exponent negative,reverse the result
		else
			result =recursionCalculate(base,exponent);
		System.out.println(base+"^"+exponent+" = "+result);
	}
	
	private static double recursionCalculate(double base, int exponent) {
		// TODO Auto-generated method stub
		double result = 0.0;
		if(exponent ==0)
			return 1;
		if((exponent&1)==1)
			return recursionCalculate(base,exponent/2)*recursionCalculate(base,exponent/2)*base;
		
		return recursionCalculate(base,exponent/2)*recursionCalculate(base,exponent/2);
	}
/*
	public static void main(String [] args)
	{
        System.out.println("The matrix is exception! ");
        P11_Power power = new P11_Power();
		//test
		//founction test
		System.out.println("Founction Test:");
		double base = 1.1;
		int exponent =7;
		power.power(base, exponent);
		base =1.9;
		exponent = -5;
		power.power(base, exponent);
		//boundary test		
		System.out.println("\nBoundary Test:");
		base =0;
		exponent = 0;
		power.power(base, exponent);
		
		base =0;
		exponent = 0x80000000;
		power.power(base, exponent);
		base =0x7fffffff;
		exponent = 0;
		power.power(base, exponent);
		//exception test		
		System.out.println("\nException Test:");
	}
	*/
}
