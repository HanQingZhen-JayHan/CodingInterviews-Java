
public class P42_ReverseSentene {

	public void ReverseSentence(String str)
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
		System.out.println("The original sentence: "+str);
		char [] sentence = str.toCharArray();
		 reverse(sentence ,0,sentence.length-1);
		 int start = 0;
		 int end = 0;
		 for(char c:sentence)
		 {
			if(c==' ') 
			{
				reverse(sentence,start,end-1);
				start = end+1;
			}
			end++;
		 }
		System.out.println("The Reverse sentence: "+String.valueOf(sentence));
	}
	
	public void reverse(char[] sentence, int start,int end) {
		// TODO Auto-generated method stub
		if(end<start)
			return;// null;
		while(end>start)
		{
			char temp = sentence[start];
			sentence [start] = sentence[end];
			sentence[end] =temp;
			start ++;
			end --;
		}
		//return sentence;
	}

	public static void main(String [] args)
	{

		P42_ReverseSentene  test = new P42_ReverseSentene ();
		//test
		//founction test
		System.out.println("Founction Test:");
		String str ="I am a student!";
		test.ReverseSentence(str);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		String strOne = "a";
		test.ReverseSentence(strOne);
		String strSpace = "          space";
		test.ReverseSentence(strSpace);
		
		//exception test		
		System.out.println("\nException Test:");
		String strEmpty = "";
		test.ReverseSentence(strEmpty);
		test.ReverseSentence(null);
		
	}
}
