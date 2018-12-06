
public class P28_StringCombination {

	public static void printCombination(int number)
	{
		if(number <=0)
		{
			System.out.println("The number of Combination must be bigger than 0! number: "+number);
			return;
		}
		char [] array = new char[number];
		for(int i=0;i<array.length;i++)
		{
			array[i]=(char) (i+'a');
		}
		for(int i =0;i<array.length;i++)
		{
		char [] temp = new char[i+1];
		recursion(array,0,temp,0);
		}

	}
	
	private static void recursion(char[] array, int index,char [] comb,int m_count) {
		// TODO Auto-generated method stub
		if(m_count == comb.length )
		{
			System.out.println(String.valueOf(comb));
			return;
		}
		if(index == array.length)
		{
			return;
		}
		recursion(array,index+1,comb,m_count);
		comb[m_count++]=array[index];
		recursion(array,index+1,comb,m_count);
	}

	
	public static void main(String [] args){
	P28_StringCombination  test = new P28_StringCombination ();
	//test
	//founction test
	System.out.println("Founction Test:");
	int number = 5;
	test.printCombination(number);
	
	//boundary test		
	System.out.println("\nBoundary Test:");
	number = 1;
	test.printCombination(number);
	
	//exception test		
	System.out.println("\nException Test:");
	test.printCombination(0);
	}
}
