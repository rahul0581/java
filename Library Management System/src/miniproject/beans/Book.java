package miniproject.beans;

public class Book {
	private String bookName;
	
	private String author;
	private String publication;
	private String price;
	private String isbn;
	private String bookQuantity;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookQuantity() {
		return bookQuantity;
	}
	public void setBookQuantity(String bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
	
}
