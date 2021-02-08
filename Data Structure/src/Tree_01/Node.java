package Tree_01;

public class Node<Key extends Comparable<Key>> { //두개의 키값을 비교하기위해 사용
	private Key item;
	private Node<Key> left;
	private Node<Key> right;
	public Node( Key newItem, Node lt, Node rt ) {
		item = newItem; left = lt; right = rt;
	}
	public Key       getKey()   { return item; }
	public Node<Key> getLeft()  { return left; }
	public Node<Key> getRight() { return right; }
	public void setKey(Key newItem)    { item = newItem; }
	public void setLeft(Node<Key> lt)  { left = lt; }
	public void setRight(Node<Key> rt) { right = rt;}
}
