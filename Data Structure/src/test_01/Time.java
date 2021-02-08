package test_01;

public class Time {
	public static void main(String[] args) {
		int[] arr = new int[500]; // create an array
		for(int i = 0 ; i < arr.length ; i++ ) arr[i] = 0; // initialize
		long beforeTime = System.currentTimeMillis(); // start the timer
		fLinear(arr);
		long afterTime = System.currentTimeMillis(); // finish the timer
		long diffTimeMilliSecond = afterTime-beforeTime; // get the diff
		System.out.println("Time diff (ms): " + diffTimeMilliSecond);
	}
	public static int fLinear(int[] arr) {
		int sum = 1;
		for(int i = 0; i <= arr.length; i++) {
			sum += i;
		}
		return sum;
	}
}