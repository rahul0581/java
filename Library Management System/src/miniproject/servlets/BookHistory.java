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
 * Servlet implementation class BookHistory
 */
public class BookHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookHistory() {
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
		if(session.getAttribute("username")!=null){
		String userName = (String)session.getAttribute("username");
		DatabaseAccessingObject dao = new DatabaseAccessingObject();
		List<BookBorrower> l = dao.returnUserBookHistory(userName);
		request.setAttribute("bookHistory",l);
		RequestDispatcher rd = request.getRequestDispatcher("userBookHistory.jsp");
		rd.forward(request,response);
		}
		else{
			pw.println("<center>Please Login..</center>");
			RequestDispatcher rd = request.getRequestDispatcher("LoginForm.jsp");
			rd.include(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
