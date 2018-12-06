
public interface GGraph {

	public static final int MAX_WEIGHT = 99999;
	int vertexCount();
	int getValue(int index);//get value of vertex which index of vertexList
	int getWeight(int vertex1,int vertex2);//get weight form the edge which construct by vertex1 and vertex2
	void insertEdge(int vertex1,int vertex2, int weight);
	void insertVertex(int vertex);
	void removeVertex(int vertex);
	void removeEdge(int vertex1,int vertex2);
	int getNextNeighbor(int vertex1,int vertex2);
	void printGraph();
	void DFSTraverse(int vertex);//deep first search traverse
	void BFSTraverse(int vertex);//broadcast first search traverse
	
}
