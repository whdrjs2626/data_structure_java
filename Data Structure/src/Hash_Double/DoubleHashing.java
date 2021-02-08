package Hash_Double;

public class DoubleHashing<K, V> {
	private int N = 0, M = 13; //���̺� ũ�� M, �׸� �� N
	private K[] a = (K[]) new Object[M];
	private V[] dt = (V[]) new Object[M];
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public void put(K key, V data) { //���� ����
		int initialpos = hash(key); //�ʱ� ��ġ
		int i = initialpos, j = 1;
		int d = (7-(int)key % 7); //�ι�° �ؽ� �Լ�
		do {
			if (a[i] == null) { //���� ��ġ �߰�
				a[i] = key; //key�� �ؽ����̺� ����
				dt[i] = data; N++; //������ ����
				return;
			}
			if (a[i].equals(key)) { //�̹� key ����
				dt[i] = data; //�����͸� ����
				return;
			}
			i = (initialpos + j * d) % M; //i = ������ġ
			j++;
		} while (N < M); //�ѹ��� ���� ���� Ż��
	}
	
	public V get(K key) { //Ž�� ����
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		int d = (7-(int)key % 7);
		while (a[i] != null) {
			if(a[i].equals(key)) return dt[i]; //Ž�� ����
			i = (initialpos + j * d) % M;
			j++;
		} 
		return null; //Ž�� ����
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
