import java.util.LinkedList;
import java.util.Queue;


public class P19_BinaryTreeMirror {

	public static void mirrorOfBinaryTree(BinaryTree tree)
	{
		if(tree == null)
		{System.out.println("EXCEPTION: The tree is NULL!");
		return;
		}
		System.out.println("The original tree:");
		tree.preOrder();
		tree.inOrder();
		tree.postOrder();
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.offer(tree.root);
		while(!queue.isEmpty())
		{
			BinaryNode root = queue.poll();
			BinaryNode temp = root.left;
			root.left = root.right;
			root.right = temp;
			if(root.left !=null)
				queue.offer(root.left);
			if(root.right != null)
				queue.offer(root.right);	
		}
		System.out.println("\nThe mirror tree:");
		tree.preOrder();
		tree.inOrder();
		tree.postOrder();
		
		mirrorRecursion(tree.root);
		System.out.println("\nThe mirror mirror tree(Recursion Method):");
		tree.preOrder();
		tree.inOrder();
		tree.postOrder();
	}
	public static void mirrorRecursion(BinaryNode root)
	{
		if(root.left == null && root.right == null)
			return;
		
		BinaryNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		if(root.left!=null)
			mirrorRecursion(root.left);
		if(root.right != null)
			mirrorRecursion(root.right);
	}
	/*
	public static void main(String [] args)
	{

		P19_BinaryTreeMirror  test = new P19_BinaryTreeMirror ();
		
		int [] pre ={1,2,3,4,5,6,7,8};
		int [] in = {3,4,2,1,6,7,5,8};
		BinaryTree tree = new BinaryTree (pre,in);
		//test
		//founction test
		System.out.println("Founction Test:");
		test.mirrorOfBinaryTree(tree);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		int [] pre_a1 ={1};
		int [] in_a1 = {1};
		BinaryTree treeA1 = new BinaryTree (pre_a1,in_a1);
		test.mirrorOfBinaryTree(treeA1);
		//only left
		//only right
		
		//exception test		
		System.out.println("\nException Test:");
		test.mirrorOfBinaryTree(null);
	}
	*/
}
