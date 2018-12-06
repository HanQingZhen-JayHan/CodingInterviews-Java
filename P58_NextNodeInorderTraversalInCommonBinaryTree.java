import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


public class P58_NextNodeInorderTraversalInCommonBinaryTree {

	public void nextNode(BinaryTreeWithParentPionter tree ,int node)
	{
		//suppose that there are no the same element in BinaryTree!
		if(tree == null)
		{System.out.println("The BinaryTree is NULL!");
		return;
		}
		boolean globleFlag = false;
		int nextNode = -1;
		//inorder Traversal to generate list
		List<Integer> inOrderList = new ArrayList<Integer>();
		inOrderTraversal(tree.root,inOrderList);
		Iterator<Integer> iterator = inOrderList.iterator();
		System.out.print("The InOrder Traversal :[ ");
		while(iterator.hasNext()){
			System.out.print(iterator.next()+" ");
		}
		System.out.println("]");
		iterator = inOrderList.iterator();
		while(iterator.hasNext()){
			if(iterator.next() == node)
				break;
		}
		if(iterator.hasNext()){
			nextNode = iterator.next();
			globleFlag = true;
		}
		
		System.out.println(node+"'s next node is "+nextNode+" , globleFlag = "+globleFlag );
	}
	
	private void inOrderTraversal(BinaryNodeWithParentPointer root, List list) {
		// TODO Auto-generated method stub
		if(root== null)
			return ;
		inOrderTraversal(root.left,list);
		list.add(root.value);
		inOrderTraversal(root.right,list);
	}

	public static void main(String [] args)
	{

		P58_NextNodeInorderTraversalInCommonBinaryTree  test = new P58_NextNodeInorderTraversalInCommonBinaryTree ();
		//test
		//founction test
        System.out.println("Founction Test:");
		int [] pre ={10,5,2,1,3,4,8,7,6,9,15,12,11,13,14,18,17,16,19};
		int [] in = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
		BinaryTreeWithParentPionter tree = new BinaryTreeWithParentPionter (pre,in);
		// 12
		test.nextNode(tree,12);

		//boundary test		
		System.out.println("\nBoundary Test:");
		//root
		test.nextNode(tree, 10);
		//left node with right child 5
		test.nextNode(tree, 5);
		//left node without right child 1
		test.nextNode(tree, 1);
		//right node with right child 8
		test.nextNode(tree, 8);
		//right node without right child19
		test.nextNode(tree, 19);
		test.nextNode(tree, 9);
		int [] pre_a1 ={1};
		int [] in_a1 = {1};
		BinaryTreeWithParentPionter treeA1 = new BinaryTreeWithParentPionter (pre_a1,in_a1);
		test.nextNode(treeA1,1);
		//only left child
		int [] preLeft ={5,4,3,2,1};
		int [] inLeft ={1,2,3,4,5};
		BinaryTreeWithParentPionter treeLeft = new BinaryTreeWithParentPionter (preLeft,inLeft);
		test.nextNode( treeLeft,3);
		//only right child
		int [] preRight ={1,2,3,4,5};
		int [] inRight ={1,2,3,4,5};
		BinaryTreeWithParentPionter treeRight = new BinaryTreeWithParentPionter (preRight,inRight);
		test.nextNode( treeRight,5);
		
		//exception test		
		System.out.println("\nException Test:");
		test.nextNode(null,0);
	}
}