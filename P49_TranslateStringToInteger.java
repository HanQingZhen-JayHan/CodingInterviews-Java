
public class P49_TranslateStringToInteger {

	public void parse(String str)
	{		
		int globleStatus = -1; //-1 :NA ;0:number;1:overflow/underflow
		System.out.println("\nglobleStatus means: -1 :NA ;  0:number;  1:overflow/underflow");
		if(str == null || str.length()<=0){
	        System.out.println("The String is exception! globleStatus = "+globleStatus);
			return;
		}
		System.out.println("str = "+str);
	int flag =-1 ; //-1:None;0:+;1:-
	int index =0;
	if(str.charAt(index)=='+'){
		flag=0;
		index++;
	}
	else if(str.charAt(index)=='-'){
		flag = 1;
		index++;
	}
	else
		flag=0;
//	int [] numberic = new int [str.length()-index];
//	int n_index =-1;
//	while(index<str.length() && str.charAt(index)>='0' && str.charAt(index)<='9')
//	{
//		n_index++;
//		numberic[n_index]=str.charAt(index)-'0';
//		index++;
//	}
//	int number =0;
//	for(int i=0;i<=n_index;i++)
//	{
//		number =numberic[i]+10*number;
//	}
	long number=0;
	int n_index =-1;
	while(index<str.length() && str.charAt(index)>='0' && str.charAt(index)<='9')
	{
		n_index++;
		number=(str.charAt(index)-'0')+number*10;
		index++;
		if(flag==0 && number >Integer.MAX_VALUE ||flag==1 && (-number)<Integer.MIN_VALUE)
		{
			globleStatus =1;
			System.out.println("This str cann't be parsed to be integer! str: "+str+" by overflow or underflow, globleStatus = "+globleStatus);
			return;
		}
	}

	if(flag==1)
		number = -number;
	
	if(n_index>-1 && index== str.length())
	{
		globleStatus =0;
		System.out.println("This str can be parsed to be integer: "+String.valueOf(number)+", globleStatus = "+globleStatus);
	}
	else
	{
		System.out.println("This str cann't be parsed to be integer! str: "+str+", globleStatus = "+globleStatus);
	}
	}
	public static void main(String [] args)
	{

		P49_TranslateStringToInteger  test = new P49_TranslateStringToInteger ();
		//test
		//founction test
		System.out.println("Founction Test:");
		String str = "+123";
		test.parse(str);
		String strNot  = "hello";
		test.parse(strNot);
		String strNegative = "-123";
		test.parse(strNegative);
		String strMix = "h1@5%0^&";
		test.parse(strMix);
		String strS = "-10e+10";
		test.parse(strS);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		String str1 = "1";
		test.parse(str1);
		String str0 ="0";
		test.parse(str0);
		String strN1="-1";
		test.parse(strN1);
		String strMax = String.valueOf(Integer.MAX_VALUE);
		test.parse(strMax);
		String strMin = String.valueOf(Integer.MIN_VALUE);
		test.parse(strMin);
		String strPuls = "+";
		test.parse(strPuls);
		String strMinus ="-";
		test.parse(strMinus);
		String strLong = String.valueOf((long)Integer.MAX_VALUE+2);
		test.parse(strLong);
		String strLongMin = String.valueOf((long)Integer.MIN_VALUE-1);
		test.parse(strLongMin);

		//exception test		
		System.out.println("\nException Test:");
		String strEmpty = "";
		test.parse(strEmpty);
		test.parse(null);
		
	}
}
