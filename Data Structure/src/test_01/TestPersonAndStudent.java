package test_01;

import java.util.Scanner;

public class TestPersonAndStudent {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		PersonInfo student = new StudentInfo(scanner);
		student.printPersonInfo();
		
	}
}


class PersonInfo {
	
	String name;
	int ID;

	PersonInfo(Scanner scanner) {
		System.out.print("학생의 이름을 입력하시오 : ");
		name = scanner.nextLine();
		System.out.print("학생의 번호를 입력하시오 : ");
		ID = scanner.nextInt();
	}

	void printPersonInfo() {
		System.out.println(name + " 학생의 번호는 " + ID);
	}
}

class StudentInfo extends PersonInfo {
	
	String deptName;
	int stuID;

	StudentInfo(Scanner scanner) {
		super(scanner);
		System.out.print("부서이름을 입력하시오 : ");
		deptName = scanner.next();
		System.out.print("부서번호를 입력하시오 : ");
		stuID = scanner.nextInt();
	}

	
	void printPersonInfo() {
		super.printPersonInfo();
		System.out.print(deptName + "부서의 번호는 " + stuID);
	}
}