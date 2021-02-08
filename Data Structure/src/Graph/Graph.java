package Graph;

import java.util.*;
public class Graph {
	static int N; // ������ ��
	static List<Edge>[] graph;
	
	public Graph(List<Edge>[] adjList) { //������
    	N = adjList.length;
    	graph = adjList;
	}
	
    public void print(List<Edge>[] adjList, int[] arr) {
    	N = adjList.length;
    	graph = adjList;
    	System.out.println("��������Ʈ�� �̿��� �׷���");
		for(int i = 0; i < N; i ++) {
			System.out.print("[" + i + "]");
			for(int j = 0; j < arr[i]; j++) {
				System.out.print(" => " + graph[i].get(j).adjvertex);
			}
			System.out.println();
		}
	}
    
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("������ �� �Է� : ");
		N = scan.nextInt();
		int[] size = new int[N];
	    List<Edge>[] adjList = new List[N];
	    for (int i = 0; i < N; i++) {
	    	adjList[i] = new LinkedList<>();
	    	System.out.print(i + "������ �����ϴ� ������ ����? ");
	    	int count;
	    	count = scan.nextInt();
	    	int[] num = new int[N]; num[0] = 1;
	    	System.out.println(i + "������ �����ϴ� ������? ");
	    	for (int j = 0; j < count; j++) {
	    		int a;
	    		a = scan.nextInt();
	    		num[a] = a;
	    	}
		    for (int j = 0; j < N; j++) {
		    	if(num[j] == j) {
		    		System.out.print(i + "������ ");
			    	System.out.print(j + "������ ���ϴ°�? (���ϸ� 1 ������������ 0) : ");
			    	int a;
			    	a = scan.nextInt();
				    if(a == 0) {
					    Edge e = new Edge(j);
					    adjList[i].add(e);
					    size[i]++;
				    }
				    else if(a == 1) {
				    	Edge e = new Edge(j);
					    adjList[i].add(0, e);
					    size[i]++;
		    	    }
		    	}
		    }
        }
	    System.out.println("[Q 1]");
	    Graph a = new Graph(adjList);
	    a.print(adjList, size);
	    
	    //System.out.println("[Q 2]");
	    //System.out.println("DFS �湮 ���� ");
	    //DFS d = new DFS(adjList);
	    
	    //System.out.println("[Q 3]");
	    //System.out.println("BFS �湮 ���� ");
	    //BFS b = new BFS(adjList);
	}
}

