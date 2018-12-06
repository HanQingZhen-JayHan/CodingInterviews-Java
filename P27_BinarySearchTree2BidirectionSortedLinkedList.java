
public class P27_BinarySearchTree2BidirectionSortedLinkedList {

	public static void translate2BidirectionLinkedList(BinaryTree tree)
	{
		if(tree == null)
		{System.out.println("The Binary Tree is NULL!");
		return;
		}
		
		BinaryNode Head = recursion(tree.root,null);
		 
		System.out.println("The bidirection sorted linked list : \n left:");
		BinaryNode p = Head;
		while(p!= null)
		{
			System.out.print(p.value+"->");
			p = p.left;
		}
		System.out.println("\n right: ");
		p = Head;
		while(p.left!= null)
		{
			p = p.left;
		}
		while(p!= null)
		{
			System.out.print(p.value+"->");
			p = p.right;
		}
		System.out.println();
	}
	
	private static BinaryNode recursion(BinaryNode root,BinaryNode LastNode) {
		// TODO Auto-generated method stub
		if(root == null)
			return null;
		//BinaryNode LastNode = null;
		//left
		if(root.left != null)
			LastNode =recursion(root.left,LastNode);
		
		//root
		root.left = LastNode;
		if(LastNode != null)
			LastNode.right = root;
		LastNode = root;
		
		//right
		if(root.right != null)
			LastNode=recursion(root.right,LastNode);
		
		return LastNode;
	}
/*
	public static void main(String [] args)
	{

		P27_BinarySearchTree2BidirectionSortedLinkedList  test = new P27_BinarySearchTree2BidirectionSortedLinkedList ();
		int [] pre = {5,3,1,2,4,7,6,8,9};
		int [] in ={1,2,3,4,5,6,7,8,9}; 
		BinaryTree tree = new BinaryTree (pre,in);
		//test
		//founction test
		System.out.println("Founction Test:");
		test.translate2BidirectionLinkedList(tree);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		//one node
		int [] pre_a1 ={1};
		int [] in_a1 = {1};
		BinaryTree treeA1 = new BinaryTree (pre_a1,in_a1);
		test.translate2BidirectionLinkedList(treeA1);
		//only left child
		int [] pre_left ={9,8,7,6,5,4,3,2,1};
		int [] in_left = {1,2,3,4,5,6,7,8,9}; 
		BinaryTree treeLeft = new BinaryTree (pre_left,in_left);
		test.translate2BidirectionLinkedList(treeLeft);
		//only right child
		int [] pre_right ={1,2,3,4,5,6,7,8,9}; 
		int [] in_right = {1,2,3,4,5,6,7,8,9}; 
		BinaryTree treeRight = new BinaryTree (pre_right,in_right);
		test.translate2BidirectionLinkedList(treeRight);
		
		//exception test		
		System.out.println("\nException Test:");
		test.translate2BidirectionLinkedList(null);
	}
	
	*/
}
