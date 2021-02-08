package Sort_Selection;
import java.lang.Comparable;
public class Selection {
    public static void sort(Comparable[] a) {
    	int N = a.length;
    	for (int i = 0; i < N; i++) {
    		int min = i; // ���ľȵ� �κп��� �ּڰ��� ���� �׸��� �ε���
    		for (int j = i+1; j < N; j++) {
    			if (isless(a[j], a[min])) min = j; // �ּҰ��� �ε���
    		}
    		swap(a, i, min); // i = ���ľȵ� �κ��� ����, min = ���ľȵ� �κ��� �ּڰ��� �ε���
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
