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
	
	public Value get(Key k) { return get(root, k); } //키 값 불러오기, 오버로딩 사용
	public Value get(Node n, Key k) {
		if (n == null)  return null; //이파리노드이므로 널 리턴
		int t = n.getKey().compareTo(k); //t가 0이면 둘이 같은거 0보다 크면 n이 더크단뜻 0보다 작으면 k가 더 크단 뜻
		if (t > 0)      return get(n.getLeft(), k);
		else if (t < 0) return get(n.getRight(), k);
		else            return (Value) n.getValue();
	}
	
	public void put(Key k, Value v) { root = put(root, k, v); } //삽입
	public Node put(Node n, Key k, Value v) {
		if (n == null)  return new Node(k, v); //get과 다른점 null이면 그자리에 삽입
		int t = n.getKey().compareTo(k);
		if (t > 0)      n.setLeft(put(n.getLeft(), k, v));
		else if (t < 0) n.setRight(put(n.getRight(), k, v));
		else            n.setValue(v); //이미 존재하는 경우 밸류값만 갱신
		return n;
	}
	
	public Key min() { //최솟값 리턴
		if (root == null) return null;
		return (Key) min(root).getKey();
	}
	private Node min(Node n) {
		if (n.getLeft() == null) return n; //왼쪽으로 쭉내려가서 마지막노드가 최솟값
		return min(n.getLeft());
	}
	
	public void deleteMin() { //최솟값 삭제
		if (root == null) System.out.println("비어있는 트리");
		else root = deleteMin(root);
	}
	private Node deleteMin(Node n) {
		if (n.getLeft() == null) return n.getRight();
		n.setLeft(deleteMin(n.getLeft()));
		return n;
	}
	
	public void delete(Key k) { root = delete(root, k); } //삭제
	public Node delete(Node n, Key k) {
		if (n == null) return null; //삭제하려는 노드가 없다면?
		int t = n.getKey().compareTo(k); //비교, 0이아니면 아직 못찾았다
		if (t > 0)      n.setLeft(delete(n.getLeft(), k)); 
		else if (t < 0) n.setRight(delete(n.getRight(), k));
		else { //0이므로 삭제할 노드 발견, 삭제연산 수행
			if (n.getRight() == null) return n.getLeft(); //삭제할 노드의 자식이 없거나 하나
			if (n.getLeft()  == null) return n.getRight(); //자식이 하나
			Node target = n; //자식이 두개
			n = min(target.getRight()); //삭제될 노드자리로 옮겨올 (노드target의 중위후속자(target의 우측에서 젤 작은값))를 min으로 검색
			n.setRight(deleteMin(target.getRight())); //노드의 중위후속자를 없앤 서브트리를 n의 오른쪽에 붙인다.
			n.setLeft(target.getLeft()); //타겟의 왼쪽서브트리를 n의 왼쪽에 붙인다.
		}
		return n; //이렇게 만들어진 트리를 리턴하면 위에서 n을 루트노드로 설정함
	}
	
	public void print() { //출력
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
	
	public void deleteMax() { //최댓값 삭제
		if (root == null) System.out.println("비어있는 트리");
		else root = deleteMax(root);
	}
	private Node deleteMax(Node n) {
		if (n.getRight() == null) return n.getLeft();
		n.setRight(deleteMax(n.getRight()));
		return n;
	}
	
	
	public Key kthSmallest(int k) { return kthSmallest(root, k); } //k번째로 작은 숫자 리턴
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
	
	public int size(Node n) { //트리의 크기
		if(n == null)
			return 0;
		else
			return (1 + size(n.getLeft()) + size(n.getRight()));
	}
	
	public boolean checkBST() { return checkBST(root, null); } //이진탐색트리인지 확인
    public boolean checkBST(Node root, Node prev) { //중위순회하면서 비교함, 현재값과 다음값을 비교함
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
