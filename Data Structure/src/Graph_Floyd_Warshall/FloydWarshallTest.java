package Graph_Floyd_Warshall;

public class FloydWarshallTest {
	public static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
    	int[][] adjMatrix = {
    			{   0,   4,   2,   5, INF },
    			{ INF,   0,   1, INF,   4 },
    			{   1,   3,   0,   1,   2 },
    			{  -2, INF, INF,   0,   2 },
    			{ INF,  -3,   3,   1,   0 }
    	};
    	
    	FloydWarshall a = new FloydWarshall(adjMatrix);
    	int[][] D = a.init(adjMatrix); // D��� �ʱ�ȭ
    	System.out.println("��� D : ");
    	a.print(D);                    // ��� D ���
    	System.out.println("��� D : ");
    	int[][] D2 = a.shortestPath(); // �˰��� ����
    	a.print(D2);                   // ���� ��� D ���
    	
    }
}
