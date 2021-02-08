package SLL;

public class main {
	public static void main(String[] args) {
		
		SList<String> s = new SList<String>();
		s.insertFront("orange"); s.insertFront("apple");
		s.insertAfter("cherry", s.head.getNext());
		s.insertFront("pear");
		
		s.print();
		System.out.println(": s의 길이 = " + s.size() + "\n");
		System.out.println("체리가 \t" + s.search("cherry") + "번째에 있다.");
		System.out.println("키위가 \t" + s.search("kiwi") + "번째에 있다.");
		s.deleteAfter(s.head);
		s.print();
		System.out.println(": s의 길이 = " + s.size()); System.out.println();
		s.deleteFront();
		s.print();
		System.out.println(": s의 길이 = " + s.size()); System.out.println();
		
		SList<Integer> t = new SList<Integer>();
		t.insertFront(500); t.insertFront(200);
		t.insertAfter(400, t.head);
		t.insertFront(100);
		t.insertAfter(300, t.head.getNext());
		t.print();
		System.out.println(": t의 길이 = " + t.size());
		
		SList<Integer> slist1 = new SList<Integer>();
		int[] arr1 = {7,11,4,1,8};
		System.out.println("Q4.Task 1");
		slist1.setAndOrderNodes(arr1);
		slist1.print();
		System.out.println();
		
		SList<Integer> slist2 = new SList<Integer>();
		int[] arr2 = {5,2,8,7,13};
		System.out.println("Q4.Task 2");
		slist2.setAndOrderNodes(arr2);
		slist2.print();
		System.out.println();
		
		slist1.join(slist2);
		slist1.reverse();
		System.out.println("Q4.Task 3");
		slist1.print();
		System.out.println();
		System.out.println();
		
		
		SList<Integer> sl = new SList<Integer>(); 
		sl.insertFront(5); sl.insertFront(4); sl.insertFront(3); sl.insertFront(2); sl.insertFront(1);
		System.out.println("Q5.Task 1"); sl.print();
		System.out.println();
		
		sl.reverse(); 
		System.out.println("Q5.Task 2"); sl.print();
	}
}
