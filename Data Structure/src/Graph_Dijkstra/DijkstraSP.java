package Graph_Dijkstra;
import java.util.*;


public class DijkstraSP {
	public int N;
	List<Edge>[] graph;
	public int[] previous; // 최단 경로 상 이전 정점을 기록하는 배열
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
			previous[i] = -1; //i까지 가는 경로에서 i바로 직전 노드가 -1이다라는 뜻 - 아직아무 방문도 안했으므로 -1임 
			D[i] = Integer.MAX_VALUE; //무한대로 초기화
		}
		previous[s] = 0;
		D[s] = 0; //출발점부터 s까지의 거리(가중치의 합), s는 출발이므로 0이다.
		for(int k = 0; k < N; k++) {
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < N; j++) { 
				if ((!visited[j])&&(D[j] < min)) { // 방문안된 각정점j에 대해 D[j]의 최소값구하기
					min = D[j];
					minVertex = j;
				}
			}
			visited[minVertex] = true; //구했으면 트루
			for(Edge e : graph[minVertex]) { //minvertex에 인접한 각 정점에 대해
				if(!visited[e.adjvertex]) {// 아직 방문 안된 정점
					int currentDist = D[e.adjvertex]; //e까지의 원래의 거리
					int newDist = D[minVertex] + e.weight; //최솟값까지의 거리 + 최솟값에서 e까지의 거리
					if (newDist < currentDist) { //두개 비교
						D[e.adjvertex] = newDist; //간선 완화 - 가중치의 최솟값으로 업데이트
						previous[e.adjvertex] = minVertex; // 최종 최단경로를 역방향으로 추출
					}
				}
			}
		}
		return D;
    }
}
