package Queue_02;
import java.util.NoSuchElementException;

import SLL.Node;
public class ListQueue <E> {
    private Node<E> front, rear;
    private int size;
    public ListQueue() { //생성자
    	front = rear = null;
    	size = 0;
    }
    public int size() { return size; }
    public boolean isEmpty() { return size() == 0; }
    
    public void add(E newItem) {
    	Node newNode = new Node(newItem, null); //새노드 생성
    	if (isEmpty()) front = newNode; //비어있으면 front가 새로운노드를 가리키게함
    	else rear.setNext(newNode); //비어있지 않으면 rear의 다음을 새로운 노드로
    	rear = newNode; //rear가 새노드를 가리키게함
    	size++;
    }
    
    public E remove() {
    	if (isEmpty()) throw new NoSuchElementException(); 
    	E frontItem = front.getItem();
    	front = front.getNext(); //front가 front다음 노드를 가리키게함
    	size--; 
    	if(isEmpty()) rear = null; //비어있다면  rear를 null로
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
