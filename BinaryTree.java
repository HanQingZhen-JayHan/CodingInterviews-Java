import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BinaryTree {
	BinaryNode root;
	boolean rebuild_legal = true;
	public BinaryTree()
	{
		
	}
	public BinaryTree(int [] preOrder,int [] inOrder )
	{
	
		if(!this.isLegal(preOrder, inOrder))
			return;
		
		this.root = buildBinaryTree(preOrder,inOrder,0,0,preOrder.length);
		if(!this.rebuild_legal)
			this.root = null;
		
	}
	private BinaryNode buildBinaryTree(int [] preOrder,int [] inOrder, int preStart,int inStart, int len )
	{
		if(len<=0)
			return null;

		int inIndex =0;
		while(inIndex<len && preOrder[preStart]!=inOrder[inStart+inIndex] )
			inIndex++;
		if(inIndex == len)
		{
			System.out.println("preOrder and inOrder are not the same binarytree!");
			this.rebuild_legal = false;   //check the preOrder & inOrder can rebuild a binary tree.
			return null;
		}
		BinaryNode root = new BinaryNode(preOrder[preStart]);
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
	private void preOrder_recursion(BinaryNode root)
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
	private void inOrder_recursion(BinaryNode root)
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
	private void postOrder_recursion(BinaryNode root)
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
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.offer(root);
		System.out.println("The Traversal of Binary Tree :");
		while(!queue.isEmpty())
		{
			BinaryNode root =queue.poll();
			System.out.print(root+" ");
			if(root.left!= null)
				queue.offer(root.left);
			if(root.right != null)
				queue.offer(root.right);
		}
		System.out.println();
	}
	public void multipleLayerPrint()
	{
		if(root == null)
			return;
		int CurrentLayer = 0; //current layer node count ,current print
		int NextLayer = 0 ; //next layer node count, will print
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.offer(root);
		NextLayer++;
		System.out.println("Multiple layer print of Binary Tree :");
		while(!queue.isEmpty())
		{
			if(CurrentLayer == 0){
				System.out.println();
				CurrentLayer = NextLayer;
				NextLayer = 0;
			}
			BinaryNode root =queue.poll();
			CurrentLayer--;
			System.out.print(root+" ");
			if(root.left!= null){
				queue.offer(root.left);
				NextLayer++;
			}
			if(root.right != null){
				queue.offer(root.right);
				NextLayer++;
			}
		}
		System.out.println();
	}
	
	public void multipleLayerPrintByTypeZ()
	{
		if(root == null)
			return;
		
		Stack<BinaryNode> stack1 = new Stack<BinaryNode>();
		Stack<BinaryNode> stack2 = new Stack<BinaryNode>();
		stack1.push(root);
		System.out.println("Multiple layer Type Z print of Binary Tree :");
		while(!stack1.isEmpty() || !stack2.isEmpty())
		{
			while(!stack1.isEmpty()){
				BinaryNode root = stack1.pop();
				System.out.print(root+" ");
				if(root.left!= null)
					stack2.push(root.left);
				if(root.right != null)
					stack2.push(root.right);
			}
			System.out.println();
			while(!stack2.isEmpty())
			{
				BinaryNode root = stack2.pop();
				System.out.print(root+" ");
				if(root.right != null)
					stack1.push(root.right);
				if(root.left!= null)
					stack1.push(root.left);

			}
			System.out.println();
		}
		//System.out.println();
	}
}
