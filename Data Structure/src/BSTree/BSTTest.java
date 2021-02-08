package BSTree;


public class BSTTest {
	public static void main(String[] args) {
		BST<Integer, Integer> bst1 = new BST(10, 10);
		bst1.put(20, 20); bst1.put(25, 25); bst1.put(30, 30); bst1.put(35, 35); bst1.put(40, 40);
		bst1.put(45, 45); bst1.put(50, 50); bst1.put(60, 60); bst1.put(70, 70);
		bst1.print();
		System.out.println("Searching for 45 yields : " + bst1.get(45));
		bst1.put(45, 99);
		System.out.println("Searching for 45 yields : " + bst1.get(45));
		System.out.println("Min value : " + bst1.min());
		bst1.deleteMin();
		System.out.println("Min value : " + bst1.min());
		bst1.delete(25); bst1.delete(35); bst1.delete(45);
		bst1.print();
		System.out.println();
		
		BST<Integer, Integer> bst2 = new BST(10, 10);
		bst2.put(20, 20); bst2.put(25, 25); bst2.put(30, 30); bst2.put(40, 40);
		bst2.put(45, 45); bst2.put(50, 50); bst2.put(60, 60); bst2.put(70, 70);
		System.out.print("Original : ");
		bst2.print();
		System.out.print("Delete Max 1 : ");
		bst2.deleteMax();
		bst2.print();
		System.out.print("Delete Max 2 : ");
		bst2.deleteMax();
		bst2.print();
		System.out.print("Delete Max 3 : ");
		bst2.deleteMax();
		bst2.print();
		System.out.println();
		
		BST<Integer, Integer> bst3 = new BST(60, 60);
		bst3.put(50, 50); bst3.put(70, 70); bst3.put(20, 20); bst3.put(10, 10); 
		bst3.put(45, 45); bst3.put(25, 25); bst3.put(40, 40); bst3.put(30, 30);
		bst3.print();
		
		for(int i = 0; i < 9; i++) {
			System.out.println(i + "번째 작은 Key값 : " + bst3.kthSmallest(i));
		}
		System.out.println();
		
		BST bst4 = new BST();
		Node a = new Node(50, 50); Node b = new Node(25, 25); Node c = new Node(75, 75);
		Node d = new Node(10, 10); Node e = new Node(30, 30); Node f = new Node(60, 60); Node g = new Node(80, 80);
		a.setLeft(b); a.setRight(c);
		b.setLeft(d); b.setRight(e); c.setLeft(f); c.setRight(g);
		bst4.setRoot(a);
		bst4.print();
		System.out.println("Task 1 : " + bst4.checkBST());
		
		BST bst5 = new BST();
		Node a1 = new Node(50, 50); Node b1 = new Node(25, 25); Node c1 = new Node(75, 75);
		Node d1 = new Node(10, 10); Node e1 = new Node(30, 30); Node f1 = new Node(80, 80); Node g1 = new Node(60, 60);
		a1.setLeft(b1); a1.setRight(c1);
		b1.setLeft(d1); b1.setRight(e1); c1.setLeft(f1); c1.setRight(g1);
		bst5.setRoot(a1);
		bst5.print();
		System.out.println("Task 2 : " + bst5.checkBST());
		
		Node a5 = new Node(100, 100);
		Node b5 = new Node(200, 200);
		Node c5 = new Node(300, 300);
		Node d5 = new Node(400, 400);
		Node e5 = new Node(500, 500);
		Node f5 = new Node(600, 600);
		Node g5 = new Node(700, 700);
		Node h5 = new Node(800, 800);
		BST t5 = new BST();
		
		a5.setLeft(b5); a5.setRight(c5);
		b5.setLeft(d5); b5.setRight(e5); c5.setLeft(f5); c5.setRight(g5);
		d5.setLeft(h5);
		t5.setRoot(a5);
		t5.print();
		BST t6 = new BST();
		t6.copy(t5.getRoot());
		t6.print();
	}
}
