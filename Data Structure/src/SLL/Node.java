package SLL;

public class Node <E> {
	private E item; //멤버변수
	private Node<E> next;
	public Node(E newItem, Node<E> node) { //생성자
		item = newItem;
		next = node;
	}
	
	public E getItem() { return item; } //항목을 리턴해주는 메소드
	public Node<E> getNext() { return next; } //다음노드는 어딘가
	public void setItem(E newItem) { item = newItem; } // 항목을 세팅
	public void setNext(Node<E> newNext) { next = newNext;} // 다음노드 세팅
}
