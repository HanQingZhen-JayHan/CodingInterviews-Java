
public class BruteForce_StringMatch {

	//Time complexity :O(n*m)
	public int match(String target, String pattern)
	{
		if(target!= null && target.length()>0 && pattern!=null &&pattern.length()>0)
		{
			if(pattern.length()>target.length())
				return -1;
			
			int tIndex = 0; //target index
			int pIndex =0; //pattern index
			while(pIndex<pattern.length() && tIndex<target.length())
			{
				if( target.charAt(tIndex)==pattern.charAt(pIndex))//next
				{
					tIndex++;
					pIndex++;
				}
				else//target index trace back
				{
					tIndex -=pIndex;
					tIndex++;
					pIndex=0;
				}
			}
			if(pIndex==pattern.length())
				return tIndex-pIndex;
			else
				return -1;
		}
		return -1;
	}
	public static void main(String [] args)
	{

		BruteForce_StringMatch  test = new BruteForce_StringMatch ();
		//test
		//founction test
		System.out.println("Founction Test:");
		String target = "aaaaab";
		String pattern = "ac";
		System.out.println("Find "+pattern+"(pattern) "+target+"(target) in "+test.match(target, pattern));
		pattern = "ab";
		System.out.println("Find "+pattern+"(pattern) "+target+"(target) in "+test.match(target, pattern));
		
		//boundary test		
		System.out.println("\nBoundary Test:");	
		pattern = "a";
		System.out.println("Find "+pattern+"(pattern) "+target+"(target) in "+test.match(target, pattern));
		pattern = "b";
		System.out.println("Find "+pattern+"(pattern) "+target+"(target) in "+test.match(target, pattern));
		target = "a";
		System.out.println("Find "+pattern+"(pattern) "+target+"(target) in "+test.match(target, pattern));
		
		pattern = "aaa";
		System.out.println("Find "+pattern+"(pattern) "+target+"(target) in "+test.match(target, pattern));

		
		//exception test		
		System.out.println("\nException Test:");
		pattern = "";
		target  ="";
		System.out.println("Find "+pattern+"(pattern) "+target+"(target) in "+test.match(target, pattern));
		pattern = null;
		System.out.println("Find "+pattern+"(pattern) "+target+"(target) in "+test.match(target, pattern));
		target =null;
		System.out.println("Find "+pattern+"(pattern) "+target+"(target) in "+test.match(target, pattern));
	}
}
