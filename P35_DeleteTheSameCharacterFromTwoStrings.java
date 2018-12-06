
public class P35_DeleteTheSameCharacterFromTwoStrings {

	public void printDeleteTheDupliycate(String str1, String str2) //delete the character in str1 which appear in str2;
	{
		if(str1 == null ||str2 == null)
		{
			System.out.println("The str1 or str2 is NULL!");
			return;
		}
		if(str1.length()<=0 || str2.length()<=0)
		{
			System.out.println("The str1 or str2 is EMPTY!");
			return;
		}
		System.out.println("The original string of str1:           "+str1);
		System.out.println("The original string of str2:           "+str2);
		System.out.print("After delete the duplicate character str1-str2 :");
		boolean [] charHash = new boolean[256];
		for(int i = 0 ;i<str2.length();i++)
		{
			char c = str2.charAt(i);
			charHash[c]=true;
		}
		int index =0;
		for(index=0;index<str1.length();index++)
		{
			char c = str1.charAt(index);
			if(!charHash[c])
				System.out.print(c);
		}
	}
	public static void main(String [] args)
	{

		P35_DeleteTheSameCharacterFromTwoStrings  test = new P35_DeleteTheSameCharacterFromTwoStrings ();
		//test
		//founction test
		System.out.println("Founction Test:");
		String str1 = "We are students!";
		String str2 = "aeiou";
		test.printDeleteTheDupliycate(str1, str2);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		String str1One = "a";
		String str2One = "a";
		test.printDeleteTheDupliycate(str1One, str2One);
		
		
		//exception test		
		System.out.println("\nException Test:");
		String str1Empty = "";
		String str2Empty = "";
		test.printDeleteTheDupliycate(str1Empty, str2Empty);
		test.printDeleteTheDupliycate(null, null);
	}
	
}
