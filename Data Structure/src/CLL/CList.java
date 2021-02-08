package CLL;
import java.util.NoSuchElementException;

import DLL.DNode;
public class CList <E> {
	private Node last; //리스트의 마지막 노드를 가리킨다.
	private int size;
	public CList() {
		last = null;
		size = 0;
	}
	public void insert(E newItem) { //last가 가리키는노드의 다음(헤드)에 새노드 삽입
		Node newNode = new Node(newItem, null);
		if (last == null) { //리스트가 비었다면
			newNode.setNext(newNode); //자기자신을 향하게함(원형이므로)
			last = newNode; //이걸 last로함
		}
		else { //리스트가 비어있지 않다면
			newNode.setNext(last.getNext()); 
			last.setNext(newNode); //last와 last다음거 사이에 삽입
		}
		size++;
	}
	public Node delete() { //last가 가리키는노드의 다음노드를 제거
		if (isempty()) throw new NoSuchElementException();
		Node x = last.getNext();
		if (x == last) last = null; //노드에 하나밖에 없다면 자기자신 삭제
		else { //노드가 두개이상일 때
			last.setNext(x.getNext()); //x를 향하는 레퍼런스 없앰 ->x
			x.setNext(null); //x가 향하는 레퍼런스 없앰 x->
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
    	if(p == null) System.out.println("빈 상태임");
    	for(int i = 1; i <= size; i++) {
    		System.out.print(p.getItem() + "\t");
    		p = p.getNext();
    	}
    	System.out.println();
    }
	public int size() {
		return size;
	}
	public void rotateLeft(int n) { //왼쪽으로 n만큼 회전시키는 메소드
		for(int i = 1; i <= n; i++) {
		    last = last.getNext();
		}
	}
	public void rotateRight(int n) { //오른쪽으로 n만큼 회전시키는 메소드
		for(int i = 1; i <= size - n; i++) {
			last = last.getNext();
		}
	}
}
