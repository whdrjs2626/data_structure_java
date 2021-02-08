package Graph_Prim;
import java.util.List;
public class PrimMST {
	int N; //�׷��� ������ ��
	List<Edge>[] graph;
	
	public PrimMST(List<Edge>[] adjList) { //������, ���Ḯ��Ʈ ���ڸ� ����
		N = adjList.length;
		graph = adjList;
	}
	
	public int[] mst(int s) { //prim�˰���, s�� ��������
		boolean[] visited = new boolean[N]; //MST�� ���ԵǾ����� ����(�湮�ߴ���)
		int[] D = new int[N]; // ���� �������� �ּҰ���ġ�� �����ϱ����ѹ迭
		int[] previous = new int[N]; // �ּҽ���Ʈ���� �������� Ȯ���� �� ������ �ٸ��� ����, pre[i] = j�� (i, j)������ �ִ°�
		for(int i = 0; i < N; i++) {
			visited[i] = false;
			previous[i] = -1;
			D[i] = Integer.MAX_VALUE; //�������� �ʱ�ȭ�Ѵ�.
		}
		previous[s] = 0;
		D[s] = 0; //��������s�� D[s]�� 0���� �ʱ�ȭ D[i]�� i�ΰ��� ������ ����ġ��, ������� �ʱ�ȭ�۾�
		for(int k = 0; k < N; k++) { //N���� ������ MST�� �߰��ϴ� �ݺ���
			int minVertex = -1; //�ּ� ������ �ε���
			int min = Integer.MAX_VALUE; //��������ġ�� �ּڰ�
			for(int j = 0; j < N; j++) {
				if ((!visited[j])&&(D[j] < min)) { //�湮���� ���� ����(MST�� ���Ծȵ�)�̰� MST�� ������ ������ �ּҰ��� ������?
					min = D[j]; //�ּҰ���ġ ����
					minVertex = j; // �ּ������ε��� ����
				}
			}
			visited[minVertex] = true; //minvertex�� �湮�ߴ�(MST�� �߰��ߴ�).
			for(Edge i : graph[minVertex]) { //minvertex�� ������ �� ������ D�ǿ���(����ġ����) ������Ʈ
				if(!visited[i.adjvertex]) {
					int currentDist = D[i.adjvertex]; //���� ����Ǿ��ִ� �ּڰ�
					int newDist = i.weight; //���ο� ����ġ��
					if (newDist < currentDist) { //���ο� ���� �������� �ּڰ� ������Ʈ
						D[i.adjvertex] = newDist;
						previous[i.adjvertex] = minVertex; //
					}
				}
			}
		}
		return previous;
	}
}
