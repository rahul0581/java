package web.shp.online.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import web.shp.online.form.HomepageForm;
import web.shp.online.form.ProductListForm;
import web.shp.online.model.Product;
import web.shp.online.service.AppService;
import web.shp.online.service.ProductService;

public class ProductListAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) {
		ProductListForm productListForm = (ProductListForm) actionForm;
		AppService<Product> service = new ProductService();
		List<Product> productList = service.list();
		productListForm.setProducts(productList);
		if(productList != null && productList.size()>0){
		return mapping.findForward("success");
		}else{
			return mapping.findForward("error");
		}
	}
}
