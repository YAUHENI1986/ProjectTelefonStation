package by.htp.telephonestation.command;

import static by.htp.telephonestation.command.util.CommandConstant.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.telephonestation.logic.AddSubscriberLogic;
import by.htp.telephonestation.resource.ConfigurationManager;
import by.htp.telephonestation.resource.MessageManager;
import by.htp.telephonestation.service.CatalogServiceInvoice;
import by.htp.telephonestation.service.CatalogServiceSubscribers;
import by.htp.telephonestation.service.impl.CatalogServiceImpl;

public class AddSubcriberCommandImpl implements ActionCommand{
	
	private CatalogServiceSubscribers catalogService = new CatalogServiceImpl();
	private CatalogServiceInvoice catalogServiceInv = new CatalogServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		
		String name = request.getParameter(REQ_PARAM_SUBSCRIBER_NAME);
		String surname = request.getParameter(REQ_PARAM_SUBSCRIBER_SURNAME);
		String adress = request.getParameter(REQ_PARAM_SUBSCRIBER_ADRESS);
		String personal_number_passport = request.getParameter(REQ_PARAM_SUBSCRIBER_PNP);
		
		if(AddSubscriberLogic.checkNullEmptyLogin(name, surname, adress, personal_number_passport)) {
			if(AddSubscriberLogic.checkUserAvailability(personal_number_passport)) {
				catalogService.addSubscriber(name, surname, adress, Integer.parseInt(personal_number_passport));
				catalogServiceInv.addInvoice(catalogServiceInv.getIdSubscriber(Integer.parseInt(personal_number_passport)), 0, "no service", catalogServiceInv.generatePhoneNumber(), "not blocked");
				page = ConfigurationManager.getProperty("path.page.main&admin");
			} else {
				request.setAttribute("errorConsilienceSubscriber", MessageManager.getProperty("message.consiliencesubscriber"));
				page = ConfigurationManager.getProperty("path.page.add&subscriber");
			}			
		} else {
			request.setAttribute("errorDataMessage", MessageManager.getProperty("message.dataempty"));
			page = ConfigurationManager.getProperty("path.page.add&subscriber");
		}	
		
		return page;
	}

}