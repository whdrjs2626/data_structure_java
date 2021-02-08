package Graph_Floyd_Warshall;

public class FloydWarshall {
	public static final int INF = Integer.MAX_VALUE;
	private int[][] D;
    private int N;
	
	public FloydWarshall(int[][] arr) { //������, ������ ���� �Է����� ����
        N = arr[0].length;
        D = new int[N][N];
	}
	
	public int[][] init(int[][] adjMatrix) {
		for (int i = 0; i < N; i++) { //�ʱ�ȭ �ݺ���
			for (int j = 0; j < N; j++) {
				D[i][j] = adjMatrix[i][j];
			}
		}
		return D;
	}
	
	public int[][] shortestPath() {
		for (int k = 0; k < N; k++) { //k�� �����ϴ� ��λ��� ��� �����鿡 ���� ������ȭ, k�� ��������� �� �ѹ��� ���
			for (int i = 0; i < N; i++) { 
				for (int j = 0; j < N; j++) { //�׷��� ����  ��� ������ �ֿ� ���� ����
					if (D[i][j] > D[i][k] + D[k][j]) { //i~j�� k�������� i~k~j�� �� ������?
						if(D[i][k] != INF && D[k][j] != INF) D[i][j] = D[i][k] + D[k][j]; //������ȭ
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
				if(D[i][j] == Integer.MAX_VALUE) { //������ ������ ���� ������ ��½�ŵ�ϴ�.
					System.out.print("��,  ");
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
