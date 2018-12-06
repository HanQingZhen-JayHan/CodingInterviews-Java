
class Node
{
	int value;
	Node next;
	public Node()
	{
		this.value = 0;
		this.next  = null;
	}
	public Node(int v)
	{
		this.value = v;
		this.next  = null;
	}
	public Node(int v, Node next)
	{
		this.value = v;
		this.next  = next;
	}
	public String toString()
	{
		return value+"";
	}
}
