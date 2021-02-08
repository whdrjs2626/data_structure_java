package Hash_Quad;

public class QuadProbing<K, V> {
	private int N = 0, M = 13; //테이블 크기 M, 항목 수 N
	private K[] a = (K[]) new Object[M];
	private V[] d = (V[]) new Object[M];
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public void put(K key, V data) { //삽입 연산
		int initialpos = hash(key); //초기 위치
		int i = initialpos, j = 1;
		do {
			if (a[i] == null) { //삽입 위치 발견
				a[i] = key; //key를 해시테이블에 저장
				d[i] = data; N++; //데이터 저장
				return;
			}
			if (a[i].equals(key)) { //이미 key 존재
				d[i] = data; //데이터만 갱신
			}
			i = (initialpos + j * j++) % M; //i = 다음위치 선형조사와 다른 부분
		} while (N < M); //한바퀴 돌면 루프 탈출
	}
	
	public V get(K key) { //탐색 연산
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		while (a[i] != null) {
			if(a[i].equals(key)) return d[i]; //탐색 성공
			i = (initialpos + j * j++) % M;
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
