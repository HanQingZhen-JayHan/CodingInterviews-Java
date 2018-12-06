
public class P58_NextNodeInBinaryTreeWithParentPionterInorderTraversal {

	public void nextNode(BinaryTreeWithParentPionter tree ,int node)
	{
		if(tree == null)
		{System.out.println("The BinaryTreeWithParentPionter is NULL!");
		return;
		}
		//find the node by Preorder Traversal
		BinaryNodeWithParentPointer p = findNode(tree.root,node);
		BinaryNodeWithParentPointer nextNode = null;
		nextNode = solution1(p);
		//nextNode = solution2(p);
		System.out.println(node+"'s next node is "+nextNode);
	}
	public BinaryNodeWithParentPointer solution2(BinaryNodeWithParentPointer p)
	{
		
		if (p== null)
			return null;
		BinaryNodeWithParentPointer nextNode =null;
		// have right child
		if(p.right != null)
		{
			p = p.right;
			while(p.left != null )
			{
				p = p.left;
			}
			nextNode = p;
		}
		//don't have right child and not root
		else if(p.parent != null)
		{
			BinaryNodeWithParentPointer pCurrent = p;
			BinaryNodeWithParentPointer pParent  = p.parent;
			while(pParent != null && pParent.right == pCurrent)
			{
				pCurrent = pParent;
				pParent  = pParent.parent;
			}
			nextNode = pParent;
		}
		//don't have right child and is root
		
		return nextNode;
	}
	public BinaryNodeWithParentPointer solution1(BinaryNodeWithParentPointer p)
	{
		BinaryNodeWithParentPointer nextNode =null;
		if (p== null)
			return null;
		//root with right child
		if(p.parent ==null && p.right != null)
		{
			p = p.right;
			while(p.left != null )
			{
				p = p.left;
			}
			nextNode = p;
		}
		else if(p.parent ==null && p.right == null)
		{
			nextNode = null;
		}
		// left node with right child
		else if(p.parent.left == p && p.right!= null)
		{
			p = p.right;
			while(p.left != null )
			{
				p = p.left;
			}
			nextNode = p;
		}
		//left node without right child
		else if(p.parent.left ==p && p.right == null)
		{
			nextNode = p.parent;
		}
		//right node wtih right child
		else if(p.parent.right == p && p.right!= null)
		{
			p = p.right;
			while(p.left != null )
			{
				p = p.left;
			}
			nextNode = p;
		}
		//right node without right child
		else
		{
			while(p.parent!= null && p.parent.right == p)
				p = p.parent;
			//if(p.parent!= null)
				nextNode = p.parent;
			//else
			//	nextNode = null;
		}
		return nextNode;
	}
	
	private BinaryNodeWithParentPointer findNode(BinaryNodeWithParentPointer root, int value) {
		// TODO Auto-generated method stub
		if(root== null)
			return null;
		if(root.value == value)
			return root;
		BinaryNodeWithParentPointer pLeft = findNode(root.left,value);
		BinaryNodeWithParentPointer pRight = findNode(root.right,value);
		if(pLeft != null)
			return pLeft;
		return pRight;
	}

	public static void main(String [] args)
	{

		P58_NextNodeInBinaryTreeWithParentPionterInorderTraversal  test = new P58_NextNodeInBinaryTreeWithParentPionterInorderTraversal ();
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
