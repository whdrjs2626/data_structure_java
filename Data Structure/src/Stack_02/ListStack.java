package Stack_02;
import java.util.EmptyStackException;
public class ListStack <E> {
	private Node<E> top;
	private int size;
	public ListStack() {//������
		top = null; //top�� ����Ű��
		size = 0;
	}
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }
	
	public E peek() { //top�� ���� ����
		if (isEmpty()) throw new EmptyStackException();
		return top.getItem();
	}
	
	public void push(E newItem) { // ����
		Node newNode = new Node(newItem, top);
		top = newNode; // top�� ����Ű�� ��带 ����� �׳�带 top���� ������
		size++;
	}
	
	public void dpush(double newItem) { //double�� newItem�� ���ڷ� �޴� push
		Node newNode = new Node(newItem, top);
		top = newNode;
		size++;
	}
	
	public E pop() {
		if (isEmpty()) throw new EmptyStackException();
		E topItem = top.getItem();
		top = top.getNext(); // top�� ������ top���� ����
		size--;
		return topItem;
	}
	
	public void print() {
		Node p = top;
		for(int i = 0; i < size; i++) {
			System.out.print(p.getItem() + "\t");
			p = p.getNext();
		}
		System.out.println();
	}
	
	public boolean checkPalindrome(String s) { //Q4 ȸ�� �˻��ϱ�
		int a = s.length();
		if(a % 2 == 0) { //���� �� �� ¦���� ���
			for(int i = 0; i < a/2; i++) { //�պκ� ���ڸ� ���ÿ� �ִ´�
				Node newNode = new Node(s.charAt(i), top);
				top = newNode;
				size++;
			}
			for(int i = a/2; i < s.length(); i++) { //�޺κ� ���ڵ��� ���ÿ��� ����
				if((char)top.getItem() == s.charAt(i)) { //�޺κ� ���ڿ� �պκб����� �������� ����?
					this.pop(); //����.
				}
				else return false; //�ƴ� ��� false
			}
		}
		else { //���� ���� Ȧ���� ���
			int a2 = a-1; 
			for(int i = 0; i < a2/2; i++) { //�պκ�
				Node newNode = new Node(s.charAt(i), top);
				top = newNode;
				size++;
			}
			for(int i = a2/2 + 1; i < s.length(); i++) { //�޺κ� 
				if((char)top.getItem() == s.charAt(i)) {
					this.pop();
				}
				else return false;
			}
		}
		if(isEmpty()) return true;
		else return false;
	}
	
	public String getPostEq(String s) { //Q5 ����ǥ��� -> ����ǥ��� ��ȯ
		String post = "";
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			switch(ch) {
			case '(':
				Node newNode = new Node(ch, top);
				top = newNode;
				size++;
				break;
			case ')':
				while(true) {
					char ch2 = (char)this.pop();
					if (ch2 == '(')
						break;
					post += ch2;
				}
				break;
			case '+':
			case '-':
			case '*':
			case '/': //�������� ��� 
				while(!isEmpty() && compare((char)this.peek(), ch)) //������� ���� �� ������ top�� ��������� ch�� ����������� ���� ��
					post += this.pop(); //ch�� post�� �߰�
				Node newNode2 = new Node(ch, top);
				top = newNode2;
				size++;
				break;
		    default: //�Ϲ� ������ ��� post�� �߰�
		    	post += ch;
			}
		}
		while(!isEmpty())
			post += this.pop();
		return post;
	}
	
	public int rank(char c) { //Q5 �켱������ �ű�� �޼ҵ�
		switch(c) {
		case '*':
		case '/':
			return 2;
		case '+':
		case '-':
			return 1;
		}
		return -1;
	}
	
	public boolean compare(char c1, char c2) { //Q5 rank()�� �ű� �켱������ ���Ͽ� true false�� �����ϴ� �޼ҵ�
		int in1 = rank(c1);
		int in2 = rank(c2);
		
		if(in1 >= in2)
			return true;
		else
			return false;
	}
	
	public double calc(String[] s) { //Q6 ����ǥ��� ����ϱ�
		for(int i = 0; i < s.length; i++) {
			String str = s[i];
			switch(str) {
			case "+":
				double B = (double)this.pop();
				double A = (double)this.pop();
				this.dpush(A+B);
				break;
			case "-":
				double B2 = (double)this.pop();
				double A2 = (double)this.pop();
				this.dpush(A2-B2);
				break;
			case "*":
				double B3 = (double)this.pop();
				double A3 = (double)this.pop();
				this.dpush(A3*B3);
				break;
			case "/":
				double B4 = (double)this.pop();
				double A4 = (double)this.pop();
				this.dpush(A4/B4);
				break;
		    default:
		    	double a = Double.parseDouble(str);
		    	this.dpush(a);
			}
		}
		return (double)this.pop();
	}
}
