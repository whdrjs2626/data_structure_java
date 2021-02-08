package Sort;
import java.lang.Comparable;
import java.util.Arrays;

public class Insertion {
    public static void sort(Comparable[] a) {
    	int N = a.length;
    	for (int i = 1; i < N; i++) { // i는 정렬안된 부분의 가장 왼쪽 인덱스, 0인덱스는 정렬이 되어있다. 그래서 1부터 시작
    		for (int j = i; j > 0; j--) { // j는 정렬된 부분의 인덱스 하나씩 줄여가면서 비교
    			if ( isless(a[j], a[j-1]) ) // 조건이 맞으면 순서가 맞지 않는 것
    				swap(a, j, j-1);
    			else break;
    		}
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
    	System.out.println("삽입 정렬");
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
