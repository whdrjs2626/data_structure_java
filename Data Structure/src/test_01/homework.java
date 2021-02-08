package test_01;

public class homework {
	public static void F(int N) {
		if (N > 0)	{
			F(N/2);
			System.out.print(N % 2);
		}
	}
	public static void main(String[] args) {
		F(12);
	}
}
