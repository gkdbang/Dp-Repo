package com.codingraja.sorting;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeMap;

class Book3 implements Comparable<Book3>{
	
	int bookId;
	String bookName,authorName;
	int bookQuantity;
	double bookPrice;
	
	public Book3() {
		
	}
	
	public Book3(int bookId, String bookName, String authorName,
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
	
	public int compareTo(Book3 book){
		if(bookId<book.bookId)
			return -1;
		else if(bookId>book.bookId)
			return +1;
		return 0;
	}
}

public class SortingWithGeneric3 {

	public static void main(String[] args) {
		
			TreeMap<Book3,String> tm=new TreeMap<Book3,String>();
			tm.put(new Book3(102,"Java","Nagesh Rao",10,540.80),"Black Book");
			tm.put(new Book3(103,"Testing","Venkatesh Reddy",5,330.7f),"Sun Publications");
			tm.put(new Book3(101,"Oracle","Dinesh",8,405),"Mc Hill");
			
			System.out.println("Sorting Based on Id key : ");
			for(Entry<Book3,String> entry:tm.entrySet()){
				System.out.println(entry);
			}
			System.out.println("==================================================================");
			TreeMap<Book3,String> tm2=new TreeMap<Book3,String>(new BookPriceComparator());
			tm2.put(new Book3(102,"Java","Nagesh Rao",10,540.80),"Black Book");
			tm2.put(new Book3(103,"Testing","Venkatesh Reddy",5,330.7f),"Sun Publications");
			tm2.put(new Book3(101,"Oracle","Dinesh",8,405),"Mc Hill");
			
			System.out.println("Sorting Based on Price key : ");
			for(Entry<Book3,String> entry:tm2.entrySet()){
				System.out.println(entry);
			}
	}
}
class BookPriceComparator implements Comparator<Book3>{

	@Override
	public int compare(Book3 book1, Book3 book2) {
		
		return ((Double)book2.bookPrice).compareTo((Double)(book1.bookPrice));
	}
	
}

