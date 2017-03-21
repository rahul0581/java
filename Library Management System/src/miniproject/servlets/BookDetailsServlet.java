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

import miniproject.beans.Book;
import miniproject.dao.DatabaseAccessingObject;

/**
 * Servlet implementation class BookDetailsServlet
 */
public class BookDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDetailsServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(false);
		if(session.getAttribute("username")!=null){
		session.setAttribute("bookName",request.getParameter("bname"));
		DatabaseAccessingObject dao = new DatabaseAccessingObject();
		List<Book> list = dao.returnBooks(request.getParameter("bname"));
		request.setAttribute("bookDetails",list);
		RequestDispatcher rd = request.getRequestDispatcher("bookdetailsx.jsp");
		rd.forward(request,response);
		}else{
			pw.println("<center>Please Login..</center>");
			RequestDispatcher rd1 = request.getRequestDispatcher("LoginForm.jsp");
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
