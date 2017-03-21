package miniproject.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniproject.beans.BookBorrower;
import miniproject.dao.DatabaseAccessingObject;

/**
 * Servlet implementation class ConfirmBookOrderServlet
 */
public class ConfirmBookOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmBookOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		
		DatabaseAccessingObject dao = new DatabaseAccessingObject();
		boolean flag = false;
		RequestDispatcher rd1 = request.getRequestDispatcher("confirmbookorder.jsp");
		RequestDispatcher rd2 = request.getRequestDispatcher("LoginForm.jsp");
		
		if(session.getAttribute("username")!=null){
			String userId = (String)session.getAttribute("username");
			String bookName = (String)session.getAttribute("bookName");
			flag = dao.checkBorrower(userId, bookName);
			if(flag){
			out.println("<img src=rb.png><br>");
			out.println("you have already taken this book once. you cannot take more copies.");
			out.println("<a href=LoginForm.jsp> Please Logout</a><br><a href='Home'>Home</a><br><a href='BookHistory'>Book History</a>");
			return;
			}else{
				int quantity = dao.returnBookQuantity(bookName);
				if(quantity==0){

					out.println("<img src=rb.png><br>");
					out.println("all books are borrowed by users. no book for you");
					out.println("<a href=LoginForm.jsp> Please Logout</a><br><a href='Home'>Home</a><br><a href='BookHistory'>Book History</a>");
					return;
				}else{
					quantity = quantity-1;
					dao.updateBookQuantity(quantity, bookName);
				}
			}
			String issuedDate =  (String)session.getAttribute("issuedDate");
			String returnDate = (String)session.getAttribute("returnDate");
			BookBorrower bookBorrower = new BookBorrower();
			bookBorrower.setBook_IssuedDate(issuedDate);
			bookBorrower.setBook_Name(bookName);
			bookBorrower.setBook_ReturnedDate(returnDate);
			bookBorrower.setBorrower_Id(userId);
			int i = dao.insertBorrowerDetails(bookBorrower);
			if(i>0){
				rd1.forward(request,response);
			}else{
				out.println("<center>Something went Wrong</center>");
				rd2.include(request,response);
			}
			
		}else{
			out.println("<center>You have not logged in.Please login..</center>");
			rd2.include(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
