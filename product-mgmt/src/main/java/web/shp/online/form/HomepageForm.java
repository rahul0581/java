package web.shp.online.form;

import org.apache.struts.action.ActionForm;

public class HomepageForm extends ActionForm {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
