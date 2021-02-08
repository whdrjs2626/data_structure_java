package Graph;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    int N;
    List<Edge>[] graph;
    private boolean[] visited;
    public BFS(List<Edge>[] adjList) {
    	N = adjList.length;
    	graph = adjList;
    	visited = new boolean[N];
    	for (int i = 0; i < N; i++) visited[i] = false;
    	for (int i = 0; i < N; i++) if (!visited[i]) bfs(i);
    }
    
    private void bfs(int i) {
    	Queue<Integer> q = new LinkedList<Integer>(); //큐사용
    	visited[i] = true;
    	q.add(i); //큐에 시작정점을 넣는다.
    	while (!q.isEmpty()) {
    		int j = q.remove(); //큐에서 정점하나 j를 가져와서
    	    System.out.print(j+" "); //출력한다.
    	    for (Edge e: graph[j]) { //j라는 정점에 연결되어있는모든 정점들을 방문한다.
    	    	if (!visited[e.adjvertex]) {
    			    visited[e.adjvertex] = true; //방문했다 
    			    q.add(e.adjvertex); //추가함
    		    }
    	    }
    	}
    }
}
