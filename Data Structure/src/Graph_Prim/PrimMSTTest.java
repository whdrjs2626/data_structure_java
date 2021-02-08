package Graph_Prim;

import java.util.LinkedList;
import java.util.List;

public class PrimMSTTest {
	public static void main(String[] args) {
		int N = 7;
		List<Edge>[] adjList = new List[N];
		adjList[0] = new LinkedList<>();
		    adjList[0].add(new Edge(1, 9));
		    adjList[0].add(new Edge(2, 10));
		adjList[1] = new LinkedList<>();
		    adjList[1].add(new Edge(0, 9));
		    adjList[1].add(new Edge(3, 10));
		    adjList[1].add(new Edge(4, 5));
		    adjList[1].add(new Edge(6, 3));
		adjList[2] = new LinkedList<>();
	    	adjList[2].add(new Edge(0, 10));
	    	adjList[2].add(new Edge(3, 9));
	    	adjList[2].add(new Edge(4, 7));
	    	adjList[2].add(new Edge(5, 2));
		adjList[3] = new LinkedList<>();
		    adjList[3].add(new Edge(1, 10));
		    adjList[3].add(new Edge(2, 9));
		    adjList[3].add(new Edge(5, 4));
		    adjList[3].add(new Edge(6, 8));
		adjList[4] = new LinkedList<>();
		    adjList[4].add(new Edge(1, 5));
		    adjList[4].add(new Edge(2, 7));
		    adjList[4].add(new Edge(6, 1));
		adjList[5] = new LinkedList<>();
		    adjList[5].add(new Edge(2, 2));
		    adjList[5].add(new Edge(3, 4));
		    adjList[5].add(new Edge(6, 6));
		adjList[6] = new LinkedList<>();
		    adjList[6].add(new Edge(1, 3));
		    adjList[6].add(new Edge(3, 8));
		    adjList[6].add(new Edge(4, 1));
		    adjList[6].add(new Edge(5, 6));
		
		PrimMST a = new PrimMST(adjList);
		int[] se = a.mst(0);
		int sum = 0;
		System.out.println("[Q 3][Task]");
		System.out.println("최소신장트리 간선 : ");
		for(int i = 1; i < se.length; i++) { //최소 신장트리의 간선 출력
			System.out.print("(" + i + ", " + se[i] + ") ");
		}
		
		for(int i = 0; i < se.length; i++) { //최소신장트리의 간선 가중치의 합
			for(int j = 0; j < adjList[i].size(); j++) {
			    if(adjList[i].get(j).adjvertex == se[i])
				    sum += adjList[i].get(j).weight;
			}
		}
		System.out.println();
		System.out.println("최소신장트리 간선 가중치 합 = " + sum);
	}
}
