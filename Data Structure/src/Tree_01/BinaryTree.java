package Tree_01;
import java.util.*;
public class BinaryTree<Key extends Comparable<Key>> {
	private Node root;
	public BinaryTree() { root = null; }
	public Node getRoot() { return root; }
	public void setRoot(Node newRoot) { root = newRoot; }
	public boolean isEmpty() { return root == null; } //사이즈가 없고 삭제하다 루트가 null이면  
	
	public void preorder(Node n) { //전위순회
		if(n != null) {
			System.out.print(n.getKey() + " ");
			preorder(n.getLeft());
			preorder(n.getRight());
		}
	}
	public void inorder(Node n) { //중위순회
		if(n != null) {
			inorder(n.getLeft());
			System.out.print(n.getKey() + " ");
			inorder(n.getRight());
		}
	}
	public void postorder(Node n) { //후위순휘
		if(n != null) {
			postorder(n.getLeft());
			postorder(n.getRight());
			System.out.print(n.getKey() + " ");
		}
	}
	public void levelorder(Node root) { //레벨순회
		Queue<Node> q = new LinkedList<Node>(); //큐를하나 만듦
		Node t; 
		q.add(root); //큐에 루트노드를 넣는다
		while(!q.isEmpty()) { //계속 추가하면서 삭제하다가 비면 끝남
			t = q.remove(); //큐는 선입선출이므로 가장 앞에 있는 것이 나옴(제거)
			System.out.print(t.getKey() + " "); //제거된 노드 출력
			if(t.getLeft() != null) //제거된노드의 왼쪽 자식이 null이 아니면
				q.add(t.getLeft()); //큐에 왼쪽자식을 넣는다
			if(t.getRight() != null) //제거된노드의 오른쪽 자식이 널이 아니면
				q.add(t.getRight());
		}
	}
	public int size(Node n) {
		if(n == null)
			return 0;
		else
			return (1 + size(n.getLeft()) + size(n.getRight())); //나자신 + 왼쪽노드 수 + 오른쪽 노드 수
	}
	public int height(Node n) {
		if(n == null)
			return 0;
		else
			return (1 + Math.max(height(n.getLeft()), height(n.getRight()))); //왼쪽서브트리높이, 오른쪽 서브트리 높이 비교해서 둘중 큰거로 더함
	}
	public static boolean isEqual(Node n, Node m) {
		if( n == null || m == null) //둘 중하나가 널이면
			return n == m; //둘다 널이면 true 아니면 false
		if(n.getKey().compareTo(m.getKey()) != 0) //둘다 null이 아니면 비교 - 비교하는것은 방문이므로 전위순회다.
			return false;
		return(isEqual(n.getLeft(), m.getLeft()) &&
				isEqual(n.getRight(), m.getRight()));
	}
	
	public int[] btree2intarr() { //레벨순회를 이용했음
		int size = this.size(root); 
		int arr[] = new int[size]; //트리의 크기만한 배열 생성
		int i = 0;
		Queue<Node> q = new LinkedList<Node>(); //큐 자료구조 이용
		Node t;
		q.add(root);
		while(!q.isEmpty()) {
			t = q.remove();
			arr[i] = (int) t.getKey();
			if(t.getLeft() != null)
				q.add(t.getLeft());
			if(t.getRight() != null)
				q.add(t.getRight());
			i++;
		}
		return arr;
	}
	
	public void intarr2btree(int[] arr) {
		Node t = root;
		for(int i = 1; i < arr.length; i++) {
			if(i == 1) { //1번째 인덱스의 값을 루트노드로 한다.
				t = new Node(arr[i], null, null);
				root = t;
			}
			else { //나머지
			    if(2*i <= arr.length+1) {
			    	if(2*i+1 <= arr.length+1) {
					    Node t1 = new Node(arr[2*i-2], null, null);
				    	t.setLeft(t1);
					    Node t2 = new Node(arr[2*i-1], null, null);
					    t.setRight(t2);
					    t = t1;
					    
				    }
				    else {
				    	Node t1 = new Node(arr[2*i-2], null, null);
					    t.setLeft(t1);
					    t = t1;
				    }
			    }
			    else {
				    if(2*i + 1 <= arr.length+1) {
				        Node t1 = new Node(arr[2*i-1], null, null);
				        t.setRight(t1);
				        t = t1;
				    }
			    }
			}
		}
	}

	
	public LinkedList<Node> subTreeCompare(BinaryTree t) {
		LinkedList<Node> sl = new LinkedList<Node>();
		Queue<Node> q = new LinkedList<Node>();
		Node t1;
		q.add(root);
		int i = 1;
		while(!q.isEmpty()) {
			t1 = q.remove();
			Queue<Node> q2 = new LinkedList<Node>();
			Node t2;
			q2.add(t.root);
			while(!q2.isEmpty()) {
				t2 = q2.remove();
				if(t1.getKey().compareTo(t2.getKey()) == 0) {
					sl.add(t1);
					System.out.print("Found a matching subtree " + i + " : ");
					root = t1;
					this.levelorder(root);
					i++;
					System.out.println();
				}
				if(t2.getLeft() != null)
					q2.add(t2.getLeft());
				if(t2.getRight() != null)
					q2.add(t2.getRight());
			}
			if(t1.getLeft() != null)
				q.add(t1.getLeft());
			if(t1.getRight() != null)
				q.add(t1.getRight());
		}
		return sl;
	}
}