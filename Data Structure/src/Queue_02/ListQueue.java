package Queue_02;
import java.util.NoSuchElementException;

import SLL.Node;
public class ListQueue <E> {
    private Node<E> front, rear;
    private int size;
    public ListQueue() { //������
    	front = rear = null;
    	size = 0;
    }
    public int size() { return size; }
    public boolean isEmpty() { return size() == 0; }
    
    public void add(E newItem) {
    	Node newNode = new Node(newItem, null); //����� ����
    	if (isEmpty()) front = newNode; //��������� front�� ���ο��带 ����Ű����
    	else rear.setNext(newNode); //������� ������ rear�� ������ ���ο� ����
    	rear = newNode; //rear�� ����带 ����Ű����
    	size++;
    }
    
    public E remove() {
    	if (isEmpty()) throw new NoSuchElementException(); 
    	E frontItem = front.getItem();
    	front = front.getNext(); //front�� front���� ��带 ����Ű����
    	size--; 
    	if(isEmpty()) rear = null; //����ִٸ�  rear�� null��
    	return frontItem;
    }
    
    public void print() {
    	if (isEmpty()) throw new NoSuchElementException();
    	Node<E> q = front;
    	for(int i = 0; i < size; i++) {
    		System.out.print(q.getItem() + "\t");
    		q = q.getNext();
    	}
    	System.out.println();
    }
    
    public double avg() {
    	double sum = 0;
    	E q;
		for(int i = 0; i < size; i++) {
			q = this.remove();
			sum += (double)q;
			this.add(q);
		}
		return sum/size;
	}
    
    public void reverse() {
    	Node p, current, next;
    	p = front;
    	current = null;
    	while(p != null) {
    		next = current;
    		current = p;
    		p = p.getNext();
    		current.setNext(next);
    	}
    	front = current;
    } 
}
