package Stack_01;

public class main {
	public static void main(String[] args) {
		ArrayStack<String> stack = new ArrayStack<String>();
		
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
		
		// [Q 3] [Task1]
		ArrayStack<String> s1 = new ArrayStack<String>();
		String str1 = "(ant+bee)*crab+{[ant*food]+(offset)}/gas";
		System.out.println("str1 : " + str1);
		System.out.println("Task 1 : " + s1.checkParenttheses(str1));
		System.out.println();
		
		// [Q 3] [Task2]
		ArrayStack<String> s2 = new ArrayStack<String>();
		String str2 = "(ant+bee)*crab+[ant*food]+(offset)}/gas";
		System.out.println("str2 : " + str2);
		System.out.println("Task 2 : " + s2.checkParenttheses(str2));
	}
}
