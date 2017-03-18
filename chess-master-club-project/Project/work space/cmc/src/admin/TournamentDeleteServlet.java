package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DataBase;

/**
 * Servlet implementation class TournamentDeleteServlet
 */
public class TournamentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TournamentDeleteServlet() {
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
		
		HttpSession session=request.getSession();
		String tid=(String)session.getAttribute("tid");
				
		try {
			System.out.println(tid);	
			int i=db.deleteTournament(tid);
			if(i==1)
			{
			out.println("Tournament Deleted Succusfully");
			}
			else
			{
				out.println("Tournament failed to delete");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println("Failed");
			e.printStackTrace();
		}
	}

}
