
public class P35_FirstApperOnceInAString {

	public void printFirstAppearOnce(String str)
	{
		if(str == null)
		{
			System.out.println("The string is NULL!");
			return;
		}
		if(str.length()<=0)
		{
			System.out.println("The string is EMPTY!");
			return;
		}
		int [] charHash = new int[256];
		for(int i = 0 ;i<str.length();i++)
		{
			char c = str.charAt(i);
			charHash[c]++;
		}
		int index =0;
		for(index = 0 ;index<str.length();index++)
		{
			char c = str.charAt(index);
			if(charHash[c]==1)
			{
				break;
			}
		}
		
		if(index<str.length())
			System.out.println("Find the character : "+str.charAt(index)+", which firstly appearences once!");
		else
			System.out.println("Not find the character  which firstly appearences once!");
	}
	
	public static void main(String [] args)
	{

		P35_FirstApperOnceInAString  test = new P35_FirstApperOnceInAString ();
		//test
		//founction test
		System.out.println("Founction Test:");
		String str = "abaccdeff";
		test.printFirstAppearOnce(str);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		String strOne = "a";
		test.printFirstAppearOnce(strOne);
		String strRepeat = "!!!!!!!!";
		test.printFirstAppearOnce(strRepeat);
		String strDifferent = "!@#$%^&*()";
		test.printFirstAppearOnce(strDifferent);
		
		
		//exception test		
		System.out.println("\nException Test:");
		String strEmpty = "";
		test.printFirstAppearOnce(strEmpty);
		test.printFirstAppearOnce(null);
		
	}
}
