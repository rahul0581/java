package web.shp.online.model;

import java.io.Serializable;


public class Product implements Serializable{
	private Integer id;
	private String name;
	private String brand;
	private Double price;
	private Integer rating;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String string) {
		this.name = string;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String string) {
		this.brand = string;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	 

}
