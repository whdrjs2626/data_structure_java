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
    
    public Kosaraju(List<Integer>[] graph) { //생성자
    	N = graph.length;
    	visited = new boolean[N];
    	adjList = graph;
    	sequence = new ArrayList<>();
    }
    
    public List<Integer> tsort() { //위상정렬
    	for (int i = 0; i < N; i++) if (!visited[i]) dfs(i);
    	Collections.reverse(sequence);
    	return sequence;
    }
    public void dfs(int i) { //dfs함수
    	visited[i] = true;
    	for (int v : adjList[i]) {
    		if (!visited[v]) dfs(v);
    	}
    	sequence.add(i);
    }
    
    public List<Integer>[] reverse(List<Integer>[] list, int[] arr) { //리스트 역순으로 변환
    	N = list.length;
    	List<Integer>[] reverseList = new List[N];
    	int[] reversesize = new int[N];
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < arr[i]; j++) {
    			if(reverseList[list[i].get(j)] == null) {
    			    reverseList[list[i].get(j)] = new LinkedList<>();
    			}
    			Edge e = new Edge(i);
    			reverseList[list[i].get(j)].add(e.adjvertex); //매개변수로 받은 인접리스트를 반대 방향을 바꿔서 새로운 배열에 추가
    			reversesize[list[i].get(j)]++;
    		}
    	}
    	System.out.println("역방향 그래프의 인접리스트");
    	this.listprint(reverseList, reversesize);
    	return reverseList;
    }
    
    public void SCC(List<Integer> list) { //위상정렬 순서를 받아서 강연결성분을 추출
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
    public void sccdfs(int i) { //강연결성분을 구하기 위한 DFS함수
    	visited[i] = true;
    	for (int v : adjList[i]) {
    		if (!visited[v]) sccdfs(v);
    		if(v == adjList[i].get(0)) System.out.print(i + ", "); //i가 한번만 출력되도록 조건문을 만듬
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
    	System.out.println("인접리스트를 이용한 그래프");
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
		System.out.print("정점의 수 입력 : ");
		N = scan.nextInt();
		int[] size = new int[N];
	    List<Integer>[] adjList = new List[N]; //입력한 정점의 수만큼 배열 생성
	    for (int i = 0; i < N; i++) {
	    	adjList[i] = new LinkedList<>(); //링크드리스트 생성
	    	System.out.print(i + "정점이 향하는 정점의 수는? ");
	    	int count;
	    	count = scan.nextInt(); //정점이 향하는 정점의 수를 입력받음
	    	int[] num = new int[N]; num[0] = 1;
	    	System.out.println(i + "정점이 향하는 정점은? ");
	    	for (int j = 0; j < count; j++) { //입력한 정점의 수 만큼 인접한 정점을 배열에 저장함
	    		int a;
	    		a = scan.nextInt();
	    		num[a] = a;
	    	}
		    for (int j = 0; j < N; j++) {
		    	if(num[j] == j) { //j가 입력한 정점이면
		    		Edge e = new Edge(j);
					adjList[i].add(e.adjvertex);
					size[i]++;
		    	}
		    }
        }
	    System.out.println();
	    Kosaraju a = new Kosaraju(adjList);
	    List<Integer> s = a.tsort(); //원래 그래프의 위상정렬을 s에 저장
	    
	    System.out.println("원래 그래프");
	    a.listprint(adjList, size); //원래 그래프의 인접리스트
	    System.out.println();
	    
	    List<Integer>[] readjList = a.reverse(adjList, size); //reverse함수를 이용하여 역방향그래프 생성
	    Kosaraju b = new Kosaraju(readjList); 
	    System.out.println();
	    
	    System.out.println("강연결성분");
	    b.SCC(s); //역방향그래프를 원래그래프의 위상정렬 s를 이용하여 dfs해서 강연결성분을 구함
	}
}
