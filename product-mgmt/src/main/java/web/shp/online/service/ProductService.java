package web.shp.online.service;

import java.util.List;

import web.shp.online.dao.ProductDao;
import web.shp.online.model.Product;

public class ProductService implements AppService<Product>{
	private ProductDao dao = new ProductDao();
	
	public List<Product> list() {
		return dao.getAllProducts();
	}

	
}
