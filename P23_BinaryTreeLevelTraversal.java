
public class P23_BinaryTreeLevelTraversal {

	public static void levelPrint(BinaryTree tree)
	{
		if(tree == null)
		{
			System.out.println("The Binary Tree is NULL!");
			return;
		}
		tree.levelTrveral();
	}
	/*
	public static void main(String [] args)
	{

		P23_BinaryTreeLevelTraversal  test = new P23_BinaryTreeLevelTraversal ();
		
		int [] pre ={1,2,3,4,5,6,7,8};
		int [] in = {3,4,2,1,6,7,5,8};
		BinaryTree tree = new BinaryTree (pre,in);
		//test
		//founction test
		System.out.println("Founction Test:");
		test.levelPrint(tree);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		int [] pre_a1 ={1};
		int [] in_a1 = {1};
		BinaryTree treeA1 = new BinaryTree (pre_a1,in_a1);
		test.levelPrint(treeA1);
		//only left child
		 //only right child
		
		//exception test		
		System.out.println("\nException Test:");
		test.levelPrint(null);
	}
	*/
}
