package Graph_Floyd_Warshall;

public class FloydWarshall {
	public static final int INF = Integer.MAX_VALUE;
	private int[][] D;
    private int N;
	
	public FloydWarshall(int[][] arr) { //생성자, 정점의 수를 입력으로 받음
        N = arr[0].length;
        D = new int[N][N];
	}
	
	public int[][] init(int[][] adjMatrix) {
		for (int i = 0; i < N; i++) { //초기화 반복문
			for (int j = 0; j < N; j++) {
				D[i][j] = adjMatrix[i][j];
			}
		}
		return D;
	}
	
	public int[][] shortestPath() {
		for (int k = 0; k < N; k++) { //k를 경유하는 경로상의 모든 정점들에 대해 간선완화, k는 모든정점을 다 한번씩 계산
			for (int i = 0; i < N; i++) { 
				for (int j = 0; j < N; j++) { //그래프 내의  모든 정점의 쌍에 대해 수행
					if (D[i][j] > D[i][k] + D[k][j]) { //i~j가 k를경유한 i~k~j가 더 작은가?
						if(D[i][k] != INF && D[k][j] != INF) D[i][j] = D[i][k] + D[k][j]; //간선완화
					}
				}
			}
		}
		return D;
	}
	
	public void print(int[][] D) {
		N = D[0].length;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(D[i][j] == Integer.MAX_VALUE) { //무한이 나오면 문자 ∞으로 출력시킵니다.
					System.out.print("∞,  ");
				}
				else if(D[i][j] >= 0) {
					System.out.print(D[i][j] + ",  ");
				}
				else {
					System.out.print(D[i][j] + ", ");
				}
			}
			System.out.println();
		}
	}
}
