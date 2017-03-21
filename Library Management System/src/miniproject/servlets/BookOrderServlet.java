package miniproject.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BookOrderServlet
 */
public class BookOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookOrderServlet() {
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
		if(session.getAttribute("username")!=null){
			Date d = new Date();
			SimpleDateFormat s1 = new SimpleDateFormat("yyyy");
			int yy1 = Integer.parseInt(s1.format(d));
			
			SimpleDateFormat s2 = new SimpleDateFormat("MM");
			int mm1 = Integer.parseInt(s2.format(d));
			SimpleDateFormat s3 = new SimpleDateFormat("dd");
			int dd1 = Integer.parseInt(s3.format(d));
			String currentDate = yy1 + "." + mm1 + "."+ dd1;
			SimpleDateFormat ftt = new SimpleDateFormat ("dd");
			int d1=Integer.parseInt(ftt.format(d));
			d1=d1+7;
			SimpleDateFormat ftt3=new SimpleDateFormat("MM");
			int m=Integer.parseInt(ftt3.format(d));
			SimpleDateFormat ftt2=new SimpleDateFormat("yyyy");
			int y=Integer.parseInt(ftt2.format(d));
			if(d1>=31)
			{
				d1=5;
				if(m==12)
				{m=1;
				y=y+1;
				}
				else
				{
					m=m+1;
				}
				
			}
	        String seventhDay=y + "." + m + "." + d1;
	        session.setAttribute("issuedDate",currentDate);
	        session.setAttribute("returnDate",seventhDay);
	        RequestDispatcher rd = request.getRequestDispatcher("bookorder.jsp");
	        rd.forward(request,response);
		}
		else{
			pw.println("<center>Please Login..</center>");
			RequestDispatcher rd = request.getRequestDispatcher("LoginForm.jsp");
			rd.include(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
