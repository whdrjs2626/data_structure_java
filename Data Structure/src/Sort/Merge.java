package Sort;
import java.util.Arrays;
import java.lang.Comparable;
public class Merge {
    public static void sort(Comparable[] a) {
    	Comparable[] b = new Comparable[a.length]; //�����迭 b
    	sort(a, b, 0, a.length-1);
    }
    
    private static boolean isless(Comparable v, Comparable w) {
    	return (v.compareTo(w) < 0);
    }
    
    private static void merge(Comparable[] a, Comparable[] b, int low, int mid, int high) { // �պ��Լ�, ���⼭ ������ �Ͼ
    	int i = low, j = mid + 1; //i�� �պκ� j�� �޺κп� �ε���, �ϳ��� �迭������ �ΰ��� �迭�� �ִ� ��ó��
    	for (int k = low; k <= high; k++) {
    		if      (i > mid)             b[k] = a[j++];   //���ϴٰ� �պκ��� ���� ������ ���(i�� mid�� ����) �޺κ��� b�� ����
    		else if (j > high)            b[k] = a[i++];   //���ϴٰ� �޺κ��� ���� ������ ���(j�� high�� ����) �պκ��� b�� ����
    		else if (isless(a[j], a[i]))  b[k] = a[j++];   //�ΰ��� ���Ͽ� j�� ������ j�� ����
    		else                          b[k] = a[i++];   //�ΰ��� ���Ͽ� i�� ������ i�� ����
    	}
    	for (int k = low; k <= high; k++) a[k] = b[k]; //b�� a�� ����
    }
    
    private static void sort(Comparable[] a, Comparable[] b, int low, int high) { //low�� �ڱⰡ �����ϰ��� �ϴ� ������ �ּڰ�, high�� �ִ�
    	if (high <= low) return; //���̻� �����Ұ� ���ٴ� ��
    	int mid = low + (high - low) / 2; //������ ������ ������ ������ ���� mid�� �߰��ε���
    	sort(a, b, low, mid);        // �պκ� sort�� �Ѱ� ���ȣ��
    	//���⼭ sort�޼ҵ�� �����ϴ� ������ ���� �ʴ´�. ������ �迭�� �ϳ��� �� �� ���� ������ �����Ƿ� �ᱹ �װ� �����Ͽ� ���ĵǴ� ��, �迭�� �ϳ��� ���Ұ� ������ ���ĵȰ����� ����.
    	sort(a, b, mid + 1, high);   // �޺κ� sort�� �Ѱ� ���ȣ��
    	merge(a, b, low, mid, high); // ������ ���� �� �迭�� ������ �Ǿ� ���ƿ��� �� �迭�� �Ժ� ����(��ġ�鼭 �ٽ� ������)
    } 
    
    public static void main(String[] args) {
    	System.out.println("�պ� ����");
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
