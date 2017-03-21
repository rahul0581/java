package miniproject.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniproject.dao.DatabaseAccessingObject;

/**
 * Servlet implementation class DeleteBookServlet
 */
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookServlet() {
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
			String bookName = request.getParameter("deleteid");
			DatabaseAccessingObject dao = new DatabaseAccessingObject();
			int i = dao.deleteBook(bookName);
			if(i>0){
				pw.println("<img src=delete.png><br>");
				pw.println("Book deleted");
				RequestDispatcher rd2 = request.getRequestDispatcher("deletebook.jsp");
				rd2.include(request,response);
			}else{
				pw.println("Book is not deleted");

				RequestDispatcher rd3 = request.getRequestDispatcher("deletebook.jsp");
				rd3.include(request,response);
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
