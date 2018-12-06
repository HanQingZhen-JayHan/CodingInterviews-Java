import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class GrapAdjacencyList implements GGraph{
	ArrayList<Vertex> vertexList ;

	public GrapAdjacencyList(int size)
	{
		if(size<10) size = 10;
		vertexList = new ArrayList<Vertex>(size);
	}
	public GrapAdjacencyList(int [] vertexs, Edge []edges)
	{
		//suppose vertexs != null
		//this(vertexs.length);
		vertexList = new ArrayList<Vertex>();
		if(vertexs != null && vertexs.length>0)
		{
			for(int i = 0 ;i<vertexs.length;i++)
				insertVertex(vertexs[i]);
		}
		if(edges!= null && edges.length>0)
		{
			for(int i =0;i<edges.length;i++)
				insertEdge(edges[i]);
		}
	}
	public static void main(String [] args)
	{


		//test
		//founction test
		System.out.println("Founction Test:");
		int [] vertexs = {0,1,2,3,4};
		Edge [] edges ={
				new Edge(0,1,5),new Edge(0,3,2),new Edge(1,0,5),
				new Edge(1,2,7),new Edge(1,3,6),new Edge(2,1,7),new Edge(2,3,8),
				new Edge(2,4,3),new Edge(3,0,2),new Edge(3,1,6),new Edge(3,2,8),
				new Edge(3,4,9),new Edge(4,2,3),new Edge(4,3,9)
		};
		GrapAdjacencyList test = new GrapAdjacencyList(vertexs,edges);
		test.printGraph();
		System.out.println("\n Depth Search First: ");
		for(int i=0;i<test.vertexCount();i++)//value
			test.DFSTraverse(test.getValue(i));
		System.out.println("\n Broadcast Search First: ");
		for(int i=0;i<test.vertexCount();i++)//value
			test.BFSTraverse(test.getValue(i));
		
		System.out.println("Insert vertex F, Insert Edge(A,F,20), delete vertex C, delete edge (D,E):");
		System.out.println("Insert vertex F:");
		test.insertVertex(5);
		test.printGraph();
		System.out.println("Insert Edge(A,F,20):");
		test.insertEdge(0, 5, 20);
		test.insertEdge(5, 0, 20);
		test.printGraph();
		System.out.println("delete vertex C:");
		test.removeVertex(2);
		test.printGraph();
		System.out.println("delete edge (D,E):");//A=0,B=1,C=2,D=3,E=4,F=5
		test.removeEdge(3, 4);//value
		test.removeEdge(4, 3);
		test.printGraph();
		
		//boundary test		
		System.out.println("\nBoundary Test:");

		
		//exception test		
		System.out.println("\nException Test:");
	}
	public void insertEdge(Edge edge) {
		// TODO Auto-generated method stub
		insertEdge(edge.start,edge.dest,edge.weight);
	}
	@Override
	public int vertexCount() {
		// TODO Auto-generated method stub
		
		return vertexList.size();
	}

	@Override
	public int getValue(int index) {
		// TODO Auto-generated method stub
		return vertexList.get(index).data;
	}

	public int getIndex(int value)
	{
		int index =-1;
		if(value>=0){
			for(int i=0;i<vertexCount();i++)
				if(	vertexList.get(i).data ==value)
					return i;
//			Iterator<Vertex> iterator = vertexList.iterator();
//			while(iterator.hasNext())
//			{
//				index++;
//				if(iterator.next().data==value);
//					return index;
//			}
		}
		return -1;//not exist
	}
	@Override
	public int getWeight(int vertex1, int vertex2) {
		// TODO Auto-generated method stub
		NodeT<EdgeOfAdjList> p = vertexList.get(vertex1).adjlink.head.next;
		while(p!= null)
		{
			if(p.data.dest == vertex2)
				return p.data.weight;
			p = p.next;
		}
		return this.MAX_WEIGHT;
	}

	@Override
	public void insertEdge(int vertex1, int vertex2, int weight) {
		// TODO Auto-generated method stub
		NodeT<EdgeOfAdjList> front = vertexList.get(vertex1).adjlink.head;
		NodeT<EdgeOfAdjList> p = vertexList.get(vertex1).adjlink.head.next;
		while(p!= null &&p.data.dest<vertex2)
		{
			front =p;
			p = p.next;
		}
		front.next = new NodeT<EdgeOfAdjList>(new EdgeOfAdjList(vertex2,weight),p);
	}

	@Override
	public void insertVertex(int vertex) {
		// TODO Auto-generated method stub
		//vertex is value not index
		if(vertex>=0)
			vertexList.add(new Vertex(vertex));
	}

	@Override
	public void removeVertex(int vertex) {
		// TODO Auto-generated method stub
		//vertex is value not index
		if(vertex>=0){
			Iterator<Vertex> iterator = vertexList.iterator();
			while(iterator.hasNext())
			{
				removeEdge(iterator.next().data,vertex);
			}
			vertexList.remove(vertex);
		}
		
	}

	@Override
	public void removeEdge(int vertex1, int vertex2) {
		// TODO Auto-generated method stub
		//vertex1,vertex2 is value means A=0,B=1, C=2,D=3,E=4,F=5....
		NodeT<EdgeOfAdjList> front=null;
		for(int i=0;i<vertexList.size();i++)
			if(vertexList.get(i).data == vertex1){
				front= vertexList.get(i).adjlink.head;
				break;}
		if(front ==null)
			return;
		NodeT<EdgeOfAdjList> p = front.next;
		while(p!= null )
		{
			if(p.data.dest==vertex2){
				front.next =p.next;
				break;
			}
			front =p;
			p = p.next;
		}
	}

	@Override
	public int getNextNeighbor(int vertex1, int vertex2) {
		// TODO Auto-generated method stub
		//vertex1,vertex2 is index is non negative A=0,B=1,C=2,D=3,E=4,F=5
		NodeT<EdgeOfAdjList> p=vertexList.get(vertex1).adjlink.head.next;

		while(p!= null && vertex2<vertexCount()-1){
			if(p.data.dest>= getValue(vertex2+1))
				return getIndex(p.data.dest);
			p = p.next;
		}
		return -1;
	}

	@Override
	public void printGraph() {
		// TODO Auto-generated method stub
		Iterator<Vertex> iterator = vertexList.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
	@Override
	public void DFSTraverse(int vertex) {
		// TODO Auto-generated method stub
		//vertex is value
		// suppose vertex is exist;
		boolean visited [] = new boolean [vertexCount()];
		int index  = getIndex(vertex);
		do{
			if(!visited[index])
			{
				System.out.print("{");
				depthFirst(visited,index);
				System.out.print("} ");
			}
			index = (index+1)%vertexCount();
		}while(index != getIndex(vertex));
		System.out.println();
	}
	private void depthFirst(boolean [] visited,int index)
	{
		System.out.print((char)(getValue(index)+'A')+" ");
		visited[index]=true;
		int next = this.getNextNeighbor(index, -1);
		while(next != -1){
			if(!visited[next])
				depthFirst(visited,next);
			next = this.getNextNeighbor(index, next);
		}
	}
	@Override
	public void BFSTraverse(int vertex) {
		// TODO Auto-generated method stub
		//vertex is value
		// suppose vertex is exist;
		boolean visited [] = new boolean [vertexCount()];
		int index  = getIndex(vertex);
		do{
			if(!visited[index])
			{
				System.out.print("{");
				broadcastFirst(visited,index);
				System.out.print("} ");
			}
			index = (index+1)%vertexCount();
		}while(index != getIndex(vertex));
		System.out.println();
	}
	private void broadcastFirst(boolean[] visited, int index) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(index);//enqueue visited
		System.out.print((char)(getValue(index)+'A')+" ");
		visited[index] = true;
		while(!queue.isEmpty())
		{
			int i = queue.poll();
			int next = this.getNextNeighbor(i, -1);
			while(next !=-1){
				if(!visited[next]){
					queue.offer(next);
					System.out.print((char)(getValue(next)+'A')+" ");
					visited[next] = true;
				}
				next = this.getNextNeighbor(i, next);
			}
		}
	}

}
class Vertex{
	int data;
	SortedSinglyLinkedList<EdgeOfAdjList> adjlink ;
	public Vertex()
	{
		data = 0;
		adjlink = null;
	}
	public Vertex(int data)
	{
		this.data  = data;
		this.adjlink =  new SortedSinglyLinkedList<EdgeOfAdjList>();
	}
	public Vertex(int data, SortedSinglyLinkedList<EdgeOfAdjList> adjlink)
	{
		this.data = data;
		this.adjlink = adjlink;
	}
	public String toString()
	{
		return String.valueOf(data)+"->"+adjlink.toString();
	}
}
class EdgeOfAdjList implements Comparable<EdgeOfAdjList>{

	int dest;
	int weight;
	EdgeOfAdjList next;
	
	public EdgeOfAdjList()
	{
		dest =0;
		weight =0;
		next = null;
	}
	public EdgeOfAdjList(int dest, int weight)
	{
		this.dest =dest;
		this.weight =weight;
		this.next = null;
	}
	public EdgeOfAdjList(int dest, int weight,EdgeOfAdjList next)
	{
		this.dest =dest;
		this.weight =weight;
		this.next = next;
	}
	public String toString()
	{
		return "( "+dest+","+weight+" )";
	}
	@Override
	public int compareTo(EdgeOfAdjList x) {
		// TODO Auto-generated method stub
		if(this.dest!=x.dest)
			return this.dest - x.dest;
		else
			return this.weight-x.weight;
	}
	
}