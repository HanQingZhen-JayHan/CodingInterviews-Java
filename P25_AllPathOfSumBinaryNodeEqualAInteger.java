import java.util.Iterator;
import java.util.Stack;


public class P25_AllPathOfSumBinaryNodeEqualAInteger {

	public static void printPath(BinaryTree tree, int sum)
	{
		if(tree == null |sum<0)
		{
			System.out.println("The Binary Tree or SUM is EXCEPTION!");
			return;
		}
		Stack<BinaryNode>  stack = new Stack<BinaryNode>();

		int sumStack =0;
		pathRecursion(tree.root,sum,stack,sumStack);
		
	}
	
	private static void pathRecursion(BinaryNode root, int sum,
			Stack<BinaryNode> stack, int sumStack) {
		// TODO Auto-generated method stub
		if(root == null)
			return;
		stack.push(root);
		sumStack  +=stack.peek().value;
		if(root.left == null && root.right ==null) 
		{
			if (sum == sumStack){
				System.out.println("Sum: "+sum);
			Iterator<BinaryNode> iterator = stack.iterator();
			while(iterator.hasNext())
				System.out.print(iterator.next().value+" ");
			System.out.println();

			}
			sumStack -=stack.pop().value;
			return;
		}
		if( sumStack > sum)
		{
			sumStack -=stack.pop().value;
			return;
		}
		if(root.left!= null)
			pathRecursion(root.left,sum,stack,sumStack);
		if(root.right!= null)
			pathRecursion(root.right,sum,stack,sumStack);
		stack.pop();

	}
/*

	public static void main(String [] args)
	{

		P25_AllPathOfSumBinaryNodeEqualAInteger  test = new P25_AllPathOfSumBinaryNodeEqualAInteger ();
		int [] pre ={5,9,6,4,10,8,3,12,7};
		int [] in = {6,9,10,4,5,3,12,8,7};
		BinaryTree tree = new BinaryTree (pre,in);
		//test
		//founction test
		System.out.println("Founction Test:");
		//have
		int sum = 28;
		test.printPath(tree, sum);
		//don't have
		sum =29;
		test.printPath(tree, sum);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		//one node
		int [] pre_a1 ={0};
		int [] in_a1 = {0};
		BinaryTree treeA1 = new BinaryTree (pre_a1,in_a1);
		sum =2;
		test.printPath(treeA1, sum);
		sum =0;
		test.printPath(treeA1, sum);
		//only left child
		int [] preLeft ={1,2,3,4,5};
		int [] inLeft ={1,2,3,4,5};
		BinaryTree treeLeft = new BinaryTree (preLeft,inLeft);
		sum =15;
		test.printPath(treeLeft, sum);
		//only right child
		int [] preRight ={1,2,3,4,5};
		int [] inRight ={5,4,3,2,1};
		BinaryTree treeRight = new BinaryTree (preRight,inRight);
		sum =15;
		test.printPath(treeRight, sum);
		
		//exception test		
		System.out.println("\nException Test:");
		//null
		test.printPath(null, sum);
		//negtive
		sum = -1;
		test.printPath(tree, sum);
	}
	*/
}
