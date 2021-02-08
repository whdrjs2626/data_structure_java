package List_01;

import java.util.NoSuchElementException;

public class ArrList<E> {
	private E a[];
	private int size;
	public ArrList() {
		a = (E[]) new Object[1];
		size = 0;
	}
	
	public E peek(int k) {
		if(size == 0 || k >= size)
			throw new NoSuchElementException();
		return a[k];
	}
	
	public boolean isEmpty() {
		if (size == 0) return true;
		return false;
	}
	
	public void insert(E newItem, int k) {
		if (size == a.length) //오버사이즈인가?
			resize(2 * a.length);
		for (int i = size-1; i >= k; i--) a[i+1] = a[i]; //k보다 크같인덱스 한칸씩 뒤로 보내기
		a[k] = newItem; // 항목추가
		size++; //사이즈 늘림
	}
	
	public void insertLast(E newItem) {
		if (size == a.length)
			resize(2 * a.length);
		a[size++] = newItem;
	}
	
	public void insert(E newItem) { //인서트 호출시 두번쨰인자(어디다넣을지)를 안주면 insertlast와 같이 작동하게 구현 메소드 오버로딩 중
		insertLast(newItem);
	}
	
	private void resize(int newSize) {
		Object[] t = new Object[newSize]; // newSize 크기의 새로운 배열 t생성
		for (int i = 0; i < size; i++)
			t[i] = a[i]; //배열 요소 복사
		a = (E[]) t; //가비지 컬렉터로 원래 배열을 없앰
	}
	
	public E delete(int K) {
		if (isEmpty()) throw new NoSuchElementException();
		E item = a[K];
		for (int i = K; i < size; i++) a[i] = a[i+1]; //k보다 인덱스가 크거나 같은 것들을 한칸씩 땡김
		size --;
		if(size > 0 && size <= a.length/4) //사이즈가 1/4이ㅏ만 사용되면 축소
			resize(a.length/2);
		return item;
	}
	
	public void print() {
		for (int i = 0; i < a.length; i++) { //배열의 크기만큼 출력
			if (i < size) System.out.printf(a[i] + "\t"); //항목이 존재하면 항목출력
			else System.out.printf("null\t"); //없으면 null출력
		}
		System.out.println();
	}
}
