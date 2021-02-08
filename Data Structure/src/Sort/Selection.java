package Sort;
import java.lang.Comparable;
import java.util.Arrays;
public class Selection {
    public static void sort(Comparable[] a) {
    	int N = a.length;
    	for (int i = 0; i < N; i++) { //i는 정렬안된 영역의 시작을 나타내는 인덱스
    		int min = i; // 정렬안된 부분에서 최솟값을 가진 항목의 인덱스
    		for (int j = i+1; j < N; j++) { //min찾기
    			if (isless(a[j], a[min])) min = j; // 최소값의 인덱스
    		}
    		swap(a, i, min); // i = 정렬안된 부분의 시작, min = 정렬안된 부분의 최솟값의 인덱스 - 두개스왑
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
    
    public static void main(String[] args) {
    	System.out.println("선택 정렬");
    	GenData a = new GenData();
    	int[] arr = a.genRandIntArr(10, 0, 100);
    	Comparable[] arr2 = new Comparable[arr.length];
    	for(int i = 0; 	i < arr.length; i++) {
    		arr2[i] = arr[i];
    	}
    	System.out.println("Before : " + Arrays.toString(arr2));
    	sort(arr2);
    	System.out.println("After : " + Arrays.toString(arr2));
    }
}
