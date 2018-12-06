
public class P39_TheDepthOfBinaryTree {

	public void depth(BinaryTree tree)
	{
		if(tree == null)
		{
			System.out.println("The binary tree is NULL!");
			return;
		}
		if(tree.root == null)
		{
			System.out.println("The binary tree is EMPTY!");
			return;
		}

		int depth = recursion(tree.root);
		System.out.println("The depth of binary tree is "+depth);
	}
	
	private int recursion(BinaryNode root) {
		// TODO Auto-generated method stub
		if(root == null)
			return 0;
		int depthLeft  = recursion(root.left);
		int depthRight  = recursion(root.right);
		
		return depthLeft>depthRight ? depthLeft+1 :depthRight+1;
	}

	public static void main(String [] args)
	{

		P39_TheDepthOfBinaryTree  test = new P39_TheDepthOfBinaryTree ();
		int [] pre ={1,2,3,4,5,6,7,8};
		int [] in = {3,4,2,1,6,7,5,8};
		BinaryTree tree = new BinaryTree (pre,in);
		//test
		//founction test
		System.out.println("Founction Test:");
		test.depth(tree);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		int [] pre_a1 ={1};
		int [] in_a1 = {1};
		BinaryTree treeA1 = new BinaryTree (pre_a1,in_a1);
		test.depth(treeA1);
		//only left child
		int [] preLeft ={1,2,3,4,5};
		int [] inLeft ={1,2,3,4,5};
		BinaryTree treeLeft = new BinaryTree (preLeft,inLeft);
		test.depth(treeLeft);
		//only right child
		int [] preRight ={1,2,3,4,5};
		int [] inRight ={5,4,3,2,1};
		BinaryTree treeRight = new BinaryTree (preRight,inRight);

		test.depth(treeRight);
		
		//exception test		
		System.out.println("\nException Test:");
		test.depth(null);
		BinaryTree treeEmpty = new BinaryTree ();
		test.depth(treeEmpty);
	}
}
