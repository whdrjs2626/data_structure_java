package Hash_Linear;

public class LinearProbing2<K, V> {
	private int M = 13; //테이블 크기
	private K[] a = (K[]) new Object[M]; //해시테이블
	private V[] d = (V[]) new Object[M]; //key관련 데이터 저장
	private int hash(K key) { //해시코드
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public void put(K key, V data) { //삽입 연산
		int initialpos = hash(key); //초기 위치
		int i = initialpos, j = 1;
		do {
			if (d[i]==null || a[i] == null) { //삽입 위치 발견
				a[i] = key; //key를 해시테이블에 저장
				d[i] = data; //데이터 저장
				return;
			}
			if (a[i].equals(key)) { //이미 key 존재
				d[i] = data; //데이터만 갱신
				return;
			}
			i = (initialpos + j++) % M; //i = 다음위치
		} while (i != initialpos); //한바퀴 돌면 루프 탈출
	}
	
	public V get(K key) { //탐색 연산
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		do {
			if(d[i] != null && a[i].equals(key)) return d[i];
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
	
	public V delete(K key) {
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		do {
			if(a[i].equals(key)) {
				V b = (V) a[i];
				a[i] = (K) "null";
				d[i] = (V) "null";
				return b;
			}
			i = (initialpos + j++) % M;
		} while (a[i] != null && i != initialpos);
		return null;
	}
	//delete 메소드
	public V delete2(K key) {
	    int initialpos = hash(key);
    	int i= initialpos, j=1;
    	do{
        	if(a[i].equals(key)) {
            	V deleteData=d[i];
            	d[i]=null;
            	return deleteData;
    	    }
        	i= (initialpos + j++)%M;
    	} while(a[i] != null && i != initialpos);
	    return null;
    }

}

