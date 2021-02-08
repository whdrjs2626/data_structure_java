package Sort;
import java.util.Arrays;
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
    	int i = low, j = mid + 1; //i는 앞부분 j는 뒷부분용 인덱스, 하나의 배열이지만 두개의 배열이 있는 것처럼
    	for (int k = low; k <= high; k++) {
    		if      (i > mid)             b[k] = a[j++];   //비교하다가 앞부분이 먼저 소진된 경우(i가 mid를 넘음) 뒷부분을 b에 넣음
    		else if (j > high)            b[k] = a[i++];   //비교하다가 뒷부분이 먼저 소진된 경우(j가 high를 넘음) 앞부분을 b에 넣음
    		else if (isless(a[j], a[i]))  b[k] = a[j++];   //두개를 비교하여 j가 작으면 j를 넣음
    		else                          b[k] = a[i++];   //두개를 비교하여 i가 작으면 i를 넣음
    	}
    	for (int k = low; k <= high; k++) a[k] = b[k]; //b를 a에 복사
    }
    
    private static void sort(Comparable[] a, Comparable[] b, int low, int high) { //low는 자기가 정렬하고자 하는 범위의 최솟값, high는 최댓값
    	if (high <= low) return; //더이상 정렬할게 없다는 뜻
    	int mid = low + (high - low) / 2; //정렬할 범위를 반으로 나누기 위한 mid는 중간인덱스
    	sort(a, b, low, mid);        // 앞부분 sort로 넘겨 재귀호출
    	//여기서 sort메소드는 정렬하는 연산을 하지 않는다. 하지만 배열이 하나가 될 때 까지 반으로 나누므로 결국 그걸 병합하여 정렬되는 것, 배열이 하나의 원소가 있으면 정렬된것으로 본다.
    	sort(a, b, mid + 1, high);   // 뒷부분 sort로 넘겨 재귀호출
    	merge(a, b, low, mid, high); // 위에서 정렬 두 배열이 정렬이 되어 돌아오면 두 배열을 함병 수행(합치면서 다시 정렬함)
    } 
    
    public static void main(String[] args) {
    	System.out.println("합병 정렬");
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
