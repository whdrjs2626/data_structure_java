package Graph_Bellman_Ford;

public class BellmanFordNew {
	public static final int INF = Integer.MAX_VALUE;
	private int D[];
	private int previous[];
	private int N;
	
	public BellmanFordNew(int numOfVertices) { //생성자, 정점의 수를 입력으로 받음
        N = numOfVertices;
        D = new int[N];
        previous = new int[N];
	}
	
	public void shortestPath(int s, int adjMatrix[][]) {
		int sum = 0;
		for (int i = 0; i < N; i++)
			D[i] = INF;
		D[s] = 0; previous[s] = 0;
		for (int k = 0; k < N-1; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (adjMatrix[i][j] != INF) {
						if (D[j] > D[i] + adjMatrix[i][j]) {
							D[j] = D[i] + adjMatrix[i][j];
							previous[j] = i;
						}
					}
				}
			}
		}
		for(int i = 0; i < previous.length; i++) { //최단거리의 가중치를 전부 더한다.
			sum += D[previous[i]];
		}
		if(sum >= 0) { //더한게 0이상이면 음수 싸이클이 없는 것
			System.out.println("**입력한 그래프에 음수 싸이클이 없습니다.**"); 
		}
		else { //더한게 음수면 음수 싸이클이 있는 것
			System.out.println("**입력한 그래프에 음수 싸이클이 있습니다.**");
		}
	}
	public void printPaths(int s) {
		System.out.println("정점 0으로 부터의 최단거리");
    	int[] distance = this.D;
    	
    	for (int i = 0; i < distance.length; i++) {
    		if (distance[i] == Integer.MAX_VALUE)
    			System.out.println("0과 " + i + "사이의 경로가 없습니다.");
    		else
    			System.out.println("[0,  " + i + "] = " + distance[i]);
    	}
    	int count = this.N;
    	int pre[] = this.previous;
    	System.out.printf("\n정점 0으로부터의 최단 경로\n");
    	for (int i = 1; i < count; i++) {
    		int back = i;
    		System.out.print(back);
    		while (back != 0) {
    			System.out.print("<-" + pre[back]);
    			back = pre[back];
    		}
    		System.out.println();
	    }
	}
}
