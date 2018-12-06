
public class P44_Card {

	public void isContinus( int [] array)
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
		System.out.println("  1 means A \n11 means  J \n12 means Q \n13 means K\n  0 means Read&Black Joker ");
		int joker =0;
		int gap =0;
		QuickSort qs = new QuickSort();
		qs.sort(array);
		qs.display(array);

		for(int index =array.length-1;index>=0;index--){
			if(array[index] ==0)
				joker++;
			else if(index>1 && array[index-1]>0)
			{  if(array[index]==array[index-1])
				{
					gap = Integer.MAX_VALUE;
					break;
				}
				gap += array[index]-array[index-1]-1;
			}
		}
		if(joker>=gap)
			System.out.println("The five cards is continus! joker = "+joker+", gap = "+gap);
		else
			System.out.println("The five cards is NOT continus! joker = "+joker+", gap = "+gap);
	}
	public static void main(String [] args)
	{

		P44_Card  test = new P44_Card ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int [] array ={1,2,3,0,0};
		test.isContinus(array);
		int [] arrayNo = {1,6,3,9,0};
		test.isContinus(arrayNo);
		//boundary test		
		System.out.println("\nBoundary Test:");
		int []array00 ={9,13,12,0,0};
		test.isContinus(array00);
		int []arrayPair ={9,9,12,0,0};
		test.isContinus(arrayPair);
		
		//exception test		
		System.out.println("\nException Test:");
		int [] arrayEmpty = {};
		test.isContinus(arrayEmpty);
		test.isContinus(null);
	}
}
