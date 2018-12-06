import java.util.Iterator;
import java.util.Stack;


public class P50_TheLowestAncestorCommenTree {

	int globleFlag = -3;
	public void ancestor(int child1, int child2,BinaryTree tree)
	{
		//Suppose child1 and child2 may not be in BinarySearchTree
		if(tree == null)
		{System.out.println("The binary search tree is NULL!");
		return;
		}
		if(child1 == child2)
		{
			System.out.println("The two node is the same! They don't have the ancestor! child1 = "+child1+", child2 = "+child2);
			return;
		}

		//find the ancestor & check two nodes by preTraverals
		int ancestor = -1;
		StringBuilder path1 = new StringBuilder();
		StringBuilder path2 = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		findAncestor(tree.root, child1,path1, child2,path2,stack);
		int parent_index =-1;
		int i = 0;

		while(i<path1.length() && i<path2.length())
		{
			char c1 = path1.charAt(i);
			char c2 = path2.charAt(i);
			if(c1 == c2)
			{
				parent_index=i;
				i++;
			}
			else
				break;
		}
		if(parent_index == -1)
		{
			System.out.println("Not find the ancestor!  child1 = "+child1+", child2 = "+child2+", globleFlag = "+globleFlag);
		}
		else
		{
			System.out.println("Find the ancestor: "+path1.charAt(parent_index));
		}
			globleFlag =-3; //resest
	}

	private void findAncestor(BinaryNode root, int child1, StringBuilder path1, int child2,StringBuilder path2,Stack<Integer> stack) {
		// TODO Auto-generated method stub
		if(root == null)
			return ;
		stack.push(root.value);
		if(root.value == child1) //find the child1
		{
			globleFlag=-2;
			System.out.println("Find child1: "+child1);
			Iterator<Integer> iterator = stack.iterator();
			while(iterator.hasNext()){
				path1.append(String.valueOf(iterator.next()));
			}
		}
		else 	if(root.value == child2) //find the child2
		{
			globleFlag=-1;
			System.out.println("Find child2: "+child2);
			Iterator<Integer> iterator = stack.iterator();
			while(iterator.hasNext()){
				path2.append(String.valueOf(iterator.next()));
			}
		}
		findAncestor(root.left,child1,path1,child2,path2,stack);
		findAncestor(root.right,child1,path1,child2,path2,stack);
		stack.pop();
	}
private int checkNode(BinaryNode root,int child)  //1: find 0:not find
{
	if(root == null)
		return 0;
	if(root.value == child)
		return 1;
	else if(root.value>child)
		return checkNode(root.left,child);
	else if(root.value <child)
		return checkNode(root.right, child);
	else
		return 0;
}
	public static void main(String [] args)
	{

		P50_TheLowestAncestorCommenTree  test = new P50_TheLowestAncestorCommenTree ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int [] pre ={10,5,2,1,3,4,8,7,6,9,15,12,11,13,14,18,17,16,19};
		int [] in = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
		BinaryTree tree = new BinaryTree (pre,in);
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
		BinaryTree treeA1 = new BinaryTree (pre_a1,in_a1);
		test.ancestor(child1, child2, treeA1);
		//only left child
		int [] preLeft ={5,4,3,2,1};
		int [] inLeft ={1,2,3,4,5};
		BinaryTree treeLeft = new BinaryTree (preLeft,inLeft);
		child2=3;
		test.ancestor(child1, child2, treeLeft);
		//only right child
		int [] preRight ={1,2,3,4,5};
		int [] inRight ={1,2,3,4,5};
		BinaryTree treeRight = new BinaryTree (preRight,inRight);
		test.ancestor(child1, child2, treeRight);
		
		//exception test		
		System.out.println("\nException Test:");
		test.ancestor(child1, child2, null);
		
	}
}
