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
		System.out.print("�л��� �̸��� �Է��Ͻÿ� : ");
		name = scanner.nextLine();
		System.out.print("�л��� ��ȣ�� �Է��Ͻÿ� : ");
		ID = scanner.nextInt();
	}

	void printPersonInfo() {
		System.out.println(name + " �л��� ��ȣ�� " + ID);
	}
}

class StudentInfo extends PersonInfo {
	
	String deptName;
	int stuID;

	StudentInfo(Scanner scanner) {
		super(scanner);
		System.out.print("�μ��̸��� �Է��Ͻÿ� : ");
		deptName = scanner.next();
		System.out.print("�μ���ȣ�� �Է��Ͻÿ� : ");
		stuID = scanner.nextInt();
	}

	
	void printPersonInfo() {
		super.printPersonInfo();
		System.out.print(deptName + "�μ��� ��ȣ�� " + stuID);
	}
}