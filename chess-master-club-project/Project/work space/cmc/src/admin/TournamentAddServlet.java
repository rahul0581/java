package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DataBase;

/**
 * Servlet implementation class TournamentAddServlet
 */
public class TournamentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TournamentAddServlet() {
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
		String tid=request.getParameter("tid");
		String tname=request.getParameter("tname");
		String date=request.getParameter("date");
		String venu=request.getParameter("venu");
				
		try {
			int i=db.addTournament(tid, tname, date, venu);
			if(i==1)
			{
			out.println("Tournament Added Succusfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println("Failed");
			e.printStackTrace();
		}
	}

}
