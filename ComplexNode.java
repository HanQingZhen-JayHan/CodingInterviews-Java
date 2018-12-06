
public class ComplexNode {

	int value;
	ComplexNode next;
	ComplexNode sibling;
	
	public ComplexNode()
	{
		this.value = 0;
		this.next  = null;
		this.sibling = null;
	}
	public ComplexNode(int v)
	{
		this();
		this.value  = v;
	}
	public ComplexNode(int v, ComplexNode next,ComplexNode sibling)
	{
		this.value = v;
		this.next = next;
		this.sibling = sibling;
	}
}
