package Graph_reverse;

import java.util.LinkedList;
import java.util.List;

public class CheckGraph {
    int N;
	public boolean isReverseSame(int[][] G) {
		N = G[0].length;
		int[][] reG = new int[N][N];
		for(int i = 0; i < N; i++) { //GR(���������)����� �ݺ���
			for(int j = 0; j < N; j++) {
				reG[j][i] = G[i][j];
			}
		}
		for(int i = 0; i < N; i++) { //���� ������ ����� ���� ��İ� ������ Ȯ���ϴ� �ݺ���
			for(int j = 0; j < N; j++) {
				if(reG[i][j] == G[i][j]) ;
				else return false; //�ϳ��� �ٸ��� �ٷ� false����
			}
		}
		return true; //���� ������ �ݺ����� �������� true����
	}
	
	public boolean isReverseSame(List<Edge>[] G) {
		N = G.length;
    	List<Edge>[] reverseList = new List[N];
    	for(int i = 1; i < N; i++) { //GR(��������������Ʈ)����� �ݺ���
    		for(int j = 0; j < G[i].size(); j++) {
    			if(reverseList[G[i].get(j).adjvertex] == null) {
    			    reverseList[G[i].get(j).adjvertex] = new LinkedList<>();
    			}
    			Edge e = new Edge(i, G[i].get(j).weight);
    			reverseList[G[i].get(j).adjvertex].add(e); //�Ű������� ���� ��������Ʈ�� �ݴ� ������ �ٲ㼭 ���ο� �迭�� �߰�
    		}
    	}
    	for(int i = 1; i < N; i++) { //���� �����⸮��Ʈ�� ���� ����Ʈ�� ������ Ȯ���ϴ� �ݺ���
    		for(int j = 0; j < G[i].size(); j++) {
    			if(G[i].get(j).weight == reverseList[i].get(j).weight) ;
    			else return false; //�ϳ��� �ٸ��� �ٷ� false����
    		}
    	}
    	return true; //���� ������ �ݺ����� �������� true����
	}
}
