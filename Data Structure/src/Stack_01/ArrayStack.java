package Stack_01;
import java.util.EmptyStackException;
public class ArrayStack <E> {
	private E s[]; //스택을 위한 배열
	private int top; // 스택의 top항목의 인덱스
	public ArrayStack() {
		s = (E[]) new Object[1]; //초기에 크기가 1인 배열 생성
		top = -1; //항목이 없으니 -1
	}
	public int size() { return top + 1; } //크기이므로 인덱스(top)에 +1
	public boolean isEmpty() { return (top == -1); } //top = -1은 비어있단뜻
	
	public E peek() { //top항목 내용 리턴, 가장최근에 넣은거가 뭐지?
		if (isEmpty()) throw new EmptyStackException();
		return s[top]; 
	}
	
	public void push(E newItem) { //newitem을 넣자
		if (size() == s.length) //사이즈 늘림
			resize(2*s.length);
		s[++top] = newItem; //top을 1증가시키고 top에 삽입 
	}
	
	public void resize(int newSize) {
		Object[] t = new Object[newSize]; // newSize 크기의 새로운 배열 t생성
		for (int i = 0; i < s.length; i++)
			t[i] = s[i];
		s = (E[]) t;
	}
	
	public E pop() { 
		if (isEmpty()) throw new EmptyStackException();
		E item = s[top];
		s[top--] = null; //top을 널로 바꾸거 top도 1줄임
		if (size() > 0 && size() == s.length/4)
			resize(s.length/2);
		return item;
	}
	
	public void print() {
		for (int i = 0; i < s.length; i++) {
			if (i < s.length) System.out.printf(s[i] + "\t");
			else System.out.printf("null\t");
		}
		System.out.println();
	}
	
	public boolean checkParenttheses(String s) { //Q3 괄호 짝 맞추기
		char ch;
		for(int i = 0; i < s.length(); i++ ) {
			ch = s.charAt(i);
			switch(ch) {
			case '(':
				E item = (E) "(";
				this.push(item); break;
			case '{':
				E item2 = (E) "{";
				this.push(item2); break;
			case '[':
				E item3 = (E) "[";
				this.push(item3); break;
			case ')':
				if(isEmpty()) return false;
				else {
					if(this.peek()== "(") {
						this.pop();
						break;
					}
					else return false;
				}
			case '}':
				if(isEmpty()) return false;
				else {
					if(this.peek()== "{") {
						this.pop();
						break;
					}
					else return false;
				}
			case ']':
				if(isEmpty()) return false;
				else {
					if(this.peek() == "[") {
						this.pop();
						break;
					}
					else return false;
				}
			}
		}
		if(isEmpty()) return true;
		else return false;
	}
}
