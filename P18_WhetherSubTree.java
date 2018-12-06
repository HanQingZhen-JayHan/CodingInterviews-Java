
public class P18_WhetherSubTree {

	public static void isSubTree(BinaryTree treeA, BinaryTree treeB) //Whether treeB is subtree of treeA?
	{
		if(treeA== null | treeB == null)
		{
			System.out.println("The treeA or treeB is NULL!");
			return;
		}
		boolean subTree = recursionIsSubTree(treeA.root,treeB.root);
		if(subTree)
			System.out.println("The treeB is sub tree of treeA!");
		else
			System.out.println("The treeB is NOT sub tree of treeA!");
		//System.out.println("The treeA is "+treeA.getClass().getName());
	}
	
	private static boolean recursionIsSubTree(BinaryNode rootA, BinaryNode rootB ) {
		// TODO Auto-generated method stub
		if(rootB == null)
			return true;
		if(rootA == null)
			return false;
		if(rootA.value == rootB.value)
		{
			return recursionIsSubTree(rootA.left,rootB.left) & recursionIsSubTree(rootA.right,rootB.right);
		}
		
		return recursionIsSubTree(rootA.left,rootB) | recursionIsSubTree(rootA.right,rootB);
	}
/*
	public static void main(String [] args)
	{

		P18_WhetherSubTree  test = new P18_WhetherSubTree ();
		int [] pre_a ={1,2,3,4,5,6,7,8};
		int [] in_a = {3,4,2,1,6,7,5,8};
		BinaryTree treeA = new BinaryTree (pre_a,in_a);
		int [] pre_b ={5,6,7};
		int [] in_b = {6,7,5};
		BinaryTree treeB = new BinaryTree(pre_b,in_b);
		
		int [] pre_c ={1,2,3,4};
		int [] in_c = {4,3,2,1};
		BinaryTree treeC = new BinaryTree(pre_c,in_c);
		//test
		//founction test
		System.out.println("Founction Test:");
		// subtree
		test.isSubTree(treeA, treeB);
		test.isSubTree(treeA, treeA);
		// not subtree
		test.isSubTree(treeB, treeA);
		test.isSubTree(treeA, treeC);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		//only one root
		int [] pre_a1 ={1};
		int [] in_a1 = {1};
		BinaryTree treeA1 = new BinaryTree (pre_a1,in_a1);
		int [] pre_b1 ={1};
		int [] in_b1 = {1};
		BinaryTree treeB1 = new BinaryTree(pre_b1,in_b1);
		
		int [] pre_c1 ={2};
		int [] in_c1 = {2};
		BinaryTree treeC1 = new BinaryTree(pre_c1,in_c1);
		test.isSubTree(treeA1, treeB1);
		test.isSubTree(treeA1, treeC1);
		test.isSubTree(treeA, treeA1);
		//left child
		
		//right child
		
		//exception test		
		System.out.println("\nException Test:");
		
		// one null
		test.isSubTree(treeA, null);
		test.isSubTree(null, treeB);
		//two null
		test.isSubTree(null, null);
	}
	*/
}
