package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.xml.rpc.ServiceException;

import database.DataBase;

/**
 * Servlet implementation class TournamentPlayerServlet
 */
public class TournamentPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TournamentPlayerServlet() {
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
		String emailid=request.getParameter("emailid");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String age=request.getParameter("age");
		String gender=request.getParameter("gender");
		
		try {
			int i=db.addTournamentPlayer(emailid, name, password, age, gender);
			if(i==1)
			{
			try {
				//Email email=new EmailServiceLocator().getEmail();
				//email.sendEmail(emailid, "Thank You for Registering with Us \n Your Name is : "+name+"\nYour Password is : "+password);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			out.println("Registered Succusfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println("Registration Failed");
			e.printStackTrace();
		}
	}

}
