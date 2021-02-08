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
    	Queue<Integer> q = new LinkedList<Integer>(); //ť���
    	visited[i] = true;
    	q.add(i); //ť�� ���������� �ִ´�.
    	while (!q.isEmpty()) {
    		int j = q.remove(); //ť���� �����ϳ� j�� �����ͼ�
    	    System.out.print(j+" "); //����Ѵ�.
    	    for (Edge e: graph[j]) { //j��� ������ ����Ǿ��ִ¸�� �������� �湮�Ѵ�.
    	    	if (!visited[e.adjvertex]) {
    			    visited[e.adjvertex] = true; //�湮�ߴ� 
    			    q.add(e.adjvertex); //�߰���
    		    }
    	    }
    	}
    }
}
