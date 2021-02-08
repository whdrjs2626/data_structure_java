package Graph_reverse;

import java.util.LinkedList;
import java.util.List;

public class CheckGraphTest {
	public static void main(String[] args) {
		int[][] adjmat1 = {
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 3, 0 },
				{ 0, 7, 0, 0, 4 },
				{ 0, 6, 0, 0, 9 },
				{ 0, 0, 1, 3, 0 }
		};
		int[][] adjmat2 = {
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 3, 0 },
				{ 0, 7, 0, 0, 4 },
				{ 0, 6, 0, 0, 9 },
				{ 0, 0, 0, 3, 0 }
		};
		int[][] adjmat3 = {
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 4, 0 },
				{ 0, 1, 0, 0, 2 },
				{ 0, 4, 0, 0, 3 },
				{ 0, 0, 2, 3, 0 }
		};
		int[][] adjmat4 = {
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 4, 0 },
				{ 0, 1, 0, 0, 2 },
				{ 0, 4, 0, 0, 3 },
				{ 0, 0, 2, 3, 0 }
		};
		
		
		int N = 5;
		List<Edge>[] adjlist1 = new List[N];
		adjlist1[1] = new LinkedList<>();
		    adjlist1[1].add(new Edge(2, 2));
		    adjlist1[1].add(new Edge(3, 3));
		adjlist1[2] = new LinkedList<>();
		    adjlist1[2].add(new Edge(1, 7));
		    adjlist1[2].add(new Edge(4, 4));
		adjlist1[3] = new LinkedList<>();
		    adjlist1[3].add(new Edge(1, 6));
		    adjlist1[3].add(new Edge(4, 9));
		adjlist1[4] = new LinkedList<>();
		    adjlist1[4].add(new Edge(2, 1));
		    adjlist1[4].add(new Edge(3, 3));
	    
	    List<Edge>[] adjlist2 = new List[N];
	    adjlist2[1] = new LinkedList<>();
	        adjlist2[1].add(new Edge(2, 2));
	        adjlist2[1].add(new Edge(3, 3));
	    adjlist2[2] = new LinkedList<>();
	        adjlist2[2].add(new Edge(1, 7));
	        adjlist2[2].add(new Edge(4, 4));
	    adjlist2[3] = new LinkedList<>();
	        adjlist2[3].add(new Edge(1, 6));
	        adjlist2[3].add(new Edge(4, 9));
	    adjlist2[4] = new LinkedList<>();
	        adjlist2[4].add(new Edge(3, 3));
	    
		    
	    List<Edge>[] adjlist3 = new List[N];
	    adjlist3[1] = new LinkedList<>();
	        adjlist3[1].add(new Edge(2, 1));
	        adjlist3[1].add(new Edge(3, 4));
	    adjlist3[2] = new LinkedList<>();
	        adjlist3[2].add(new Edge(1, 1));
	        adjlist3[2].add(new Edge(4, 2));
	    adjlist3[3] = new LinkedList<>();
	        adjlist3[3].add(new Edge(1, 4));
	        adjlist3[3].add(new Edge(4, 3));
	    adjlist3[4] = new LinkedList<>();
	        adjlist3[4].add(new Edge(2, 2));
	        adjlist3[4].add(new Edge(3, 3));
	       
	    List<Edge>[] adjlist4 = new List[N];
	    adjlist4[1] = new LinkedList<>();
	        adjlist4[1].add(new Edge(2, 1));
	        adjlist4[1].add(new Edge(3, 4));
	    adjlist4[2] = new LinkedList<>();
	        adjlist4[2].add(new Edge(1, 1));
	        adjlist4[2].add(new Edge(4, 2));
	    adjlist4[3] = new LinkedList<>();
	        adjlist4[3].add(new Edge(1, 4));
	        adjlist4[3].add(new Edge(4, 3));
	    adjlist4[4] = new LinkedList<>();
	        adjlist4[4].add(new Edge(2, 2));
	        adjlist4[4].add(new Edge(3, 3));
		    
		CheckGraph a = new CheckGraph();
		System.out.println("[Task 1] : ");
		System.out.println("adjmat1 : "  + a.isReverseSame(adjmat1));
		System.out.println("adjlist1 : " + a.isReverseSame(adjlist1));
		System.out.println("[Task 2] : ");
		System.out.println("adjmat2 : "  + a.isReverseSame(adjmat2));
		System.out.println("adjlist2 : " + a.isReverseSame(adjlist2));
		System.out.println("[Task 3] : ");
		System.out.println("adjmat3 : "  + a.isReverseSame(adjmat3));
		System.out.println("adjlist3 : " + a.isReverseSame(adjlist3));
		System.out.println("[Task 4] : ");
		System.out.println("adjmat4 : "  + a.isReverseSame(adjmat4));
		System.out.println("adjlist4 : " + a.isReverseSame(adjlist4));
	}
}
