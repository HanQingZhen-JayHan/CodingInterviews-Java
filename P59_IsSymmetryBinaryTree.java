
public class P59_IsSymmetryBinaryTree {

	public void isSymmetry(BinaryTree tree)
	{
		if(tree == null ||tree.root== null)
		{
			System.out.println("NULL Exception!");
			return;
		}
		//System.out.print("Bianry Tree: ");
		tree.multipleLayerPrint();
		BinaryNode root = tree.root;
		boolean flag = check(root.left,root.right);
		if(flag)
			System.out.println("Symmetry!");
		else
			System.out.println("Not symmetry!");
	}

	private boolean check(BinaryNode left, BinaryNode right) {
		// TODO Auto-generated method stub
		if(left == null && right == null)
			return true;
		if(left != null && right == null || left == null && right!= null)
			return false;
		if(left.value == right.value)
		{
			return check(left.left,right.right) && check(left.right,right.left);
		}
		return false;
	}
	
	public static void main(String [] args)
	{

		P59_IsSymmetryBinaryTree  test = new P59_IsSymmetryBinaryTree ();
		//test
		//founction test
        System.out.println("Founction Test:");
		int [] pre ={8,6,5,7,6,7,5};
		int [] in = {5,6,7,8,7,6,5};
		BinaryTree tree = new BinaryTree (pre,in);
		// yes
		test.isSymmetry(tree);
		int [] preNo ={8,6,5,7,9,7,5};
		int [] inNo = {5,6,7,8,7,9,5};
		BinaryTree treeNo = new BinaryTree (preNo,inNo);
		test.isSymmetry(treeNo);
		//boundary test		
		System.out.println("\nBoundary Test:");
		//root
		int [] pre_a1 ={1};
		int [] in_a1 = {1};
		BinaryTree treeA1 = new BinaryTree (pre_a1,in_a1);
		test.isSymmetry(treeA1);
		//only left child
		int [] preLeft ={5,4,3,2,1};
		int [] inLeft ={1,2,3,4,5};
		BinaryTree treeLeft = new BinaryTree (preLeft,inLeft);
		test.isSymmetry( treeLeft);
		//only right child
		int [] preRight ={1,2,3,4,5};
		int [] inRight ={1,2,3,4,5};
		BinaryTree treeRight = new BinaryTree (preRight,inRight);
		test.isSymmetry( treeRight);
		
		//exception test		
		System.out.println("\nException Test:");
		test.isSymmetry(null);
	}
}
