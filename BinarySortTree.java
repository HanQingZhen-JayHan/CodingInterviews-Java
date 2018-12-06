
public class BinarySortTree extends BinaryTree{

	//public boolean searchError =false;
	public BinarySortTree(){super();}
	public BinarySortTree(int [] array)
	{
		super();
		if(array == null || array.length<=0)
			return;
		//find the mid member to keep balance
		//int mid = array.length>>1;
		//Partition partition = new Partition();
		//partition.minK(array, mid);
		//this.insert(array[mid]);
		for(int i=0; i<array.length;i++)
		{
			//if(i==mid)
			//	continue;
			this.insert(array[i]);
		}
	}
	public void insert(int i) {
		// TODO Auto-generated method stub
		if(this.root== null)
			this.root = new BinaryNode(i);
		else
		{
			BinaryNode p = this.root,parent=null;
			while(p!=null )
			{
				parent =p;
				if(i==p.value)
					return; 
				else if(i<p.value)
					p = p.left;
				else
					p = p.right;
			}
			if(i==parent.value)
				return; 
			else if(i<parent.value)
				parent.left = new BinaryNode(i);
			else
				parent.right= new BinaryNode(i);

		}
		
	}
	public BinaryNode search (int target)
	{
		if(this.root == null)
			return null;
		BinaryNode p = this.root;
		while(p!=null)
		{
			if(p.value == target)
				return p;
			else if(p.value <target)
				p = p.right;
			else
				p = p.left;
		}
		return null;
	}

	public BinaryNode remove(int target)
	{
		if(this.root == null)
			return null;
		return remove(this.root,null,target);
	}
	private BinaryNode remove(BinaryNode root, BinaryNode parent, int target) {
		// TODO Auto-generated method stub
		if(root == null)//not find target
			return null;
		if(root.value>target)
			return remove(root.left,root,target);//search left tree
		else if(root.value<target)
			return remove(root.right,root,target);//search right tree
		else{//find the target
			if(parent == null)//the target is root
			{
				if(root.left!=null)
					this.root = root.left;
				else
					this.root = root.right;
				return root;
			}
			if(root.left!=null &&root.right!=null)//root has two childrens
			{
				BinaryNode next = root.right;
				while(next.left!=null)
					next = next.left;
				root.value = next.value;
				BinaryNode p = remove(root.right,root,root.value);
				p.value = target;
				return p;
			}
			if(root == parent.left)//root is leaf or only left child of parent
			{
				if(root.left!=null)
					parent.left = root.left;
				else
					parent.left = root.right;
			}
			else if(root == parent.right)//root is leaf or only right child of parent
			{
				if(root.left!=null)
					parent.right = root.left;
				else
					parent.right = root.right;
			}
			return root;
		}
	}
	public static void main(String [] args)
	{
		//test
		//founction test
		System.out.println("Founction Test:");
		int [] array = {54,18,66,87,36,12,54,81,15,76,57,6,40,99,85,99};
		BinarySortTree  test = new BinarySortTree (array);
		test.inOrder();
		//test.multipleLayerPrint();
		System.out.println("Search 66: "+test.search(66));
		System.out.println("Search 100: "+test.search(100));
		//test.inOrder();
		//boundary test		
		
		System.out.println("\nBoundary Test:");
		//root
		int [] array1 ={1};
		BinarySortTree treeA1 = new BinarySortTree (array1);
		treeA1.inOrder();
		System.out.println("Search 1: "+treeA1.search(1));
		System.out.println("Search 0: "+treeA1.search(0));
		
		//only left child
		int [] arrayleft ={5,4,3,2,1};
		BinarySortTree treeLeft = new BinarySortTree (arrayleft);
		treeLeft.inOrder();
		System.out.println("Search 1: "+treeLeft.search(1));
		System.out.println("Search 0: "+treeLeft.search(0));
		//only right child
		int [] arrayRight ={1,2,3,4,5};
		BinarySortTree treeRight = new BinarySortTree (arrayleft);
		treeRight.inOrder();
		System.out.println("Search 1: "+treeRight.search(1));
		System.out.println("Search 0: "+treeRight.search(0));
		
		//exception test		
		System.out.println("\nException Test:");
		BinarySortTree treeException = new BinarySortTree (null);
	}
}
