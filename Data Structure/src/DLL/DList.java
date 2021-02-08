package DLL;
import java.util.NoSuchElementException;

import SLL.Node;
public class DList <E> {
	protected DNode head, tail;
	protected int size;
	public DList() { //SLL은 헤드의 레퍼런스만 선언하는데 DLL은 노드를 직접 할당함(new DNode) 생성자가 두개의 노드를 가짐
		head = new DNode (null, null, null);
		tail = new DNode (null, head, null); //tail의 이전노드는 head - 아무것도 없으므로
		head.setNext(tail); //head의 다음노드 tail
		size = 0;
	}
	public void insertBefore(DNode p, E newItem) { //p라는 노드 앞에 삽입
		DNode t = p.getPrevious(); //t와 p사이에 넣을거임
		DNode newNode = new DNode(newItem, t, p); //새로운 노드 는 직전이 t고 앞에거가 p이다
		p.setPrevious(newNode); //p의 전거는 새로운노드
		t.setNext(newNode); //t의 다음도 새로운 노드 여기까지하면 모든 레퍼런스가 이어짐
		size++;
	}
	public void insertAfter(DNode p, E newItem) { //p다음에 삽입
		DNode t = p.getNext(); //t와 p사이에 넣을거임
		DNode newNode = new DNode(newItem, p, t); //위에거랑 똑가틈
		t.setPrevious(newNode);
		p.setNext(newNode);
		size++;
	}
	public void delete(DNode x) { //노드x삭제
		if(x == null) throw new NoSuchElementException();
		if(size <= 0) throw new NoSuchElementException();
		DNode f = x.getPrevious(); //f는 x전거
		DNode r = x.getNext(); //r은 x담거
		f.setNext(r);
		r.setPrevious(f); //f와 r을 이어줌 - 이것만으로 x는 낙동강오리알신세
		size--;
	}
	public void print() {
    	DNode p = head.getNext();
    	if(p == tail) System.out.println("빈 상태임");
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
		for(int i = 1; i <= size; i++) { //dl1리스트를 숫자로 변경하는 부분입니다. 1-2-3 을 123으로
			sum += (int)q.getItem()*count1;
			q = q.getPrevious();
			count1 *= 10;
		}
		for(int i = 1; i <= adl2.size; i++) { //dl2리스트를 숫자로 변경하는 부분입니다. 6-7-8-9 을 6789으로
			sum += (int)p2.getItem()*count2;
			p2 = p2.getPrevious();
			count2 *= 10;
		}
		return sum;
	}
}
