package CLL;
import java.util.NoSuchElementException;

import DLL.DNode;
public class CList <E> {
	private Node last; //����Ʈ�� ������ ��带 ����Ų��.
	private int size;
	public CList() {
		last = null;
		size = 0;
	}
	public void insert(E newItem) { //last�� ����Ű�³���� ����(���)�� ����� ����
		Node newNode = new Node(newItem, null);
		if (last == null) { //����Ʈ�� ����ٸ�
			newNode.setNext(newNode); //�ڱ��ڽ��� ���ϰ���(�����̹Ƿ�)
			last = newNode; //�̰� last����
		}
		else { //����Ʈ�� ������� �ʴٸ�
			newNode.setNext(last.getNext()); 
			last.setNext(newNode); //last�� last������ ���̿� ����
		}
		size++;
	}
	public Node delete() { //last�� ����Ű�³���� ������带 ����
		if (isempty()) throw new NoSuchElementException();
		Node x = last.getNext();
		if (x == last) last = null; //��忡 �ϳ��ۿ� ���ٸ� �ڱ��ڽ� ����
		else { //��尡 �ΰ��̻��� ��
			last.setNext(x.getNext()); //x�� ���ϴ� ���۷��� ���� ->x
			x.setNext(null); //x�� ���ϴ� ���۷��� ���� x->
		}
		size--;
		return x;
	}
	private boolean isempty() { 
		if(last == null) return true;
		else return false;
	}
	public void print() {
    	Node p = last.getNext();
    	if(p == null) System.out.println("�� ������");
    	for(int i = 1; i <= size; i++) {
    		System.out.print(p.getItem() + "\t");
    		p = p.getNext();
    	}
    	System.out.println();
    }
	public int size() {
		return size;
	}
	public void rotateLeft(int n) { //�������� n��ŭ ȸ����Ű�� �޼ҵ�
		for(int i = 1; i <= n; i++) {
		    last = last.getNext();
		}
	}
	public void rotateRight(int n) { //���������� n��ŭ ȸ����Ű�� �޼ҵ�
		for(int i = 1; i <= size - n; i++) {
			last = last.getNext();
		}
	}
}
