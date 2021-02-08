package Sort_Bubble;
import java.util.Arrays;
import java.util.Random;
public class GenData {
	int[] getRandIntArr(int N, int min, int max) {
		Random rd = new Random();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = rd.nextInt(max - min - 1) + min;
		}
		return arr;
	}
	public static void main(String[] args) {
		
		GenData a = new GenData();
		int[] task1 = a.getRandIntArr(5, 0, 10);
		System.out.println("[Task 1] : " + Arrays.toString(task1));
		
		int[] task2 = a.getRandIntArr(10, 0, 100);
		System.out.println("[Task 2] : " + Arrays.toString(task2));
	}
}
