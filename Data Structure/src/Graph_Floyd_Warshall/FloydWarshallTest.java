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
    	int[][] D = a.init(adjMatrix); // D행렬 초기화
    	System.out.println("행렬 D : ");
    	a.print(D);                    // 행렬 D 출력
    	System.out.println("행렬 D : ");
    	int[][] D2 = a.shortestPath(); // 알고리즘 실행
    	a.print(D2);                   // 최종 행렬 D 출력
    	
    }
}
