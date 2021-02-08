package Graph_trans;

import java.util.*;

public class MyGraph {
	public int N;

	public int[][] getAdjMatrixFromAdjList(List<Edge>[] lst) {
		N = lst.length;
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < lst[i].size(); j++) {
				arr[i][lst[i].get(j).adjvertex] = lst[i].get(j).weight;
			}
		}
		return arr;
	}
	
	public List<Edge>[] getAdjListFromAdjMatrix(int[][] mat) {
		N = mat[0].length;
		List<Edge>[] graph = new List[N];
		for(int i = 0; i < N; i++) {
			graph[i] = new LinkedList<>();
			for(int j = 0; j < N; j++) {
				if(mat[i][j] != 0) {
				    Edge e = new Edge(j, mat[i][j]);
				    graph[i].add(e);
				}
			}
		}
		return graph;
	}
	
	public void print(int[][] mat) {
		N = mat[0].length;
		System.out.println("AdjMatrix : ");
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(mat[i][j] + ", ");
			}
			System.out.println();
		}
	}
	
	public void print(List<Edge>[] lst) {
		N = lst.length;
    	System.out.println("AjdList : ");
		for(int i = 0; i < N; i ++) {
			System.out.print("[" + i + "]");
			for(int j = 0; j < lst[i].size(); j++) {
				System.out.print(" => " + lst[i].get(j).adjvertex + "(" + lst[i].get(j).weight + ")");
				
			}
			System.out.println();
		}
	}
}
