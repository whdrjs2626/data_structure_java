package Sort_Merge;
import java.lang.Comparable;
public class Merge {
    public static void sort(Comparable[] a) {
    	Comparable[] b = new Comparable[a.length]; //보조배열 b
    	sort(a, b, 0, a.length-1);
    }
    
    private static boolean isless(Comparable v, Comparable w) {
    	return (v.compareTo(w) < 0);
    }
    
    private static void merge(Comparable[] a, Comparable[] b, int low, int mid, int high) { // 합병함수, 여기서 정렬이 일어남
    	int i = low, j = mid + 1; //i는 앞부분 j는 뒷부분용 인덱스
    	for (int k = low; k <= high; k++) {
    		if      (i > mid)             b[k] = a[j++];   //앞부분이 먼저 소진된 경우(i가 mid를 넘음) 뒷부분을 b에 넣음
    		else if (j < high)            b[k] = a[i++];   //뒷부분이 먼저 소진된 경우(j가 high를 넘음) 앞부분을 b에 넣음
    		else if (isless(a[j], a[i]))  b[k] = a[j++];   //두개를 비교하여 j가 작으면 j를 넣음
    		else                          b[k] = a[i++];   //두개를 비교하여 i가 작으면 i를 넣음
    	}
    	for (int k = low; k <= high; k++) a[k] = b[k]; //b를 a에 복사
    }
    
    private static void sort(Comparable[] a, Comparable[] b, int low, int high) { //low는 자기가 정렬하고자 하는 범위의 최솟값, high는 최댓값
    	if (high <= low) return;
    	int mid = low + (high - low) / 2; //mid는 중간인덱스
    	sort(a, b, low, mid);        // 앞부분 sort로 넘겨 재귀호출
    	//여기서 sort메소드는 정렬하는 연산을 하지 않는다. 하지만 배열이 하나가 될 때 까지 반으로 나누므로 결국 그걸 병합하여 정렬되는 것
    	sort(a, b, mid + 1, high);   // 뒷부분 sort로 넘겨 재귀호출
    	merge(a, b, low, mid, high); // 위에서 정렬된 두 배열을 함병 수행
    } 
}
