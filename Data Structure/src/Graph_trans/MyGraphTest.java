package Graph_trans;
import java.util.*;

public class MyGraphTest {
	public static void main(String[] args) {
		//그래프를 인접리스트로 구현한 것
		int N = 8;
		List<Edge>[] adjList = new List[N];
		adjList[0] = new LinkedList<>();
		    adjList[0].add(new Edge(1, 1));
		    adjList[0].add(new Edge(3, 2));
		adjList[1] = new LinkedList<>();
		    adjList[1].add(new Edge(0, 1));
		    adjList[1].add(new Edge(2, 4));
		    adjList[1].add(new Edge(3, 3));
		    adjList[1].add(new Edge(4, 1));
		    adjList[1].add(new Edge(5, 6));
		adjList[2] = new LinkedList<>();
	    	adjList[2].add(new Edge(1, 4));
	    	adjList[2].add(new Edge(5, 1));
	    	adjList[2].add(new Edge(6, 1));
	    	adjList[2].add(new Edge(7, 2));
		adjList[3] = new LinkedList<>();
		    adjList[3].add(new Edge(0, 2));
		    adjList[3].add(new Edge(1, 3));
		    adjList[3].add(new Edge(4, 5));
		adjList[4] = new LinkedList<>();
		    adjList[4].add(new Edge(1, 1));
		    adjList[4].add(new Edge(3, 5));
		    adjList[4].add(new Edge(6, 2));
		adjList[5] = new LinkedList<>();
		    adjList[5].add(new Edge(1, 6));
		    adjList[5].add(new Edge(2, 1));
		    adjList[5].add(new Edge(7, 9));
		adjList[6] = new LinkedList<>();
		    adjList[6].add(new Edge(2, 1));
		    adjList[6].add(new Edge(4, 2));
		    adjList[6].add(new Edge(7, 1));
		adjList[7] = new LinkedList<>();
		    adjList[7].add(new Edge(2, 2));
		    adjList[7].add(new Edge(5, 9));
		    adjList[7].add(new Edge(6, 1));
		
		MyGraph a = new MyGraph();
		System.out.print("[Task 1] ");
		a.print(a.getAdjMatrixFromAdjList(adjList)); //행렬로 바꿔서 출력
	    System.out.println();
	    
		int[][] adjmatrix = { //그래프를 인접 행렬로 구현한 것
				{ 0, 1, 0, 2, 0, 0, 0, 0 },
				{ 1, 0, 4, 3, 1, 6, 0, 0 },
				{ 0, 4, 0, 0, 0, 1, 1, 2 },
				{ 2, 3, 0, 0, 5, 0, 0, 0 },
				{ 0, 1, 0, 5, 0, 0, 2, 0 },
				{ 0, 6, 1, 0, 0, 0, 0, 9 },
				{ 0, 0, 1, 0, 2, 0, 0, 1 },
				{ 0, 0, 2, 0, 0, 9, 1, 0 }
		};
		MyGraph b = new MyGraph();
		System.out.print("[Task 2] ");
		b.print(b.getAdjListFromAdjMatrix(adjmatrix)); //리스트로 바꿔서 출력
	}
}
