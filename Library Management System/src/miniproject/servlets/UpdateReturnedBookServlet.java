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
 * Servlet implementation class UpdateReturnedBookServlet
 */
public class UpdateReturnedBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReturnedBookServlet() {
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
			String bookName = request.getParameter("bookName");
			DatabaseAccessingObject dao = new DatabaseAccessingObject();
			int i = dao.updateBookStatus(bookName);
			if(i>0){
				pw.println("Book status is updated");
			}else{
				pw.println("Book status is not updated");
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
