package SLL;
import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;
public class SList <E> {
	protected Node head; //첫노드
	private int size; //크기
	public SList() { //생성자
		head = null; //첫노드를 만들고 널로 설정 SLL내부에 레퍼런스밖에 없다.데이터를 안에 저장하지않음
		size = 0; //하나도 없으므로 사이즈 0임
	}
    public int search(E target) {
	    Node p = head;
	    for (int k = 0; k < size; k ++) { //모든노드탐색
		    if (target == p.getItem()) return k; //탐색중에 target이 있는가?
		    p = p.getNext(); // 다음노드로
	    }
	    return -1; //없으면-1리턴
    }
    public void insertFront(E newItem) {
    	head = new Node(newItem, head); //새로운 항목을 만들되 헤드를 향하게 하고 이것을 헤드로 바꿈
    	size++; //사이즈 증가
    }
    public void insertAfter(E newItem, Node p) { //p다음에 newItem넣기
    	p.setNext(new Node(newItem, p.getNext())); //p의 다음거를 향하는 newItem을 p의 다음으로 설정함
    	size++; //사이즈 증가
    }
    public void deleteFront() { //첫노드 삭제
    	if(size == 0) throw new NoSuchElementException();
    	head = head.getNext(); //헤드를 헤드의 다음걸로 바꿈
    	size--;
    }
    public void deleteAfter(Node p) { //p다음거 삭제
    	if(p == null) throw new NoSuchElementException();
    	Node t = p.getNext(); 
    	p.setNext(t.getNext()); //삭제할거 다음거를 p의 다음거로 설정 - 이건 삭제할 노드를 향하는 레퍼런스없애는거
    	t.setNext(null); //이건 삭제할 노드가 향하는 레퍼런스 없애는거 둘다없에면 가비지컬렉터로 없앰
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
    	while(p != null) { //이 메소드의 경우 head앞으로 계속 새 노드를 생성하므로 순서를 뒤집어 주어야 함. -> 메인 메소드에서 reverse메소드 호출
    	    if((int)p.getItem() > (int)q.getItem()) { //p가 큰 경우
    		    head = new Node(q.getItem(), head); //p보다 q가 작으므로 새 노드로 생성한다.
    		    if(p.getNext() == null) head = new Node(p.getItem(), head); // 만약 p다음이 null이면 노드로 삽입할 수 없으므로 노드 생성 
    		    q = q.getNext(); //노드에 들어간 숫자는 또 비교할 필요 없으므로 다음숫자로 넘어간다.
    	    }
    	    else if ((int)p.getItem() == (int)q.getItem()) { // 둘이 크기가 같은 경우
    	    	head = new Node(q.getItem(), head); // 둘중 아무거나 노드 생성
    	    	p = p.getNext(); //둘 다 같은 숫자이므로 다음숫자로 넘어간다.
    	    	q = q.getNext(); //둘 다 같은 숫자이므로 다음숫자로 넘어간다.
    	    }
    	    else { //q가 큰 경우
    	    	head = new Node(p.getItem(), head); //q보다 p가 작으므로 새 노드로 생성한다.
    	    	if(q.getNext() == null) head = new Node(q.getItem(), head); //만약 q다음이 null이면 노드로 삽입할 수 없으므로 노드 생성 
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
