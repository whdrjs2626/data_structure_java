package test_01;

import java.util.Scanner;

public class FactorialRecursive {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		System.out.print("���� N�� �Է��Ͻÿ� : ");
		a = sc.nextInt();
		System.out.println("N!�� " + factorial(a));
	}
	
	public static int factorial(int num) {
		if(num <= 1) {
			return num;
		}
		else {
			return num*factorial(num-1);
		}
	}
}
