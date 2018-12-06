
public class P53_RegularExpression {
	public void match(String pattern,String str)
	{
		if(pattern == null || str == null)
		{
			System.out.println("NULL Exception! pattern = "+pattern+", str = "+str);
			return;
		}
		if(pattern.length()<=0 |str.length()<=0)
		{
			System.out.println("EMPTY Exception! pattern = "+pattern+", str = "+str);
			return;
		}
		System.out.println("pattern: "+pattern+", str: "+str);
		
		boolean pass = recursion(pattern,0,str,0);
		if(pass)
		{
			System.out.println("str match pattern!");
		}
		else
			System.out.println("str don't match!");
	}
	private boolean recursion(String pattern, int patternIndex, String str, int strIndex) {
		// TODO Auto-generated method stub
		if((patternIndex == pattern.length()) && (strIndex == str.length()))
			return true;
		if((patternIndex== pattern.length()) || (strIndex ==str.length()))
			return false;
		
		if(patternIndex+1<pattern.length() &&pattern.charAt(patternIndex+1) == '*')
		{
			if(pattern.charAt(patternIndex) == str.charAt(strIndex)  && strIndex<str.length() || (pattern.charAt(patternIndex) == '.'))
				return recursion(pattern,patternIndex+2,str,strIndex)  ||    //0
						    recursion(pattern,patternIndex+2,str,strIndex+1) ||   //1
						    recursion(pattern,patternIndex,str,strIndex+1);       //n
			else
				return recursion(pattern,patternIndex+2,str,strIndex); //ignore *
		}
		if(pattern.charAt(patternIndex) == str.charAt(strIndex)  && strIndex<str.length() || (pattern.charAt(patternIndex) == '.'))
			return recursion(pattern,patternIndex+1,str , strIndex+1);
		return false;
	}
	public static void main(String [] args)
	{

		P53_RegularExpression  test = new P53_RegularExpression ();
		//test
		//founction test
		System.out.println("Founction Test:");
		String str = "a";
		String pattern = ".";
		test.match(pattern, str);
		String pattern1 = "*";
		test.match(pattern1, str);
		String pattern2 = ".*";
		test.match(pattern2, str);
		String pattern3 = "*.";
		test.match(pattern3, str);
		String pattern4 = "a*";
		str = "aab";
		test.match(pattern4, str);
		String pattern5 =  "a.";
		test.match(pattern5, str);
		String pattern6 = "a*ab";
		test.match(pattern6, str);
		String pattern7 = "a.b";
		test.match(pattern7, str);
		//boundary test		
		System.out.println("\nBoundary Test:");
		String strOne = "a";
		test.match(pattern, strOne);
		test.match(pattern1, strOne);
		test.match(pattern2, strOne);
		test.match(pattern3, strOne);
		test.match(pattern4, strOne);
		test.match(pattern5, strOne);
		test.match(pattern6, strOne);
		test.match(pattern7, strOne);
		String patternFull = "a ab aaaa abababa";
		test.match(patternFull, patternFull);
		//exception test		
		System.out.println("\nException Test:");
		String strEmpty = "";
		test.match(patternFull, strEmpty);
		test.match(strEmpty, str);
		test.match(null, strEmpty);
		test.match(patternFull, null);
	}
}
