package Tree_01;

import java.util.Arrays;

public class BinaryTreeTest {
	public static void main(String[] args) {
		Node a = new Node(100, null, null);
		Node b = new Node(200, null, null);
		Node c = new Node(300, null, null);
		Node d = new Node(400, null, null);
		Node e = new Node(500, null, null);
		Node f = new Node(600, null, null);
		Node g = new Node(700, null, null);
		Node h = new Node(800, null, null);
		BinaryTree t1 = new BinaryTree();
		t1.setRoot(a);
		a.setLeft(b); a.setRight(c);
		b.setLeft(d); b.setRight(e); c.setLeft(f); c.setRight(g);
		d.setLeft(h);
		
		Node a1 = new Node(100, null, null);
		Node b1 = new Node(200, null, null);
		Node c1 = new Node(300, null, null);
		Node d1 = new Node(400, null, null);
		Node e1 = new Node(500, null, null);
		Node f1 = new Node(600, null, null);
		Node g1 = new Node(700, null, null);
		Node h1 = new Node(800, null, null);
		BinaryTree t2 = new BinaryTree();
		t2.setRoot(a1);
		a1.setLeft(b1); a1.setRight(c1);
		b1.setLeft(d1); b1.setRight(e1); c1.setLeft(f1); c1.setRight(g1);
		d1.setLeft(h1); 
		//[Q 1]
		System.out.println("트리 노드 수 = " + t1.size(t1.getRoot()));
		System.out.println("트리 높이 = " + t1.height(t1.getRoot()));
		System.out.print("전위 순회 : "); t1.preorder(t1.getRoot()); System.out.println();
		System.out.print("중위 순회 : "); t1.inorder(t1.getRoot()); System.out.println();
		System.out.print("후위 순회 : "); t1.postorder(t1.getRoot()); System.out.println();
		System.out.print("레벨 순회 : "); t1.levelorder(t1.getRoot()); System.out.println();
		System.out.println("동일성 검사 : " + t1.isEqual(t1.getRoot(), t2.getRoot()));
		System.out.println();
		//[Q 2]
		System.out.println("이진트리를 배열로 변환 : " + Arrays.toString(t1.btree2intarr())); //[Task 1]
		System.out.println();
		
		int arr[] = {0, 10, 20, 30, 40, 50, 60, 70, 80};
		t1.intarr2btree(arr); //[Task 2]
		System.out.print("배열을 이진트리로 변환 : "); t1.levelorder(t1.getRoot()); System.out.println(); System.out.println();
		
	    Node a3 = new Node(1, null, null);
		Node b3 = new Node(2, null, null);
		Node c3 = new Node(3, null, null);
		Node d3 = new Node(300, null, null);
		Node e3 = new Node(7, null, null);
		Node f3 = new Node(9, null, null);
		Node g3 = new Node(70, null, null);
		Node h3 = new Node(600, null, null);
		Node i2 = new Node(900, null, null);
		BinaryTree t4 = new BinaryTree();
		t4.setRoot(a3);
		a3.setLeft(b3); a3.setRight(c3);
		b3.setLeft(d3); b3.setRight(e3); c3.setLeft(f3); c3.setRight(g3);
		d3.setLeft(h3); 
		//[Q 3]
	    t2.subTreeCompare(t4);
		
	}
}