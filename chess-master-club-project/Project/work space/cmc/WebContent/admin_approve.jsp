<%@page import="database.DataBase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

   String emailid=request.getParameter("emailid");
   DataBase db=new DataBase();
   try {
		//int i=db.approveTournamentPlayer("Approved",emailid);
		//if(i==1)
		{
		out.println("Player Approved");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		out.println("Player not Approved");
		e.printStackTrace();
	}

%>