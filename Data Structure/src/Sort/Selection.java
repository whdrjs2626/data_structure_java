package Sort;
import java.lang.Comparable;
import java.util.Arrays;
public class Selection {
    public static void sort(Comparable[] a) {
    	int N = a.length;
    	for (int i = 0; i < N; i++) { //i�� ���ľȵ� ������ ������ ��Ÿ���� �ε���
    		int min = i; // ���ľȵ� �κп��� �ּڰ��� ���� �׸��� �ε���
    		for (int j = i+1; j < N; j++) { //minã��
    			if (isless(a[j], a[min])) min = j; // �ּҰ��� �ε���
    		}
    		swap(a, i, min); // i = ���ľȵ� �κ��� ����, min = ���ľȵ� �κ��� �ּڰ��� �ε��� - �ΰ�����
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
    
    public static void main(String[] args) {
    	System.out.println("���� ����");
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
