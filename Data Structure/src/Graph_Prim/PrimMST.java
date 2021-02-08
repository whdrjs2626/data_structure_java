package Graph_Prim;
import java.util.List;
public class PrimMST {
	int N; //그래프 정점의 수
	List<Edge>[] graph;
	
	public PrimMST(List<Edge>[] adjList) { //생성자, 연결리스트 인자를 받음
		N = adjList.length;
		graph = adjList;
	}
	
	public int[] mst(int s) { //prim알고리즘, s는 시작지점
		boolean[] visited = new boolean[N]; //MST에 포함되었는지 여부(방문했는지)
		int[] D = new int[N]; // 인접 정점들의 최소가중치를 저장하기위한배열
		int[] previous = new int[N]; // 최소신장트리의 간선으로 확정될 때 간선의 다른쪽 끝점, pre[i] = j는 (i, j)간선이 있는거
		for(int i = 0; i < N; i++) {
			visited[i] = false;
			previous[i] = -1;
			D[i] = Integer.MAX_VALUE; //무한으로 초기화한다.
		}
		previous[s] = 0;
		D[s] = 0; //시작정점s의 D[s]는 0으로 초기화 D[i]는 i로가는 간선의 가중치값, 여기까지 초기화작업
		for(int k = 0; k < N; k++) { //N개의 정점을 MST에 추가하는 반복문
			int minVertex = -1; //최소 정점의 인덱스
			int min = Integer.MAX_VALUE; //간선가중치의 최솟값
			for(int j = 0; j < N; j++) {
				if ((!visited[j])&&(D[j] < min)) { //방문하지 않은 정점(MST에 포함안됨)이고 MST에 인접한 간선중 최소값의 정점은?
					min = D[j]; //최소가중치 업뎃
					minVertex = j; // 최소정점인덱스 업뎃
				}
			}
			visited[minVertex] = true; //minvertex를 방문했다(MST에 추가했다).
			for(Edge i : graph[minVertex]) { //minvertex에 인접한 각 정점의 D의원소(가중치값들) 업데이트
				if(!visited[i.adjvertex]) {
					int currentDist = D[i.adjvertex]; //원래 저장되어있는 최솟값
					int newDist = i.weight; //새로운 가중치값
					if (newDist < currentDist) { //새로운 값이 더작으면 최솟값 업데이트
						D[i.adjvertex] = newDist;
						previous[i.adjvertex] = minVertex; //
					}
				}
			}
		}
		return previous;
	}
}
