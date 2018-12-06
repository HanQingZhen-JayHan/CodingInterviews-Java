
import java.util.LinkedList;
import java.util.Queue;


public class P50_TheLowestAncestorParentPointer {

	public void ancestor(int child1, int child2,BinaryTreeWithParentPionter tree)
	{
		//Suppose child1 and child2 may not be in BinaryTreeWithParentPionter
		if(tree == null)
		{System.out.println("The BinaryTreeWithParentPionter is NULL!");
		return;
		}
		if(child1 == child2)
		{
			System.out.println("The two node is the same! They don't have the ancestor! child1 = "+child1+", child2 = "+child2);
			return;
		}
		BinaryNodeWithParentPointer node1 = findNode(tree.root,child1);
		BinaryNodeWithParentPointer node2 = findNode(tree.root,child2);
		if(node1 == null | node2 == null)
		{
			System.out.println("node1 or node2 is not in binary tree with parent pointer! child1 = "+child1+" ,child2 = "+child2);
			return;
		}
		//convert to two linkedlist have a common node
		int node1Length =0;
		BinaryNodeWithParentPointer p = node1;
		while(p!=null)
		{
			node1Length++;
			p = p.parent;
		}
		int node2Length =0;
		p = node2;
		while(p!=null)
		{
			node2Length++;
			p = p.parent;
		}

		BinaryNodeWithParentPointer p1 = node1;
		BinaryNodeWithParentPointer p2 = node2;
		if(node1Length >=node2Length)
		{
			int n = node1Length - node2Length;		
			while(n!=0 && p1!= null)
			{
				n--;
				p1 = p1.parent;
			}
		}
		else
		{
			int n = node2Length - node1Length;		
			while(n!=0 && p2!= null)
			{
				n--;
				p2 = p2.parent;
			}
		}
		while(p1!= null && p2 != null)
		{
			if(p1 == p2)
			{
				break;
			}
			p1 = p1.parent;
			p2 = p2.parent;
		}
		if(p1 != null && p2!= null){
			System.out.println("Find the ancestor: "+p1.value);
		}
		else
			System.out.println("Not find the ancestor! node1 = "+node1.value+" ,node2 = "+node2.value);

	}
	public BinaryNodeWithParentPointer findNode(BinaryNodeWithParentPointer root , int child)
	{
		if(root == null)
			return null;
		if(root.value == child)
			return root;
		BinaryNodeWithParentPointer findLeft = findNode(root.left,child);
		BinaryNodeWithParentPointer findRight = findNode(root.right,child);
		if(findLeft != null)
			return findLeft;
		//if(findRight != null) //if findLeft is null,return findRight (findRight is right node,return the node,else return null)
			return findRight;
		//return null;
	}
	public static void main(String [] args)
	{

		P50_TheLowestAncestorParentPointer  test = new P50_TheLowestAncestorParentPointer ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int [] pre ={10,5,2,1,3,4,8,7,6,9,15,12,11,13,14,18,17,16,19};
		int [] in = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
		BinaryTreeWithParentPionter tree = new BinaryTreeWithParentPionter (pre,in);
		// exist
		int child1 = 4;
		int child2 = 9;
		test.ancestor(child1, child2, tree);
		//not exist
		child2=3;
		test.ancestor(child1, child2, tree);
		child2 = 60;
		test.ancestor(child1, child2, tree);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		int [] pre_a1 ={1};
		int [] in_a1 = {1};
		BinaryTreeWithParentPionter treeA1 = new BinaryTreeWithParentPionter (pre_a1,in_a1);
		test.ancestor(child1, child2, treeA1);
		//only left child
		int [] preLeft ={5,4,3,2,1};
		int [] inLeft ={1,2,3,4,5};
		BinaryTreeWithParentPionter treeLeft = new BinaryTreeWithParentPionter (preLeft,inLeft);
		child2=3;
		test.ancestor(child1, child2, treeLeft);
		//only right child
		int [] preRight ={1,2,3,4,5};
		int [] inRight ={1,2,3,4,5};
		BinaryTreeWithParentPionter treeRight = new BinaryTreeWithParentPionter (preRight,inRight);
		test.ancestor(child1, child2, treeRight);
		
		//exception test		
		System.out.println("\nException Test:");
		test.ancestor(child1, child2, null);
	}
}


class BinaryNodeWithParentPointer {
	int value;
	BinaryNodeWithParentPointer left;
	BinaryNodeWithParentPointer right;
	BinaryNodeWithParentPointer parent;
	
