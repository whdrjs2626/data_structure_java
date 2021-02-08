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
    	sort(a, low, j-1);  //�ǹ����� ���� �κ��� ���ȣ��       
    	sort(a, j+1, high); //�ǹ�����    ū �κ��� ���ȣ��
    }
    private static int partition(Comparable[] a, int pivot, int high) { //low�ε����� pivot�� ��
    	int i = pivot + 1;      //�ǹ��� ù��° �����̹Ƿ� �״��� ���Ҹ� i
    	int j = high;           //������ ���Ҹ� j
    	Comparable p = a[pivot];
    	while (true) {
    		while (i <= high && !isless(p, a[i])) i++; // �ǹ��� ���ų� ������ i���� , �ǹ����� ū ���� ������ ����
    		while (j >= pivot && isless(p, a[j])) j--; // �ǹ����� ũ�� j����         , �ǹ����� ���� ���� ������ ����
    		if (i >= j) break; // i�� j�� �����Ǹ� ���� Ż��
    		swap(a, i, j); //������ i�� j�� ��ȯ
    	}
    	swap(a, pivot, j); //�ǹ��� a[j]�� ��ȯ
    	return j;          //������ �ǹ��� �ڸ� ����
    }
    private static boolean isless(Comparable v, Comparable w) { // Ű ��
    	return (v.compareTo(w) < 0);
    }
    private static void swap(Comparable[] a, int i, int j) { // ���� ��ȯ
    	Comparable temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }
    public static void main(String[] args) {
    	System.out.println("�� ����");
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