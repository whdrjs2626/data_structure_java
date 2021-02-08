package Hash_Linear;

public class LinearProbing<K, V> { //���׸�Ÿ�� ����
	private int M = 13; //���̺� ũ��
	private K[] a = (K[]) new Object[M]; //�ؽ����̺�
	private V[] d = (V[]) new Object[M]; //key���� ������ ����
	private int hash(K key) { //�ؽ��ڵ�
		return (key.hashCode() & 0x7fffffff) % M; //�������Լ� �ؽ��Լ�
	}
	
	public void put(K key, V data) { //���� ����
		int initialpos = hash(key); //�ʱ� ��ġ
		int i = initialpos, j = 1; //�浹�� ���������� j�� �����ʴٰ� �浹�� �Ͼ�� i�� j�� ����
		do {
			if (a[i] == null) { //���� ��ġ �߰�
				a[i] = key; //key�� �ؽ����̺� ����
				d[i] = data; //������ ����
				return;
			}
			if (a[i].equals(key)) { //�̹� key ����
				d[i] = data; //�����͸� ����
				return;
			}
			i = (initialpos + j++) % M; //i = ������ġ
		} while (i != initialpos); //�ѹ��� ����(������� ����) ���� Ż��
	}
	
	public V get(K key) { //Ž�� ����
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		do {
			if(a[i].equals(key)) return d[i];
			i = (initialpos + j++) % M;
		} while(a[i] != null // a[i]�� null�̸� stop
				&& i != initialpos); // ó������ ���ƿ͵� stop 
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
