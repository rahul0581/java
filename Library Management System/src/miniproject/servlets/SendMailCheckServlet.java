package miniproject.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.Days;

import miniproject.dao.DatabaseAccessingObject;

/**
 * Servlet implementation class SendMailCheckServlet
 */
public class SendMailCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMailCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean mailStatus = false;
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(false);
		if(session.getAttribute("adminId")!=null){
		String[] emails  = request.getParameterValues("email");
		String[] returnDates = request.getParameterValues("returnDate");
		int i = 0;
		DatabaseAccessingObject dao = new DatabaseAccessingObject();
		for(String email : emails){
			String returnDate = returnDates[i];
			
			int fine = calculateFine(returnDate);
		    boolean flag = dao.checkUserMail(email);
		if(flag&&(fine>0)){
			mailStatus = true;
			//RequestDispatcher rd = request.getRequestDispatcher("sendmail.jsp");
			//rd.forward(request,response);
			sendMail(session, email,fine);
		}
		i++;
		}
			if(mailStatus){
				RequestDispatcher rd = request.getRequestDispatcher("sendmail.jsp");
				rd.forward(request,response);
			}else{
				pw.println("Users are not registered or The Return Date is not yet reached.<a href='AuthenticationServlet?cnt=4'>Issued Books</a><br><a href='Register.jsp'>Please Register</a>");
			}
		}else{
			pw.println("You have not logged in..Please login.");
			RequestDispatcher rd1 = request.getRequestDispatcher("admin1.jsp");
			rd1.include(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void sendMail(HttpSession session,String email,int fine){

		   /*String result;
		   // Recipient's email ID needs to be mentioned.
		   
		   String to = email;
		   

		   // Sender's email ID needs to be mentioned
		   String from = (String)session.getAttribute("smid");//(String)request.getParameter("efrom");
			//String frompassword=(String)request.getParameter("epassword");
		   // Assuming you are sending emai1l from localhost
		   String host = "smtp.gmail.com";
		   
		   final String username = (String)session.getAttribute("smid");//(String)request.getParameter("efrom");
			final String password = (String)session.getAttribute("smpd");//(String)request.getParameter("epassword");
			System.out.println(username);
			System.out.println(password);
		   // Get system properties object
		   Properties properties = System.getProperties();

		   // Setup mail server
		   properties.setProperty("mail.smtp.host", host);
		   properties.put("mail.smtp.auth", "true");
		   properties.put("mail.smtp.starttls.enable", "true");
		   //properties.put("mail.smtp.host", "smtp.gmail.com");
		   properties.put("mail.smtp.port", "587");
		   // Get the default Session object.
		   Session mailSession = Session.getInstance(properties,
					  new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username,password);
						}
					  });

		   try{
		      // Create a default MimeMessage object.
		      MimeMessage message = new MimeMessage(mailSession);
		      // Set From: header field of the header.
		      message.setFrom(new InternetAddress(from));
		      // Set To: header field of the header.
		      message.addRecipient(Message.RecipientType.TO,
		                               new InternetAddress(to));
		      // Set Subject: header field
		      message.setSubject((String)session.getAttribute("ssub"));//(request.getParameter("subject1"));
		      // Now set the actual message
		      //message.setText((String)session.getAttribute("smsg"));//(request.getParameter("message1"));
		      message.setText("Dear User, your date to return book has passed. please return your book with the fine amount of "+fine+"Rs. Thanking You, Administrator");
		      // Send message
		      
		      Transport.send(message);
		      //result = "Sent message successfully....";
		      //out.println(result);
		   }
		   catch(MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		      //out.println(mex);
		   }*/
		   Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		Session session1 = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
						return new javax.mail.PasswordAuthentication("librarymessage123@gmail.com","librarian123");
					}
				});
		try {
			 
			Message message = new MimeMessage(session1);
			message.setFrom(new InternetAddress("librarymessage123@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject("Testing Subject");
			message.setText("Dear User, your date to return book has passed. please return your book with the fine amount of "+fine+"Rs. Thanking You, Administrator");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
		System.out.println("Message sent");

		    
	}
	public int calculateFine(String returnDate){
		Date d = new Date();
		int  fine = 0;
		int days = 0;
		SimpleDateFormat s1 = new SimpleDateFormat("yyyy");
		int yy1 = Integer.parseInt(s1.format(d));
		
		SimpleDateFormat s2 = new SimpleDateFormat("MM");
		int mm1 = Integer.parseInt(s2.format(d));
		SimpleDateFormat s3 = new SimpleDateFormat("dd");
		int dd1 = Integer.parseInt(s3.format(d));
		String currentDate = yy1 + "." + mm1 + "."+ dd1;
		//System.out.println(currentDate);
		//String returnDate = "2014.4.24";
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		Date d1 = null;
		Date d2 = null;
		try{
			d1 = format.parse(returnDate);
			d2 = format.parse(currentDate);
			DateTime dt1 = new DateTime(d1);
			DateTime dt2 = new DateTime(d2);
			days = Days.daysBetween(dt1,dt2).getDays();
			//fine = 0;
			//System.out.print(Days.daysBetween(dt1, dt2).getDays() + " days, ");
			if(days>0){
				fine = 2*days;
				System.out.println("Days : "+days);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("Fine is :"+fine);
		//System.out.println("days are :"+days);
		return fine;
	}

}
