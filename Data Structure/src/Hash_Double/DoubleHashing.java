package Hash_Double;

public class DoubleHashing<K, V> {
	private int N = 0, M = 13; //테이블 크기 M, 항목 수 N
	private K[] a = (K[]) new Object[M];
	private V[] dt = (V[]) new Object[M];
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public void put(K key, V data) { //삽입 연산
		int initialpos = hash(key); //초기 위치
		int i = initialpos, j = 1;
		int d = (7-(int)key % 7); //두번째 해시 함수
		do {
			if (a[i] == null) { //삽입 위치 발견
				a[i] = key; //key를 해시테이블에 저장
				dt[i] = data; N++; //데이터 저장
				return;
			}
			if (a[i].equals(key)) { //이미 key 존재
				dt[i] = data; //데이터만 갱신
				return;
			}
			i = (initialpos + j * d) % M; //i = 다음위치
			j++;
		} while (N < M); //한바퀴 돌면 루프 탈출
	}
	
	public V get(K key) { //탐색 연산
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		int d = (7-(int)key % 7);
		while (a[i] != null) {
			if(a[i].equals(key)) return dt[i]; //탐색 성공
			i = (initialpos + j * d) % M;
			j++;
		} 
		return null; //탐색 실패
	}
	
	public void print() {
		int i;
		for (i = 0; i < M; i++) {
			System.out.print(i + "     ");
		}
		System.out.println();
		for (i = 0; i < M; i++) {
			if(a[i] == null) {
				System.out.print(a[i] + "  ");
			}
			else {
			System.out.print(a[i] + "    ");
			}
		}
		System.out.println();
	}
}
