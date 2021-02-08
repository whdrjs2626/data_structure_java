package Hash_Random;
import java.util.Random;
public class RandProbing<K, V> {
	private int N = 0, M = 13; //���̺� ũ�� M, �׸� �� N
	private K[] a = (K[]) new Object[M];
	private V[] d = (V[]) new Object[M];
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public void put(K key, V data) { //���� ����
		int initialpos = hash(key); //�ʱ� ��ġ
		int i = initialpos;
		Random rand = new Random(); 
		rand.setSeed(10); //���� ���� �غ�
		do {
			if (a[i] == null) { //���� ��ġ �߰�
				a[i] = key; //key�� �ؽ����̺� ����
				d[i] = data; N++; //������ ����
				return;
			}
			if (a[i].equals(key)) { //�̹� key ����
				d[i] = data; //�����͸� ����
				return;
			}
			i = (initialpos + rand.nextInt(1000)) % M; //i = ������ġ
		} while (N < M); //�ѹ��� ���� ���� Ż��
	}
	
	public V get(K key) { //Ž�� ����
		int initialpos = hash(key);
		int i = initialpos;
		Random rand = new Random();
		rand.setSeed(10); //���� ���궧�� ���� seed������ ���� ����
		while (a[i] != null) {
			if(a[i].equals(key)) return d[i]; //Ž�� ����
			i = (initialpos + rand.nextInt(1000)) % M;
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
