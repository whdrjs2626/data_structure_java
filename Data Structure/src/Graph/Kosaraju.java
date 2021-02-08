package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Kosaraju {
	static int N;
    boolean[] visited;
    List<Integer>[] adjList;
    List<Integer> sequence;
    
    public Kosaraju(List<Integer>[] graph) { //������
    	N = graph.length;
    	visited = new boolean[N];
    	adjList = graph;
    	sequence = new ArrayList<>();
    }
    
    public List<Integer> tsort() { //��������
    	for (int i = 0; i < N; i++) if (!visited[i]) dfs(i);
    	Collections.reverse(sequence);
    	return sequence;
    }
    public void dfs(int i) { //dfs�Լ�
    	visited[i] = true;
    	for (int v : adjList[i]) {
    		if (!visited[v]) dfs(v);
    	}
    	sequence.add(i);
    }
    
    public List<Integer>[] reverse(List<Integer>[] list, int[] arr) { //����Ʈ �������� ��ȯ
    	N = list.length;
    	List<Integer>[] reverseList = new List[N];
    	int[] reversesize = new int[N];
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < arr[i]; j++) {
    			if(reverseList[list[i].get(j)] == null) {
    			    reverseList[list[i].get(j)] = new LinkedList<>();
    			}
    			Edge e = new Edge(i);
    			reverseList[list[i].get(j)].add(e.adjvertex); //�Ű������� ���� ��������Ʈ�� �ݴ� ������ �ٲ㼭 ���ο� �迭�� �߰�
    			reversesize[list[i].get(j)]++;
    		}
    	}
    	System.out.println("������ �׷����� ��������Ʈ");
    	this.listprint(reverseList, reversesize);
    	return reverseList;
    }
    
    public void SCC(List<Integer> list) { //�������� ������ �޾Ƽ� �����Ἲ���� ����
    	int count = 1;
    	for(int i = 0; i < N; i++) {
    		if (!visited[list.get(i)]) {
    			System.out.print("[" + count + "] ");
    			System.out.print("[");
    			sccdfs(list.get(i));
    			System.out.println("]   ");
    			count++;
    		}
    	}
    }
    public void sccdfs(int i) { //�����Ἲ���� ���ϱ� ���� DFS�Լ�
    	visited[i] = true;
    	for (int v : adjList[i]) {
    		if (!visited[v]) sccdfs(v);
    		if(v == adjList[i].get(0)) System.out.print(i + ", "); //i�� �ѹ��� ��µǵ��� ���ǹ��� ����
    	}
    }
    
    public void print(List<Integer> list) {
    	System.out.print("[");
    	for(int i = 0; i < N; i++) {
        	System.out.print(list.get(i) + ", ");
    	}
    	System.out.print("]");
    }
    
    public void listprint(List<Integer>[] adjList2, int[] arr) {
    	N = adjList2.length;
    	//adjList = adjList2;
    	System.out.println("��������Ʈ�� �̿��� �׷���");
		for(int i = 0; i < N; i++) {
			System.out.print("[" + i + "]");
			for(int j = 0; j < arr[i]; j++) {
				System.out.print(" => " + adjList2[i].get(j));
			}
			System.out.println();
		}
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
	    System.out.println();
	    Kosaraju a = new Kosaraju(adjList);
	    List<Integer> s = a.tsort(); //���� �׷����� ���������� s�� ����
	    
	    System.out.println("���� �׷���");
	    a.listprint(adjList, size); //���� �׷����� ��������Ʈ
	    System.out.println();
	    
	    List<Integer>[] readjList = a.reverse(adjList, size); //reverse�Լ��� �̿��Ͽ� ������׷��� ����
	    Kosaraju b = new Kosaraju(readjList); 
	    System.out.println();
	    
	    System.out.println("�����Ἲ��");
	    b.SCC(s); //������׷����� �����׷����� �������� s�� �̿��Ͽ� dfs�ؼ� �����Ἲ���� ����
	}
}
