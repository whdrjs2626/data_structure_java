package Graph;
import java.util.List;

public class DFS {
    int N; //������ �� 
    List<Edge>[] graph; //���Ḯ��Ʈ�� �迭�� ������ �׷���
    private boolean[] visited;
    public DFS(List<Edge>[] adjList) {
    	N = adjList.length;
    	graph = adjList;
    	visited = new boolean[N];
    	for (int i = 0; i < N; i++) visited[i] = false; //�迭 �ʱ�ȭ
    	for (int i = 0; i < N; i++) if (!visited[i]) dfs(i); //���Ἲ���� �� �̾����� ���� �� �����Ƿ� 0���� N-1���� �ϳ��� üũ�Ѵ�.
    }
    
    private void dfs(int i) {
    	visited[i] = true;
    	System.out.print(i+" ");
    	for (Edge e: graph[i]) { //�ϳ��� ������ dfs, �߰��ٰ� ���̸� �̿����湮 ->�̷��� �ǹǷ� ���̿켱
    		if (!visited[e.adjvertex]) {
    			dfs(e.adjvertex);
    		}
    	}
    }
}
