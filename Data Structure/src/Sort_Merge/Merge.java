package Sort_Merge;
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
    	int i = low, j = mid + 1; //i�� �պκ� j�� �޺κп� �ε���
    	for (int k = low; k <= high; k++) {
    		if      (i > mid)             b[k] = a[j++];   //�պκ��� ���� ������ ���(i�� mid�� ����) �޺κ��� b�� ����
    		else if (j < high)            b[k] = a[i++];   //�޺κ��� ���� ������ ���(j�� high�� ����) �պκ��� b�� ����
    		else if (isless(a[j], a[i]))  b[k] = a[j++];   //�ΰ��� ���Ͽ� j�� ������ j�� ����
    		else                          b[k] = a[i++];   //�ΰ��� ���Ͽ� i�� ������ i�� ����
    	}
    	for (int k = low; k <= high; k++) a[k] = b[k]; //b�� a�� ����
    }
    
    private static void sort(Comparable[] a, Comparable[] b, int low, int high) { //low�� �ڱⰡ �����ϰ��� �ϴ� ������ �ּڰ�, high�� �ִ�
    	if (high <= low) return;
    	int mid = low + (high - low) / 2; //mid�� �߰��ε���
    	sort(a, b, low, mid);        // �պκ� sort�� �Ѱ� ���ȣ��
    	//���⼭ sort�޼ҵ�� �����ϴ� ������ ���� �ʴ´�. ������ �迭�� �ϳ��� �� �� ���� ������ �����Ƿ� �ᱹ �װ� �����Ͽ� ���ĵǴ� ��
    	sort(a, b, mid + 1, high);   // �޺κ� sort�� �Ѱ� ���ȣ��
    	merge(a, b, low, mid, high); // ������ ���ĵ� �� �迭�� �Ժ� ����
    } 
}
