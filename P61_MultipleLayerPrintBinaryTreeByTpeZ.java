
public class P61_MultipleLayerPrintBinaryTreeByTpeZ {

	public void print(BinaryTree tree)
	{
		if(tree == null ||tree.root== null)
		{
			System.out.println("NULL Exception!");
			return;
		}
		tree.multipleLayerPrint();
		tree.multipleLayerPrintByTypeZ();
	}
	
	public static void main(String [] args)
	{

		P61_MultipleLayerPrintBinaryTreeByTpeZ  test = new P61_MultipleLayerPrintBinaryTreeByTpeZ ();
		//test
		//founction test
        System.out.println("Founction Test:");
		int [] pre ={1,2,4,8,9,5,10,11,3,6,12,13,7,14,15};
		int [] in = {8,4,9,2,10,5,11,1,12,6,13,3,14,7,15};
		BinaryTree tree = new BinaryTree (pre,in);
		test.print(tree);

		//boundary test		
		System.out.println("\nBoundary Test:");
		//root
		int [] pre_a1 ={1};
		int [] in_a1 = {1};
		BinaryTree treeA1 = new BinaryTree (pre_a1,in_a1);
		test.print(treeA1);
		//only left child
		int [] preLeft ={5,4,3,2,1};
		int [] inLeft ={1,2,3,4,5};
		BinaryTree treeLeft = new BinaryTree (preLeft,inLeft);
		test.print( treeLeft);
		//only right child
		int [] preRight ={1,2,3,4,5};
		int [] inRight ={1,2,3,4,5};
		BinaryTree treeRight = new BinaryTree (preRight,inRight);
		test.print( treeRight);
		
		//exception test		
		System.out.println("\nException Test:");
		test.print(null);
	}
}