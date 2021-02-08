package test_01;

import java.util.Comparator;
import java.time.LocalDate;
import java.util.Arrays;

public class Book implements Comparable<Book> {
	
	public static final Comparator<Book> WITH_NAME = new WithName();
	public static final Comparator<Book> WITH_SERIAL = new WithSerial();
	public static final Comparator<Book> WITH_DATE = new WithDate();
	
    private String name;
    private int serial;
    private LocalDate date1;


    public Book(String name, int serial, int yyyy, int mm, int dd) {
        this.name = name;
        this.serial = serial;
        date1 = LocalDate.of(yyyy, mm, dd);
    }

    public String getName() {return name;}
    public int getSerial() {return serial;}
    public LocalDate getDate() {return date1;}
    
    public static class WithName implements Comparator<Book> {
    	public int compare(Book s1, Book s2) {
    		return s1.name.compareTo(s2.name);
    	}
    }
    
    public static class WithSerial implements Comparator<Book> {
    	public int compare(Book s1, Book s2) {
    		return s1.serial-s2.serial;
    	}
    }
    
    public static class WithDate implements Comparator<Book> {
    	public int compare(Book s1, Book s2) {
    		return s1.date1.compareTo(s2.date1);
    	}
    }
    
    @Override
    public int compareTo(Book s1) {
    return this.name.compareTo(s1.name);
    }
    
    public static void main(String[] args) {
    	Book[] a = {new Book("한림대학교     ",1,2010,3,15),
    	            new Book("IT기술         ",2,2018,8,11),
    	    	    new Book("자바 프로그래밍",3,2011,1,1),
    	          	new Book("C 프로그래밍  ",4,1999,12,18),
    	        	new Book("인공지능        ",5,2019,2,22),
    	         	new Book("기계학습        ",6,2015,9,30),
    	        	new Book("인간의 미래    ",7,2017,5,21)
    	         	};
    	

    	print(a, "책");
    	
    	Arrays.sort(a, Book.WITH_NAME);
    	print(a, "이름");
    	
    	Arrays.sort(a, Book.WITH_SERIAL);
    	print(a, "번호");
    	
    	Arrays.sort(a, Book.WITH_DATE);
    	print(a, "출간일");
    }
    
    public static void print(Book[] a, String key) {

    	System.out.println("\n           "+key+"순으로 정렬\n------------------------");
    	for(Book temp: a) {
    		System.out.printf(temp.getName()+"  "+temp.getSerial()+"  "+temp.getDate() + "\n");
    	}
    	
    }
}
