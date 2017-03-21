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
 * Servlet implementation class ReturnBookServlet
 */
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		RequestDispatcher rd1  = request.getRequestDispatcher("admin1.jsp");
		HttpSession session = request.getSession(false);
		if(session.getAttribute("adminId")!=null){
		String userId = request.getParameter("userid");
		String bookName = request.getParameter("bookName");
		DatabaseAccessingObject dao = new DatabaseAccessingObject();
		dao.updateBookQuantity(bookName);
		int i = dao.deleteBorrower(bookName, userId);
		RequestDispatcher rd  = request.getRequestDispatcher("returnbook2.jsp");
		if(i>0){
			rd.forward(request,response);
		}
		}else{
			pw.println("You have not logged in.Please Login...");
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
