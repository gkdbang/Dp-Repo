package com.codingraja.sorting;

import java.util.Comparator;
import java.util.TreeSet;

class Book2 implements Comparable<Book2>{
	
	int bookId;
	String bookName,authorName;
	int bookQuantity;
	double bookPrice;
	
	public Book2() {
		
	}
	
	public Book2(int bookId, String bookName, String authorName,
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
	public int compareTo(Book2 book) {
		
		if(bookId<book.bookId)
			return -1;
		else if(bookId>book.bookId)
			return +1;
		return 0;
	}	
}

public class SortingWithGeneric2 {

	public static void main(String[] args) {
		
			TreeSet<Book2> ts=new TreeSet<Book2>();
			ts.add(new Book2(102,"Java","Nagesh Rao",10,540.80));
			ts.add(new Book2(103,"Testing","Venkatesh Reddy",5,330.7f));
			ts.add(new Book2(101,"Oracle","Dinesh",8,405));
			
			System.out.println("Ascending Order Book Id : ");
			for(Book2 book:ts){
				System.out.println(book);
			}
			System.out.println("==================================================================");
			TreeSet<Book2> ts2=new TreeSet<Book2>(new BookIdComparator2());
			ts2.add(new Book2(102,"Java","Nagesh Rao",10,540.80));
			ts2.add(new Book2(103,"Testing","Venkatesh Reddy",5,330.7f));
			ts2.add(new Book2(101,"Oracle","Dinesh",8,405));

			System.out.println("Descending Order of Book Id : ");
			for(Book2 book:ts2){
				System.out.println(book);
			}
			System.out.println("==================================================================");
			TreeSet<Book2> ts3=new TreeSet<Book2>(new BookQuantityComparator2());
			ts3.add(new Book2(102,"Java","Nagesh Rao",10,540.80));
			ts3.add(new Book2(103,"Testing","Venkatesh Reddy",5,330.7f));
			ts3.add(new Book2(101,"Oracle","Dinesh",8,405));
			
			System.out.println("Ascending Order of Book Quantity : ");
			for(Book2 book:ts3){
				System.out.println(book);
			}
			System.out.println("==================================================================");
			TreeSet<Book2> ts4=new TreeSet<Book2>(new BookAuthorNameComparator2());
			ts4.add(new Book2(102,"Java","Nagesh Rao",10,540.80));
			ts4.add(new Book2(103,"Testing","Venkatesh Reddy",5,330.7f));
			ts4.add(new Book2(101,"Oracle","Dinesh",8,405));
			
			System.out.println("Alphabetical Order of Author Name : ");
			for(Book2 book:ts4){
				System.out.println(book);
			}
	}
}
class BookIdComparator2 implements Comparator<Book2>{

	@Override
	public int compare(Book2 book1, Book2 book2) {
		return ((Integer)book2.bookId).compareTo(((Integer)book1.bookId));
	}	
}
class BookQuantityComparator2 implements Comparator<Book2>{

	@Override
	public int compare(Book2 book1, Book2 book2) {
		return -((Integer)book2.bookQuantity).compareTo(((Integer)book1.bookQuantity));
	}	
}
class BookAuthorNameComparator2 implements Comparator<Book2>{

	@Override
	public int compare(Book2 book1, Book2 book2) {
		return ((book1.authorName).compareTo(book2.authorName));
	}	
}

