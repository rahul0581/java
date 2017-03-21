package miniproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import miniproject.beans.Book;
import miniproject.beans.BookBorrower;
import miniproject.beans.Login;
import miniproject.beans.Register;

public class DatabaseAccessingObject {
	PreparedStatement preparedStatement;
	public static Connection returnConnection(){
		Connection connection = null;
	  try{
	  Class.forName("com.mysql.jdbc.Driver");
	  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	  
	  }catch(Exception e){
		  e.printStackTrace();
	  }
		return connection;
	}
	public int insertBookDetails(Book book){
		int i = 0;
		try{
		preparedStatement = returnConnection().prepareStatement("insert into book values(?,?,?,?,?,?,?)");
		preparedStatement.setString(1, book.getBookName());
		preparedStatement.setString(2,book.getAuthor());
		preparedStatement.setString(3,book.getPublication());
		preparedStatement.setDouble(4,Double.parseDouble(book.getPrice()));
		preparedStatement.setDouble(5,Double.parseDouble(book.getIsbn()));
		preparedStatement.setInt(6,1);
		preparedStatement.setInt(7,Integer.parseInt(book.getBookQuantity()));
		i = preparedStatement.executeUpdate();
		preparedStatement.close();
		returnConnection().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		return i;
	}
	public boolean checkLoginDetails(Login login){
		boolean flag = false;
		try{
		preparedStatement = returnConnection().prepareStatement("select*from user where user_id=? and user_password=?");
		preparedStatement.setString(1,login.getUsername());
		preparedStatement.setString(2,login.getPassword());
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next()){
			flag = true;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		if(flag){
			return true;
		}else{
			return false;
		}
		
	}
	public boolean checkUserId(String userId){
		boolean flag = false;
		try{
		preparedStatement = returnConnection().prepareStatement("select*from user where user_id=?");
		preparedStatement.setString(1,userId);
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next()){
			flag = true;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	public int insertregistrationDetails(Register register){
		int i = 0;
		try{
		preparedStatement = returnConnection().prepareStatement("insert into user values(?,?,?,?,?,?)");
		preparedStatement.setString(1,register.getUserId());
		preparedStatement.setString(2,register.getName());
		preparedStatement.setString(3,register.getAddress());
		preparedStatement.setString(4,register.getPassword());
		preparedStatement.setString(5,register.getEmail());
		preparedStatement.setDouble(6,Double.parseDouble(register.getMobileno()));
		i = preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return i;
		}
		return i;
	}
	public List<Book> returnBooks(String bookName){
		ArrayList<Book> al = new ArrayList<Book>();
		try{
		preparedStatement = returnConnection().prepareStatement("select*from book where book_name=?");
		preparedStatement.setString(1,bookName);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()){
			Book book = new Book();
			book.setBookName(rs.getString(1));
			book.setAuthor(rs.getString(2));
			book.setPublication(rs.getString(3));
			book.setPrice(rs.getString(4));
			book.setIsbn(rs.getString(5));
			book.setBookQuantity(rs.getString(7));
			al.add(book);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return al;
	}
	public boolean checkBorrower(String id,String bookName){
		boolean flag = false;
		try{
		preparedStatement = returnConnection().prepareStatement("select*from book_borrower where borrower_id=? and book_name=? and status = 1");
		preparedStatement.setString(1,id);
		preparedStatement.setString(2,bookName);
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next()){
			flag = true;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		if(flag){
			return true;
		}else{
			return false;
		}
		
	}
	public int returnBookQuantity(String bookName){
		//System.out.println(bookName);
		int quantity = 0;
		try{
		preparedStatement  = returnConnection().prepareStatement("select quantity from book where book_name=?");
		preparedStatement.setString(1,bookName);
		ResultSet rs  = preparedStatement.executeQuery();
		while(rs.next()){
			quantity  = rs.getInt("quantity");
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return quantity;
	}
	public void updateBookQuantity(int quantity,String bookName){
		try{
		preparedStatement = returnConnection().prepareStatement("update book set quantity=? where book_name=?");
		preparedStatement.setInt(1,quantity);
		preparedStatement.setString(2,bookName);
		preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public int insertBorrowerDetails(BookBorrower borrower){
		int i = 0;
		try{
		preparedStatement  = returnConnection().prepareStatement("insert into book_borrower values(?,?,?,?,?)");
		preparedStatement.setString(1,borrower.getBorrower_Id());
		preparedStatement.setString(2,borrower.getBook_Name());
		preparedStatement.setString(3,borrower.getBook_IssuedDate());;
		preparedStatement.setString(4,borrower.getBook_ReturnedDate());
		preparedStatement.setInt(5,1);
		i = preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}
	public void updateBookQuantity(String bookName){
		try{
		preparedStatement = returnConnection().prepareStatement("select quantity from book where book_name=?");
		preparedStatement.setString(1,bookName);
		ResultSet rs = preparedStatement.executeQuery();
		int number = 0;
		while(rs.next()){
			number = rs.getInt("quantity");
		}
		number = number+1;
		preparedStatement.close();
		preparedStatement = returnConnection().prepareStatement("update book set quantity=? where book_name=?");
		preparedStatement.setInt(1,number);
		preparedStatement.setString(2,bookName);
		preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public int deleteBorrower(String bookName,String userId){
		int i = 0;
		//System.out.println(bookName+"  "+userId);
		try{
		preparedStatement = returnConnection().prepareStatement("update book_borrower set status=0 where borrower_id=? and book_name=?");
		//delete from book_borrower where borrower_id=? and book_name=?
		preparedStatement.setString(1,userId);
		preparedStatement.setString(2,bookName);
		 i = preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}
	public int deleteUser(String userId){
		
		int i = 0;
		try{
		preparedStatement = returnConnection().prepareStatement("delete from user where user_id=?");
		preparedStatement.setString(1,userId);
		i = preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}
	public int deleteBook(String bookName){
		int i = 0;
		
		try{
		preparedStatement = returnConnection().prepareStatement("delete from book where book_name=?");
		preparedStatement.setString(1,bookName);
		i = preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}
	public int updateBookStatus(String bookName){
		int i = 0;
		try{
		preparedStatement = returnConnection().prepareStatement("update book set book_aorn=1 where book_name=?");
		preparedStatement.setString(1,bookName);
		i = preparedStatement.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	public boolean checkUserMail(String email){
		boolean flag = false;
		try{
		preparedStatement = returnConnection().prepareStatement("select user_email from user");
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()){
			if(email.equals(rs.getString("user_email"))){
				flag = true;
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	public List<BookBorrower> returnUserBookHistory(String username){
		List<BookBorrower> al = new ArrayList<BookBorrower>(); 
		try{
		preparedStatement = returnConnection().prepareStatement("select*from book_borrower where borrower_id=?");
		preparedStatement.setString(1,username);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()){
			BookBorrower bookBorrower = new BookBorrower();
			bookBorrower.setBorrower_Id(rs.getString(1));
			bookBorrower.setBook_Name(rs.getString(2));
			bookBorrower.setBook_IssuedDate(rs.getString(3));
			bookBorrower.setBook_ReturnedDate(rs.getString(4));
			bookBorrower.setStatus(rs.getString(5));
			al.add(bookBorrower);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return al;
	}
	public void issuedBookHistory(HttpServletRequest request){
		List<BookBorrower> borrowers = new ArrayList<BookBorrower>();
		List<String> emails = new ArrayList<String>();
		try{
		preparedStatement = returnConnection().prepareStatement("select*from book_borrower where status=1");
		//preparedStatement.setString(1,username);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()){
			BookBorrower bookBorrower = new BookBorrower();
			bookBorrower.setBorrower_Id(rs.getString(1));
			bookBorrower.setBook_Name(rs.getString(2));
			bookBorrower.setBook_IssuedDate(rs.getString(3));
			bookBorrower.setBook_ReturnedDate(rs.getString(4));
			bookBorrower.setStatus(rs.getString(5));
			
			preparedStatement = returnConnection().prepareStatement("select*from user where user_id=?");
			preparedStatement.setString(1,rs.getString(1));
			ResultSet rs1 = preparedStatement.executeQuery();
			while(rs1.next()){
				emails.add(rs1.getString(5));
			}
			//select user_email from user where user_id=?;
			borrowers.add(bookBorrower);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("emails", emails);
		request.setAttribute("borrowers",borrowers);
		
	}

}
