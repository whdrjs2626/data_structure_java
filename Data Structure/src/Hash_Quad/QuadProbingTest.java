package Hash_Quad;

public class QuadProbingTest {
	public static void main(String[] args) {
		QuadProbing<Integer, String> qu = new QuadProbing<Integer, String>();
		qu.put(25, "grape"); qu.put(37, "apple"); qu.put(18, "banana"); qu.put(55, "cherry");
		qu.put(22, "mango"); qu.put(35, "lime"); qu.put(50, "orange"); qu.put(63, "watermelon");
		System.out.println("Ž�� ���");
		System.out.println("50�� data : " + qu.get(50));
		System.out.println("63�� data : " + qu.get(63));
		System.out.println("���� ���� ��� �ؽ� ���̺�");
		qu.print();
	}
}
