package Hash_Random;

public class RandProbingTest {
	public static void main(String[] args) {
		RandProbing<Integer, String> ra = new RandProbing<Integer, String>();
		ra.put(25, "grape"); ra.put(37, "apple"); ra.put(18, "banana"); ra.put(55, "cherry");
		ra.put(22, "mango"); ra.put(35, "lime"); ra.put(50, "orange"); ra.put(63, "watermelon");
		System.out.println("Ž�� ���");
		System.out.println("50�� data : " + ra.get(50));
		System.out.println("63�� data : " + ra.get(63));
		System.out.println("���� ���� ��� �ؽ� ���̺�");
		ra.print();
	}
}
