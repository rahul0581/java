package miniproject.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniproject.beans.Book;
import miniproject.dao.DatabaseAccessingObject;

/**
 * Servlet implementation class BookInsertServlet
 */
public class BookInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int i = 0;
		HttpSession session = request.getSession(false);
		if(session.getAttribute("adminId")!=null){
		String bookName = request.getParameter("bookName");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String publication = request.getParameter("publication");
		String bookQuantity = request.getParameter("bookQuantity");
		String isbn = request.getParameter("isbn");
		Book book = new Book();
		book.setAuthor(author);
		book.setBookName(bookName);
		book.setIsbn(isbn);
		book.setPrice(price);
		book.setPublication(publication);
		book.setBookQuantity(bookQuantity);
		DatabaseAccessingObject dao = new DatabaseAccessingObject();
		 i = dao.insertBookDetails(book);
		 if(i>0){
			 pw.println("Book Added Successfully");
			 RequestDispatcher rd1 = request.getRequestDispatcher("addnewbook.jsp");
			 rd1.include(request,response);
		 }else{
			 pw.println("Book is not added");
			 RequestDispatcher rd2 = request.getRequestDispatcher("addnewbook.jsp");
			 rd2.include(request,response);
		 }
		}else{
			pw.println("You have not logged in..Please login.");
			RequestDispatcher rd1 = request.getRequestDispatcher("admin1.jsp");
			rd1.include(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
