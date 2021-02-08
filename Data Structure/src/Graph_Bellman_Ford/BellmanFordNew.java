package Graph_Bellman_Ford;

public class BellmanFordNew {
	public static final int INF = Integer.MAX_VALUE;
	private int D[];
	private int previous[];
	private int N;
	
	public BellmanFordNew(int numOfVertices) { //������, ������ ���� �Է����� ����
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
		for(int i = 0; i < previous.length; i++) { //�ִܰŸ��� ����ġ�� ���� ���Ѵ�.
			sum += D[previous[i]];
		}
		if(sum >= 0) { //���Ѱ� 0�̻��̸� ���� ����Ŭ�� ���� ��
			System.out.println("**�Է��� �׷����� ���� ����Ŭ�� �����ϴ�.**"); 
		}
		else { //���Ѱ� ������ ���� ����Ŭ�� �ִ� ��
			System.out.println("**�Է��� �׷����� ���� ����Ŭ�� �ֽ��ϴ�.**");
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
