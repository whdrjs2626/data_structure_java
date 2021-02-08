package Graph_reverse;

public class Edge { //간선 
	int adjvertex; // 간선의 다른쪽 정점
	int weight;
	public Edge(int v, int w) {
		adjvertex = v;
		weight = w;
	}
}