
public class P28_StringPermutation {

	public static void printStringOfPermutated(String str)
	{
		if(str == null)
		{
			System.out.println("The string is NULL!");
			return;
		}
		if(str.length()<=0)
		{
			System.out.println("The string is Empty!");
			return;
		}
		recursion(str,0);
	}
	
	
	private static void recursion(String str,int index) {
		// TODO Auto-generated method stub
		if(str.length()-1==index)
		{
			System.out.println(str);
			return;
		}
		for(int i = index;i<str.length();i++)
		{
			char [] temp = str.toCharArray();
			char c = temp[i];
			temp[i] = temp [index];
			temp[index] = c;
			String newStr = String.valueOf(temp);
			recursion(newStr,index+1);
		}
	}

/*
	public static void main(String [] args)
	{

		P28_StringPermutation  test = new P28_StringPermutation ();
		
		String str = "abcd";
		//test
		//founction test
		System.out.println("Founction Test:");
		test.printStringOfPermutated(str);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		String strOne = "a";
		test.printStringOfPermutated(strOne);
		
		//exception test		
		System.out.println("\nException Test:");
		test.printStringOfPermutated(null);
		test.printStringOfPermutated("");
	}
	*/
}
