
public class P35_TwoStringUnionIntersectExcept {
	public void printExcept(String str1, String str2) //delete the character in str1 which appear in str2;
	{
		if(str1 == null ||str2 == null)
		{
			System.out.println("The str1 or str2 is NULL!");
			System.out.println("str1: "+str1+", str2: "+str2);
			return;
		}
		if(str1.length()<=0 || str2.length()<=0)
		{
			System.out.println("The str1 or str2 is EMPTY!");
			System.out.println("str1: "+str1+", str2: "+str2);
			return;
		}
		System.out.println("str1:  "+str1);
		System.out.println("str2:   "+str2);
		System.out.print("str1 - str2 :");
		
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
		System.out.println();
	}
	public void printUnion(String str1, String str2) 
	{
		if(str1 == null ||str2 == null)
		{
			System.out.println("The str1 or str2 is NULL!");
			System.out.println("str1: "+str1+", str2: "+str2);
			return;
		}
		if(str1.length()<=0 || str2.length()<=0)
		{
			System.out.println("The str1 or str2 is EMPTY!");
			System.out.println("str1: "+str1+", str2: "+str2);
			return;
		}
		System.out.println("str1:  "+str1);
		System.out.println("str2:   "+str2);
		System.out.print("str1 U str2 :");
		
		boolean [] charHash = new boolean[256];
		for(int i = 0 ;i<str2.length();i++)
		{
			char c = str2.charAt(i);
			charHash[c]=true;
		}
		for(int i = 0 ;i<str1.length();i++)
		{
			char c = str1.charAt(i);
			charHash[c]=true;
		}
		int index =0;
		for(index=0;index<str1.length();index++)
		{
			char c = str1.charAt(index);
			if(charHash[c]){
				System.out.print(c);
				charHash[c] = false;
			}
		}
		for(index=0;index<str2.length();index++)
		{
			char c = str2.charAt(index);
			if(charHash[c])
				System.out.print(c);
		}
		System.out.println();
	}
	public void printIntersect(String str1, String str2) 
	{
		if(str1 == null ||str2 == null)
		{
			System.out.println("The str1 or str2 is NULL!");
			System.out.println("str1: "+str1+", str2: "+str2);
			return;
		}
		if(str1.length()<=0 || str2.length()<=0)
		{
			System.out.println("The str1 or str2 is EMPTY!");
			System.out.println("str1: "+str1+", str2: "+str2);
			return;
		}
		System.out.println("str1:  "+str1);
		System.out.println("str2:   "+str2);
		System.out.print("str1 n str2 :");
		
		int [] charHash = new int[256];
		for(int i = 0 ;i<str2.length();i++)
		{
			char c = str2.charAt(i);
			charHash[c]++;
		}
		for(int i = 0 ;i<str1.length();i++)
		{
			char c = str1.charAt(i);
			charHash[c]++;
		}
		int index =0;
		for(index=0;index<charHash.length;index++)
		{
			if(charHash[index]>1)
				System.out.print((char)index);
		}
		System.out.println();
	}
	public static void main(String [] args)
	{

		P35_TwoStringUnionIntersectExcept  test = new P35_TwoStringUnionIntersectExcept ();
		//test
		//founction test
		System.out.println("Founction Test:");
		String str1 = "We are students!";
		String str2 = "aeiou";
		test.printExcept(str1, str2);
		test.printIntersect(str1, str2);
		test.printUnion(str1, str2);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		String str1One = "a";
		String str2One = "a";
		test.printExcept(str1One, str2One);
		test.printIntersect(str1One, str2One);
		test.printUnion(str1One, str2One);
		
		String str1Same = "We are the same!";
		String str2Same = "We are the same!";
		test.printExcept(str1Same, str2Same);
		test.printIntersect(str1Same, str2Same);
		test.printUnion(str1Same, str2Same);
		
		
		//exception test		
		System.out.println("\nException Test:");
		String str1Empty = "";
		String str2Empty = "";
		test.printExcept(str1Empty, str2Empty);
		test.printIntersect(str1Empty, str2Empty);
		test.printUnion(str1Empty, str2Empty);
		test.printExcept(null, null);
		test.printIntersect(null, null);
		test.printUnion(null, null);
	}
}
