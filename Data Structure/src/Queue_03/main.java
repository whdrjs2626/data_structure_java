package Queue_03;

public class main {
	public static void main(String[] args) {
		AnimalShelter<String> animal = new AnimalShelter<String>();
		animal.addDog("Brad"); animal.addDog("Tom"); animal.addCat("Cindy");
		animal.addDog("Jake"); animal.addCat("Jenny"); animal.addDog("Alex");
		animal.addCat("Lucy"); animal.addCat("Maggie"); animal.print(); 
		
		System.out.println("�ƹ��ų� �Ծ�");
		animal.adoptAny(); animal.print(); 
		System.out.println("����� �Ծ�");
		animal.adoptCat(); animal.print(); 
		System.out.println("�� �Ծ�");
		animal.adoptDog(); animal.print(); 
		System.out.println("�ƹ��ų� �Ծ�");
		animal.adoptAny(); animal.print(); 
		System.out.println("�� �Ծ�");
		animal.adoptDog(); animal.print();
	}
}
