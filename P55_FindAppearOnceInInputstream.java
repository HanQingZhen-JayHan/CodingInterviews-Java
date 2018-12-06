
public class P55_FindAppearOnceInInputstream {

	public void findTheCharacter(String str)
	{
		if( str == null)
		{
			System.out.println("NULL Exception! str = "+str);
			return;
		}
		if(str.length()<=0)
		{
			System.out.println("EMPTY Exception! str = "+str);
			return;
		}
		System.out.println(" str: "+str);
		Charstatistics statistics = new Charstatistics();
		for(int i=0;i<str.length();i++)
			statistics.insert(str.charAt(i), i);
		
		System.out.println("The first appear once character : "+statistics.findFirstAppearOnce());
	}
	public static void main(String [] args)
	{

		P55_FindAppearOnceInInputstream  test = new P55_FindAppearOnceInInputstream ();
		//test
		//founction test
		System.out.println("Founction Test:");
		test.findTheCharacter("go");
		test.findTheCharacter("gooogle");
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		test.findTheCharacter("g");
		test.findTheCharacter("abcdefghijklmnabcdefghijklmno");
		
		//exception test		
		System.out.println("\nException Test:");
		test.findTheCharacter("");
		test.findTheCharacter(null);
	}
}
class Charstatistics
{
	public int [] hashChar = new int[256];//collection of characters is hash; key is ascii code of character, 
																										//value is -1  mean:not appear; -2 mean: appear multip times; >=0 mean: index
	public Charstatistics()
	{
		for(int i = 0; i<hashChar.length;i++)
			hashChar[i] = -1;
	}
	public void insert(char c ,int index) //position of character in string
	{
		if(hashChar[c]==-1)
			hashChar[c]=index; //appear once
		else if(hashChar[c]>-1)
			hashChar[c] = -2;  //appear multip times;
	}
	public char findFirstAppearOnce()
	{
		int minIndex = Integer.MAX_VALUE;
		char target=' ';
		for(int i =0;i<hashChar.length;i++)
		{
			if(hashChar[i]>-1 && hashChar[i] <minIndex)
			{
				minIndex = hashChar[i];
				target = (char)i;
			}
		}
		return target;
	}
}
