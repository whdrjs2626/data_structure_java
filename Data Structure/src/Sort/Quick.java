package Sort;
import java.lang.Comparable;

import java.util.Arrays;
public class Quick {
    public static void sort(Comparable[] a) {
    	sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int low, int high) {
    	if (high <= low) return;
    	int j = partition(a, low, high);
    	sort(a, low, j-1);  //피벗보다 작은 부분을 재귀호출       
    	sort(a, j+1, high); //피벗보다    큰 부분을 재귀호출
    }
    private static int partition(Comparable[] a, int pivot, int high) { //low인덱스가 pivot이 됨
    	int i = pivot + 1;      //피벗이 첫번째 원소이므로 그다음 원소를 i
    	int j = high;           //마지막 원소를 j
    	Comparable p = a[pivot];
    	while (true) {
    		while (i <= high && !isless(p, a[i])) i++; // 피벗과 같거나 작으면 i증가 , 피벗보다 큰 수를 만나면 정지
    		while (j >= pivot && isless(p, a[j])) j--; // 피벗보다 크면 j감소         , 피벗보다 작은 수를 만나면 정지
    		if (i >= j) break; // i와 j가 교차되면 루프 탈출
    		swap(a, i, j); //정지한 i와 j를 교환
    	}
    	swap(a, pivot, j); //피벗과 a[j]를 교환
    	return j;          //고정된 피벗의 자리 리턴
    }
    private static boolean isless(Comparable v, Comparable w) { // 키 비교
    	return (v.compareTo(w) < 0);
    }
    private static void swap(Comparable[] a, int i, int j) { // 원소 교환
    	Comparable temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }
    public static void main(String[] args) {
    	System.out.println("퀵 정렬");
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