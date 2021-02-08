package Graph_Bellman_Ford;

public class BellmanFord {
	public static final int INF = Integer.MAX_VALUE;
	private int D[];
	private int previous[]; //경로 추출을 위해
	private int N;
	
	public BellmanFord(int numOfVertices) { //생성자, 정점의 수를 입력으로 받음
        N = numOfVertices;
        D = new int[N]; //최단거리 저장
        previous = new int[N]; //최단경로 추출
	}
	
	public void shortestPath(int s, int adjMatrix[][]) { //그래프와 출발점을 인자로 받음
		for (int i = 0; i < N; i++)
			D[i] = INF; //초기화
		D[s] = 0; previous[s] = 0;
		for (int k = 0; k < N-1; k++) { //최대 간선 수만큼 반복
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) { //모든 (i, j)에 대하여
					if (adjMatrix[i][j] != INF) {
						if (D[j] > D[i] + adjMatrix[i][j]) { //계속 방문하다가 더 작은 값이 나오면 갱신
							D[j] = D[i] + adjMatrix[i][j]; //간선완화
							previous[j] = i; //
						}
					}
				}
			}
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
