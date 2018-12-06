
public class P51_DuplicateMemberInArray {

	public void findDuplicateNumber(int [] array)
	{
		if(array == null )
		{System.out.println("The array is NULL!");
		return;
		}
		if(array.length<=0)
		{
			System.out.println("The array is EMPTY !");
			return;
		}
		if(array.length==1)
		{
			System.out.println("The array don not have duplicate member! [ "+array[0]+" ]");
			return;
		}
		System.out.print("The array :[ ");
		for(int k:array)
		{
			System.out.print(k+" ");
		}
		System.out.println("]");
		
        int index =0;
        boolean find =false;
		for( index = 0;index<array.length;index++)
		{
			
			while(index != array[index])
			{
				int m = array[index];
				if(array[m] == m)
				{
					find = true;
					break;
				}
				array[index] = array[m];
				array[m] = m;
			}
			if(find)
				break;
		}
		if(index < array.length)
			System.out.println("Find the duplicate member: "+array[index]);
		else
			System.out.println("Not find! ");
	}
	public static void main(String [] args)
	{

		P51_DuplicateMemberInArray  test = new P51_DuplicateMemberInArray ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int [] array = {7,4,5,6,4,0,1,2,3,3,};
		test.findDuplicateNumber(array);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		int [] arrayOne ={0};
		test.findDuplicateNumber(arrayOne);
		int [] arrayTwo ={0,1};
		test.findDuplicateNumber(arrayTwo);
		int [] arrayNo = {0,1,2,3,4,5,6,7,8,9};
		test.findDuplicateNumber(arrayNo);
		int [] arraySame = {2,2,2,2,2,2,2,2,2,2};
		test.findDuplicateNumber(arraySame);
		
		
		//exception test		
		System.out.println("\nException Test:");
		int [] arrayEmpty = {};
		test.findDuplicateNumber(arrayEmpty);
		test.findDuplicateNumber(null);
		
	}
}
