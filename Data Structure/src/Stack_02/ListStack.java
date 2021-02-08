package Stack_02;
import java.util.EmptyStackException;
public class ListStack <E> {
	private Node<E> top;
	private int size;
	public ListStack() {//생성자
		top = null; //top을 가르키게
		size = 0;
	}
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }
	
	public E peek() { //top의 내용 리턴
		if (isEmpty()) throw new EmptyStackException();
		return top.getItem();
	}
	
	public void push(E newItem) { // 삽입
		Node newNode = new Node(newItem, top);
		top = newNode; // top을 가리키는 노드를 만들고 그노드를 top으로 선언함
		size++;
	}
	
	public void dpush(double newItem) { //double형 newItem을 인자로 받는 push
		Node newNode = new Node(newItem, top);
		top = newNode;
		size++;
	}
	
	public E pop() {
		if (isEmpty()) throw new EmptyStackException();
		E topItem = top.getItem();
		top = top.getNext(); // top의 다음걸 top으로 만듦
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
	
	public boolean checkPalindrome(String s) { //Q4 회문 검사하기
		int a = s.length();
		if(a % 2 == 0) { //글자 수 가 짝수인 경우
			for(int i = 0; i < a/2; i++) { //앞부분 글자를 스택에 넣는다
				Node newNode = new Node(s.charAt(i), top);
				top = newNode;
				size++;
			}
			for(int i = a/2; i < s.length(); i++) { //뒷부분 글자들을 스택에서 뺀다
				if((char)top.getItem() == s.charAt(i)) { //뒷부분 글자와 앞부분글자의 마지막이 같나?
					this.pop(); //뺀다.
				}
				else return false; //아닌 즉시 false
			}
		}
		else { //글자 수가 홀수인 경우
			int a2 = a-1; 
			for(int i = 0; i < a2/2; i++) { //앞부분
				Node newNode = new Node(s.charAt(i), top);
				top = newNode;
				size++;
			}
			for(int i = a2/2 + 1; i < s.length(); i++) { //뒷부분 
				if((char)top.getItem() == s.charAt(i)) {
					this.pop();
				}
				else return false;
			}
		}
		if(isEmpty()) return true;
		else return false;
	}
	
	public String getPostEq(String s) { //Q5 중위표기법 -> 후위표기법 변환
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
			case '/': //연산자인 경우 
				while(!isEmpty() && compare((char)this.peek(), ch)) //비어있지 않을 때 스택의 top의 연산순위가 ch의 연산순위보다 높을 시
					post += this.pop(); //ch를 post에 추가
				Node newNode2 = new Node(ch, top);
				top = newNode2;
				size++;
				break;
		    default: //일반 변수인 경우 post에 추가
		    	post += ch;
			}
		}
		while(!isEmpty())
			post += this.pop();
		return post;
	}
	
	public int rank(char c) { //Q5 우선순위를 매기는 메소드
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
	
	public boolean compare(char c1, char c2) { //Q5 rank()로 매긴 우선순위를 비교하여 true false를 리턴하는 메소드
		int in1 = rank(c1);
		int in2 = rank(c2);
		
		if(in1 >= in2)
			return true;
		else
			return false;
	}
	
	public double calc(String[] s) { //Q6 후위표기법 계산하기
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
