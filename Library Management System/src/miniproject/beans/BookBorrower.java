package miniproject.beans;

public class BookBorrower {
	private String borrower_Id;
	private String book_Name;
	private String book_IssuedDate;
	private String book_ReturnedDate;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBorrower_Id() {
		return borrower_Id;
	}
	public void setBorrower_Id(String borrower_Id) {
		this.borrower_Id = borrower_Id;
	}
	public String getBook_Name() {
		return book_Name;
	}
	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}
	public String getBook_IssuedDate() {
		return book_IssuedDate;
	}
	public void setBook_IssuedDate(String book_IssuedDate) {
		this.book_IssuedDate = book_IssuedDate;
	}
	public String getBook_ReturnedDate() {
		return book_ReturnedDate;
	}
	public void setBook_ReturnedDate(String book_ReturnedDate) {
		this.book_ReturnedDate = book_ReturnedDate;
	}

}
