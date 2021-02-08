package Sort_Selection;
import java.lang.Comparable;
public class Selection {
    public static void sort(Comparable[] a) {
    	int N = a.length;
    	for (int i = 0; i < N; i++) {
    		int min = i; // 정렬안된 부분에서 최솟값을 가진 항목의 인덱스
    		for (int j = i+1; j < N; j++) {
    			if (isless(a[j], a[min])) min = j; // 최소값의 인덱스
    		}
    		swap(a, i, min); // i = 정렬안된 부분의 시작, min = 정렬안된 부분의 최솟값의 인덱스
    	}
    }
    private static boolean isless(Comparable i, Comparable j ) { // 키 비교
    	return (i.compareTo(j) < 0);
    }
    private static void swap(Comparable[] a, int i, int j) { // 원소 교환
    	Comparable temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }
}
