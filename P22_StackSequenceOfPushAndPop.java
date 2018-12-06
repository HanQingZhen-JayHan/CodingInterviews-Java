import java.util.Stack;


public class P22_StackSequenceOfPushAndPop {

	public static void isPopSequenceOfPushInStack(int [] pushArray, int [] popArray)
	{
		if(pushArray == null | popArray == null)
		{
			System.out.println("The pushArray or popArray is NULL!");
			return;
		}
		if(pushArray.length<=0 | popArray.length<=0)
		{
			System.out.println("The pushArray or popArray is EMPTY!");
			return;
		}
		if(pushArray.length != popArray.length)
		{
			System.out.println("The popArray is NOT pop sequence of pushArray in stack!");
			return;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int index_push=0;
		int index_pop=0;

		while(index_push<pushArray.length)
		{
			stack.push(pushArray[index_push++]);
			while(stack.peek() != popArray[index_pop]  &&  index_push<pushArray.length)
				stack.push(pushArray[index_push++]);
			while(!stack.isEmpty() &&index_pop<popArray.length && stack.peek() == popArray[index_pop]  ){
			     System.out.print(stack.pop()+" ");
			     index_pop++;
			}
		}
		while(!stack.isEmpty() &&index_pop<popArray.length && stack.peek() == popArray[index_pop]  ){
		     System.out.print(stack.pop()+" ");
		     index_pop++;
		}
		System.out.println();
		if(index_pop ==popArray.length)
			System.out.println("The popArray is POP sequence of pushArray in stack!");
		else
			System.out.println("The popArray is NOT pop sequence of pushArray in stack!");
	}
/*	
	public static void main(String [] args)
	{

		P22_StackSequenceOfPushAndPop  test = new P22_StackSequenceOfPushAndPop ();
		
		int [] pushArray={1,2,3,4,5,6,7,8,9};
		int [] popArray={4,5,3,2,1,9,8,7,6};
		int [] popArrayWrong = {4,3,5,1,2,9,8,7,6};
		//test
		//founction test
		System.out.println("Founction Test:");
		//right
		test.isPopSequenceOfPushInStack(pushArray, popArray);
		//wrong
		test.isPopSequenceOfPushInStack(pushArray, popArrayWrong);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		//one
		int [] pushOne= {1};
		int [] popOne = {2};
		test.isPopSequenceOfPushInStack(pushOne, popOne);
		//exception test		
		System.out.println("\nException Test:");
		//empty
		int [] pushArrayEmpty={};
		int [] popArrayEmpty={};
		test.isPopSequenceOfPushInStack(pushArrayEmpty, popArrayEmpty);
		//null
		test.isPopSequenceOfPushInStack(pushArray, null);
		test.isPopSequenceOfPushInStack(null, popArrayEmpty);
	}
	*/
}
