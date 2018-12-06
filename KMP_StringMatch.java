
public class KMP_StringMatch {

	//Time Complexity :O(n)
	public int match(String target, String pattern)
	{
		if(target!= null && target.length()>0 && pattern!=null &&pattern.length()>0)
		{
			if(pattern.length()>target.length())//
				return -1;
			
			int tIndex = 0; //target index
			int pIndex =0; //pattern index
			//int [] next = getNext(pattern);
			int [] next = getNextPlus(pattern);
			while(tIndex<target.length())
			{
				if(pIndex==-1 || target.charAt(tIndex)==pattern.charAt(pIndex))//next
				{
					tIndex++;
					pIndex++;
				}
				else//pattern index back,target index not trace back
				{
					pIndex = next[pIndex];
				}
				if(pIndex == pattern.length())
					return tIndex-pIndex;
			}
		}
		return -1;
	}
	private int[] getNext(String pattern) {
		// TODO Auto-generated method stub
		if(pattern!=null && pattern.length()>0)
		{
			int [] next = new int [pattern.length()];
			next[0]=-1;
			int k =-1;
			int index=0;
			while(index<pattern.length()-1)
			{
				if(k==-1 || pattern.charAt(index)==pattern.charAt(k))
				{
					k++;
					index++;
					next[index]=k;//will be improved
				}
				else
					k = next[k];
			}
			return next;
		}
		return null;
	}
	private int[] getNextPlus(String pattern) {
		// TODO Auto-generated method stub
		if(pattern!=null && pattern.length()>0)
		{
			int [] next = new int [pattern.length()];
			next[0]=-1;
			int k =-1;
			int index=0;
			while(index<pattern.length()-1)
			{
				if(k==-1 || pattern.charAt(index)==pattern.charAt(k))
				{
					k++;
					index++;
					if(pattern.charAt(index)!=pattern.charAt(k))//improvement
						next[index]=k;
					else
						next[index]=next[k];
				}
				else
					k = next[k];
			}
			return next;
		}
		return null;
	}
	public static void main(String [] args)
	{

		KMP_StringMatch  test = new KMP_StringMatch ();
		//test
		//founction test
		System.out.println("Founction Test:");
		String target = "abdabcabbabcabc";
		String pattern = "ac";
		System.out.println("Find "+pattern+"(pattern) "+target+"(target) in "+test.match(target, pattern));
		pattern = "abcabc";
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
