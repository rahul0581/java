package web.shp.online.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;




public class ProductForm extends ActionForm {

	
	private String name;
	private String brand;
	private Double price;
	private Integer rating;
	
	
	
	

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.name = null;
		this.brand =null;
		this.price = null;
		this.rating=null;
	}
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if(name == null || name.length()<5){
			errors.add("Invalid NAme",new ActionMessage("error.name.invalid"));
		}
		return errors;
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
