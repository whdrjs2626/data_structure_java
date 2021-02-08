package Hash_Double;

public class DoubleHashingTest {
	public static void main(String[] args) {
		DoubleHashing<Integer, String> db = new DoubleHashing<Integer, String>();
		db.put(25, "grape"); db.put(37, "apple"); db.put(18, "banana"); db.put(55, "cherry");
		db.put(22, "mango"); db.put(35, "lime"); db.put(50, "orange"); db.put(63, "watermelon");
		System.out.println("탐색 결과");
		System.out.println("50의 data : " + db.get(50));
		System.out.println("63의 data : " + db.get(63));
		System.out.println("이중 해싱 해시 테이블");
		db.print();
	}
}