package Graph_Bellman_Ford;

public class BellmanFordTest {
    public static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
    	int[][] weight = { //음수 싸이클이 없는 그래프
    			{ INF,   1, INF,   2, INF, INF, INF, INF },
    			{ INF, INF,   4,  -2, INF,   6, INF, INF },
    			{ INF, INF, INF, INF, INF, INF, INF,   2 },
    			{ INF, INF, INF, INF,  -1, INF, INF, INF },
    			{ INF, INF, INF, INF, INF, INF,   4, INF },
    			{ INF, INF,   1, INF, INF, INF, INF, INF },
    			{ INF, INF,  -1, INF, INF, INF, INF,   1 },
    			{ INF, INF, INF, INF, INF,   3, INF, INF },
    	};
    	int[][] weight2 = {  //음수 싸이클이 있는 그래프
    			{ INF,  -1, INF,   2, INF, INF, INF, INF },
    			{ INF, INF,   4,  -2, INF,   6, INF, INF },
    			{ INF, INF, INF, INF, INF, INF, INF,   2 },
    			{  -1, INF, INF, INF,  -1, INF, INF, INF },
    			{ INF, INF, INF, INF, INF, INF,   4, INF },
    			{ INF, INF,   1, INF, INF, INF, INF, INF },
    			{ INF, INF,  -1, INF, INF, INF, INF,   1 },
    			{ INF, INF, INF, INF, INF,   3, INF, INF },
    	};
    	int N = weight.length;
    	
    	int s = 0;
    	//5번 과제 테스트
    	System.out.println("[Q 5]");
    	BellmanFord q5 = new BellmanFord(N);
    	q5.shortestPath(s, weight);
    	q5.printPaths(s);
    	System.out.println();
    	
    	//6번 과제 테스트
    	System.out.println("[Q 6]");
    	BellmanFordNew bf = new BellmanFordNew(N);
    	bf.shortestPath(s, weight);
    	bf.printPaths(s);
    	System.out.println();
    	
    	int N2 = weight2.length;
    	BellmanFordNew bf2 = new BellmanFordNew(N2);
    	bf2.shortestPath(s, weight2);
    	bf2.printPaths(s);
    }
}
