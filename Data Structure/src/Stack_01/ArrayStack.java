package Stack_01;
import java.util.EmptyStackException;
public class ArrayStack <E> {
	private E s[]; //������ ���� �迭
	private int top; // ������ top�׸��� �ε���
	public ArrayStack() {
		s = (E[]) new Object[1]; //�ʱ⿡ ũ�Ⱑ 1�� �迭 ����
		top = -1; //�׸��� ������ -1
	}
	public int size() { return top + 1; } //ũ���̹Ƿ� �ε���(top)�� +1
	public boolean isEmpty() { return (top == -1); } //top = -1�� ����ִܶ�
	
	public E peek() { //top�׸� ���� ����, �����ֱٿ� �����Ű� ����?
		if (isEmpty()) throw new EmptyStackException();
		return s[top]; 
	}
	
	public void push(E newItem) { //newitem�� ����
		if (size() == s.length) //������ �ø�
			resize(2*s.length);
		s[++top] = newItem; //top�� 1������Ű�� top�� ���� 
	}
	
	public void resize(int newSize) {
		Object[] t = new Object[newSize]; // newSize ũ���� ���ο� �迭 t����
		for (int i = 0; i < s.length; i++)
			t[i] = s[i];
		s = (E[]) t;
	}
	
	public E pop() { 
		if (isEmpty()) throw new EmptyStackException();
		E item = s[top];
		s[top--] = null; //top�� �η� �ٲٰ� top�� 1����
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
	
	public boolean checkParenttheses(String s) { //Q3 ��ȣ ¦ ���߱�
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
