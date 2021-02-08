package Graph_reverse;

import java.util.LinkedList;
import java.util.List;

public class CheckGraph {
    int N;
	public boolean isReverseSame(int[][] G) {
		N = G[0].length;
		int[][] reG = new int[N][N];
		for(int i = 0; i < N; i++) { //GR(역방향행렬)만드는 반복문
			for(int j = 0; j < N; j++) {
				reG[j][i] = G[i][j];
			}
		}
		for(int i = 0; i < N; i++) { //만든 역방향 행렬이 원래 행렬과 같은지 확인하는 반복문
			for(int j = 0; j < N; j++) {
				if(reG[i][j] == G[i][j]) ;
				else return false; //하나라도 다르면 바로 false리턴
			}
		}
		return true; //전부 같으면 반복문을 빠져나와 true리턴
	}
	
	public boolean isReverseSame(List<Edge>[] G) {
		N = G.length;
    	List<Edge>[] reverseList = new List[N];
    	for(int i = 1; i < N; i++) { //GR(역방향인접리스트)만드는 반복문
    		for(int j = 0; j < G[i].size(); j++) {
    			if(reverseList[G[i].get(j).adjvertex] == null) {
    			    reverseList[G[i].get(j).adjvertex] = new LinkedList<>();
    			}
    			Edge e = new Edge(i, G[i].get(j).weight);
    			reverseList[G[i].get(j).adjvertex].add(e); //매개변수로 받은 인접리스트를 반대 방향을 바꿔서 새로운 배열에 추가
    		}
    	}
    	for(int i = 1; i < N; i++) { //만든 역방향리스트가 원래 리스트와 같은지 확인하는 반복문
    		for(int j = 0; j < G[i].size(); j++) {
    			if(G[i].get(j).weight == reverseList[i].get(j).weight) ;
    			else return false; //하나라도 다르면 바로 false리턴
    		}
    	}
    	return true; //전부 같으면 반복문을 빠져나와 true리턴
	}
}
