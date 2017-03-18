package web.shp.online.form;

import org.apache.struts.action.ActionForm;

import web.shp.online.model.Product;

import java.util.List;


public class ProductListForm extends ActionForm {

	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
