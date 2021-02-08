package test_01;

import java.util.Scanner;

public class ArrayTest {
	public static void main(String[] args) {
		int n;
		int[] arr2 = IntArray();
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자 n을 입력하시오 : ");
		n = scan.nextInt();
		
		boolean flag = false;
		int tmp;
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				for(int k = 0; k < 100; k++) {
					if(i != j && j != k && k != i) {
						tmp = arr2[i] + arr2[j] + arr2[k];
						if(tmp == n) {
							flag = true;
				     	    System.out.println(arr2[i] + " + " + arr2[j] + " + " + arr2[k] + " = " + n );
				     	    break;
						}
					}
				}
				if(flag) break;
			}
			if(flag) break;
		}
	}
	
    public static int[] IntArray() {
    	int [] arr = new int[100];
		for(int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
		return arr;
	}
}
