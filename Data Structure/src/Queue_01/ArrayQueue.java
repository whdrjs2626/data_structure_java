package Queue_01;
import java.util.NoSuchElementException;
public class ArrayQueue <E> {
	private E[] q; // ť�� ���� �迭
	private int front, rear, size; //�ε���2���� ������
	public ArrayQueue() { // ������
		q = (E[]) new Object[2]; //�ʱ⿡ ũ�Ⱑ 2�� �迭���� = front���Ǿտ� �׸��� �տ� ��带 ���ϰ� �����Ƿ�
		front = rear = size = 0;
	}
	public int size() { return size; }
	public boolean isEmpty() { return (size == 0); }
	
	public void add(E newItem) { //������ �ڿ����Ƿ� �ε����� ��������
		if ((rear + 1) % q.length == front) //����ִ� ���Ұ� 1���ΰ�� = �������
			resize(2 * q.length);
		rear = (rear + 1) % q.length; //�迭�� �������� �����ϹǷ� �ε����� �迭��ũ�Ⱑ �Ѿ�� 0���� �ٽý�����
		q[rear] = newItem;
		size++;
	}
	
	public E remove() {
		if (isEmpty()) throw new NoSuchElementException();
		front = (front + 1) % q.length; //front�� ������� ����Ű�Ƿ� 1�� ���ؾ��� ������ �׸��� ����Ų 
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
			t[i] = q[j % q.length]; //�迭 q�� t�� ����, 1�����ϴ� ���� - ����Ʈ�� 0(����ִ°�)�� �����Ѿ��ϴ� ����
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
