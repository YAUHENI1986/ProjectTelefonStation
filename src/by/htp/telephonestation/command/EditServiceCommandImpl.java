package by.htp.telephonestation.command;

import static by.htp.telephonestation.command.util.CommandConstant.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.telephonestation.logic.EditServiceLogic;
import by.htp.telephonestation.resource.ConfigurationManager;
import by.htp.telephonestation.resource.MessageManager;
import by.htp.telephonestation.service.CatalogServicesPhoneServices;
import by.htp.telephonestation.service.impl.CatalogServiceImpl;

public class EditServiceCommandImpl implements ActionCommand{
	
	private CatalogServicesPhoneServices catalogService = new CatalogServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		
		String id = request.getParameter(REQ_PARAM_ID);
		String type_list = request.getParameter(REQ_PARAM_SERVICES_TYPE);
		String status_list = request.getParameter(REQ_PARAM_SERVICES_STATUS);
		String description = request.getParameter(REQ_PARAM_SERVICES_DESCRIPTION);
		String cost_per_month = request.getParameter(REQ_PARAM_SERVICES_COST_PER_MONTH);
		
		if(EditServiceLogic.checkNullEmpty(id, type_list, status_list, description, cost_per_month)) {
			if(EditServiceLogic.checkServiceAvailability(id, cost_per_month)) {
				catalogService.editPhoneServiceById(Integer.parseInt(id), status_list, type_list, description, Double.parseDouble(cost_per_month));
				page = ConfigurationManager.getProperty("path.page.main&admin");
			} else {
				request.setAttribute("errorConsilienceService", MessageManager.getProperty("message.consilienceservice"));
				page = ConfigurationManager.getProperty("path.page.edit&service");
			}
			
		} else {
			request.setAttribute("errorDataMessage", MessageManager.getProperty("message.dataempty"));
			page = ConfigurationManager.getProperty("path.page.edit&service");
		}
		
		return page;
	}

}


//private CatalogServicesPhoneServices catalogService = new CatalogServiceImpl();
//
//@Override
//public void performAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//	
//	String id = req.getParameter(REQ_PARAM_ID);
//	String type_list = req.getParameter(REQ_PARAM_SERVICES_TYPE);
//	String status_list = req.getParameter(REQ_PARAM_SERVICES_STATUS);
//	String description = req.getParameter(REQ_PARAM_SERVICES_DESCRIPTION);
//	String cost_per_month = req.getParameter(REQ_PARAM_SERVICES_COST_PER_MONTH);
//			
//	try{
//		if(id!=null && description!=null && cost_per_month!=null && type_list!=null && status_list!=null) {
//			catalogService.editPhoneServiceById(Integer.parseInt(id), status_list, type_list, description, Double.parseDouble(cost_per_month));
//			req.getRequestDispatcher("/index.html").forward(req, resp);
//		}
//	} catch (NumberFormatException | ServletException ex) {
//		try {
//			req.getRequestDispatcher("/edit_service.jsp").forward(req, resp);
//		} catch (ServletException e) {
//			e.printStackTrace();
//		}
//	}
//	
//}