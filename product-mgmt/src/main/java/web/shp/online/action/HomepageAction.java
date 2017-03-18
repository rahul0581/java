package web.shp.online.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import web.shp.online.form.HomepageForm;

public class HomepageAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) {
		HomepageForm homepageForm = (HomepageForm) actionForm;
		homepageForm
				.setMessage("This is an application on Product management. Please click the below dashboard button to start the website.");
		return mapping.findForward("success");
	}
}
