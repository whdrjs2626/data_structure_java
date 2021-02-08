package DLL;
import java.util.NoSuchElementException;

import SLL.Node;
public class DList <E> {
	protected DNode head, tail;
	protected int size;
	public DList() { //SLL�� ����� ���۷����� �����ϴµ� DLL�� ��带 ���� �Ҵ���(new DNode) �����ڰ� �ΰ��� ��带 ����
		head = new DNode (null, null, null);
		tail = new DNode (null, head, null); //tail�� �������� head - �ƹ��͵� �����Ƿ�
		head.setNext(tail); //head�� ������� tail
		size = 0;
	}
	public void insertBefore(DNode p, E newItem) { //p��� ��� �տ� ����
		DNode t = p.getPrevious(); //t�� p���̿� ��������
		DNode newNode = new DNode(newItem, t, p); //���ο� ��� �� ������ t�� �տ��Ű� p�̴�
		p.setPrevious(newNode); //p�� ���Ŵ� ���ο���
		t.setNext(newNode); //t�� ������ ���ο� ��� ��������ϸ� ��� ���۷����� �̾���
		size++;
	}
	public void insertAfter(DNode p, E newItem) { //p������ ����
		DNode t = p.getNext(); //t�� p���̿� ��������
		DNode newNode = new DNode(newItem, p, t); //�����Ŷ� �Ȱ�ƴ
		t.setPrevious(newNode);
		p.setNext(newNode);
		size++;
	}
	public void delete(DNode x) { //���x����
		if(x == null) throw new NoSuchElementException();
		if(size <= 0) throw new NoSuchElementException();
		DNode f = x.getPrevious(); //f�� x����
		DNode r = x.getNext(); //r�� x���
		f.setNext(r);
		r.setPrevious(f); //f�� r�� �̾��� - �̰͸����� x�� �����������˽ż�
		size--;
	}
	public void print() {
    	DNode p = head.getNext();
    	if(p == tail) System.out.println("�� ������");
    	while(p != tail) {
    		System.out.print(p.getItem() + "\t");
    		p = p.getNext();
    	}
    	System.out.println();
    }
	public int add(DList adl2) {
		DList p = adl2;
		DNode q = tail.getPrevious();
		DNode p2 = p.tail.getPrevious();
		int a, b, sum = 0;
		int count1 = 1, count2 = 1;
		for(int i = 1; i <= size; i++) { //dl1����Ʈ�� ���ڷ� �����ϴ� �κ��Դϴ�. 1-2-3 �� 123����
			sum += (int)q.getItem()*count1;
			q = q.getPrevious();
			count1 *= 10;
		}
		for(int i = 1; i <= adl2.size; i++) { //dl2����Ʈ�� ���ڷ� �����ϴ� �κ��Դϴ�. 6-7-8-9 �� 6789����
			sum += (int)p2.getItem()*count2;
			p2 = p2.getPrevious();
			count2 *= 10;
		}
		return sum;
	}
}
