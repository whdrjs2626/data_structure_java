package Graph;

import java.util.*;
public class Graph {
	static int N; // 정점의 수
	static List<Edge>[] graph;
	
	public Graph(List<Edge>[] adjList) { //생성자
    	N = adjList.length;
    	graph = adjList;
	}
	
    public void print(List<Edge>[] adjList, int[] arr) {
    	N = adjList.length;
    	graph = adjList;
    	System.out.println("인접리스트를 이용한 그래프");
		for(int i = 0; i < N; i ++) {
			System.out.print("[" + i + "]");
			for(int j = 0; j < arr[i]; j++) {
				System.out.print(" => " + graph[i].get(j).adjvertex);
			}
			System.out.println();
		}
	}
    
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("정점의 수 입력 : ");
		N = scan.nextInt();
		int[] size = new int[N];
	    List<Edge>[] adjList = new List[N];
	    for (int i = 0; i < N; i++) {
	    	adjList[i] = new LinkedList<>();
	    	System.out.print(i + "정점에 인접하는 정점의 수는? ");
	    	int count;
	    	count = scan.nextInt();
	    	int[] num = new int[N]; num[0] = 1;
	    	System.out.println(i + "정점에 인접하는 정점은? ");
	    	for (int j = 0; j < count; j++) {
	    		int a;
	    		a = scan.nextInt();
	    		num[a] = a;
	    	}
		    for (int j = 0; j < N; j++) {
		    	if(num[j] == j) {
		    		System.out.print(i + "정점이 ");
			    	System.out.print(j + "정점을 향하는가? (향하면 1 향하지않으면 0) : ");
			    	int a;
			    	a = scan.nextInt();
				    if(a == 0) {
					    Edge e = new Edge(j);
					    adjList[i].add(e);
					    size[i]++;
				    }
				    else if(a == 1) {
				    	Edge e = new Edge(j);
					    adjList[i].add(0, e);
					    size[i]++;
		    	    }
		    	}
		    }
        }
	    System.out.println("[Q 1]");
	    Graph a = new Graph(adjList);
	    a.print(adjList, size);
	    
	    //System.out.println("[Q 2]");
	    //System.out.println("DFS 방문 순서 ");
	    //DFS d = new DFS(adjList);
	    
	    //System.out.println("[Q 3]");
	    //System.out.println("BFS 방문 순서 ");
	    //BFS b = new BFS(adjList);
	}
}

