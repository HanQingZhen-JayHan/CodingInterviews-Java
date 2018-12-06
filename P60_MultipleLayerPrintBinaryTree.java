
public class P60_MultipleLayerPrintBinaryTree {

	public void print(BinaryTree tree)
	{
		if(tree == null ||tree.root== null)
		{
			System.out.println("NULL Exception!");
			return;
		}
		tree.multipleLayerPrint();
	}
	
	public static void main(String [] args)
	{

		P60_MultipleLayerPrintBinaryTree  test = new P60_MultipleLayerPrintBinaryTree ();
		//test
		//founction test
        System.out.println("Founction Test:");
		int [] pre ={8,6,5,7,6,7,5};
		int [] in = {5,6,7,8,7,6,5};
		BinaryTree tree = new BinaryTree (pre,in);
		// yes
		test.print(tree);
		int [] preNo ={8,6,5,7,9,7,5};
		int [] inNo = {5,6,7,8,7,9,5};
		BinaryTree treeNo = new BinaryTree (preNo,inNo);
		test.print(treeNo);
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
