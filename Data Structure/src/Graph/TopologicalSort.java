package Graph;
import java.util.*;
public class TopologicalSort {
    static int N;
    boolean[] visited;
    List<Integer>[] adjList; //인접리스트 형태의 입력 그래프
    List<Integer> sequence; //위상정렬 순서를 담을 리스트
    public TopologicalSort(List<Integer>[] graph) { //생성자
    	N = graph.length;
    	visited = new boolean[N];
    	adjList = graph;
    	sequence = new ArrayList<>();
    }
    public List<Integer> tsort() { //위상정렬
    	for (int i = 0; i < N; i++) if (!visited[i]) dfs(i); //dfs를 수행하면 sequence가 나올것임 
    	Collections.reverse(sequence); //그것을 뒤집어준다.
    	return sequence;
    }
    public void dfs(int i) { //깊이우선탐색 private이면 볼때 편하다
    	visited[i] = true;
    	for (int v : adjList[i]) { //i의 방문이 끝나고 앞으로 방문해야하는 각 정점 v
    		if (!visited[v]) dfs(v); 
    	}
    	sequence.add(i); //i가 가야할 정점이 없으면(마지막이면) sequence에 추가함 - 위상정렬반대순서로 추가됨
    }
    public void print(List<Integer> list) { //리스트 출력
    	System.out.print("[");
    	for(int i = 0; i < N; i++) {
        	System.out.print(list.get(i) + ", ");
    	}
    	System.out.print("]");
    }
    
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
		System.out.print("정점의 수 입력 : ");
		N = scan.nextInt();
		int[] size = new int[N];
	    List<Integer>[] adjList = new List[N]; //입력한 정점의 수만큼 배열 생성
	    for (int i = 0; i < N; i++) {
	    	adjList[i] = new LinkedList<>(); //링크드리스트 생성
	    	System.out.print(i + "정점이 향하는 정점의 수는? ");
	    	int count;
	    	count = scan.nextInt(); //정점이 향하는 정점의 수를 입력받음
	    	int[] num = new int[N]; num[0] = 1;
	    	System.out.println(i + "정점이 향하는 정점은? ");
	    	for (int j = 0; j < count; j++) { //입력한 정점의 수 만큼 인접한 정점을 배열에 저장함
	    		int a;
	    		a = scan.nextInt();
	    		num[a] = a;
	    	}
		    for (int j = 0; j < N; j++) {
		    	if(num[j] == j) { //j가 입력한 정점이면
		    		Edge e = new Edge(j);
					adjList[i].add(e.adjvertex);
					size[i]++;
		    	}
		    }
        }
	    TopologicalSort a = new TopologicalSort(adjList);
	    System.out.println("위상정렬");
	    a.print(a.tsort());
	}
}
