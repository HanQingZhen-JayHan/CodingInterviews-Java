
public class P63_KstNodeInBinarySearchTree {
// 1st big node is smallest value  of node in binary search tree;
	private static int count = 0;
	public void findKNode(BinaryTree tree,int k)
	{
		if(tree == null)
		{System.out.println("The binary search tree is NULL!");
		return;
		}
		if(k<1)
		{
			System.out.println("k is illegal! k= "+k);
			return;
		}
		P63_KstNodeInBinarySearchTree.count =0;
		BinaryNode target = inOrderTraversal(tree.root,k);
		if(target!= null)
		{
			System.out.println("Find the node! k = "+k+",  value = "+target.value);
		}
		else
			System.out.println("Not Find!  k = "+k);
	}

	private BinaryNode inOrderTraversal(BinaryNode root, int k) {
		// TODO Auto-generated method stub
		if(root == null)
			return null;
		BinaryNode target =	inOrderTraversal(root.left,k);
		P63_KstNodeInBinarySearchTree.count++;
		if(k == P63_KstNodeInBinarySearchTree.count)
			target= root;
		//k--;
		if(target == null )
			target = inOrderTraversal(root.right,k);
		
		return target;
	}
	public static void main(String [] args)
	{

		P63_KstNodeInBinarySearchTree  test = new P63_KstNodeInBinarySearchTree ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int [] pre ={10,5,2,1,3,4,8,7,6,9,15,12,11,13,14,18,17,16,19};
		int [] in = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
		BinaryTree tree = new BinaryTree (pre,in);
		tree.inOrder();
		//find
		test.findKNode(tree,5);
		//not find
		test.findKNode(tree,55);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		int [] pre_a1 ={1};
		int [] in_a1 = {1};
		BinaryTree treeA1 = new BinaryTree (pre_a1,in_a1);
		treeA1.inOrder();
		test.findKNode(treeA1,1);
		//only left child
		int [] preLeft ={5,4,3,2,1};
		int [] inLeft ={1,2,3,4,5};
		BinaryTree treeLeft = new BinaryTree (preLeft,inLeft);
		treeLeft.inOrder();
		test.findKNode(treeLeft,1);
		//only right child
		int [] preRight ={1,2,3,4,5};
		int [] inRight ={1,2,3,4,5};
		BinaryTree treeRight = new BinaryTree (preRight,inRight);
		treeRight.inOrder();
		test.findKNode(treeRight,5);
		
		//exception test		
		System.out.println("\nException Test:");
		test.findKNode(null,-1);
		
	}
}
