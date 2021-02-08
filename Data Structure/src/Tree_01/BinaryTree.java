package Tree_01;
import java.util.*;
public class BinaryTree<Key extends Comparable<Key>> {
	private Node root;
	public BinaryTree() { root = null; }
	public Node getRoot() { return root; }
	public void setRoot(Node newRoot) { root = newRoot; }
	public boolean isEmpty() { return root == null; } //����� ���� �����ϴ� ��Ʈ�� null�̸�  
	
	public void preorder(Node n) { //������ȸ
		if(n != null) {
			System.out.print(n.getKey() + " ");
			preorder(n.getLeft());
			preorder(n.getRight());
		}
	}
	public void inorder(Node n) { //������ȸ
		if(n != null) {
			inorder(n.getLeft());
			System.out.print(n.getKey() + " ");
			inorder(n.getRight());
		}
	}
	public void postorder(Node n) { //��������
		if(n != null) {
			postorder(n.getLeft());
			postorder(n.getRight());
			System.out.print(n.getKey() + " ");
		}
	}
	public void levelorder(Node root) { //������ȸ
		Queue<Node> q = new LinkedList<Node>(); //ť���ϳ� ����
		Node t; 
		q.add(root); //ť�� ��Ʈ��带 �ִ´�
		while(!q.isEmpty()) { //��� �߰��ϸ鼭 �����ϴٰ� ��� ����
			t = q.remove(); //ť�� ���Լ����̹Ƿ� ���� �տ� �ִ� ���� ����(����)
			System.out.print(t.getKey() + " "); //���ŵ� ��� ���
			if(t.getLeft() != null) //���ŵȳ���� ���� �ڽ��� null�� �ƴϸ�
				q.add(t.getLeft()); //ť�� �����ڽ��� �ִ´�
			if(t.getRight() != null) //���ŵȳ���� ������ �ڽ��� ���� �ƴϸ�
				q.add(t.getRight());
		}
	}
	public int size(Node n) {
		if(n == null)
			return 0;
		else
			return (1 + size(n.getLeft()) + size(n.getRight())); //���ڽ� + ���ʳ�� �� + ������ ��� ��
	}
	public int height(Node n) {
		if(n == null)
			return 0;
		else
			return (1 + Math.max(height(n.getLeft()), height(n.getRight()))); //���ʼ���Ʈ������, ������ ����Ʈ�� ���� ���ؼ� ���� ū�ŷ� ����
	}
	public static boolean isEqual(Node n, Node m) {
		if( n == null || m == null) //�� ���ϳ��� ���̸�
			return n == m; //�Ѵ� ���̸� true �ƴϸ� false
		if(n.getKey().compareTo(m.getKey()) != 0) //�Ѵ� null�� �ƴϸ� �� - ���ϴ°��� �湮�̹Ƿ� ������ȸ��.
			return false;
		return(isEqual(n.getLeft(), m.getLeft()) &&
				isEqual(n.getRight(), m.getRight()));
	}
	
	public int[] btree2intarr() { //������ȸ�� �̿�����
		int size = this.size(root); 
		int arr[] = new int[size]; //Ʈ���� ũ�⸸�� �迭 ����
		int i = 0;
		Queue<Node> q = new LinkedList<Node>(); //ť �ڷᱸ�� �̿�
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
			if(i == 1) { //1��° �ε����� ���� ��Ʈ���� �Ѵ�.
				t = new Node(arr[i], null, null);
				root = t;
			}
			else { //������
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