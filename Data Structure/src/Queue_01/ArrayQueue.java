package Queue_01;
import java.util.NoSuchElementException;
public class ArrayQueue <E> {
	private E[] q; // 큐를 위한 배열
	private int front, rear, size; //인덱스2개와 사이즈
	public ArrayQueue() { // 생성자
		q = (E[]) new Object[2]; //초기에 크기가 2인 배열생성 = front를맨앞에 항목의 앞에 노드를 향하게 했으므로
		front = rear = size = 0;
	}
	public int size() { return size; }
	public boolean isEmpty() { return (size == 0); }
	
	public void add(E newItem) { //무조건 뒤에들어가므로 인덱스는 받지않음
		if ((rear + 1) % q.length == front) //비어있는 원소가 1개인경우 = 꽉찬경우
			resize(2 * q.length);
		rear = (rear + 1) % q.length; //배열을 원형으로 생각하므로 인덱스가 배열의크기가 넘어가면 0부터 다시시작함
		q[rear] = newItem;
		size++;
	}
	
	public E remove() {
		if (isEmpty()) throw new NoSuchElementException();
		front = (front + 1) % q.length; //front는 빈공간을 가리키므로 1을 더해야지 삭제할 항목을 가르킨 
		E item = q[front];
		q[front] = null;
		size--;
		if (size > 0 && size == q.length / 4)
			resize(q.length / 2);
		return item;
	}
	
	private void resize(int newSize) {
		Object[] t = new Object[newSize];
		for(int i = 1, j = front + 1; i < size + 1; i++, j++) {
			t[i] = q[j % q.length]; //배열 q를 t에 복사, 1부터하는 이유 - 프론트가 0(비어있는곳)을 가르켜야하는 이유
		}
		front = 0;
		rear = size;
		q = (E[]) t;
	}
	
	public void print() {
		if (isEmpty()) throw new NoSuchElementException();
		for (int i = 0; i < q.length; i++) {
			System.out.print(q[i] + "\t");
		}
		System.out.println();
	}
	
}
