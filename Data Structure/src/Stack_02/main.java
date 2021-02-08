package Stack_02;

public class main {
	public static void main(String[] args) {
		ListStack<String> stack = new ListStack<String>();
		
		stack.push("apple");
		stack.push("orange");
		stack.push("cherry");
		System.out.println(stack.peek());
		stack.push("pear");
		stack.print();
		stack.pop();
		System.out.println(stack.peek());
		stack.push("grape");
		stack.print();
		System.out.println();
		
		// [Q 4] [Task1 ~ 5]
		ListStack<String> p = new ListStack<String>();
		String s1 = "redivider";
		System.out.println("s1 : " + s1);
		System.out.println("Task 1 : " + p.checkPalindrome(s1));
		String s2 = "redder";
		System.out.println("s2 : " + s2);
		System.out.println("Task 2 : " + p.checkPalindrome(s2));
		String s3 = "a";
		System.out.println("s3 : " + s3);
		System.out.println("Task 3 : " + p.checkPalindrome(s3));
		String s4 = "abbd";
		System.out.println("s4 : " + s4);
		System.out.println("Task 4 : " + p.checkPalindrome(s4));
		String s5 = "koxko";
		System.out.println("s5 : " + s5);
		System.out.println("Task 5 : " + p.checkPalindrome(s5));
		System.out.println();
		
		// [Q 5] [Task1 ~ 3]
		ListStack<String> p2 = new ListStack<String>();
		String str1 = "A*(B+C/D)";
		System.out.println("str1 : " + str1);
		System.out.println("Task 1 : " + p2.getPostEq(str1));
		String str2 = "(A+B)*(C-D)";
		System.out.println("str2 : " + str2);
		System.out.println("Task 2 : " + p2.getPostEq(str2));
		String str3 = "A+B+C*(B+C*D)/D";
		System.out.println("str3 : " + str3);
		System.out.println("Task 3 : " + p2.getPostEq(str3));
		System.out.println();
		
		// [Q 6] [Task1]
		ListStack<String> p3 = new ListStack<String>();
		String[] str4 = {"81", "37", "-211", "+", "15", "-", "/"};
		System.out.print("Task 1 : 81 37 -211 + 15 - / = ");
		System.out.println(p3.calc(str4));
		
		// [Q 6] [Task2]
		ListStack<String> p4 = new ListStack<String>();
		String[] str5 = {"20.5", "10.2", "3.3", "+", "*"};
		System.out.print("Task 2 : 20.5 10.2 3.3 + * = ");
		System.out.println(p4.calc(str5));
		
		ListStack<String> p5 = new ListStack<String>();
		String[] str6 = {"10", "2", "-", "3", "*", "30", "4", "6", "+", "/", "-"};
		System.out.println(p5.calc(str6));
	
		ListStack<String> p6 = new ListStack<String>();
		p6.push("1"); p6.push("2"); p6.push("3"); p6.push("4"); p6.push("5");
		System.out.println(p6.peek());
		System.out.println(p6.pop()); System.out.println(p6.pop()); System.out.println(p6.pop()); 
		System.out.println(p6.pop()); System.out.println(p6.pop());
	}
}
