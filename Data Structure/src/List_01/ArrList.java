package List_01;

import java.util.NoSuchElementException;

public class ArrList<E> {
	private E a[];
	private int size;
	public ArrList() {
		a = (E[]) new Object[1];
		size = 0;
	}
	
	public E peek(int k) {
		if(size == 0 || k >= size)
			throw new NoSuchElementException();
		return a[k];
	}
	
	public boolean isEmpty() {
		if (size == 0) return true;
		return false;
	}
	
	public void insert(E newItem, int k) {
		if (size == a.length) //�����������ΰ�?
			resize(2 * a.length);
		for (int i = size-1; i >= k; i--) a[i+1] = a[i]; //k���� ũ���ε��� ��ĭ�� �ڷ� ������
		a[k] = newItem; // �׸��߰�
		size++; //������ �ø�
	}
	
	public void insertLast(E newItem) {
		if (size == a.length)
			resize(2 * a.length);
		a[size++] = newItem;
	}
	
	public void insert(E newItem) { //�μ�Ʈ ȣ��� �ι�������(���ٳ�����)�� ���ָ� insertlast�� ���� �۵��ϰ� ���� �޼ҵ� �����ε� ��
		insertLast(newItem);
	}
	
	private void resize(int newSize) {
		Object[] t = new Object[newSize]; // newSize ũ���� ���ο� �迭 t����
		for (int i = 0; i < size; i++)
			t[i] = a[i]; //�迭 ��� ����
		a = (E[]) t; //������ �÷��ͷ� ���� �迭�� ����
	}
	
	public E delete(int K) {
		if (isEmpty()) throw new NoSuchElementException();
		E item = a[K];
		for (int i = K; i < size; i++) a[i] = a[i+1]; //k���� �ε����� ũ�ų� ���� �͵��� ��ĭ�� ����
		size --;
		if(size > 0 && size <= a.length/4) //����� 1/4�̤��� ���Ǹ� ���
			resize(a.length/2);
		return item;
	}
	
	public void print() {
		for (int i = 0; i < a.length; i++) { //�迭�� ũ�⸸ŭ ���
			if (i < size) System.out.printf(a[i] + "\t"); //�׸��� �����ϸ� �׸����
			else System.out.printf("null\t"); //������ null���
		}
		System.out.println();
	}
}
