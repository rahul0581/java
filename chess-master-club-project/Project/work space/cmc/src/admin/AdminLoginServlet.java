package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AdminDao;

import database.DataBase;

/**
 * Servlet implementation class AdminLoginServlet
 */


public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<AdminDao> l=new ArrayList<AdminDao>();
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		//PrintWriter out=response.getWriter();
		
		String a=request.getParameter("user");
		String b=request.getParameter("pass");
		DataBase db=new DataBase();
		try{
			
			l=db.adminLogin();
			//System.out.println(l.get(0).getPassword());
		
			if(a.equals(l.get(0).getUsername())&& b.equals(l.get(0).getPassword()))
					{
			response.sendRedirect("adminlogin.html");	
			}
			else
			{
				response.sendRedirect("index.jsp");
			}
			
			//db.connect();

			//System.out.println("db.");
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

}
}
