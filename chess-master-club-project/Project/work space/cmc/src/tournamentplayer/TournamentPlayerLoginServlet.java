package tournamentplayer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.TournamentDao;

import database.DataBase;

/**
 * Servlet implementation class TournamentPlayerLoginServlet
 */
public class TournamentPlayerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TournamentPlayerLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		 PrintWriter out=response.getWriter();

		String a = request.getParameter("un");
		String b = request.getParameter("pw");
		DataBase db = new DataBase();
		List<TournamentDao> l = new ArrayList<TournamentDao>();
		try {

			l = db.tLogin(a);
			System.out.println(l);
			if (l.isEmpty()) {
				out.println("ERROR");
				//response.sendRedirect("index1.jsp");
			}
			// System.out.println(l.get(0).getPassword());

			else {
				if (a.equals(l.get(0).getEmailID())
						&& b.equals(l.get(0).getPassword())) {
					//response.sendRedirect("tplayerlogin.html");
					out.println("SUCCESS");
				} else {
					//System.out.println("please enter the correct login details");
					//response.sendRedirect("index1.jsp");
					out.println("ERROR");
					
				}

			}

			// db.connect();

			// System.out.println("db.");

		} catch (Exception e) {
			out.println("ERROR");
			e.printStackTrace();
		}

	}

}
