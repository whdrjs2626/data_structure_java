package ListPoly;

public class ArrListPoly extends ArrList {
private int highestDegree;
	
	public int getHighestDegree() {
		return highestDegree;
	}
	public void setPoly(int k, int[] arr) { //�θ�Ŭ������ insert�Լ��� �迭�� ����
		this.highestDegree = k;
		super.insert(arr[0]);
		super.insert(arr[1]);
		super.insert(arr[2]);
		super.insert(arr[3]);
		super.insert(arr[4]);
		System.out.println();
	}
	
	


}
