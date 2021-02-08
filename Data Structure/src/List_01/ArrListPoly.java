package List_01;

public class ArrListPoly extends ArrList {
	private int highestDegree;
	
	public int getHighestDegree() {
		return highestDegree;
	}
	public void setPoly(int k, int[] arr) { //부모클래스의 insert함수로 배열에 삽입
		this.highestDegree = k;
		for(int i : arr) {
			super.insert(i);
		}
	}
	
	public ArrListPoly sumPoly(ArrListPoly array2) { 		
		ArrListPoly array = new ArrListPoly();	//합친 결과를 저장할 새로운 배열 선언
		if(this.getHighestDegree() > array2.getHighestDegree()) { //인자로 받은 다항식보다 객체의 다항식의 차수가 높을 경우
			array.highestDegree = this.getHighestDegree(); //새로운 배열의 차수는 더큰 차수
			
			for(int i = 0; i <= array2.getHighestDegree(); i++) { //최고차수가 더 낮은 배열에서 i를 최고차수까지 1씩 높이면서 계수를 더해서 새로운 배열에 삽입 
				array.insert((int)this.peek(i) + (int)array2.peek(i));
			}
			
			for(int i = array2.getHighestDegree() + 1; i <= this.getHighestDegree(); i++) { //최고차수가 더 높은 배열에선 자기의 계수만 삽입한다
				array.insert((int)this.peek(i));
			}
		} else { //길이가 같거나 인자로 받은 다항식의 차수가 높은 경우
			array.highestDegree = array2.getHighestDegree(); 
			for(int i = 0; i <= this.getHighestDegree(); i++) { //위와 같다
				array.insert((int)this.peek(i) + (int)array2.peek(i));
			}
			for(int i = this.getHighestDegree() + 1; i <= array2.getHighestDegree(); i++) {
				array.insert((int)array2.peek(i));
			}
		}
		return array;
	}
}
