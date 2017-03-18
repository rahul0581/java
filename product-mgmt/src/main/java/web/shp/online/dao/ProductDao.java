package web.shp.online.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import web.shp.online.model.Product;





public class ProductDao extends AppDAO {
	
	
	
	//Statement stmt = null;
	ResultSet rs = null ;
	
	public void createProduct(Product product){
		try {	
		
			Connection con = getConnection();
		 PreparedStatement stmt = con.prepareStatement("Insert INTO id,name,brand,price from product"); 
		 
		}catch (Exception e) {

			System.out.println("Not Connected");
			e.printStackTrace();
		}
		
	}
	
	
	public List<Product> getAllProducts(){
		
		List<Product> result = new ArrayList<Product>();
		try {
			
			
			Connection	con = getConnection();
			System.out.println("Connected");
		Statement stmt = con.createStatement();
			 rs = stmt.executeQuery("select id,name,brand,price,rating from shp.product");
			 
			 Product p;
			 while(rs.next()){
				 
				 p = new Product();
				 p.setId(rs.getInt(1));
				 p.setName(rs.getString(2));
				 p.setBrand(rs.getString(3));
				 p.setPrice(rs.getDouble(4));
				 p.setRating(rs.getInt(4));
				 result.add(p);
				// System.out.println(p);
			 }
			 
			}catch (Exception e) {

				System.out.println("Not Connected");
				e.printStackTrace();
			}
			
		
		return result;
	}


}
