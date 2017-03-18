<%@page import="database.DataBase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
         String emailid=request.getParameter("user");
         System.out.println(emailid);
         DataBase db=new DataBase();
         if(db.checkTournamentPlayerEmailID(emailid))
         {
        	 out.print("<font color=green>Email ID already exist</font>");
         }
         else
         {
        	 out.println("<font color=green>OK</font>");
         }
    
    %>
