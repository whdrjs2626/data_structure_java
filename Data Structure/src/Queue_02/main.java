package Queue_02;

public class main {
	public static void main(String[] args) {
	    ListQueue<String> queue = new ListQueue<String>();
	    queue.add("apple");  queue.add("orange");
	    queue.add("cherry"); queue.add("pear");   queue.print();
	    queue.remove();      queue.print();
	    queue.add("grape");  queue.print();
	    queue.remove();      queue.print();
	    queue.add("lemon");  queue.print();
	    queue.add("mango");  queue.print();
	    queue.add("lime");   queue.print();
	    queue.add("kiwi");   queue.print();
	    queue.remove();      queue.print();
	    System.out.println();
	    
	    ListQueue<Double> in = new ListQueue<Double>();
	    in.add(1.0); in.add(2.0); in.add(3.0); in.add(4.0); in.add(5.0); 
	    System.out.println("저장된 정수"); in.print();
	    System.out.println("평균 값 : " + in.avg());
	    System.out.println("저장된 정수"); in.print();
	    System.out.println();
	    
	    ListQueue<String> re = new ListQueue<String>();
	    re.add("A"); re.add("B"); re.add("C"); re.add("D"); re.add("E"); 
	    System.out.println("[Task 1]");
	    re.print(); re.reverse(); re.print();
	    
	    ListQueue<Integer> re2 = new ListQueue<Integer>();
	    re2.add(5); re2.add(4); re2.add(3); re2.add(2); re2.add(1); 
	    System.out.println("[Task 2]");
	    re2.print(); re2.reverse(); re2.print();
	}
}
