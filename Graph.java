
public class Graph {

	public Graph()
	{
		
	}
	public static void main(String [] args)
	{
		//test
		//founction test
		System.out.println("Founction Test:");
		int [] vertexs = {0,1,2,3,4};
		Edge [] edges ={
				new Edge(0,1,25),new Edge(0,3,22),new Edge(0,2,4),
				new Edge(1,0,25),new Edge(1,2,16),new Edge( 1,4,3),new Edge(2,3,18),
				new Edge(2,0,4),new Edge(2,1,16),new Edge(2,4,7),new Edge(3,2,18),
				new Edge(3,0,22),new Edge(3,2,18),new Edge(3,4,9),
				new Edge(4,1,3),new Edge(4,2,7),new Edge(4,3,9)
		};
		GraphAdjacencyMatrix adjMatrix = new GraphAdjacencyMatrix(vertexs,edges);
		//adjMatrix.printGraph();
		Graph test = new Graph();
		test.minSpanTremPrim(adjMatrix);
		
		//==========================================
		Edge [] edgeDijkstra ={
				new Edge(0,1,10),new Edge(0,3,30),new Edge(0,4,99),
				new Edge(1,2,50),new Edge(1,3,40),new Edge( 2,4,10),new Edge(3,2,20),
				new Edge(3,4,60)
		};
		GraphAdjacencyMatrix adjMatrixDijkstra= new GraphAdjacencyMatrix(vertexs,edgeDijkstra);
		adjMatrixDijkstra.printGraph();
		test.shortestPath_Dijkstra(adjMatrixDijkstra, 0);
		
		//==============================================
		int [] vertexsFloyd = {0,1,2,3};
		Edge [] edgeFloyd ={
				new Edge(0,1,16),new Edge(0,2,57),new Edge(0,3,65),
				new Edge(1,2,11),new Edge(1,3,43),
				new Edge(2,0,39),new Edge(2,3,9),
				new Edge(3,0,22)
		};
		GraphAdjacencyMatrix adjMatrixFloyd= new GraphAdjacencyMatrix(vertexsFloyd,edgeFloyd);
		adjMatrixFloyd.printGraph();
		test.shortestPath_Floyd(adjMatrixFloyd);
	}
	public void minSpanTremPrim(GGraph graph)
	{
		if(graph == null)
			return;
		graph.printGraph();
		Edge mst [] = new Edge[graph.vertexCount()-1];
		for(int i = 0;i<mst.length;i++)//initial
		{
			mst[i] = new Edge(0,i+1,graph.getWeight(0, i+1));
		}
		for(int i=0;i<mst.length;i++)
		{
			int minWeight = graph.MAX_WEIGHT;
			int minIndex =0;
			for(int j=i;j<mst.length;j++)//find min
				if(minWeight>mst[j].weight)
				{
					minWeight = mst[j].weight;
					minIndex = j;
				}
			Edge temp = mst[i];  //switch
			mst[i] = mst[minIndex];
			mst[minIndex] = temp;
			
			int tv = mst[i].dest;
			for(int j=i+1;j<mst.length;j++) //adjust the rest
			{
				int v =mst[j].dest;
				if(graph.getWeight(tv, v)<mst[j].weight)
				{
					mst[j].weight = graph.getWeight(tv, v);
					mst[j].start = tv;
				}
			}
		}
		
		int minCost =0;
		System.out.println("The Min Cost Tree By Prim: ");
		for(int k=0;k<mst.length;k++){
			System.out.print(mst[k]);
			minCost += mst[k].weight;
		}
		System.out.println("\n The cost: "+minCost);
	}
	/*
	 * 非负权值的单源最短路径 即单点A 到其他各点的最短距离
	 * Dijkstra迪克斯特拉算法采用贪心策略逐步求解，
	 * 每一步将一条最短路径扩充一条边形成下一条最短路径
	 */
	public void shortestPath_Dijkstra(GGraph graph, int i)
	{
		if(graph== null ||i<0||i>=graph.vertexCount())
			return;
		
		int n = graph.vertexCount();
		int vset [] = new int[n];
		int path[] = new int [n];
		int dist[] =   new int [n];
		
		vset[i] = 1;
		for(int j=0;j<n;j++)// initial arrays
		{
			dist[j] = graph.getWeight(i, j);
			path[j] = (j!=i &&  graph.getWeight(i, j)<graph.MAX_WEIGHT) ? i : -1;
		}
		
		for(int j=(i+1)%n;j!=i;j++)//traversal circle to find the shortest path
		{
			int minWeight = graph.MAX_WEIGHT,u=0;
			for(int k=0;k<n;k++)//find the min weight
			{
				if(vset[k]==0 && dist[k]<minWeight)
				{
					minWeight = dist[k];
					u = k;
				}
			}
			vset[u]=1;
			if(minWeight == graph.MAX_WEIGHT)//if not exist ,so not need update dist[]
				break;
			for(int k = 0;k<n ;k++)//update dist[] ,path[]
			{
				if(vset[k]==0 && graph.getWeight(u,k)<graph.MAX_WEIGHT&& dist[k]>dist[u]+graph.getWeight(u, k))
				{
					path[k] = u;
					dist [k] = dist[u]+graph.getWeight(u, k);
				}
			}
		}
		
		System.out.println("The Dijkstra of shortest path: ");
		for(int j=0;j<n;j++)
		{
			if(i==j)
				continue;
			String pathStr="";
			for(int k = path[j];k!=i &&k!=j && k!=-1;k=path[k])
				pathStr = " , "+String.valueOf((char)(k+'A'))+pathStr;
			
			System.out.println("("+String.valueOf((char)(i+'A'))+pathStr+" , "+String.valueOf((char)(j+'A'))+") shortest weight is "+(dist[j]==graph.MAX_WEIGHT ? "∞":dist[j]));
		}
	}
	/*
	 * Floyd两点间最短路径
	 * 使用两个矩阵存储每对顶点间的最短路径和长度；
	 * 初始化D矩阵是邻接矩阵，P矩阵vi！=vj且存在边vij或vji，则pij=i,否则为-1
	 * 用中间点调整矩阵D和矩阵P
	 */
	
