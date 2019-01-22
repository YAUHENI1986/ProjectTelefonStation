package by.htp.telephonestation.command;

import static by.htp.telephonestation.command.util.CommandConstant.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.telephonestation.logic.AddServiceLogic;
import by.htp.telephonestation.resource.ConfigurationManager;
import by.htp.telephonestation.resource.MessageManager;
import by.htp.telephonestation.service.CatalogServicesPhoneServices;
import by.htp.telephonestation.service.impl.CatalogServiceImpl;

public class AddServiceCommandImpl implements ActionCommand{
	
	private CatalogServicesPhoneServices catalogService = new CatalogServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		
		String type_list = request.getParameter(REQ_PARAM_SERVICES_TYPE);
		String status_list = request.getParameter(REQ_PARAM_SERVICES_STATUS);
		String description = request.getParameter(REQ_PARAM_SERVICES_DESCRIPTION);
		String cost_per_month = request.getParameter(REQ_PARAM_SERVICES_COST_PER_MONTH);
		
		if(AddServiceLogic.checkNullEmptyLogin(type_list, status_list, description, cost_per_month)) {
			catalogService.addPhoneService(status_list, type_list, description, Double.parseDouble(cost_per_month));
			page = ConfigurationManager.getProperty("path.page.main&admin");
		} else {
			request.setAttribute("errorDataMessage", MessageManager.getProperty("message.dataempty"));
			page = ConfigurationManager.getProperty("path.page.add&service");
		}
		return page;
	}

}