import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class GraphAdjacencyMatrix implements GGraph {

	protected int [][] adjmatrix;
	protected List<Integer> vertexList;
	
	public GraphAdjacencyMatrix(int size)
	{
		if(size<10) size =10; //default size =10
		adjmatrix = new int [size][size];
		vertexList = new ArrayList<Integer>(size);
		for(int i = 0;i<size;i++)
			for(int j = 0;j<size;j++)
				if(i==j)
					adjmatrix[i][j] = 0;
				else
					adjmatrix[i][j] = this.MAX_WEIGHT;
	}
	public GraphAdjacencyMatrix(int [] vertexs,Edge [] edges)
	{
		//suppose the vertexs is not null
		this(vertexs.length);
		if(vertexs!=null && vertexs.length>0)
		{
			for(int i=0;i<vertexs.length;i++)
				insertVertex(vertexs[i]);
		}
		if( edges!= null &&edges.length>0)
		{
			for(int i=0;i<edges.length;i++)
				inertEdge(edges[i]);
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
		GraphAdjacencyMatrix test = new GraphAdjacencyMatrix(vertexs,edges);
		test.printGraph();
		System.out.println("\n Depth Search First: ");
		for(int i=0;i<test.vertexCount();i++)//index
			test.DFSTraverse(i);
		
		System.out.println("\n Broadcast Search First: ");
		for(int i=0;i<test.vertexCount();i++)//index
			test.BFSTraverse(i);
		
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
		System.out.println("delete edge (D,E):");//
		test.removeEdge(2, 3);//index
		test.removeEdge(3, 2);
		test.printGraph();
		
		//boundary test		
		System.out.println("\nBoundary Test:");

		
		//exception test		
		System.out.println("\nException Test:");
		

	}
	@Override
	public int vertexCount() {
		// TODO Auto-generated method stub
		return vertexList.size();
	}

	@Override
	public int getValue(int index) {
		// TODO Auto-generated method stub
		//suppose index is in [0,vertexCount)
		return vertexList.get(index);
	}

	@Override
	public int getWeight(int vertex1, int vertex2) {
		// TODO Auto-generated method stub
		//suppose index is in [0,vertexCount)
		return adjmatrix[vertex1][vertex2];
	}

	@Override
	public void insertEdge(int vertex1, int vertex2, int weight) {
		// TODO Auto-generated method stub
		//vertex1 ,vertex2 is index , 
		int n = vertexCount();
		boolean valid = vertex1>=0 && vertex1<n && vertex2>=0 && vertex2<n && vertex1 != vertex2 && adjmatrix[vertex1][vertex2]==this.MAX_WEIGHT;
		if(valid)
			adjmatrix[vertex1][vertex2] = weight;
		//esle do nothing
	}

	public void inertEdge(Edge edge) {
		// TODO Auto-generated method stub
		insertEdge(edge.start,edge.dest,edge.weight);
	}
	
	@Override
	public void insertVertex(int vertex) {
		// TODO Auto-generated method stub
		vertexList.add(vertex);
		int n = vertexCount();
		if(n>adjmatrix.length)//out of adjmatrix
		{
			int [][] temp = new int [adjmatrix.length*2][adjmatrix.length*2];
			for(int i=0;i<adjmatrix.length;i++)
				for(int j =0;j<adjmatrix.length;j++)
					temp[i][j] = adjmatrix[i][j];
			
			for(int i=adjmatrix.length;i<temp.length;i++) //right
				for(int j =0;j<adjmatrix.length;j++)
					temp[i][j] = this.MAX_WEIGHT;
			for(int i=0;i<adjmatrix.length;i++)                 //down
				for(int j =adjmatrix.length;j<temp.length;j++)
					temp[i][j] = this.MAX_WEIGHT;
			for(int i=adjmatrix.length;i<temp.length;i++) //right down
				for(int j =adjmatrix.length;j<temp.length;j++)
					if(i==j)
						temp[i][j]=0;
					else
						temp[i][j] = this.MAX_WEIGHT;
			adjmatrix = temp;
			temp = null;
		}
	}

	@Override
	public void removeVertex(int vertex) {
		// TODO Auto-generated method stub
		// suppose vertex in [0,vertexCount)
		int n = vertex;
		int length= vertexCount();
		vertexList.remove(n);
		for(int i = 0;i<n;i++)                                          //right part<
			for(int k=n;k<length-1;k++)
				adjmatrix[i][k] = adjmatrix[i][k+1];
		for(int i = n;i<length-1;i++)                                          //down part ^
			for(int k=0;k<n;k++)
				adjmatrix[i][k] = adjmatrix[i+1][k];
		
		for(int i = n;i<length-1;i++)                                          //right down part <^
			for(int k=n;k<length-1;k++)
				adjmatrix[i][k] = adjmatrix[i+1][k+1];
	}

	@Override
	public void removeEdge(int vertex1, int vertex2) {
		// TODO Auto-generated method stub
		if(vertex1!=vertex2)
			adjmatrix[vertex1][vertex2] =  this.MAX_WEIGHT;
		//else do nothing
	}

	@Override
	public int getNextNeighbor(int vertex1, int vertex2) {
		// TODO Auto-generated method stub
		//vertex1 ,vertex2 are indexs, vertex1 connect vertex2,and vertex2 is visited,return which connect vertex2
		int n = vertexCount();
		if(vertex1>=0 && vertex1<n && vertex2>=-1 && vertex2<n && vertex1 != vertex2)//vertex1 and vertex2 are valid
		{
			for(int k = vertex2+1;k<n;k++)
				if(adjmatrix[vertex1][k]>0 && adjmatrix[vertex1][k]<this.MAX_WEIGHT)//in the row of vertex1
					return k;
		}
		return -1;//-1 means no next neighbor
	}
	@Override
	public void printGraph() {
		// TODO Auto-generated method stub
		int row = vertexCount();
		for(int i = 0;i<vertexCount();i++){
			for(int j = 0 ;j<vertexCount();j++)
				if(adjmatrix[i][j]==this.MAX_WEIGHT)
					System.out.print("∞ ");
				else
					System.out.print(adjmatrix[i][j]+"   ");
			System.out.println();
		}
	}
	@Override
	public void DFSTraverse(int vertex) {
		// TODO Auto-generated method stub
		//vertex is index;
		int n = vertexCount();
		if(vertex<0 ||vertex >n)
			return;
		boolean visited [] = new boolean[n];
		int index = vertex;
		do{
			if(!visited[index])
			{
				System.out.print("{");
				depthFirt(visited,index);
				System.out.println("}");
			}
			index = (1+index)%n;
		}while(index != vertex);
	}
	private void depthFirt(boolean[] visited, int index) {
		// TODO Auto-generated method stub
		System.out.print((char)('A'+this.getValue(index))+" ");
		visited[index] = true;
		int next = this.getNextNeighbor(index, -1);
		while(next !=-1)
		{
			if(!visited[next])
				depthFirt(visited,next);
			next = this.getNextNeighbor(index, next);
			
		}
	}
	@Override
	public void BFSTraverse(int vertex) {
		// TODO Auto-generated method stub
		//vertex is index
		int n= vertexCount();
		if(vertex<0 || vertex>n-1)
			return;
		boolean visited [] = new boolean[n];
		int index =vertex;
		do{
			if(!visited[index])
			{
				System.out.print("{ ");
				broadcastFirst(visited,index);
				System.out.print(" }");
			}
			index =(index+1)%n;
		}while(index != vertex);
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
 class Edge implements Comparable<Edge>{

	public int start, dest, weight;
	public Edge(int start, int dest,int weight)
	{
		this.start = start;
		this.dest = dest;
		this.weight = weight;
	}
	public Edge(Edge e)
	{
		this.start  = e.start;
		this.dest   = e.dest;
		this.weight = e.weight;
	}
	public String toString()
	{
		return "( "+start+", "+dest+", "+weight+" )  ";
	}
	@Override
	public int compareTo(Edge e) {
		// TODO Auto-generated method stub
		if(this.start != e.start)//compare start first;
			return this.start-e.start;
		return this.dest-e.dest;
	}
	
}
