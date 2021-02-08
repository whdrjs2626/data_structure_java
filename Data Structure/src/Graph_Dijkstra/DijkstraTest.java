package Graph_Dijkstra;
import java.util.*;
public class DijkstraTest {
    public static void main(String[] args) {
    	int[][] weight = { //�Է±׷���
    			{ 0, 1, 0, 2, 0, 0, 0, 0 },
    			{ 1, 0, 4, 3, 1, 6, 0, 0 },
    			{ 0, 4, 0, 0, 0, 1, 1, 2 },
    			{ 2, 3, 0, 0, 5, 0, 0, 0 },
    			{ 0, 1, 0, 5, 0, 0, 2, 0 },
    			{ 0, 6, 1, 0, 0, 0, 0, 9 },
    			{ 0, 0, 1, 0, 2, 0, 0, 1 },
    			{ 0, 0, 2, 0, 0, 9, 1, 0 }
    	};
    	int N = weight.length;
    	List<Edge>[] adjList = new List[N];
    	for (int i = 0; i < N; i++) {
    		adjList[i] = new LinkedList<>();
    		for (int j = 0; j < N; j++) {
    			if (weight[i][j] != 0) { //����Ǿ� �ִ�.
    				Edge e = new Edge(i, j, weight[i][j]);
    				adjList[i].add(e);
    			}
    		}
    	}
    	DijkstraSP d = new DijkstraSP(adjList);
    	
    	System.out.println("[Q 4][Task]");
    	System.out.println("���� 0���� ������ �ִܰŸ�");
    	int[] distance = d.shortestPath(0);
    	
    	for (int i = 0; i < distance.length; i++) {
    		if (distance[i] == Integer.MAX_VALUE)
    			System.out.println("0�� " + i + "������ ��ΰ� �����ϴ�.");
    		else
    			System.out.println("[0,  " + i + "] = " + distance[i]);
    	}
    	
    	System.out.printf("\n���� 0���κ����� �ִ� ���\n");
    	for (int i = 1; i < d.N; i++) {
    		int back = i;
    		System.out.print(back);
    		while (back != 0) {
    			System.out.print("<-" + d.previous[back]);
    			back = d.previous[back];
    		}
    		System.out.println();
    	}
    }
}
