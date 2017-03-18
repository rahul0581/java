package funPlayer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DataBase;

/**
 * Servlet implementation class AddFQueryServlet
 */
public class AddFQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
		protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			DataBase db=new DataBase();
			PrintWriter out=response.getWriter();
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String sub=request.getParameter("sub");
			String query=request.getParameter("query");
							
			try {
				int i=db.addFQuery(name,email,sub,query);
				if(i==1)
				{
				out.println("Query submitted Succusfully");
				//response.sendRedirect("contact.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				out.println("Failed");
				e.printStackTrace();
			}
		}
}
