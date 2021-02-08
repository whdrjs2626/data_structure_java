package Hash_Chaining;

public class Chaining<K, V> {
	//private int N = 0, M = 13; //[Q 6]과제의 테이블 크기
	private int N = 0, M = 5; //[Q 7]과제의 테이블 크기
	private Node[] a = new Node[M]; //해시 테이블
	public static class Node { //노드 클래스
		private Object key;
		private Object data;
		private Node   next;
		public Node(Object newkey, Object newdata, Node ref) { //생성자
			key  = newkey;
			data = newdata;
			next = ref;
		}
		public Object getKey()  { return key;  }
		public Object getData() { return data; }
	}
	
	private int hash(K key) { //해시코드
		return (key.hashCode() & 0x7fffffff) % M; //나눗셈 영상 
	}
	
	public V get(K key) { //탐색 연산
		int i = hash(key);
		for (Node x = a[i]; x != null; x = x.next) //연결리스트 탐색
			if (key.equals(x.key)) return (V) x.data; //탐색 성공
		return null; //탐색 실패
	}
	
	public void put(K key, V data) { //삽입 연산
		double alpha = (double)N / (double)M; //적재율 ※[Q 7]과제에서만 사용하는 문장
		if(alpha > 0.75 || ( alpha < 0.25 && 5 <= M/2)) this.rehash(alpha);
		int i = hash(key);
		for (Node x = a[i]; x != null; x = x.next) //같은 값이 있을 까봐 반복문
			if(key.equals(x.key)) { //key가 이미 있으면
				x.data = data; //데이터만 갱신
				return;
			}
		a[i] = new Node(key, data, a[i]); //연결 리스트의 첫 노드로 삽입
		N++;
		
	}
	
	public void print() { //출력
		for(int i = 0; i < M; i++) {
			System.out.print(i);
			for (Node x = a[i]; x != null; x = x.next) {
				System.out.print(" --> [" + x.key + ", ");
				System.out.print(x.data + "]");
			}
			System.out.println();
		}
	}
	
	private void rehash(double l) {
		int oldM = M;
		    //테이블 크기 재설정
	    if ( l > 0.75 ) M = M*2;
		else if ( l < 0.25 ) {
		    if ( M / 2 >= 5 ) M = M/2;
		    else if ( M > 5 ) M = 5;
		}
		//재해시
		Node[] t= new Node[M];
		for(int i=0; i<oldM; i++) {
		    for(Node x=a[i]; x!=null; x=x.next) {
		        int j=hash((K)x.key);
		        t[j]=new Node(x.key, x.data, t[j]);
		        }
		}
		a=t;
		System.out.println("[msg] 테이블의 사이즈를 "+oldM+"에서 "+M+"(으)로 변경합니다.");
	}
	public void delete(K key) { //삭제 연산
		int i = hash(key);
		if(a[i] == null) { 
			System.out.println("비어있습니다.");
			this.rehash(0.1); //비어있을 시 테이블을 최소로 줄입니다.
		}
		else {
		    for (Node x = a[i]; x != null; x = x.next) {//연결리스트 탐색
		    	if (key.equals(x.key) && x.next == null) {
		    		a[i] = null;
		    		N--;
		    	}
		    	else if (key.equals(x.next.key)) {
				    a[i].next = null;
				    N--;
			    }
		    }
		}
		double alpha = (double)N / (double)M; //적재율 ※[Q 7]과제에서만 사용하는 문장
		if(alpha > 0.75 || ( alpha < 0.25 && 5 <= M/2)) this.rehash(alpha);
	}
}
