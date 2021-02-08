package List_01;

public class ArrListPoly extends ArrList {
	private int highestDegree;
	
	public int getHighestDegree() {
		return highestDegree;
	}
	public void setPoly(int k, int[] arr) { //�θ�Ŭ������ insert�Լ��� �迭�� ����
		this.highestDegree = k;
		for(int i : arr) {
			super.insert(i);
		}
	}
	
	public ArrListPoly sumPoly(ArrListPoly array2) { 		
		ArrListPoly array = new ArrListPoly();	//��ģ ����� ������ ���ο� �迭 ����
		if(this.getHighestDegree() > array2.getHighestDegree()) { //���ڷ� ���� ���׽ĺ��� ��ü�� ���׽��� ������ ���� ���
			array.highestDegree = this.getHighestDegree(); //���ο� �迭�� ������ ��ū ����
			
			for(int i = 0; i <= array2.getHighestDegree(); i++) { //�ְ������� �� ���� �迭���� i�� �ְ��������� 1�� ���̸鼭 ����� ���ؼ� ���ο� �迭�� ���� 
				array.insert((int)this.peek(i) + (int)array2.peek(i));
			}
			
			for(int i = array2.getHighestDegree() + 1; i <= this.getHighestDegree(); i++) { //�ְ������� �� ���� �迭���� �ڱ��� ����� �����Ѵ�
				array.insert((int)this.peek(i));
			}
		} else { //���̰� ���ų� ���ڷ� ���� ���׽��� ������ ���� ���
			array.highestDegree = array2.getHighestDegree(); 
			for(int i = 0; i <= this.getHighestDegree(); i++) { //���� ����
				array.insert((int)this.peek(i) + (int)array2.peek(i));
			}
			for(int i = this.getHighestDegree() + 1; i <= array2.getHighestDegree(); i++) {
				array.insert((int)array2.peek(i));
			}
		}
		return array;
	}
}
