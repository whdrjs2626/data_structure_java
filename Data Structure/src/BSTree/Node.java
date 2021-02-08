package BSTree;

public class Node <Key extends Comparable<Key>, Value> { 
//여기서 key와 value는 제네릭타입이고 key는 비교 연산을 위해 자바의 comparable인터페이스 상속받음
	private Key id;
	private Value name;
	private Node left, right;
	public Node(Key newId, Value newName) {
		id = newId;
		name = newName;
		left = right = null; //일단 왼,오는 null로 초기화하고 나중에 setter사용
	}
	public Key getKey() { return id; }
	public Value getValue() { return name; }
	public Node getLeft() { return left; }
	public Node getRight() { return right; }
	public void setKey(Key newId) { id = newId; }
	public void setValue(Value newName) { name = newName; }
	public void setLeft(Node newLeft) { left = newLeft; }
	public void setRight(Node newRight) { right = newRight; }
}
