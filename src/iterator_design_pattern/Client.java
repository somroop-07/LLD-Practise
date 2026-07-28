package iterator_design_pattern;

import java.util.ArrayList;
import java.util.List;

public class Client {
     public static void main(String[] args) {
		Library library = new Library();
		library.addBook(new Book("abc", "xyz"));
		library.addBook(new Book("dfdsf", "fddf"));
		
		Iterator<Book> iterator = library.iterator();		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	} 
}

interface Iterator<T> {
	boolean hasNext();
	T next();
}

interface Collection<T> {
	Iterator<T> iterator();
}

class Book {
	String bookName;
	String authorName;
	public Book(String bookName, String authorName) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
	}
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", authorName=" + authorName + "]";
	}
	
	
	
}

class BookIterator implements Iterator<Book> {
	
	List<Book> books;
	private int idx = 0;

	public BookIterator(List<Book> books) {
		super();
		this.books = books;
	}

	@Override
	public boolean hasNext() {
		if(idx >= books.size()) {
			return false;
		}
		return true;
	}

	@Override
	public Book next() {
		if(hasNext()) {
			return books.get(idx++);
		}
		return null;
	}
	
}

class Library implements Collection<Book>{

	List<Book> books = new ArrayList<>();
	
     public void addBook(Book book) {
    	 books.add(book);
     }
	@Override
	public Iterator<Book> iterator() {
		return new BookIterator(books);
	}
	
}
