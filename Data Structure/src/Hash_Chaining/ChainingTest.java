package Hash_Chaining;

public class ChainingTest {
	public static void main(String[] args) {
		//[Q 6]
		/*Chaining<Integer, String> ch = new Chaining<Integer, String>();
		ch.put(25, "grape"); ch.put(37, "apple"); ch.put(18, "banana"); ch.put(55, "cherry");
		ch.put(22, "mango"); ch.put(35, "lime"); ch.put(50, "orange"); ch.put(63, "watermelon");
		System.out.println("Ž�� ���");
		System.out.println("50�� data : " + ch.get(50));
		System.out.println("63�� data : " + ch.get(63));
		System.out.println("37�� data : " + ch.get(37));
		System.out.println("22�� data : " + ch.get(22));
		System.out.println("ü�̴� �ؽ� ���̺�");
		ch.print();*/
		
		//[Q 7]
		Chaining<Integer, Integer> ch2 = new Chaining<Integer, Integer>();
		for(int i = 0; i < 20; i++) {
			ch2.put(i, i);
		}
		
		ch2.print();
		System.out.println();
		for(int i = 0; i < 20; i++) {
			ch2.delete(i);
		}
		ch2.print();
	}
}