	public BinaryNodeWithParentPointer()
	{
		this.value = 0;
		this.left   = null;
	    this.right = null;
	    this.parent = null;
	}
	public BinaryNodeWithParentPointer(int v)
	{
		this();
		this.value = v;
	}
	public BinaryNodeWithParentPointer(int v, BinaryNodeWithParentPointer left, BinaryNodeWithParentPointer right)
	{
		this.value = v;
		this.left   = left;
	    this.right = right;
	    this.parent = null;
	}
	
	public String toString()
	{
		return value+" ";
	}
}

class BinaryTreeWithParentPionter {
	BinaryNodeWithParentPointer root;
	boolean rebuild_legal = true;
	public BinaryTreeWithParentPionter()
	{
		
	}
	public BinaryTreeWithParentPionter(int [] preOrder,int [] inOrder )
	{
	
		if(!this.isLegal(preOrder, inOrder))
			return;
		
		this.root = buildBinaryTree(preOrder,inOrder,0,0,preOrder.length);
		if(!this.rebuild_legal)
			this.root = null;
		buildParent_recursion(root);
	}
	private void buildParent_recursion(BinaryNodeWithParentPointer root)
	{
		if(root == null)
			return ;
		if(root.left!= null){
			root.left.parent = root;
			buildParent_recursion(root.left);
		}
		if(root.right!= null){
			root.right.parent = root;
			buildParent_recursion(root.right);
		}

	}
	private BinaryNodeWithParentPointer buildBinaryTree(int [] preOrder,int [] inOrder, int preStart,int inStart, int len )
	{
		if(len<=0)
			return null;

		int inIndex =0;
		while(preOrder[preStart]!=inOrder[inStart+inIndex] && inIndex<len)
			inIndex++;
		if(inIndex == len)
		{
			System.out.println("preOrder and inOrder are not the same binarytree!");
			this.rebuild_legal = false;   //check the preOrder & inOrder can rebuild a binary tree.
			return null;
		}
		BinaryNodeWithParentPointer root = new BinaryNodeWithParentPointer(preOrder[preStart]);
		root.left = buildBinaryTree(preOrder, inOrder,preStart+1,inStart,inIndex);
		root.right = buildBinaryTree(preOrder,inOrder,preStart+inIndex+1,inStart+inIndex+1,len-inIndex-1);
				
		return root;
	}
	public boolean isLegal(int [] preOrder, int [] inOrder)
	{
		boolean pass = true;
		if(preOrder == null | inOrder == null)
		{
			System.out.println("The array of preOrder or inOrder is NULL!");
			return false;
		}
		if(preOrder.length<=0 | inOrder.length<=0)
		{
			System.out.println("The length of preOrder or inOrder is 0!");
			return false;
		}
		if(preOrder.length!= inOrder.length)
		{
			System.out.println("preOrder.length is not equal inOrder.length!");
			return false;
		}
		
		return pass;
	}
	public void preOrder()
	{
		if(this.root == null)
		{
			System.out.println("The binary tree is NULL!");
			return;
		}
		System.out.println("Binary Tree PreOder:");
		preOrder_recursion(this.root);
		System.out.println();
	}
	private void preOrder_recursion(BinaryNodeWithParentPointer root)
	{
		if(root == null)
			return ;
		System.out.print(root.toString());
		preOrder_recursion(root.left);
		preOrder_recursion(root.right);
	}
	public void inOrder()
	{
		if(this.root == null)
		{
			System.out.println("The binary tree is NULL!");
			return ;
		}
		System.out.println("Binary Tree InOrder:");
		inOrder_recursion(this.root);
		System.out.println();
	}
	private void inOrder_recursion(BinaryNodeWithParentPointer root)
	{
		if(root == null)
			return ;
		inOrder_recursion(root.left);
		System.out.print(root.toString());
		inOrder_recursion(root.right);
	}
	public void postOrder()
	{
		if(this.root == null)
		{
			System.out.println("The binary tree is NULL!");
			return ;
		}
		System.out.println("Binary Tree postOrder:");
		postOrder_recursion(this.root);
		System.out.println();
	}
	private void postOrder_recursion(BinaryNodeWithParentPointer root)
	{
		if(root == null)
			return ;
		postOrder_recursion(root.left);
		postOrder_recursion(root.right);
		System.out.print(root.toString());
	}
	public void levelTrveral()
	{
		if(root == null)
			return;
		Queue<BinaryNodeWithParentPointer> queue = new LinkedList<BinaryNodeWithParentPointer>();
		queue.offer(root);
		System.out.println("The Traversal of Binary Tree :");
		while(!queue.isEmpty())
		{
			BinaryNodeWithParentPointer root =queue.poll();
			System.out.print(root+" ");
			if(root.left!= null)
				queue.offer(root.left);
			if(root.right != null)
				queue.offer(root.right);
		}
		System.out.println();
	}
}

