package Graph_Dijkstra;

public class Edge { //���� 
	int vertex;    // ������ ���� �� ����
	int adjvertex; // ������ �ٸ��� ����
	int weight;    // ������ ����ġ
	public Edge(int u, int v, int wt) {
		vertex = u;
		adjvertex = v;
		weight = wt;
	}
}