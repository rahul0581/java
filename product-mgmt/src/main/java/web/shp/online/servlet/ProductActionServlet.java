package web.shp.online.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionServlet;

public class ProductActionServlet extends ActionServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String action = request.getServletPath();
		//String KEY = request.getParameter("KEY");
		String KEY = "PRDMGMT";
		if("PRDMGMT".equals(KEY)|| action.contains("homepage") ){
			
		
		super.doGet(request, response);
		}else{
			response.getWriter().write("UNAUTHORIZED ACCESS");
		}
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String KEY = "PRDMGMT";
		if("PRDMGMT".equals(KEY)){
			
		
		super.doPost(request, response);
		}else{
			response.getWriter().write("UNAUTHORIZED ACCESS");
		}
		
	}

	
}
