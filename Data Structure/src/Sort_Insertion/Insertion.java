package Sort_Insertion;
import java.lang.Comparable;
public class Insertion {
    public static void sort(Comparable[] a) {
    	int N = a.length;
    	for (int i = 1; i < N; i++) { // i�� ���ľȵ� �κ��� ���� ���� �ε���, 0�ε����� ������ �Ǿ��ִ�. �׷��� 1���� ����
    		for (int j = i; j > 0; j--) { // j�� ���ĵ� �κ��� �ε��� �ϳ��� �ٿ����鼭 ��
    			if ( isless(a[j], a[j-1]) ) // ������ ������ ������ ���� �ʴ� ��
    				swap(a, j, j-1);
    			else break;
    		}
    	}
    }
    private static boolean isless(Comparable i, Comparable j ) { // Ű ��
    	return (i.compareTo(j) < 0);
    }
    private static void swap(Comparable[] a, int i, int j) { // ���� ��ȯ
    	Comparable temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }
}
