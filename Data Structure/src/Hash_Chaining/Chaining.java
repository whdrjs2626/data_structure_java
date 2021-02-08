package Hash_Chaining;

public class Chaining<K, V> {
	//private int N = 0, M = 13; //[Q 6]������ ���̺� ũ��
	private int N = 0, M = 5; //[Q 7]������ ���̺� ũ��
	private Node[] a = new Node[M]; //�ؽ� ���̺�
	public static class Node { //��� Ŭ����
		private Object key;
		private Object data;
		private Node   next;
		public Node(Object newkey, Object newdata, Node ref) { //������
			key  = newkey;
			data = newdata;
			next = ref;
		}
		public Object getKey()  { return key;  }
		public Object getData() { return data; }
	}
	
	private int hash(K key) { //�ؽ��ڵ�
		return (key.hashCode() & 0x7fffffff) % M; //������ ���� 
	}
	
	public V get(K key) { //Ž�� ����
		int i = hash(key);
		for (Node x = a[i]; x != null; x = x.next) //���Ḯ��Ʈ Ž��
			if (key.equals(x.key)) return (V) x.data; //Ž�� ����
		return null; //Ž�� ����
	}
	
	public void put(K key, V data) { //���� ����
		double alpha = (double)N / (double)M; //������ ��[Q 7]���������� ����ϴ� ����
		if(alpha > 0.75 || ( alpha < 0.25 && 5 <= M/2)) this.rehash(alpha);
		int i = hash(key);
		for (Node x = a[i]; x != null; x = x.next) //���� ���� ���� ��� �ݺ���
			if(key.equals(x.key)) { //key�� �̹� ������
				x.data = data; //�����͸� ����
				return;
			}
		a[i] = new Node(key, data, a[i]); //���� ����Ʈ�� ù ���� ����
		N++;
		
	}
	
	public void print() { //���
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
		    //���̺� ũ�� �缳��
	    if ( l > 0.75 ) M = M*2;
		else if ( l < 0.25 ) {
		    if ( M / 2 >= 5 ) M = M/2;
		    else if ( M > 5 ) M = 5;
		}
		//���ؽ�
		Node[] t= new Node[M];
		for(int i=0; i<oldM; i++) {
		    for(Node x=a[i]; x!=null; x=x.next) {
		        int j=hash((K)x.key);
		        t[j]=new Node(x.key, x.data, t[j]);
		        }
		}
		a=t;
		System.out.println("[msg] ���̺��� ����� "+oldM+"���� "+M+"(��)�� �����մϴ�.");
	}
	public void delete(K key) { //���� ����
		int i = hash(key);
		if(a[i] == null) { 
			System.out.println("����ֽ��ϴ�.");
			this.rehash(0.1); //������� �� ���̺��� �ּҷ� ���Դϴ�.
		}
		else {
		    for (Node x = a[i]; x != null; x = x.next) {//���Ḯ��Ʈ Ž��
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
		double alpha = (double)N / (double)M; //������ ��[Q 7]���������� ����ϴ� ����
		if(alpha > 0.75 || ( alpha < 0.25 && 5 <= M/2)) this.rehash(alpha);
	}
}
