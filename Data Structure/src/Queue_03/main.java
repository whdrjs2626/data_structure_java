package Queue_03;

public class main {
	public static void main(String[] args) {
		AnimalShelter<String> animal = new AnimalShelter<String>();
		animal.addDog("Brad"); animal.addDog("Tom"); animal.addCat("Cindy");
		animal.addDog("Jake"); animal.addCat("Jenny"); animal.addDog("Alex");
		animal.addCat("Lucy"); animal.addCat("Maggie"); animal.print(); 
		
		System.out.println("아무거나 입양");
		animal.adoptAny(); animal.print(); 
		System.out.println("고양이 입양");
		animal.adoptCat(); animal.print(); 
		System.out.println("개 입양");
		animal.adoptDog(); animal.print(); 
		System.out.println("아무거나 입양");
		animal.adoptAny(); animal.print(); 
		System.out.println("개 입양");
		animal.adoptDog(); animal.print();
	}
}
