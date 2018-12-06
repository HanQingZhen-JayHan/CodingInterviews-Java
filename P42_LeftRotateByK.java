
public class P42_LeftRotateByK {

	public void leftRotate(String str,int k)
	{
		if(str == null)
		{
			System.out.println("The string is NULL!");
			return;
		}
		if(str.length()<=0)
		{
			System.out.println("The string is EMPYT!");
			return;
		}
		if(k<0)
		{
			System.out.println("K is illegal! k= "+k);
			return;
		}
		P42_ReverseSentene Reverse = new P42_ReverseSentene();
		char [] sentence = str.toCharArray();
		int start =0;
		int end = k%str.length();
		Reverse.reverse(sentence, start, end-1);
		Reverse.reverse(sentence, end, str.length()-1);
		Reverse.reverse(sentence, start, str.length()-1);
		System.out.println("The original string: "+str);
		System.out.println("After left rotate by "+k+": "+String.valueOf(sentence));
	}
	public static void main(String [] args)
	{

		P42_LeftRotateByK  test = new P42_LeftRotateByK ();
		//test
		//founction test
		System.out.println("Founction Test:");
		String str = "abcdefg";
		int k=3;
		test.leftRotate(str, k);
		k=10;
		test.leftRotate(str, k);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		String strOne = "a";
		k=1;
		test.leftRotate(strOne, k);
		k=10;
		test.leftRotate(strOne, k);
		String strSame ="aaaaaaaa";
		
		//exception test		
		System.out.println("\nException Test:");
		k=0;
		test.leftRotate(str, k);
		k=-1;
		test.leftRotate(str, k);
		test.leftRotate(null, k);
		
	}
	
}
