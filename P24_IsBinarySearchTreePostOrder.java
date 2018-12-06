
public class P24_IsBinarySearchTreePostOrder {

	public static void isPostOrderOfBinarySearchTree(int [] postOrder)
	{
		if(postOrder == null)
		{System.out.println("The sequence of postOrder is NULL!");
		return;
		}
		if(postOrder.length<=0)
		{
			System.out.println("The sequence of postOrder is EMPTY!");
			return;
		}
//		if(postOrder.length == 1)
//		{
//			System.out.println("The sequence is postOrder of a Binary Search Tree!");
//			return;
//		}
		boolean judge = checkPostOrderRecursion(postOrder,0,postOrder.length);
		if(judge)
			System.out.println("The sequence is postOrder of a Binary Search Tree!");
		else
			System.out.println("The sequence is NOT postOrder of a Binary Search Tree!");
	}
	
	private static boolean checkPostOrderRecursion(int[] postOrder, int start, int length) {
		// TODO Auto-generated method stub
		if(length <= 1)
			return true;
		
		int i=0;
		int root = postOrder[length-1];
		while( i<length) 
			if(root<postOrder[i++]) 
				break;
		int j=i-1;
		while( j<length) 
			if(root>postOrder[j++])
				return false;
		
		return checkPostOrderRecursion(postOrder,start,i-1) && checkPostOrderRecursion(postOrder,i,length-i);
	}
/*
	public static void main(String [] args)
	{

		P24_IsBinarySearchTreePostOrder  test = new P24_IsBinarySearchTreePostOrder ();
		int [] postOrder ={5,7,6,9,11,10,8};
		int [] postOrder_wrong = {19,7,6,9,11,10,8};
		//test
		//founction test
		System.out.println("Founction Test:");
		//yes
		test.isPostOrderOfBinarySearchTree(postOrder);
		//no
		test.isPostOrderOfBinarySearchTree(postOrder_wrong);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		//one
		int [] postOne = {1};
		test.isPostOrderOfBinarySearchTree(postOne);
		//only left
		int [] postLeft = {1,2,3,4,5};
		test.isPostOrderOfBinarySearchTree(postLeft);
		//only right
		int [] postRight = {6,7,8,9,5};
		test.isPostOrderOfBinarySearchTree(postRight);
		
		//exception test		
		System.out.println("\nException Test:");
		//empty
		int [] postEmpty = {};
		test.isPostOrderOfBinarySearchTree(postEmpty);
		//null
		test.isPostOrderOfBinarySearchTree(null);
	}
	*/
}
