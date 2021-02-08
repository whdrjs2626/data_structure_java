package Graph_Bellman_Ford;

public class BellmanFord {
	public static final int INF = Integer.MAX_VALUE;
	private int D[];
	private int previous[]; //��� ������ ����
	private int N;
	
	public BellmanFord(int numOfVertices) { //������, ������ ���� �Է����� ����
        N = numOfVertices;
        D = new int[N]; //�ִܰŸ� ����
        previous = new int[N]; //�ִܰ�� ����
	}
	
	public void shortestPath(int s, int adjMatrix[][]) { //�׷����� ������� ���ڷ� ����
		for (int i = 0; i < N; i++)
			D[i] = INF; //�ʱ�ȭ
		D[s] = 0; previous[s] = 0;
		for (int k = 0; k < N-1; k++) { //�ִ� ���� ����ŭ �ݺ�
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) { //��� (i, j)�� ���Ͽ�
					if (adjMatrix[i][j] != INF) {
						if (D[j] > D[i] + adjMatrix[i][j]) { //��� �湮�ϴٰ� �� ���� ���� ������ ����
							D[j] = D[i] + adjMatrix[i][j]; //������ȭ
							previous[j] = i; //
						}
					}
				}
			}
		}
	}
	public void printPaths(int s) {
		System.out.println("���� 0���� ������ �ִܰŸ�");
    	int[] distance = this.D;
    	
    	for (int i = 0; i < distance.length; i++) {
    		if (distance[i] == Integer.MAX_VALUE)
    			System.out.println("0�� " + i + "������ ��ΰ� �����ϴ�.");
    		else
    			System.out.println("[0,  " + i + "] = " + distance[i]);
    	}
    	int count = this.N;
    	int pre[] = this.previous;
    	System.out.printf("\n���� 0���κ����� �ִ� ���\n");
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
