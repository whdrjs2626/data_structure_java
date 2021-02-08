package Graph;
import java.util.*;
public class TopologicalSort {
    static int N;
    boolean[] visited;
    List<Integer>[] adjList; //��������Ʈ ������ �Է� �׷���
    List<Integer> sequence; //�������� ������ ���� ����Ʈ
    public TopologicalSort(List<Integer>[] graph) { //������
    	N = graph.length;
    	visited = new boolean[N];
    	adjList = graph;
    	sequence = new ArrayList<>();
    }
    public List<Integer> tsort() { //��������
    	for (int i = 0; i < N; i++) if (!visited[i]) dfs(i); //dfs�� �����ϸ� sequence�� ���ð��� 
    	Collections.reverse(sequence); //�װ��� �������ش�.
    	return sequence;
    }
    public void dfs(int i) { //���̿켱Ž�� private�̸� ���� ���ϴ�
    	visited[i] = true;
    	for (int v : adjList[i]) { //i�� �湮�� ������ ������ �湮�ؾ��ϴ� �� ���� v
    		if (!visited[v]) dfs(v); 
    	}
    	sequence.add(i); //i�� ������ ������ ������(�������̸�) sequence�� �߰��� - �������Ĺݴ������ �߰���
    }
    public void print(List<Integer> list) { //����Ʈ ���
    	System.out.print("[");
    	for(int i = 0; i < N; i++) {
        	System.out.print(list.get(i) + ", ");
    	}
    	System.out.print("]");
    }
    
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
		System.out.print("������ �� �Է� : ");
		N = scan.nextInt();
		int[] size = new int[N];
	    List<Integer>[] adjList = new List[N]; //�Է��� ������ ����ŭ �迭 ����
	    for (int i = 0; i < N; i++) {
	    	adjList[i] = new LinkedList<>(); //��ũ�帮��Ʈ ����
	    	System.out.print(i + "������ ���ϴ� ������ ����? ");
	    	int count;
	    	count = scan.nextInt(); //������ ���ϴ� ������ ���� �Է¹���
	    	int[] num = new int[N]; num[0] = 1;
	    	System.out.println(i + "������ ���ϴ� ������? ");
	    	for (int j = 0; j < count; j++) { //�Է��� ������ �� ��ŭ ������ ������ �迭�� ������
	    		int a;
	    		a = scan.nextInt();
	    		num[a] = a;
	    	}
		    for (int j = 0; j < N; j++) {
		    	if(num[j] == j) { //j�� �Է��� �����̸�
		    		Edge e = new Edge(j);
					adjList[i].add(e.adjvertex);
					size[i]++;
		    	}
		    }
        }
	    TopologicalSort a = new TopologicalSort(adjList);
	    System.out.println("��������");
	    a.print(a.tsort());
	}
}
