package Graph;
import java.util.List;

public class DFS {
    int N; //정점의 수 
    List<Edge>[] graph; //연결리스트의 배열로 구현한 그래프
    private boolean[] visited;
    public DFS(List<Edge>[] adjList) {
    	N = adjList.length;
    	graph = adjList;
    	visited = new boolean[N];
    	for (int i = 0; i < N; i++) visited[i] = false; //배열 초기화
    	for (int i = 0; i < N; i++) if (!visited[i]) dfs(i); //연결성분이 다 이어있지 않을 수 있으므로 0부터 N-1까지 하나씩 체크한다.
    }
    
    private void dfs(int i) {
    	visited[i] = true;
    	System.out.print(i+" ");
    	for (Edge e: graph[i]) { //하나씩 꺼내서 dfs, 쭉가다가 끝이면 이웃노드방문 ->이렇게 되므로 깊이우선
    		if (!visited[e.adjvertex]) {
    			dfs(e.adjvertex);
    		}
    	}
    }
}
