package Sort;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
    	int[] nums = {7, 4, 5, 1, 3};
    	System.out.println("Before : " + Arrays.toString(nums));
    	int[] sorted_nums = doSort(nums);
    	System.out.println("After : " + Arrays.toString(sorted_nums));
    	System.out.println("버블 정렬");
    	GenData a = new GenData();
    	int[] arr = a.genRandIntArr(10, 0, 100);
    	System.out.println("Before : " + Arrays.toString(arr));
    	int[] sorted_arr = doSort(arr);
    	System.out.println("After : " + Arrays.toString(sorted_arr));
    }
    public static int[] doSort(int[] arr) {
    	int temp = 0;
    	for (int end = arr.length - 1; end > 0; end--) //end = 정렬해야하는 숫자의 범위, 1회전마다 1씩 줄어듦
    		for (int i = 0; i < end; i++) 
    			if(arr[i] > arr[i+1]) { //이 조건이 성립하면 순서가 잘못된 거임
    				temp = arr[i]; //temp에 큰 수 저장
    				arr[i] = arr[i+1]; //큰 수자리에 작은수를 저장
    				arr[i+1] = temp; //작은 수자리에 temp저장 -> 스왑임
    			}
    	return arr;
    }
}
