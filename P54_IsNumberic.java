
public class P54_IsNumberic {

	public void isNumber(String str)
	{
		if(str == null)
		{
			System.out.println("NULL Exception!str = "+str);
			return;
		}
		if(str.length()<=0)
		{
			System.out.println("EMPTY Exception!  str = "+str);
			return;
		}
		System.out.print("str: "+str);
		//[sign]integral-digits[.[fractional-digits]][e|E[sign[exponential-digits]
		boolean pass = formula(str);
		if(pass)
			System.out.println("   Yes!");
		else
			System.out.println("   No!");
	}
	
	private boolean formula(String str) {
		// TODO Auto-generated method stub
		int index = 0;
		if(str.charAt(index)=='+'|str.charAt(index)=='-')
			index++;
		if(index == str.length()) //only + or -
			return false;
		index =scanNumberic(str,index);
		
		if(index<str.length())
		{
			if(str.charAt(index)=='.')//
			{
				if(++index == str.length())
					return false;
				index=scanNumberic(str,index);
				
				if(index<str.length() && (str.charAt(index)=='e'||str.charAt(index)=='E'))
					return isExponent(str,index);
				else if(index == str.length())
					return true;
				else return false;
			}
			else if(str.charAt(index)=='e'||str.charAt(index)=='E')
				return isExponent(str,index);
			else
					return false;
		}
			return true; //only -/+15
	}

	private boolean isExponent(String str, int index) {
		// TODO Auto-generated method stub
		if(str.charAt(index)!='e'&&str.charAt(index)!='E')
			return false;
		index++;
		if(index<str.length() && (str.charAt(index)=='+'||str.charAt(index)=='-'))
			index++;
		if(index == str.length())
			return false;
		index=scanNumberic(str,index);
		if(index==str.length())
			return true;
		return false;
	}

	private int scanNumberic(String str, int index) {  //can not check start with 0
		// TODO Auto-generated method stub
		while(index<str.length() && str.charAt(index)>='0' && str.charAt(index)<='9')
			index++;
		return index;	
	}

	public static void main(String [] args)
	{

		P54_IsNumberic  test = new P54_IsNumberic ();
		//test
		//founction test
		System.out.println("Founction Test:");
		String str ="-12.34e-10";
		test.isNumber(str);
		String strNo = "+12.34.e++10";
		test.isNumber(strNo);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		test.isNumber("-123");
		test.isNumber("3.1244");
		test.isNumber("-1E-16");
		test.isNumber("5e2");
		test.isNumber("-0");
		test.isNumber("-0.1");
		test.isNumber("-0.1e1");
		test.isNumber("-0.1e-1");
		test.isNumber("00.0");
		test.isNumber("+-");
		test.isNumber("-");
		test.isNumber("++12.34");
		test.isNumber("12e");
		test.isNumber("1a3.12");
		test.isNumber("1.1.1");
		test.isNumber("12e4.5");
		test.isNumber("12e-");
		test.isNumber(".12e");
		test.isNumber("12e-0");
		
		//exception test		
		System.out.println("\nException Test:");
		test.isNumber("");
		test.isNumber(null);
	}
}
