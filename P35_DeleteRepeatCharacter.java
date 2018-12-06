
public class P35_DeleteRepeatCharacter {

	public void printDeleteRepeat(String str)
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
		boolean [] charHash = new boolean[256];
		for(int i = 0 ;i<str.length();i++)
		{
			char c = str.charAt(i);
			charHash[c]=true;
		}
		System.out.println("After delete repeat: ");
		int index =0;
		for(index = 0 ;index<str.length();index++)
		{
			char c = str.charAt(index);
			if(charHash[c])
			{
				System.out.print(c);
				charHash[c]=false;
			}
		}
		System.out.println();
	}
	
	public static void main(String [] args)
	{

		P35_DeleteRepeatCharacter  test = new P35_DeleteRepeatCharacter ();
		//test
		//founction test
		System.out.println("Founction Test:");
		String str = "google";
		test.printDeleteRepeat(str);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		String StrOne = "a";
		test.printDeleteRepeat(StrOne);
		String strRepeat = "!!!!!!!";
		test.printDeleteRepeat(strRepeat);
		String strDifferent = "348*wergfdv";
		test.printDeleteRepeat(strDifferent);
		
		//exception test		
		System.out.println("\nException Test:");
		String strEmpty = "";
		test.printDeleteRepeat(strEmpty);
		test.printDeleteRepeat(null);
		
	}
}