	public void shortestPath_Floyd(GGraph graph){
		
		if(graph == null)
			return;
		int n = graph.vertexCount();
		int dist [][] = new int [n][n];
		int path[][] = new int [n][n];
		
		int i=0;
		int j=0;
		//initial matrix
		for( i=0;i<n;i++)//start
			for(j=0;j<n;j++)//end
			{
				dist[i][j] = graph.getWeight(i, j);
				if(i!=j && dist[i][j]<graph.MAX_WEIGHT)
					path[i][j]=i;
				else
					path[i][j] =-1;
			}
		//update dist[][] path[][] by middle 
		for(int k =0;k<n;k++) //mid
			for(i=0;i<n;i++)//start
				if(i!=k)
					for(j=0;j<n;j++)//end
					{
						if(j!=k && i!=j && dist[i][j]>dist[i][k]+dist[k][j])
						{
							 dist[i][j]=dist[i][k]+dist[k][j];
							 path[i][j] = path[k][j];
						}
					}
		System.out.println("The Floyd of shortest path: ");
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)
			{
				if(i==j)
					continue;
				String pathStr ="";
				for(int k = path[i][j];k!=i&&j!=k&&k!=-1;k=path[i][k])
					pathStr = " , "+String.valueOf((char)(k+'A'))+pathStr;
				pathStr = "( "+String.valueOf((char)(i+'A'))+pathStr+" , "+String.valueOf((char)(j+'A'))+" ) the shortest weight is "+(dist[i][j]==graph.MAX_WEIGHT ? " ∞":dist[i][j]);
				System.out.println(pathStr);
			}
	}
	public void kruskal()
	{}
}
