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
 * Servlet implementation class AdminADDServlet
 */
public class AdminAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<AdminDao> l=new ArrayList<AdminDao>();
	AdminDao dao=new AdminDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		PrintWriter out=response.getWriter();
		String a=request.getParameter("user");
		String b=request.getParameter("tlevel");
		String c=request.getParameter("trating");
		String d=request.getParameter("tposition");
		DataBase db=new DataBase();
try{
			
	int l=db.AdminAdd(a,b,c,d);
			
	if(l==1)
			{
		//response.sendRedirect("adminadd.html");	
		
		out.println("inserted");
		
			}
	else{
		out.println("not inserted");
	}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

}
	
}

