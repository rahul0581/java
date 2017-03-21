package miniproject.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuthenticationServlet
 */
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationServlet() {
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
			int cnt = Integer.parseInt(request.getParameter("cnt"));
		
		switch(cnt){
			case 1 : 
			RequestDispatcher rd1 = request.getRequestDispatcher("updatereturnedbookstatus.jsp");
			rd1.forward(request, response);
			break;
			case 2 : 
				RequestDispatcher rd2 = request.getRequestDispatcher("checkavailablebooks.jsp");
				rd2.forward(request,response);
				break;
			case 3 : 
				RequestDispatcher rd3 = request.getRequestDispatcher("checkregisteredusers.jsp");
				rd3.forward(request,response);
				break;
			case 4 : 
				RequestDispatcher rd4 = request.getRequestDispatcher("/IssuedBooks");
				//sendmailtouser.jsp
				rd4.forward(request,response);
				break;
			case 5 : 
				RequestDispatcher rd5 = request.getRequestDispatcher("deleteusers.jsp");
				rd5.forward(request,response);
				break;
			case 6 : 
				RequestDispatcher rd6 = request.getRequestDispatcher("returnbook.jsp");
				rd6.forward(request,response);
				break;
			case 7 : 
				RequestDispatcher rd7 = request.getRequestDispatcher("addnewbook.jsp");
				rd7.forward(request,response);
				break;
			case 8 :
				RequestDispatcher rd8 = request.getRequestDispatcher("deletebook.jsp");
				rd8.forward(request,response);
				break;
		}
		}else{
			pw.println("<center>Please login..</center>");
			RequestDispatcher rd9 = request.getRequestDispatcher("admin1.jsp");
			rd9.include(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
