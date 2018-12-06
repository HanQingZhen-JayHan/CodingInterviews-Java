
public class P50_TheLowestAncestorBinarySearchTree {
	int globleFlag = -2;
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
		int smallChild = child1<child2 ? child1:child2;
		int bigChild     = child1<child2 ? child2:child1;
		//find the ancestor & check two nodes by preTraverals
		int ancestor = -1;
		ancestor = findAncestor(tree.root, smallChild, bigChild);
		if(globleFlag !=0)
			System.out.println("Not find the ancestor! child1 = "+child1+", child2 = "+child2);
	//	else
			globleFlag =-2; //resest
	}

	private int findAncestor(BinaryNode root, int smallChild, int bigChild) {
		// TODO Auto-generated method stub
		if(root == null)
			return -1;
		if(root.value>=smallChild && root.value<=bigChild)
		{
			if(checkNode(root,smallChild)==1){
			globleFlag ++;
			System.out.println("Find node : "+smallChild);
			}
			if(checkNode(root,bigChild)==1){
			globleFlag ++;
			System.out.println("Find node : "+bigChild);
			}
			if(globleFlag==0){
				System.out.println("Find the ancestor: "+root.value);
				return root.value;
			}
			else
			{
				System.out.println("Not find the ancestor for one or two nodes is not in binary search tree!");
				System.out.println("node1= "+smallChild+", node2 = "+bigChild);
				return -1;
			}
		}
		else if(root.value >bigChild)
			return findAncestor(root.left,smallChild,bigChild);
		else if(root.value<smallChild)
			return findAncestor(root.right,smallChild,bigChild);
		else
			return -1;
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

		P50_TheLowestAncestorBinarySearchTree  test = new P50_TheLowestAncestorBinarySearchTree ();
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
