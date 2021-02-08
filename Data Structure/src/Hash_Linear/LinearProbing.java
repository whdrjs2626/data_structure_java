package Hash_Linear;

public class LinearProbing<K, V> { //제네릭타입 선언
	private int M = 13; //테이블 크기
	private K[] a = (K[]) new Object[M]; //해시테이블
	private V[] d = (V[]) new Object[M]; //key관련 데이터 저장
	private int hash(K key) { //해시코드
		return (key.hashCode() & 0x7fffffff) % M; //나눗셈함수 해시함수
	}
	
	public void put(K key, V data) { //삽입 연산
		int initialpos = hash(key); //초기 위치
		int i = initialpos, j = 1; //충돌이 나기전까진 j를 쓰지않다가 충돌이 일어나면 i에 j를 더함
		do {
			if (a[i] == null) { //삽입 위치 발견
				a[i] = key; //key를 해시테이블에 저장
				d[i] = data; //데이터 저장
				return;
			}
			if (a[i].equals(key)) { //이미 key 존재
				d[i] = data; //데이터만 갱신
				return;
			}
			i = (initialpos + j++) % M; //i = 다음위치
		} while (i != initialpos); //한바퀴 돌면(빈공간이 없다) 루프 탈출
	}
	
	public V get(K key) { //탐색 연산
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		do {
			if(a[i].equals(key)) return d[i];
			i = (initialpos + j++) % M;
		} while(a[i] != null // a[i]가 null이면 stop
				&& i != initialpos); // 처음으로 돌아와도 stop 
		return null;
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
