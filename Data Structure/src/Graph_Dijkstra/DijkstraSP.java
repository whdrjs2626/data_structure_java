package Graph_Dijkstra;
import java.util.*;


public class DijkstraSP {
	public int N;
	List<Edge>[] graph;
	public int[] previous; // �ִ� ��� �� ���� ������ ����ϴ� �迭
	public DijkstraSP(List<Edge>[] adjList) {
		N = adjList.length;
		previous = new int[N];
		graph = adjList;
	}
	
    public int[] shortestPath (int s) {
    	boolean[] visited = new boolean[N];
    	int[] D = new int[N];
    	for(int i = 0; i < N; i++) {
			visited[i] = false;
			previous[i] = -1; //i���� ���� ��ο��� i�ٷ� ���� ��尡 -1�̴ٶ�� �� - �����ƹ� �湮�� �������Ƿ� -1�� 
			D[i] = Integer.MAX_VALUE; //���Ѵ�� �ʱ�ȭ
		}
		previous[s] = 0;
		D[s] = 0; //��������� s������ �Ÿ�(����ġ�� ��), s�� ����̹Ƿ� 0�̴�.
		for(int k = 0; k < N; k++) {
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < N; j++) { 
				if ((!visited[j])&&(D[j] < min)) { // �湮�ȵ� ������j�� ���� D[j]�� �ּҰ����ϱ�
					min = D[j];
					minVertex = j;
				}
			}
			visited[minVertex] = true; //�������� Ʈ��
			for(Edge e : graph[minVertex]) { //minvertex�� ������ �� ������ ����
				if(!visited[e.adjvertex]) {// ���� �湮 �ȵ� ����
					int currentDist = D[e.adjvertex]; //e������ ������ �Ÿ�
					int newDist = D[minVertex] + e.weight; //�ּڰ������� �Ÿ� + �ּڰ����� e������ �Ÿ�
					if (newDist < currentDist) { //�ΰ� ��
						D[e.adjvertex] = newDist; //���� ��ȭ - ����ġ�� �ּڰ����� ������Ʈ
						previous[e.adjvertex] = minVertex; // ���� �ִܰ�θ� ���������� ����
					}
				}
			}
		}
		return D;
    }
}
