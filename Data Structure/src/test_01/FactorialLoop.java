package test_01;

import java.util.Scanner;

public class FactorialLoop {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		int fact = 1;
		System.out.print("숫자 N을 입력하시오 : ");
		a = sc.nextInt();
		
		for(int i = a; i >= 1; i--) {
			fact = fact*i;
		}
		
		System.out.println("N!은 " + fact);
	}
}
