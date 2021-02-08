package Hash_Linear;

public class LinearProbingTest {
	public static void main(String[] args) {
		//[Q 1]
		System.out.println("[Q 1]");
		LinearProbing<Integer, String> li1 = new LinearProbing<Integer, String>();
		li1.put(25, "grape"); li1.put(37, "apple"); li1.put(18, "banana"); li1.put(55, "cherry");
		li1.put(22, "mango"); li1.put(35, "lime"); li1.put(50, "orange"); li1.put(63, "watermelon");
		System.out.println("탐색 결과");
		System.out.println("50의 data : " + li1.get(50));
		System.out.println("63의 data : " + li1.get(63));
		System.out.println("해시 테이블");
		li1.print();
		
		//[Q 2]
		System.out.println("[Q 2]");
		LinearProbing2<Integer, Integer> li2 = new LinearProbing2<Integer, Integer>();
		li2.put(25, 25); li2.put(37, 37); li2.put(18, 18); li2.put(55, 55);
		li2.put(22, 22); li2.put(35, 35); li2.put(50, 50); li2.put(63, 63);
		li2.print();
		System.out.println("63의 data : " + li2.get(63));
		System.out.println();
		System.out.println("50 삭제 연산 : " + li2.delete(50));
		li2.print();
		System.out.println("63의 data : " + li2.get(63));
	}
}
