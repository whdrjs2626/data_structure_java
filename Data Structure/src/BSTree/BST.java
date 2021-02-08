package BSTree;

public class BST<Key extends Comparable<Key>, Value> {
	public Node root;
	public Node getRoot() { return root; }
	public void setRoot(Node newRoot) { root = newRoot; }
	public BST() {
		Node root;
	}
	public BST(Key newId, Value newName) {
		root = new Node(newId, newName);
	}
	
	public Value get(Key k) { return get(root, k); } //Ű �� �ҷ�����, �����ε� ���
	public Value get(Node n, Key k) {
		if (n == null)  return null; //���ĸ�����̹Ƿ� �� ����
		int t = n.getKey().compareTo(k); //t�� 0�̸� ���� ������ 0���� ũ�� n�� ��ũ�ܶ� 0���� ������ k�� �� ũ�� ��
		if (t > 0)      return get(n.getLeft(), k);
		else if (t < 0) return get(n.getRight(), k);
		else            return (Value) n.getValue();
	}
	
	public void put(Key k, Value v) { root = put(root, k, v); } //����
	public Node put(Node n, Key k, Value v) {
		if (n == null)  return new Node(k, v); //get�� �ٸ��� null�̸� ���ڸ��� ����
		int t = n.getKey().compareTo(k);
		if (t > 0)      n.setLeft(put(n.getLeft(), k, v));
		else if (t < 0) n.setRight(put(n.getRight(), k, v));
		else            n.setValue(v); //�̹� �����ϴ� ��� ������� ����
		return n;
	}
	
	public Key min() { //�ּڰ� ����
		if (root == null) return null;
		return (Key) min(root).getKey();
	}
	private Node min(Node n) {
		if (n.getLeft() == null) return n; //�������� �߳������� ��������尡 �ּڰ�
		return min(n.getLeft());
	}
	
	public void deleteMin() { //�ּڰ� ����
		if (root == null) System.out.println("����ִ� Ʈ��");
		else root = deleteMin(root);
	}
	private Node deleteMin(Node n) {
		if (n.getLeft() == null) return n.getRight();
		n.setLeft(deleteMin(n.getLeft()));
		return n;
	}
	
	public void delete(Key k) { root = delete(root, k); } //����
	public Node delete(Node n, Key k) {
		if (n == null) return null; //�����Ϸ��� ��尡 ���ٸ�?
		int t = n.getKey().compareTo(k); //��, 0�̾ƴϸ� ���� ��ã�Ҵ�
		if (t > 0)      n.setLeft(delete(n.getLeft(), k)); 
		else if (t < 0) n.setRight(delete(n.getRight(), k));
		else { //0�̹Ƿ� ������ ��� �߰�, �������� ����
			if (n.getRight() == null) return n.getLeft(); //������ ����� �ڽ��� ���ų� �ϳ�
			if (n.getLeft()  == null) return n.getRight(); //�ڽ��� �ϳ�
			Node target = n; //�ڽ��� �ΰ�
			n = min(target.getRight()); //������ ����ڸ��� �Űܿ� (���target�� �����ļ���(target�� �������� �� ������))�� min���� �˻�
			n.setRight(deleteMin(target.getRight())); //����� �����ļ��ڸ� ���� ����Ʈ���� n�� �����ʿ� ���δ�.
			n.setLeft(target.getLeft()); //Ÿ���� ���ʼ���Ʈ���� n�� ���ʿ� ���δ�.
		}
		return n; //�̷��� ������� Ʈ���� �����ϸ� ������ n�� ��Ʈ���� ������
	}
	
	public void print() { //���
		print(root);
		System.out.println();
	}
	public void print(Node n) {
		if(n != null) {
			print(n.getLeft());
			System.out.print(n.getKey() + " ");
			print(n.getRight());
		}
	}
	
	public void deleteMax() { //�ִ� ����
		if (root == null) System.out.println("����ִ� Ʈ��");
		else root = deleteMax(root);
	}
	private Node deleteMax(Node n) {
		if (n.getRight() == null) return n.getLeft();
		n.setRight(deleteMax(n.getRight()));
		return n;
	}
	
	
	public Key kthSmallest(int k) { return kthSmallest(root, k); } //k��°�� ���� ���� ����
	public Key kthSmallest(Node n, int k) {
		int a;
		if (n != null) a = size(n.getLeft());
		else a = 0;
		if (a == k) {
			return (Key) n.getKey();
		}
		if (a > k) {
			return kthSmallest(n.getLeft(), k);
		}
		return kthSmallest(n.getRight(), k - a -1);
	}
	
	public int size(Node n) { //Ʈ���� ũ��
		if(n == null)
			return 0;
		else
			return (1 + size(n.getLeft()) + size(n.getRight()));
	}
	
	public boolean checkBST() { return checkBST(root, null); } //����Ž��Ʈ������ Ȯ��
    public boolean checkBST(Node root, Node prev) { //������ȸ�ϸ鼭 ����, ���簪�� �������� ����
        if (root == null)
            return true;
        if (!checkBST(root.getLeft(), prev))
            return false;
        if (prev != null && (int)root.getKey() < (int)prev.getKey())
            return false;
        prev = root;
        if (!checkBST(root.getRight(), prev))
            return false;
        return true;
    }
    
    /*Node copy(Node originalNode) {
    	Node copyNode = originalNode;
    	root = copyNode;
    	if(originalNode != null) {
			copyNode.setLeft(copy(originalNode.getLeft()));
			copyNode.setRight(copy(originalNode.getRight()));
			
		}
    	return copyNode;
    }*/
    
    Node copy(Node originalNode) {
        Node copyNode = originalNode;
        if(originalNode == null) {
            return null;
        }
        else {
            copy(originalNode.getLeft());
            copy(originalNode.getRight());
            copyNode.setKey(originalNode.getKey());
            copyNode.setValue(originalNode.getValue());
            root = copyNode;
            return copyNode;
        }
    }
    
 
}
