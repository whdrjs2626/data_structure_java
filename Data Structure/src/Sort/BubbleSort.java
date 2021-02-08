package Sort;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
    	int[] nums = {7, 4, 5, 1, 3};
    	System.out.println("Before : " + Arrays.toString(nums));
    	int[] sorted_nums = doSort(nums);
    	System.out.println("After : " + Arrays.toString(sorted_nums));
    	System.out.println("���� ����");
    	GenData a = new GenData();
    	int[] arr = a.genRandIntArr(10, 0, 100);
    	System.out.println("Before : " + Arrays.toString(arr));
    	int[] sorted_arr = doSort(arr);
    	System.out.println("After : " + Arrays.toString(sorted_arr));
    }
    public static int[] doSort(int[] arr) {
    	int temp = 0;
    	for (int end = arr.length - 1; end > 0; end--) //end = �����ؾ��ϴ� ������ ����, 1ȸ������ 1�� �پ��
    		for (int i = 0; i < end; i++) 
    			if(arr[i] > arr[i+1]) { //�� ������ �����ϸ� ������ �߸��� ����
    				temp = arr[i]; //temp�� ū �� ����
    				arr[i] = arr[i+1]; //ū ���ڸ��� �������� ����
    				arr[i+1] = temp; //���� ���ڸ��� temp���� -> ������
    			}
    	return arr;
    }
}
