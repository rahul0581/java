package miniproject.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniproject.beans.Register;
import miniproject.dao.DatabaseAccessingObject;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String mobileno = request.getParameter("mobileno");
		Register register = new Register();
		register.setUserId(userId);
		register.setName(name);
		register.setAddress(address);
		register.setPassword(password);
		register.setEmail(email);
		register.setMobileno(mobileno);
		DatabaseAccessingObject dao = new DatabaseAccessingObject();
		boolean flag = dao.checkUserId(request.getParameter("userId"));
		RequestDispatcher rd1 = request.getRequestDispatcher("Register.jsp");
		RequestDispatcher rd2 = request.getRequestDispatcher("LoginForm.jsp");
		int i = 0;
		if(!flag){
			i = dao.insertregistrationDetails(register);
		}else{
			pw.println("UserID is already Exists.Please enter Another UserID");
			rd1.include(request,response);
			return;
		}
		if(i>0){
			pw.println("Registration Completed Successfully.Please Login..");
			rd2.include(request,response);
		}else{
			pw.println("Registration not completed.Please regidter Again..");
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
