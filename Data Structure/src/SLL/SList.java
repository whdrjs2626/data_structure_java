package SLL;
import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;
public class SList <E> {
	protected Node head; //ù���
	private int size; //ũ��
	public SList() { //������
		head = null; //ù��带 ����� �η� ���� SLL���ο� ���۷����ۿ� ����.�����͸� �ȿ� ������������
		size = 0; //�ϳ��� �����Ƿ� ������ 0��
	}
    public int search(E target) {
	    Node p = head;
	    for (int k = 0; k < size; k ++) { //�����Ž��
		    if (target == p.getItem()) return k; //Ž���߿� target�� �ִ°�?
		    p = p.getNext(); // ��������
	    }
	    return -1; //������-1����
    }
    public void insertFront(E newItem) {
    	head = new Node(newItem, head); //���ο� �׸��� ����� ��带 ���ϰ� �ϰ� �̰��� ���� �ٲ�
    	size++; //������ ����
    }
    public void insertAfter(E newItem, Node p) { //p������ newItem�ֱ�
    	p.setNext(new Node(newItem, p.getNext())); //p�� �����Ÿ� ���ϴ� newItem�� p�� �������� ������
    	size++; //������ ����
    }
    public void deleteFront() { //ù��� ����
    	if(size == 0) throw new NoSuchElementException();
    	head = head.getNext(); //��带 ����� �����ɷ� �ٲ�
    	size--;
    }
    public void deleteAfter(Node p) { //p������ ����
    	if(p == null) throw new NoSuchElementException();
    	Node t = p.getNext(); 
    	p.setNext(t.getNext()); //�����Ұ� �����Ÿ� p�� �����ŷ� ���� - �̰� ������ ��带 ���ϴ� ���۷������ִ°�
    	t.setNext(null); //�̰� ������ ��尡 ���ϴ� ���۷��� ���ִ°� �Ѵپ����� �������÷��ͷ� ����
    	size--;
    }
    public void print() {
    	Node p = head;
    	while(p != null) {
    		System.out.print(p.getItem() + "\t");
    		p = p.getNext();
    	}
    }
    public int size() {
    	return size;
    }
    public void setAndOrderNodes(int[] arr) {
    	if(arr != null) {
    		Arrays.sort(arr);
    		size = arr.length;
    		head = new Node(arr[0], head);
    		Node p = head; 
    		for(int i = 1; i < size; i++) {
    			p.setNext(new Node(arr[i], p.getNext()));
    			p = p.getNext();
    		}
    	}
    	else return;
    }
    public void join(SList<Integer> slist2) {
    	Node q = slist2.head;
    	Node p = head;
    	head = null;
    	while(p != null) { //�� �޼ҵ��� ��� head������ ��� �� ��带 �����ϹǷ� ������ ������ �־�� ��. -> ���� �޼ҵ忡�� reverse�޼ҵ� ȣ��
    	    if((int)p.getItem() > (int)q.getItem()) { //p�� ū ���
    		    head = new Node(q.getItem(), head); //p���� q�� �����Ƿ� �� ���� �����Ѵ�.
    		    if(p.getNext() == null) head = new Node(p.getItem(), head); // ���� p������ null�̸� ���� ������ �� �����Ƿ� ��� ���� 
    		    q = q.getNext(); //��忡 �� ���ڴ� �� ���� �ʿ� �����Ƿ� �������ڷ� �Ѿ��.
    	    }
    	    else if ((int)p.getItem() == (int)q.getItem()) { // ���� ũ�Ⱑ ���� ���
    	    	head = new Node(q.getItem(), head); // ���� �ƹ��ų� ��� ����
    	    	p = p.getNext(); //�� �� ���� �����̹Ƿ� �������ڷ� �Ѿ��.
    	    	q = q.getNext(); //�� �� ���� �����̹Ƿ� �������ڷ� �Ѿ��.
    	    }
    	    else { //q�� ū ���
    	    	head = new Node(p.getItem(), head); //q���� p�� �����Ƿ� �� ���� �����Ѵ�.
    	    	if(q.getNext() == null) head = new Node(q.getItem(), head); //���� q������ null�̸� ���� ������ �� �����Ƿ� ��� ���� 
    	    	p = p.getNext();
    	    }
    	}
    }
    public void reverse() { 
    	Node p, q, r;
    	p = head;
    	q = null;
    	while(p != null) {
    		r = q;
    		q = p;
    		p = p.getNext();
    		q.setNext(r);
    	}
    	head = q;
    }    
}
