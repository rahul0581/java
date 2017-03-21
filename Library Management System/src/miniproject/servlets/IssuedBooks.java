package miniproject.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniproject.beans.BookBorrower;
import miniproject.dao.DatabaseAccessingObject;

/**
 * Servlet implementation class IssuedBooks
 */
public class IssuedBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssuedBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(false);
		
		if(session.getAttribute("adminId")!=null){
			DatabaseAccessingObject dao = new DatabaseAccessingObject();
			dao.issuedBookHistory(request);
			RequestDispatcher rd = request.getRequestDispatcher("issuedBooks.jsp");
			rd.forward(request,response);
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
