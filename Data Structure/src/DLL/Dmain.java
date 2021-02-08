package DLL;

public class Dmain {
	public static void main(String[] args) {
		DList<String> s = new DList<String>();
		
		s.insertAfter(s.head, "apple");
		s.insertBefore(s.tail, "orange");
		s.insertBefore(s.tail, "cherry");
		s.insertAfter(s.head.getNext(), "pear");
		s.print(); System.out.println();
		
		s.delete(s.tail.getPrevious());
		s.print(); System.out.println();
		
		s.insertBefore(s.tail, "grape");
		s.print(); System.out.println();
		s.delete(s.head.getNext()); s.print(); s.delete(s.head.getNext()); s.print();
		s.delete(s.head.getNext()); s.print(); s.delete(s.head.getNext()); s.print();
	
		DList<Integer> dl1 = new DList<Integer>();
		dl1.insertAfter(dl1.head, 1);

		dl1.insertAfter(dl1.head.getNext(), 2);
		dl1.insertBefore(dl1.tail, 3);
		System.out.println("Q6.Task 1"); dl1.print(); 
		System.out.println();
		
		DList<Integer> dl2 = new DList<Integer>();
		dl2.insertAfter(dl2.head, 6);
		dl2.insertBefore(dl2.tail, 8);
		dl2.insertBefore(dl2.tail, 9);
		dl2.insertAfter(dl2.head.getNext(), 7);
		System.out.println("Q6.Task 2"); dl2.print();
		System.out.println();
		
		int add1 = dl1.add(dl2);
		int add2 = dl2.add(dl1);
		System.out.println("Q6.Task 3"); 
		System.out.println("add1의 값 : " + add1);
		System.out.println("add2의 값 : " + add2);
		System.out.println();
	}
}