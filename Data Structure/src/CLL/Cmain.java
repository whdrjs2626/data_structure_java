package CLL;

public class Cmain {
	public static void main(String[] args) {
		CList <String> s = new CList<String>();
		
		s.insert("pear"); s.insert("cherry");
		s.insert("orange"); s.insert("apple");
		s.print();
		System.out.print(": s의 길이 = " + s.size() + "\n");
		
		s.delete();
		s.print();
		System.out.print(" : s의 길이 = " + s.size()); System.out.println();
		
		CList<Integer> cl1 = new CList<Integer>();
		cl1.insert(4); cl1.insert(3); cl1.insert(2); cl1.insert(1); System.out.println("cl1"); cl1.print();
		cl1.rotateLeft(1); System.out.println("cl1.rotateLeft(1) 결과 "); cl1.print();
		
		System.out.println();
		CList<Integer> cl2 = new CList<Integer>();
		cl2.insert(4); cl2.insert(3); cl2.insert(2); cl2.insert(1); System.out.println("cl2"); cl2.print();
		cl2.rotateRight(1); System.out.println("cl2.rotateRight(1) 결과 "); cl2.print();
	}
}
