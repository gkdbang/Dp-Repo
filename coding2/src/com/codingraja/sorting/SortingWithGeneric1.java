package com.codingraja.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Book implements Comparable<Book>{
	
	int bookId;
	String bookName,authorName;
	int bookQuantity;
	double bookPrice;
	
	public Book() {
		
	}
	
	public Book(int bookId, String bookName, String authorName,
			int bookQuantity, double bookPrice) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookQuantity = bookQuantity;
		this.bookPrice = bookPrice;
	}
	
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName
				+ ", authorName=" + authorName + ", bookQuantity="
				+ bookQuantity + ", bookPrice=" + bookPrice + "]";
	}

	@Override
	public int compareTo(Book book) {
		
		if(bookId<book.bookId)
			return -1;
		else if(bookId>book.bookId)
			return +1;
		return 0;
	}	
}

public class SortingWithGeneric1 {

	public static void main(String[] args) {
		
			ArrayList<Book> al=new ArrayList<Book>();
			al.add(new Book(102,"Java","Nagesh Rao",10,540.80));
			al.add(new Book(103,"Testing","Venkatesh Reddy",5,330.7f));
			al.add(new Book(101,"Oracle","Dinesh",8,405));
			Collections.sort(al);
			System.out.println("Ascending Order Book Id : ");
			for(Book book:al){
				System.out.println(book);
			}
			System.out.println("==================================================================");
			ArrayList<Book> al2=new ArrayList<Book>();
			al2.add(new Book(102,"Java","Nagesh Rao",10,540.80));
			al2.add(new Book(103,"Testing","Venkatesh Reddy",5,330.7f));
			al2.add(new Book(101,"Oracle","Dinesh",8,405));
			Collections.sort(al2,new BookIdComparator());
			System.out.println("Descending Order of Book Id : ");
			for(Book book:al2){
				System.out.println(book);
			}
			System.out.println("==================================================================");
			ArrayList<Book> al3=new ArrayList<Book>();
			al3.add(new Book(102,"Java","Nagesh Rao",10,540.80));
			al3.add(new Book(103,"Testing","Venkatesh Reddy",5,330.7f));
			al3.add(new Book(101,"Oracle","Dinesh",8,405));
			Collections.sort(al3,new BookQuantityComparator());
			System.out.println("Ascending Order of Book Quantity : ");
			for(Book book:al3){
				System.out.println(book);
			}
			System.out.println("==================================================================");
			ArrayList<Book> al4=new ArrayList<Book>();
			al4.add(new Book(102,"Java","Nagesh Rao",10,540.80));
			al4.add(new Book(103,"Testing","Venkatesh Reddy",5,330.7f));
			al4.add(new Book(101,"Oracle","Dinesh",8,405));
			Collections.sort(al4,new BookAuthorNameComparator());
			System.out.println("Alphabetical Order of Author Name : ");
			for(Book book:al4){
				System.out.println(book);
			}
	}
}
class BookIdComparator implements Comparator<Book>{

	@Override
	public int compare(Book book1, Book book2) {
		Integer id1 =book1.bookId;
		Integer id2 =book2.bookId;
		return id2.compareTo(id1);
	}	
}
class BookQuantityComparator implements Comparator<Book>{

	@Override
	public int compare(Book book1, Book book2) {
		Integer quantity1 =book1.bookQuantity;
		Integer quantity2 =book2.bookQuantity;
		return quantity1.compareTo(quantity2);
	}	
}
class BookAuthorNameComparator implements Comparator<Book>{

	@Override
	public int compare(Book book1, Book book2) {
		String authorName1 =book1.authorName;
		String authorName2 =book2.authorName;
		return authorName1.compareTo(authorName2);
	}	
}

